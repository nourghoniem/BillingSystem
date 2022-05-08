/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.billing.servicepackage;

import com.billing.postgresql.DB_Connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michael Ramez
 */
public class ServicePackageHandler {
    
    private static final ServicePackageHandler servicePackageHandlerInstance = new ServicePackageHandler();
    private final Connection dbconnection;
    
    private ServicePackageHandler(){
        dbconnection = DB_Connection.getDatabaseInstance().getConnection();
    }
    
    public static ServicePackageHandler getServicePackageHandler(){
        return servicePackageHandlerInstance;
    }
    
    public void AddServicePackage(ServicePackage servicePackage){
        try {
            String insSP_sql = "insert into service_package(service_id,amount,service_type_id) values(?, ?, ?)";
            PreparedStatement insSP_stm = dbconnection.prepareStatement(insSP_sql);
            int serviceId = servicePackage.getService_id();
            int amount = servicePackage.getAmount();
            int serviceTypeId = servicePackage.getService_type_id();
            insSP_stm.setInt(1, serviceId);
            insSP_stm.setInt(2, amount);
            insSP_stm.setInt(3, serviceTypeId);
            insSP_stm.executeUpdate();
            dbconnection.commit();
        } catch (SQLException ex) {
            try {
                dbconnection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(ServicePackageHandler.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
}







