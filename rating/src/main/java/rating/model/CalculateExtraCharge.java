/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rating.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import rating.database.DatabaseManagement;

/**
 *
 * @author Salma
 */
public class CalculateExtraCharge {

    private final String VON_NET = "voice on-net";
    private final String VCR_NET = "voice cross-net";
    private final String SON_NET = "SMS on-net";
    private final String SCR_NET = "SMS cross-net";
    private final String DATA = "data cross-net";
    private final String VROOM = "voice roaming";
    private final String VINT = "voice international";
    DatabaseManagement database = new DatabaseManagement();
    ArrayList<String> users;

    public Double CalculateExtraCharge() throws SQLException {
        Double extraCharges = 0.0;
        this.users = database.getUsers();
        for (String us : users) {
            int ratePlanId = database.getRatePlan(us);
            Rating customerUsage = database.getCustomerUsage(us);
            HashMap<String, Integer> bundle = database.getCustomerPackage(ratePlanId);
            HashMap<String, Integer> fbundle = database.getFreePackage(ratePlanId);

            if (bundle.get(VON_NET) != null) {
                if (bundle.get(VON_NET) - customerUsage.getVoice_onnet() >= 0) {
                    extraCharges += 0;

                } else {
                    extraCharges = (bundle.get(VON_NET) - customerUsage.getVoice_onnet()) * database.getServicePrice("voice", "on-net");

                }
            } else {
                extraCharges += customerUsage.getVoice_onnet() * database.getServicePrice("voice", "on-net");

            }
        }
        return extraCharges;
    }

    public Double getVoiceOnNet(int ratePlanId) {
        if (bundle.get(VON_NET) != null) {
            if (bundle.get(VON_NET) - customerUsage.getVoice_onnet() >= 0) {
                extraCharges += 0;

            } else {
                extraCharges = (bundle.get(VON_NET) - customerUsage.getVoice_onnet()) * database.getServicePrice("voice", "on-net");

            }
        } else {
            extraCharges += customerUsage.getVoice_onnet() * database.getServicePrice("voice", "on-net");

        }
    }

}
