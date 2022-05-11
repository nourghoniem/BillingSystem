/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rating.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import rating.model.CDR;
import rating.model.Rating;

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
            String SQL = "SELECT msisdn, dial_b, usage, service_id, rateplan_id FROM rating;";
            rs = stmt.executeQuery(SQL);
            cdrs = new ArrayList<CDR>();
            while (rs.next()) {
                String msisdn = rs.getString("msisdn");
                String dial_b = rs.getString("dial_b");
                Double usage = rs.getDouble("usage");
                Integer service_id = rs.getInt("service_id");
                Integer rateplan_id = rs.getInt("rateplan_id");
                CDR cdr = new CDR(msisdn, dial_b, service_id, rateplan_id, usage);
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
                    pst = conn.prepareStatement("INSERT INTO customer_usage (msisdn, rateplan_id, voice_onnet, voice_crossnet, sms_onnet, sms_crossnet, data) VALUES(?,?,?,?,?,?,?)");
                    pst.setString(1, r.getMsisdn());
                    pst.setInt(2, r.getRateplan_id());
                    pst.setDouble(3, r.getVoice_onnet());
                    pst.setDouble(4, r.getVoice_crossnet());
                    pst.setDouble(5, r.getSms_onnet());
                    pst.setDouble(6, r.getSms_crossnet());
                    pst.setDouble(7, r.getData());
                    int rows = pst.executeUpdate();

                }
                pst.close();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createView() {
        try {
            stmt = conn.createStatement();
            String SQL = "CREATE VIEW customer_view AS SELECT msisdn, rateplan_id, sum(voice_onnet) AS voice_onnet, sum(voice_crossnet) AS voice_crossnet, sum(sms_onnet) AS sms_onnet, sum(sms_crossnet) AS sms_crossnet, sum(data) AS data FROM customer_usage GROUP BY msisdn, rateplan_id;";
            stmt.executeUpdate(SQL);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
