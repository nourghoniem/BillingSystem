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
   private Double one_time = 0.0; 
   private Double recurring = 0.0;
   private Double non_rating = 0.0;
private Double RatePlanPrice = 0.0;


    public Double getRatePlanPrice() {
        return RatePlanPrice;
    }

    public void setRatePlanPrice(Double RatePlanPrice) {
        this.RatePlanPrice = RatePlanPrice;
    }
   

    public User(String msisdn, int ratePlanId) {
        this.msisdn = msisdn;
        this.ratePlanId = ratePlanId;
    }

    public User() {
       
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

    public Double getOne_time() {
        return one_time;
    }

    public void setOne_time(Double one_time) {
        this.one_time = one_time;
    }

    public Double getRecurring() {
        return recurring;
    }

    public void setRecurring(Double recurring) {
        this.recurring = recurring;
    }

    public Double getNon_rating() {
        return non_rating;
    }

    public void setNon_rating(Double non_rating) {
        this.non_rating = non_rating;
    }

  

}
