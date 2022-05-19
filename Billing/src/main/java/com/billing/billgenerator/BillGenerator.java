/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.billing.billgenerator;

import com.billing.postgresql.DB_Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michael Ramez
 */
public class BillGenerator {

    private final DB_Connection dbInstance = DB_Connection.getDatabaseInstance();
    private static final BillGenerator billGeneratorInstance = new BillGenerator();
    private final String getMsisdnsSQLCommand = "select msisdn from billing";

    private BillGenerator() {

    }

    public static BillGenerator GetBillGeneratorInstance() {
        return billGeneratorInstance;
    }

    public void GenerateBills() {

        try {
            PreparedStatement getMsisdnsStatement = dbInstance.getPreparedStatement(getMsisdnsSQLCommand);
            ResultSet resultSet = getMsisdnsStatement.executeQuery();
            while (resultSet.next()) {
                String msisdn = resultSet.getString("msisdn");
                Bill bill = new Bill(msisdn);
                bill.GenerateBill();
            }
        } catch (SQLException ex) {
            Logger.getLogger(BillGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
