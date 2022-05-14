/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.billing.servicepackage;

/**
 *
 * @author Michael Ramez
 */
public class ServicePackage {

   private int id, amount;
   private final int service_id, service_type_id;

    public ServicePackage(int amount, int service_id, int service_type_id) {
        this.amount = amount;
        this.service_id = service_id;
        this.service_type_id = service_type_id;
    }

    public ServicePackage(int id, int amount, int service_id, int service_type_id) {
        this.id = id;
        this.amount = amount;
        this.service_id = service_id;
        this.service_type_id = service_type_id;
    }

    public int getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public int getService_id() {
        return service_id;
    }

    public int getService_type_id() {
        return service_type_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
   
   
}
