/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.billing.jasperreports;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author Michael Ramez
 */
public class JasperReports {

    private final String DB_URL = "jdbc:postgresql://localhost:5432/registration";
    private final String USERNAME = "postgres";
    private final String PASSWORD = "0000";
    Connection con;
    String compiledJasperReport = "D:/VScode/Tomcat/Billing/test.jasper";
    String outputPDF = "D:/VScode/Tomcat/Billing/test.pdf";
    Map parameters = new HashMap();

    public void ConnectToDB() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("com.billing.jasperreports.JasperReports.ConnectToDB()");
        }
        try {
            con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("connection successful");
        } catch (SQLException e) {
            System.out.println("connection failed");
        }
        parameters.put("Title", "Test");
        String sqlCommand = "select * from user_info where fname='michael'";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement(sqlCommand);
            ResultSet resultSet = preparedStatement.executeQuery();
            JRResultSetDataSource dataSource = new JRResultSetDataSource(resultSet);
            try {
                JasperPrint jasperPrint = JasperFillManager.fillReport(compiledJasperReport, parameters, dataSource);
                JasperExportManager.exportReportToPdfFile(jasperPrint, outputPDF);
            } catch (JRException ex) {
                Logger.getLogger(JasperReports.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JasperReports.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] args) {
        new JasperReports().ConnectToDB();
    }
}
