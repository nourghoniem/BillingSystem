/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.billing.postgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author asmaaMohamed
 */
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
            connection = DriverManager.getConnection(URL, USERNAME, PASS);
            connection.setAutoCommit(false);
            System.out.println("Connection is made successfully");

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("webDatabase.WebDataBase.connect()error");
        }

    }


    
    public void closeDatabase() throws SQLException {
        connection.close();
    }

    public static void main(String[] args) throws SQLException {
//        WebDatabase db = WebDatabase.databaseInstance;
    }

}
