/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.billing.main;

import com.billing.billgenerator.BillGenerator;
import com.billing.postgresql.DB_Connection;



/**
 *
 * @author Michael Ramez
 */
public class Main {

    public static void main(String[] args) {
        DB_Connection dbInstance = DB_Connection.getDatabaseInstance();
        dbInstance.connectToDatabase();
        dbInstance.DisableAutoCommit();
        BillGenerator billGenerator = BillGenerator.GetBillGeneratorInstance();
        billGenerator.GenerateBills();
        dbInstance.closeDatabaseConnection();
    }
}
