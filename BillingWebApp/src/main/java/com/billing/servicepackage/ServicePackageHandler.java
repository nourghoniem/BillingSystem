/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.billing.servicepackage;

import com.billing.postgresql.DB_Connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michael Ramez
 */
public class ServicePackageHandler {

    private static final ServicePackageHandler servicePackageHandlerInstance = new ServicePackageHandler();
    private final Connection dbconnection;

    private ServicePackageHandler() {
        dbconnection = DB_Connection.getDatabaseInstance().getConnection();
    }

    public static ServicePackageHandler getServicePackageHandler() {
        return servicePackageHandlerInstance;
    }

    public void AddServicePackage(ServicePackage servicePackage) {
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

    public List<Integer> getServicePkgs(int rpid) {
        List<Integer> svp = new ArrayList();
        try {
            String getRPs_sql = "select * from service_rateplan where rateplan_id=?";
            PreparedStatement getRPs_stm = dbconnection.prepareStatement(getRPs_sql);
            getRPs_stm.setInt(1, rpid);
            ResultSet getRPs_res = getRPs_stm.executeQuery();

            while (getRPs_res.next()) {
                svp.add(getRPs_res.getInt(2));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ServicePackageHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return svp;
    }

    public ServicePackage getService(int spid) {
        ServicePackage sp = null;
        try {
            String getRPs_sql = "select  concat(s.event_type,'_',st.\"type\") as services ,sp.amount  from service_package sp ,service s,service_type st  where sp.service_id=s.id and sp.service_type_id=st.id and sp.id=?";
            PreparedStatement getRPs_stm = dbconnection.prepareStatement(getRPs_sql);
            getRPs_stm.setInt(1, spid);
            ResultSet getRPs_res = getRPs_stm.executeQuery();

            while (getRPs_res.next()) {
                sp = new ServicePackage(getRPs_res.getInt(2), getRPs_res.getString(1).split("_")[1], getRPs_res.getString(1).split("_")[0]);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ServicePackageHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sp;
    }

    public ArrayList<ServicePackage> getServices() {
        ArrayList<ServicePackage> svpk = new ArrayList<ServicePackage>();
        ServicePackage sp = null;
        try {
            String getRPs_sql = "select sp.id, concat(s.event_type,'_',st.\"type\") as services ,sp.amount from service_package sp ,service s,service_type st  where sp.service_id=s.id and sp.service_type_id=st.id";
            PreparedStatement getRPs_stm = dbconnection.prepareStatement(getRPs_sql);

            ResultSet getRPs_res = getRPs_stm.executeQuery();

            while (getRPs_res.next()) {
                sp = new ServicePackage(getRPs_res.getInt(1), getRPs_res.getInt(3), getRPs_res.getString(2).split("_")[1], getRPs_res.getString(2).split("_")[0]);
                svpk.add(sp);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ServicePackageHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return svpk;
    }

    public ServicePackage getFreeService(int id) {

        ServicePackage sp = null;
        try {
            String getRPs_sql = "select concat(s.event_type,'_',st.\"type\") as services ,sp.amount  from free_units sp ,service s,service_type st  where sp.service_id=s.id and sp.service_package_type_id=st.id and sp.id=? ";
            PreparedStatement getRPs_stm = dbconnection.prepareStatement(getRPs_sql);
            getRPs_stm.setInt(1, id);
            ResultSet getRPs_res = getRPs_stm.executeQuery();

            while (getRPs_res.next()) {
                sp = new ServicePackage(getRPs_res.getInt(2), getRPs_res.getString(1).split("_")[1], getRPs_res.getString(1).split("_")[0]);

            }

        } catch (SQLException ex) {
            Logger.getLogger(ServicePackageHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sp;
    }

    public ArrayList<ServicePackage> getFreeServices() {
        ArrayList<ServicePackage> svpk = new ArrayList<ServicePackage>();
        ServicePackage sp = null;
        try {
            String getRPs_sql = "select sp.id,concat(s.event_type,'_',st.\"type\") as services ,sp.amount  from free_units sp ,service s,service_type st  where sp.service_id=s.id and sp.service_package_type_id=st.id ";
            PreparedStatement getRPs_stm = dbconnection.prepareStatement(getRPs_sql);

            ResultSet getRPs_res = getRPs_stm.executeQuery();

            while (getRPs_res.next()) {
                sp = new ServicePackage(getRPs_res.getInt(1), getRPs_res.getInt(3), getRPs_res.getString(2).split("_")[1], getRPs_res.getString(2).split("_")[0]);
                svpk.add(sp);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ServicePackageHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return svpk;
    }

    public ArrayList<ServicePackage> getAllEventTypes() {
        ArrayList<ServicePackage> evt = new ArrayList<ServicePackage>();

        try {
            String getRPs_sql = "SELECT s.id,s.event_type  FROM service s";
            PreparedStatement getRPs_stm = dbconnection.prepareStatement(getRPs_sql);

            ResultSet getRPs_res = getRPs_stm.executeQuery();

            while (getRPs_res.next()) {
                ServicePackage sp = new ServicePackage();
                sp.setService_id(getRPs_res.getInt("id"));
                sp.setService_type(getRPs_res.getString("event_type"));
                evt.add(sp);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ServicePackageHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return evt;

    }

    public ArrayList<ServicePackage> getAllZonePkg() {
        ArrayList<ServicePackage> zpkg = new ArrayList<ServicePackage>();

        try {
            String getRPs_sql
                    = "select st.id,st.\"type\" from service_type st ";
            PreparedStatement getRPs_stm = dbconnection.prepareStatement(getRPs_sql);

            ResultSet getRPs_res = getRPs_stm.executeQuery();

            while (getRPs_res.next()) {
                ServicePackage sp = new ServicePackage();
                sp.setService_id(getRPs_res.getInt(1));
                sp.setService_type(getRPs_res.getString(2));
                zpkg.add(sp);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ServicePackageHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return zpkg;

    }
}
