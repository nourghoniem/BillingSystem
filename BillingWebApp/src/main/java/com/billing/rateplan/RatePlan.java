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

    private int id, servicePackageId, nonRatingId, freeUnitId, price;
    private String name;

    public RatePlan(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public RatePlan(int id, int servicePackageId, int nonRatingId, int freeUnitId, String name, int price) {
        this.id = id;
        this.servicePackageId = servicePackageId;
        this.nonRatingId = nonRatingId;
        this.freeUnitId = freeUnitId;
        this.name = name;
        this.price = price;
    }

    public RatePlan(int servicePackageId, int nonRatingId, int freeUnitId, String name, int price) {
        this.servicePackageId = servicePackageId;
        this.nonRatingId = nonRatingId;
        this.freeUnitId = freeUnitId;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public int getServicePackageId() {
        return servicePackageId;
    }

    public int getNonRatingId() {
        return nonRatingId;
    }

    public int getFreeUnitId() {
        return freeUnitId;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setServicePackageId(int servicePackageId) {
        this.servicePackageId = servicePackageId;
    }

    public void setNonRatingId(int nonRatingId) {
        this.nonRatingId = nonRatingId;
    }

    public void setFreeUnitId(int freeUnitId) {
        this.freeUnitId = freeUnitId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
