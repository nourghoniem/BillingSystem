/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rating.model;

import java.util.ArrayList;
import java.util.HashMap;
import rating.database.DatabaseManagement;

/**
 *
 * @author Salma
 */
public class CalculateExtraCharge {

    private static DatabaseManagement database = new DatabaseManagement();
    private static ArrayList<User> users = database.getUsers();
    private static Double extraCharge = 0.0;

    public static ArrayList<User> Calculations() {

        ArrayList<User> usersInfo = new ArrayList<User>();
        for (User user : users) {
            user.setBundle(database.getCustomerPackage(user.getRatePlanId()));
            user.setFreeUnits(database.getFreePackage(user.getRatePlanId()));
            user.setUsage(database.getCustomerUsage(user.getMsisdn()));
            user.setExtraCharges(getServiceExteraCharge(user));
            usersInfo.add(user);

        }
        return usersInfo;
    }

    private static Double getServiceExteraCharge(User u) {
        HashMap<String, Integer> bundle = u.getBundle();
        HashMap<String, Integer> freeUnits = u.getFreeUnits();
        Double amountUsed = 0.0;
        for (String service : bundle.keySet()) {
            amountUsed = u.getUsage().getService(service);
            if (bundle.get(service) != null) {
                if (bundle.get(service) - amountUsed >= 0) {

                    extraCharge += 0;
                } else {
                    if (freeUnits.get(service) != null) {
                        if (bundle.get(service) - amountUsed + freeUnits.get(service) >= 0) {
                            extraCharge += 0;
                        } else {
                            extraCharge += Math.abs(bundle.get(service) - amountUsed + freeUnits.get(service)) * CalculateExtraCharge.getServiePrice(service);
                        }
                    } else {
                        extraCharge += Math.abs(bundle.get(service) - amountUsed) * CalculateExtraCharge.getServiePrice(service);
                    }
                }
            } else {
                extraCharge += amountUsed * CalculateExtraCharge.getServiePrice(service);
            }

        }

        return extraCharge;
    }

    private static Double getServiePrice(String service) {

        Double price = 0.0;
        try {
            price = database.getServicePrice(service.split("_")[0], service.split("_")[1]);

            return price;
        } catch (ArrayIndexOutOfBoundsException e) {
            price = database.getServicePrice(service);

            return price;
        }

    }
}
