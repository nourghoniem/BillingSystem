/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.billing.jasperreports;

import com.billing.postgresql.DB_Connection;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author Michael Ramez
 */
public class PDFGenerator {

    private final DB_Connection dbInstance = DB_Connection.getDatabaseInstance();
    private static final PDFGenerator PDF_GENERATOR_INSTANCE = new PDFGenerator();
    private final String BillingProjectPathString = System.getProperty("user.dir");
    private final Path BillingProjectPath = Paths.get(BillingProjectPathString);
    private final Path ParentProjectPath = BillingProjectPath.getParent();
    private final String compiledReportPath = BillingProjectPathString+"/Billing.jasper";
    private final String outputPDF_BasePath = ParentProjectPath.toString()+"/Invoices";
//    private final String compiledReportPath = "D:/VScode/Billing/Billing/Billing.jasper";
//    private final String outputPDF_BasePath = "D:/VScode/Billing/Billing/";
    private final String generated_Bill_SQL_Command = "select billing.msisdn,rateplan.name as rateplanname, customer.name as customername,\n"
            + "rateplanprice,extracharges,onetimefee,billing.recurring,nonrating,billdate,\n"
            + "0.14*(rateplanprice+extracharges+onetimefee+billing.recurring+nonrating) as tax,\n"
            + "1.14*(rateplanprice+extracharges+onetimefee+billing.recurring+nonrating) as total\n"
            + "from billing,customer,contract,rateplan\n"
            + "where billing.msisdn = contract.msisdn and contract.customer_id = customer.id\n"
            + "and billing.rateplanid = rateplan.id and billing.msisdn = ?";

    private PDFGenerator() {

    }

    public static PDFGenerator getJasperReportsInstance() {
        return PDF_GENERATOR_INSTANCE;
    }

    public void Generate_PDF_Report(String msisdn) {
        try {
            PreparedStatement generated_Bill_Statement = dbInstance.getPreparedStatement(generated_Bill_SQL_Command);
            generated_Bill_Statement.setString(1, msisdn);
            ResultSet resultSet = generated_Bill_Statement.executeQuery();
            JRResultSetDataSource dataSource = new JRResultSetDataSource(resultSet);
            JasperPrint jasperPrint = JasperFillManager.fillReport(compiledReportPath, null, dataSource);
            JasperExportManager.exportReportToPdfFile(jasperPrint, outputPDF_BasePath + msisdn + ".pdf");

        } catch (SQLException | JRException ex) {
            System.out.println("com.billing.jasperreports.PDFGenerator.Generate_PDF_Report()");
            Logger.getLogger(PDFGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
