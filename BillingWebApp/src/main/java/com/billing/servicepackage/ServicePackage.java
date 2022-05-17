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
    private int service_id, service_type_id;
    private String service_destination, service_type;

    public ServicePackage(int id, int amount, String service_destination, String service_type) {
        this.id = id;
        this.amount = amount;

        this.service_destination = service_destination;
        this.service_type = service_type;
    }

    public ServicePackage(int amount, String service_destination, String service_type) {
        this.id = id;
        this.amount = amount;

        this.service_destination = service_destination;
        this.service_type = service_type;
    }

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

    public String getService_destination() {
        return service_destination;
    }

    public void setService_destination(String service_destination) {
        this.service_destination = service_destination;
    }

    public String getService_type() {
        return service_type;
    }

    public void setService_type(String service_type) {
        this.service_type = service_type;
    }

}
