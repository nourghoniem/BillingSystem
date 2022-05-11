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
        ArrayList<Rating> rating_list = new ArrayList<Rating>();
        for (CDR c : cdrs) {
            Rating rating = new Rating();
            rating.setMsisdn(c.getMsisdn());
            rating.setRateplan_id(c.getRateplan_id());
            String dial_b = c.getDial_b().substring(4);
            if (c.getService_id() == 1) {

                System.out.println("voice");
                if (dial_b.substring(1).startsWith("1")) {
                    System.out.println("on-net");
                    rating.setVoice_onnet(c.getUsage());

                } else {
                    System.out.println("cross-net");
                    rating.setVoice_crossnet(c.getUsage());
                }
            } else if (c.getService_id() == 2) {
                System.out.println("sms");
                if (dial_b.substring(1).startsWith("1")) {
                    System.out.println("on-net");
                    int sms_usage = (int)c.getUsage();
                    rating.setSms_onnet(sms_usage);
                } else {
                    System.out.println("cross-net");
                    int sms_usage = (int)c.getUsage();
                    rating.setSms_crossnet(sms_usage);
                }
            } else {
                System.out.println("data");
                rating.setData(c.getUsage());
            }
            rating_list.add(rating);
        }
        System.out.println("**********************************************");
//            for(Rating r: rating_list){
//                
//                System.out.println(r.getMsisdn());
//                System.out.println(r.getVoice_onnet());
//                System.out.println(r.getVoice_crossnet());
//                System.out.println(r.getSms_onnet());
//                System.out.println(r.getSms_crossnet());
//                System.out.println(r.getData());
//                System.out.println("----------------------------------------------");
//            }
     database.insertIntoCustomerUsage(rating_list);
     database.createView();
    
            
    }

}
