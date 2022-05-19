/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.billing.billgenerator;

import com.billing.jasperreports.PDFGenerator;
import com.billing.postgresql.DB_Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michael Ramez
 */
public class Bill {

    private final String msisdn;
    private final PDFGenerator pdfGenerator = PDFGenerator.getJasperReportsInstance();
    private final DB_Connection dbInstance = DB_Connection.getDatabaseInstance();

    public Bill(String msisdn) {
        this.msisdn = msisdn;
    }

    public void GenerateBill() {
        GeneratePDF();
        UpdateBillCycle();
        ResetOneTimeFee();
        //        RemoveFromBillTable();
        dbInstance.CommitTransaction();
    }

    private void GeneratePDF() {

        pdfGenerator.Generate_PDF_Report(msisdn);

    }

    private void UpdateBillCycle() {
        try {
            String updateBillCycleSQLCommand = "update contract set bill_cycle = bill_cycle + INTERVAL '28 day' where msisdn = ?";
            PreparedStatement updateBillCycleStatement = dbInstance.getPreparedStatement(updateBillCycleSQLCommand);
            updateBillCycleStatement.setString(1, msisdn);
            updateBillCycleStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Bill.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void ResetOneTimeFee() {
        try {
            String resetOneTimeFeeSQLCommand = "update contract set one_time = 0 where msisdn = ?";
            PreparedStatement resetOneTimeFeeStatement = dbInstance.getPreparedStatement(resetOneTimeFeeSQLCommand);
            resetOneTimeFeeStatement.setString(1, msisdn);
            resetOneTimeFeeStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Bill.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    private void RemoveFromBillTable(){
//        try {
//            String removeFromBillTableSQLCommand = "delete from billing where msisdn = ?";
//            PreparedStatement removeFromBillTableStatement = dbInstance.getPreparedStatement(removeFromBillTableSQLCommand);
//            removeFromBillTableStatement.setString(1, msisdn);
//            removeFromBillTableStatement.executeUpdate();
//        } catch (SQLException ex) {
//            Logger.getLogger(Bill.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
