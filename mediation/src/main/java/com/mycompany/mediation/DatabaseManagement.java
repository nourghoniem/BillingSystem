/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mediation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import mediation.model.CDR;

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

    public void insertCDR(CDR cdr) {
        try {
            pst = conn.prepareStatement("INSERT INTO cdrs (msisdn, dial_b, service_id, rateplan_id, start_date, start_time) VALUES(?,?,?,?,?,?)");
            pst.setString(1, cdr.getMsisdn());
            pst.setString(2, cdr.getDial_b());
            pst.setInt(3, cdr.getService_id());
            pst.setInt(4, cdr.getRateplan_id());
            pst.setString(5, cdr.getStart_date());
            pst.setString(6, cdr.getStart_time());
            int rows = pst.executeUpdate();
            pst.close();
            rs.close();
        } catch (SQLException e) {
            e.getMessage();
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
              e.printStackTrace(); }
        }
    }
}
