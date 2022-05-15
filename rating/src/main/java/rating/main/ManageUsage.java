/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rating.main;

import java.util.ArrayList;
import rating.model.CDR;
import rating.model.Rating;

/**
 *
 * @author nour
 */
public class ManageUsage {

    public static ArrayList<Rating> setCustomerUsage(ArrayList<CDR> cdrs) {
        ArrayList<Rating> rating_list = new ArrayList<Rating>();
        for (CDR c : cdrs) {

            Rating rating = new Rating();
            rating.setMsisdn(c.getMsisdn());
            rating.setRateplan_id(c.getRateplan_id());
            rating.setCdr_id(c.getCdr_id());
            rating.setDate(c.getDate());
            String dial_b = c.getDial_b().substring(4);
            boolean dial_code = c.getDial_b().startsWith("0020");
            int sms_usage;

            switch (c.getService_id()) {
                case 1:
                    if (dial_code == true) {

                        if (dial_b.substring(1).startsWith("1")) {
                            rating.setVoice_onnet(c.getUsage());
                        } else {

                            rating.setVoice_crossnet(c.getUsage());
                        }
                    } else {
                        rating.setVoice_international(c.getUsage());
                    }
                    break;

                case 2:
                        if (dial_b.substring(1).startsWith("1")) {
                            sms_usage = (int) c.getUsage();
                            rating.setSms_onnet(sms_usage);
                        } else {
                            sms_usage = (int) c.getUsage();
                            rating.setSms_crossnet(sms_usage);
                        } 
                    break;

                case 3:
                    rating.setData(c.getUsage());
                    break;

            }
            rating_list.add(rating);
        }
        return rating_list;
    }

}
