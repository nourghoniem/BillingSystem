/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.billing.customers;

import java.time.LocalDate;

/**
 *
 * @author nour
 */
public class Customer {
    
    private int id;
    private String name;
    private String email;
    private String msisdn;
    private int rateplan_id;
    private String rateplan_name;
    private LocalDate creation_date;
    private int recurring = 0;
    private int onetime = 0;
    private LocalDate bill_cycle;
    
    public Customer(){}

    public Customer(Integer id, String name, String email, String msisdn, String rateplan_name, LocalDate bill_cycle) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.msisdn = msisdn;
        this.rateplan_name = rateplan_name;
        this.bill_cycle = bill_cycle;
    }
    
     public Customer(String name, String email, String msisdn, String rateplan_name, LocalDate bill_cycle, int recurring, int onetime) {
        this.name = name;
        this.email = email;
        this.msisdn = msisdn;
        this.rateplan_name = rateplan_name;
        this.bill_cycle = bill_cycle;
        this.onetime = onetime;
        this.recurring = recurring;
    }
    
    

    public Customer(String name, String email, String msisdn, int rateplan_id, LocalDate creation_date, int recurring, int onetime, LocalDate bill_cycle) {
        this.name = name;
        this.email = email;
        this.msisdn = msisdn;
        this.rateplan_id = rateplan_id;
        this.creation_date = creation_date;
        this.recurring = recurring;
        this.onetime = onetime;
        this.bill_cycle = bill_cycle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRateplan_name() {
        return rateplan_name;
    }

    public void setRateplan_name(String rateplan_name) {
        this.rateplan_name = rateplan_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public int getRateplan_id() {
        return rateplan_id;
    }

    public void setRateplan_id(int rateplan_id) {
        this.rateplan_id = rateplan_id;
    }

    public LocalDate getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(LocalDate creation_date) {
        this.creation_date = creation_date;
    }

    public int getRecurring() {
        return recurring;
    }

    public void setRecurring(int recurring) {
        this.recurring = recurring;
    }

    public int getOnetime() {
        return onetime;
    }

    public void setOnetime(int onetime) {
        this.onetime = onetime;
    }

    public LocalDate getBill_cycle() {
        return bill_cycle;
    }

    public void setBill_cycle(LocalDate bill_cycle) {
        this.bill_cycle = bill_cycle;
    }
    
    
    
         
    
    
    
    
    
    
}
