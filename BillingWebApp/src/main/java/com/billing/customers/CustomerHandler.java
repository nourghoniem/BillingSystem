/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.billing.customers;

import com.billing.postgresql.DB_Connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 *
 * @author nour
 */
public class CustomerHandler {

    private static final CustomerHandler customerHandlerInstance = new CustomerHandler();
    private final Connection dbconnection;
    private Statement stmt;
    private ResultSet rs;
    private PreparedStatement pst;
    ArrayList<Customer> customers;

    private CustomerHandler() {
        DB_Connection.getDatabaseInstance().connectToDatabase();
        dbconnection = DB_Connection.getDatabaseInstance().getConnection();
    }

    public static CustomerHandler getRatePlanHanlder() {
        return customerHandlerInstance;
    }

    public List<Customer> getCustomers() {
        customers = new ArrayList<Customer>();
        try {
            stmt = dbconnection.createStatement();
            String SQL = " SELECT c.id, c.name, c.email, o.msisdn, o.bill_cycle, w.name as rateplan FROM customer as c inner join contract as o on c.id=o.customer_id inner join rateplan as w on w.id=o.rateplan_id;";
            rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                Integer id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String msisdn = rs.getString("msisdn");
                Date bill_cycle = rs.getDate("bill_cycle");
                String rateplan = rs.getString("rateplan");
                Customer customer = new Customer(id, name, email, msisdn, rateplan, bill_cycle.toLocalDate());
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customers;
    }

    public List<Customer> getCustomersSearch(String pattern) {
        customers = new ArrayList<Customer>();
        try {
            stmt = dbconnection.createStatement();
            String SQL = " SELECT c.id, c.name, c.email, o.msisdn, o.bill_cycle, w.name as rateplan FROM customer as c inner join contract as o on c.id=o.customer_id inner join rateplan as w on w.id=o.rateplan_id where o.msisdn like '%" + pattern + "%'";
            rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                Integer id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String msisdn = rs.getString("msisdn");
                Date bill_cycle = rs.getDate("bill_cycle");
                String rateplan = rs.getString("rateplan");
                Customer customer = new Customer(id, name, email, msisdn, rateplan, bill_cycle.toLocalDate());
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customers;
    }

    public int addCustomer(Customer c) {
        int id = 0;
        try {

            String SQL = "INSERT INTO customer (name, email) VALUES(?,?);";
            pst = dbconnection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, c.getName());
            pst.setString(2, c.getEmail());
            pst.executeUpdate();
            rs = pst.getGeneratedKeys();
          
            while(rs.next()) {
                id = rs.getInt(1);
            }
            
            dbconnection.commit();
            
            pst.close();
          
        } catch (Exception e) {
            e.getMessage();
        }
        return id;
    }

    public void addContract(Customer c, int customer_id) {
        try {
            int id = getRateplan_id(c.getRateplan_name());
            System.out.print(id);
            pst = dbconnection.prepareStatement("INSERT INTO contract (msisdn, rateplan_id, customer_id, creation_date, bill_cycle, recurring, one_time) VALUES(?,?,?,?,?,?,?);");
            pst.setString(1, c.getMsisdn());
            pst.setInt(2, id);
            pst.setInt(3, customer_id);
            Date creation_date = Date.valueOf(c.getCreation_date());
            Date bill_cycle = Date.valueOf(c.getBill_cycle());
            pst.setDate(4, creation_date );
            pst.setDate(5, bill_cycle);
            pst.setInt(6, c.getRecurring());
            pst.setInt(7, c.getOnetime());
          
            int rows = pst.executeUpdate();
            dbconnection.commit();
            pst.close();
            System.out.print(rows);
        } catch (Exception e) {
            e.getMessage();
        }

    }
    
    public int getRateplan_id(String rateplan){
        Integer id = -1;
         try {
            stmt = dbconnection.createStatement();
            String SQL = " SELECT id FROM rateplan where name='"+rateplan+"'";
            rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                 id = rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

}
