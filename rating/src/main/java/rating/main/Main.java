/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rating.main;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import rating.database.DatabaseManagement;
import rating.model.CDR;
import rating.model.CalculateExtraCharge;
import rating.model.Rating;
import rating.model.User;

/**
 *
 * @author nour
 */
public class Main {

    public static void main(final String[] args) throws IOException, SQLException {

        DatabaseManagement database = new DatabaseManagement();
        ArrayList<CDR> cdrs = database.getCDRs();
        ArrayList<Rating> rating_list = ManageUsage.setCustomerUsage(cdrs);
        database.insertIntoCustomerUsage(rating_list);
        ArrayList<User> hu = CalculateExtraCharge.Calculations();
        
        
        for (User u : hu) {
          System.out.println(u.getExtraCharges());
          System.out.println(u.getMsisdn());
             
          System.out.println(u.getOne_time());
          System.out.println(u.getNon_rating());
          System.out.println(u.getRecurring());
          System.out.println(u.getRatePlanPrice());
          System.out.println(u.getRatePlanId());
          
//            
        }

       
        
       }
    }


