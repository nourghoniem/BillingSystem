/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.billing.postgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class DB_Connection {

    private final String URL = "jdbc:postgresql://bkaxb3w5rvjztkre1shf-postgresql.services.clever-cloud.com:5432/bkaxb3w5rvjztkre1shf";
    private final String USERNAME = "uiivnrlitesybgtcbqso";
    private final String PASS = "3u6dKo3lOPgPz5gGGWCX";
    private Connection connection;

    private static final DB_Connection databaseInstance = new DB_Connection();

    private DB_Connection() {
    }

    public static DB_Connection getDatabaseInstance() {
        return databaseInstance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void connectToDatabase() {

        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(URL, USERNAME, PASS);
            this.connection.setAutoCommit(false);
            System.out.println("Connection is made successfully");

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DB_Connection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


    
    public void closeDatabaseConnection() {
        try {
            System.out.println("Connection Closed");
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DB_Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) throws SQLException {
        
        System.out.println(databaseInstance.getConnection());
    }

}
