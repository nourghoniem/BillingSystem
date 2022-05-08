/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mediation.model;


import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author nour
 */
public class CDR {
    private String msisdn;
    private String dial_b;
    private int service_id;
    private int rateplan_id;
    private int usage;
    private LocalDate start_date;
    private LocalTime start_time;
    
    public CDR() {}

    public CDR(String msisdn, String dial_b, int service_id, int rateplan_id, int usage, LocalDate start_date, LocalTime start_time) {
        this.msisdn = msisdn;
        this.dial_b = dial_b;
        this.service_id = service_id;
        this.rateplan_id = rateplan_id;
        this.usage = usage;
        this.start_date = start_date;
        this.start_time = start_time;
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

    public LocalDate getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public LocalTime getStart_time() {
        return start_time;
    }

    public void setStart_time(LocalTime start_time) {
        this.start_time = start_time;
    }

    public int getUsage() {
        return usage;
    }

    public void setUsage(int usage) {
        this.usage = usage;
    }
    
}
