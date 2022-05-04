/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mediation.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author nour
 */
public class DatabaseConnection {

    private static Connection con;

    public DatabaseConnection() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found " + e);
        }
        try {

            con = DriverManager.getConnection("jdbc:postgresql://bkaxb3w5rvjztkre1shf-postgresql.services.clever-cloud.com:5432/bkaxb3w5rvjztkre1shf", "uiivnrlitesybgtcbqso", "3u6dKo3lOPgPz5gGGWCX");
            System.out.println("database connected");
        } catch (Exception ex) {
    
            System.out.println("exception at database connection" + ex);
        }
    }

    public static Connection getConnection() {
        return con;
    }

    public static void closeConnection() {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }

}
