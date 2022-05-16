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
    
    public List<Customer> getCustomers(){
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
      public List<Customer> getCustomersSearch(String pattern){
        customers = new ArrayList<Customer>();
        try {
            stmt = dbconnection.createStatement();
            String SQL = " SELECT c.id, c.name, c.email, o.msisdn, o.bill_cycle, w.name as rateplan FROM customer as c inner join contract as o on c.id=o.customer_id inner join rateplan as w on w.id=o.rateplan_id where o.msisdn like '%"+pattern+"%'";
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

}
