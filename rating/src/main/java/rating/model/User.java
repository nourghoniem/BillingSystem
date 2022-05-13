/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rating.model;

import java.util.HashMap;

/**
 *
 * @author Salma
 */
public class User {

    private String msisdn;
    private int ratePlanId;
    private HashMap<String, Integer> bundle;
    private HashMap<String, Integer> freeUnits;
    private Rating usage;
    private Double extraCharges = 0.0;

    public User(String msisdn, int ratePlanId) {
        this.msisdn = msisdn;
        this.ratePlanId = ratePlanId;
    }

    public User() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Rating getUsage() {
        return usage;
    }

    public void setUsage(Rating usage) {
        this.usage = usage;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public int getRatePlanId() {
        return ratePlanId;
    }

    public void setRatePlanId(int ratePlanId) {
        this.ratePlanId = ratePlanId;
    }

    public HashMap<String, Integer> getBundle() {
        return bundle;
    }

    public void setBundle(HashMap<String, Integer> bundle) {
        this.bundle = bundle;
    }

    public HashMap<String, Integer> getFreeUnits() {
        return freeUnits;
    }

    public void setFreeUnits(HashMap<String, Integer> freeUnits) {
        this.freeUnits = freeUnits;
    }

    public Double getExtraCharges() {
        return extraCharges;
    }

    public void setExtraCharges(Double extraCharges) {
        this.extraCharges = extraCharges;
    }

}
