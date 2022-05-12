/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rating.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import rating.database.DatabaseManagement;
import rating.model.CDR;
import rating.model.Rating;

/**
 *
 * @author nour
 */
public class Main {

    public static void main(final String[] args) throws IOException {
        
        DatabaseManagement database = new DatabaseManagement();
        ArrayList<CDR> cdrs = database.getCDRs();
        ArrayList<Rating> rating_list = ManageUsage.setCustomerUsage(cdrs);
        database.insertIntoCustomerUsage(rating_list);

    }

}
