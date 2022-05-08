/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.billing.rateplan;

import com.billing.postgresql.DB_Connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Michael Ramez
 */
public class RatePlanHandler {

    private static final RatePlanHandler ratePlanHandlerInstance = new RatePlanHandler();
    private final Connection dbconnection;

    private RatePlanHandler() {
        dbconnection = DB_Connection.getDatabaseInstance().getConnection();
    }

    public static RatePlanHandler getRatePlanHanlder() {
        return ratePlanHandlerInstance;
    }

    public void AddServiceRatePlan(RatePlan ratePlan) {
        try {
            String insRP_sql = "insert into rateplan(name) values ? returning id";
            PreparedStatement insRP_stm = dbconnection.prepareStatement(insRP_sql, Statement.RETURN_GENERATED_KEYS);
            insRP_stm.setString(1, ratePlan.getName());
            insRP_stm.executeUpdate();
            ResultSet insRP_res = insRP_stm.getGeneratedKeys();
            int ratePlanId = insRP_res.getInt("id");

            String insServiceRP_sql = "insert into service_rateplan values (?,?)";
            PreparedStatement insServiceRP_stm = dbconnection.prepareStatement(insServiceRP_sql);
            int servicePackageId = ratePlan.getServicePackageId();
            insServiceRP_stm.setInt(1, servicePackageId);
            insServiceRP_stm.setInt(2, ratePlanId);
            insServiceRP_stm.executeUpdate();
            dbconnection.commit();
        } catch (SQLException ex) {
            try {
                dbconnection.rollback();
            } catch (SQLException ex1) {
            }
        }
    }

    public List<RatePlan> GetCurrentRatePlans() throws SQLException {
        List<RatePlan> currentRPs = new ArrayList<>();
        String getRPs_sql = "select * from rateplan";
        PreparedStatement getRPs_stm = dbconnection.prepareStatement(getRPs_sql);
        ResultSet getRPs_res = getRPs_stm.executeQuery();
        while(getRPs_res.next()){
            int ratePlanId = getRPs_res.getInt("id");
            String ratePlanName = getRPs_res.getString("name");
            currentRPs.add(new RatePlan(ratePlanId, ratePlanName));
        }
        return currentRPs;
    }
}
