/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rating.model;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author nour
 */
public class CDR {
    
    private int cdr_id;
    private String msisdn;
    private String dial_b;
    private int service_id;
    private int rateplan_id;
    private double usage;
   
    
    public CDR() {}

    public CDR(int cdr_id, String msisdn, String dial_b, int service_id, int rateplan_id, double usage) {
        this.cdr_id = cdr_id;
        this.msisdn = msisdn;
        this.dial_b = dial_b;
        this.service_id = service_id;
        this.rateplan_id = rateplan_id;
        this.usage = usage;
        
    }

    public int getCdr_id() {
        return cdr_id;
    }

    public void setCdr_id(int cdr_id) {
        this.cdr_id = cdr_id;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getDial_b() {
        return dial_b;
    }

    public void setDial_b(String dial_b) {
        this.dial_b = dial_b;
    }

    public int getService_id() {
        return service_id;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    public int getRateplan_id() {
        return rateplan_id;
    }

    public void setRateplan_id(int rateplan_id) {
        this.rateplan_id = rateplan_id;
    }

  

    public double getUsage() {
        return usage;
    }

    public void setUsage(double usage) {
        this.usage = usage;
    }
    
}

