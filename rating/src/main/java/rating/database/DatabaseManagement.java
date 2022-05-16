/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rating.database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import rating.model.AdditionalCharges;
import rating.model.CDR;
import rating.model.Rating;
import rating.model.User;

/**
 *
 * @author nour
 */
public class DatabaseManagement {

    Connection conn;
    Statement stmt;
    ResultSet rs;
    PreparedStatement pst;

    public DatabaseManagement() {
        DatabaseConnection c = new DatabaseConnection();
        conn = c.getConnection();
        if (conn == null) {
            System.out.println("database connection is null");
        }
    }

    public ArrayList<CDR> getCDRs() {
        ArrayList<CDR> cdrs = null;
        try {
            stmt = conn.createStatement();
            String SQL = "SELECT id, msisdn, dial_b, usage, service_id, rateplan_id, start_date FROM rating WHERE id NOT IN (SELECT rating_id FROM customer_usage);";
            rs = stmt.executeQuery(SQL);
            cdrs = new ArrayList<CDR>();
            while (rs.next()) {
                String msisdn = rs.getString("msisdn");
                String dial_b = rs.getString("dial_b");
                Double usage = rs.getDouble("usage");
                Integer service_id = rs.getInt("service_id");
                Integer rateplan_id = rs.getInt("rateplan_id");
                Integer cdr_id = rs.getInt("id");
                Date date = rs.getDate("start_date");
                CDR cdr = new CDR(cdr_id, msisdn, dial_b, service_id, rateplan_id, usage, date.toLocalDate());
                cdrs.add(cdr);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cdrs;
    }

    public void insertIntoCustomerUsage(ArrayList<Rating> rating) {

        try {
            if (!rating.isEmpty()) {

                for (Rating r : rating) {
                    pst = conn.prepareStatement("INSERT INTO customer_usage (msisdn, rateplan_id, voice_onnet, voice_crossnet, sms_onnet, sms_crossnet, data, voice_international, rating_id, rating_date) VALUES(?,?,?,?,?,?,?,?,?,?)");
                    pst.setString(1, r.getMsisdn());
                    pst.setInt(2, r.getRateplan_id());
                    pst.setDouble(3, r.getVoice_onnet());
                    pst.setDouble(4, r.getVoice_crossnet());
                    pst.setDouble(5, r.getSms_onnet());
                    pst.setDouble(6, r.getSms_crossnet());
                    pst.setDouble(7, r.getData());
                    pst.setDouble(8, r.getVoice_international());
                    pst.setDouble(9, r.getCdr_id());
                    Date date = Date.valueOf(r.getDate());
                    pst.setDate(10, date);
                    int rows = pst.executeUpdate();

                }
                pst.close();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<User>();
        User user;
        String guery = "SELECT msisdn ,rateplan_id FROM customer_view ";
        try {
            pst = conn.prepareStatement(guery);
            rs = pst.executeQuery();
            while (rs.next()) {
                user = new User(rs.getString("msisdn"), rs.getInt("rateplan_id"));
                System.out.println(rs.getInt("rateplan_id"));
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Rating getCustomerUsage(String msisdn) {
        try {
            String guery = "SELECT * FROM customer_view where msisdn =?";
            pst = conn.prepareStatement(guery);
            pst.setString(1, msisdn);
            rs = pst.executeQuery();
            Rating usage = new Rating();
            while (rs.next()) {
                usage.setVoice_onnet(rs.getDouble("voice_onnet"));
                usage.setVoice_crossnet(rs.getDouble("voice_crossnet"));
                usage.setSms_onnet(rs.getInt("sms_onnet"));
                usage.setSms_crossnet(rs.getInt("sms_crossnet"));
                usage.setData(rs.getDouble("data"));
                usage.setVoice_international(rs.getDouble("voice_international"));

            }
            return usage;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public HashMap<String, Integer> getCustomerPackage(int ratePlanId) {
        try {
            HashMap<String, Integer> pakage = new HashMap<>();

            String sQuery = "select case when s.event_type='voice'and st.\"type\"='on-net' then 'voice_onnet' \n"
                    + "when s.event_type='voice'and st.\"type\"='cross-net' then'voice_crossnet'\n"
                    + "when s.event_type='voice'and st.\"type\"='roaming' then'voice_roaming'\n"
                    + "when s.event_type='voice'and st.\"type\"='international' then'voice_international'\n"
                    + "when s.event_type='SMS'and st.\"type\"='cross-net' then'sms_crossnet'\n"
                    + "when s.event_type='SMS'and st.\"type\"='on-net' then'sms_onnet'\n"
                    + "when s.event_type='data' then'data'\n"
                    + "end as service,sp.amount  from service_package sp ,service_rateplan srp ,service s,service_type st \n"
                    + "                where sp.id=srp.service_package_id  and\n"
                    + "               sp.service_type_id=st.id and s.id=sp.service_id and srp.rateplan_id=?;";
            PreparedStatement selectStatement = conn.prepareStatement(sQuery);
            selectStatement.setInt(1, ratePlanId);
            ResultSet res = selectStatement.executeQuery();
            while (res.next()) {
                pakage.put(res.getString("service"), res.getInt("amount"));

            }
            selectStatement.close();

            return pakage;
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return null;
    }

    public HashMap<String, Integer> getFreePackage(int ratePlanId) {
        try {
            HashMap<String, Integer> pakage = new HashMap<>();

            String sQuery = "select case when s.event_type='voice'and st.\"type\"='on-net' then 'voice_onnet' \n"
                    + "when s.event_type='voice'and st.\"type\"='cross-net' then'voice_crossnet'\n"
                    + "when s.event_type='voice'and st.\"type\"='roaming' then'voice_roaming'\n"
                    + "when s.event_type='voice'and st.\"type\"='international' then'voice_international'\n"
                    + "when s.event_type='SMS'and st.\"type\"='cross-net' then'sms_crossnet'\n"
                    + "when s.event_type='SMS'and st.\"type\"='on-net' then'sms_onnet'\n"
                    + "when s.event_type='data' then'data'\n"
                    + "end as service,f.amount \n"
                    + " from free_units f ,service_type st,rateplan rp ,service s\n"
                    + " where rp.free_unit_id=f.id and st.id = f.service_package_type_id and f.service_id=s.id\n"
                    + "  and rp.id=?";
            pst = conn.prepareStatement(sQuery);
            pst.setInt(1, ratePlanId);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                pakage.put(res.getString("service"), res.getInt("amount"));

            }
            pst.close();

            return pakage;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Double getServicePrice(String serviceType, String serviceDestination) {
        Double price = 0.0;
        try {
            String sQuery = "select i.price  from interval_module i, service s, service_type st where i.service_id=s.id and i.service_type_id=st.id and s.event_type=? and st.\"type\"=?";
            pst = conn.prepareStatement(sQuery);
            pst.setString(1, serviceType);
            pst.setString(2, serviceDestination);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                price = res.getDouble("price");

            }

            return price;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        ;
        return -1.0;
    }

    public Double getServicePrice(String serviceType) {
        Double price = 0.0;
        try {
            String sQuery = "select i.price  from interval_module i, service s, service_type st where i.service_id=s.id and i.service_type_id=st.id and s.event_type=? ";
            pst = conn.prepareStatement(sQuery);
            pst.setString(1, serviceType);

            ResultSet res = pst.executeQuery();
            while (res.next()) {
                price = res.getDouble("price");

            }

            return price;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return -1.0;
    }

    public AdditionalCharges getAdditionalcharges(String msisdn) {

        AdditionalCharges charges = new AdditionalCharges();

        try {

            String query = "SELECT c.one_time,c.recurring, n.price as non_rating FROM contract c  , rateplan rp ,non_rating n where rp.id=c.rateplan_id and rp.non_rating_id=n.id and msisdn=?";
            pst = conn.prepareStatement(query);
            pst.setString(1, msisdn);

            rs = pst.executeQuery();

            while (rs.next()) {

                double non_rating = rs.getDouble("non_rating");
                double one_time = rs.getDouble("one_time");
                double recurring = rs.getDouble("recurring");

                charges.setOne_time(one_time);
                charges.setRecurring(recurring);
                charges.setNon_rating(non_rating);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("error");
        }
        return charges;

    }

    public Double getRatePlanPrice(int rateplanid) {
        try {

            String query = "SELECT price from rateplan WHERE id=?;";
            pst = conn.prepareStatement(query);
            pst.setInt(1, rateplanid);

            rs = pst.executeQuery();
            while (rs.next()) {
                return rs.getDouble("price");

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return -1.0;
    }

    public Date getBillCycle(String msisdn) {
        try {
            String sQuery = "select bill_cycle  from contract where msisdn=?";
            pst = conn.prepareStatement(sQuery);
            pst.setString(1, msisdn);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                return res.getDate("bill_cycle");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage() + "kkk");
        }

        return null;
    }

    public void insertIntoBilling(User u) {
        try {
            Date d = getBillCycle(u.getMsisdn());
            pst = conn.prepareStatement("INSERT INTO billing(msisdn,ratePlanid,ratePlanPrice,extraCharges,oneTimeFee,recurring,nonrating,billdate) values(?,?,?,?,?,?,?,?)");
            pst.setString(1, u.getMsisdn());
            pst.setInt(2, u.getRatePlanId());
            pst.setDouble(3, u.getRatePlanPrice());
            pst.setDouble(4, u.getExtraCharges());
            pst.setDouble(5, u.getOne_time());
            pst.setDouble(6, u.getRecurring());
            pst.setDouble(7, u.getNon_rating());
            pst.setDate(8, d);
            int x = pst.executeUpdate();
            System.out.println(x);
        } catch (SQLException e) {
            System.out.println(e.fillInStackTrace());
        }
    }
}
