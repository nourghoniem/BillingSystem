/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/ServletListener.java to edit this template
 */
package com.billing.webappinit;

import com.billing.postgresql.DB_Connection;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 *
 * @author Michael Ramez
 */
public class ContextInitializer implements ServletContextListener {

    private final DB_Connection dbConnection = DB_Connection.getDatabaseInstance();

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        dbConnection.connectToDatabase();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        dbConnection.closeDatabaseConnection();
    }
}
