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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michael Ramez
 */
public class RatePlanHandler {

    private static final RatePlanHandler ratePlanHandlerInstance = new RatePlanHandler();
    private final Connection dbconnection;

    private RatePlanHandler() {
        DB_Connection.getDatabaseInstance().connectToDatabase();
        dbconnection = DB_Connection.getDatabaseInstance().getConnection();
    }

    public static RatePlanHandler getRatePlanHanlder() {
        return ratePlanHandlerInstance;
    }

    public void AddServiceRatePlan(RatePlan ratePlan) {
        try {
            String insRP_sql = "insert into rateplan(name,non_rating_id,price,free_unit_id) values (?,?,?,?) returning id";
            PreparedStatement insRP_stm = dbconnection.prepareStatement(insRP_sql, Statement.RETURN_GENERATED_KEYS);
            insRP_stm.setString(1, ratePlan.getName());
            insRP_stm.setInt(2, ratePlan.getNonRatingId());
            insRP_stm.setInt(3, ratePlan.getPrice());
            insRP_stm.setInt(4, ratePlan.getFreeUnitId());
            insRP_stm.executeUpdate();
            ResultSet insRP_res = insRP_stm.getGeneratedKeys();
            insRP_res.next();

            int ratePlanId = insRP_res.getInt("id");
            System.out.println("id = " + ratePlanId);

            String insServiceRP_sql = "insert into service_rateplan values (?,?)";
            PreparedStatement insServiceRP_stm = dbconnection.prepareStatement(insServiceRP_sql);
            int servicePackageId = ratePlan.getServicePackageId();
            insServiceRP_stm.setInt(1, ratePlanId);
            insServiceRP_stm.setInt(2, servicePackageId);
            insServiceRP_stm.executeUpdate();
            dbconnection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(RatePlanHandler.class.getName()).log(Level.SEVERE, null, ex);
            try {
                dbconnection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(RatePlanHandler.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    public List<RatePlan> GetCurrentRatePlans() {
        List<RatePlan> currentRPs = new ArrayList<>();
        try {
            String getRPs_sql = "select * from rateplan";
            PreparedStatement getRPs_stm = dbconnection.prepareStatement(getRPs_sql);
            ResultSet getRPs_res = getRPs_stm.executeQuery();
            while (getRPs_res.next()) {
                int ratePlanId = getRPs_res.getInt("id");
                String ratePlanName = getRPs_res.getString("name");
                int price = getRPs_res.getInt("price");
//                int nonRatingId = getRPs_res.getInt("non_rating_id");
//                int freeUnitId = getRPs_res.getInt("free_unit_id");
                currentRPs.add(new RatePlan(ratePlanId, ratePlanName, price));
            }
            return currentRPs;
        } catch (SQLException ex) {
            Logger.getLogger(RatePlanHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return currentRPs;
    }

    public static void main(String[] args) {

        ratePlanHandlerInstance.AddServiceRatePlan(new RatePlan(1,1,1,"test", 500));
    }
}
