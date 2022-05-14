/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.billing.rateplan;

/**
 *
 * @author Michael Ramez
 */
public class RatePlan {
    
    private int  id;
    private final int servicePackageId; 
    private String name;

    public RatePlan(int servicePackageId, String name) {
        this.servicePackageId = servicePackageId;
        this.name = name;
    }

    public RatePlan(int id, int servicePackageId, String name) {
        this.id = id;
        this.servicePackageId = servicePackageId;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getServicePackageId() {
        return servicePackageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
