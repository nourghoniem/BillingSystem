/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.billing.rateplan;

import com.billing.servicepackage.ServicePackage;
import com.billing.servicepackage.ServicePackageHandler;
import java.util.ArrayList;

/**
 *
 * @author Michael Ramez
 */
public class RatePlan {

    private int id, servicePackageId, nonRatingId, freeUnitId, price, recurring, oneTime;
    private String name;
    private ArrayList<ServicePackage> sp = new ArrayList<ServicePackage>();
    private RatePlan nonrating;
    private ServicePackage freeUnits;

    public RatePlan(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.sp.clear();
    }

    public RatePlan(int id, int nonRatingId, int freeUnitId, int price, String name) {
        this.id = id;
        this.nonRatingId = nonRatingId;
        this.freeUnitId = freeUnitId;
        this.price = price;
        this.name = name;
        this.nonrating = RatePlanHandler.getRatePlanHanlder().getNonRating(id);
        this.freeUnits = ServicePackageHandler.getServicePackageHandler().getFreeService(id);
    }

    public RatePlan(int id, int servicePackageId, int nonRatingId, int freeUnitId, String name, int price) {
        this.id = id;
        this.servicePackageId = servicePackageId;
        this.nonRatingId = nonRatingId;
        this.freeUnitId = freeUnitId;
        this.name = name;
        this.price = price;
        this.sp.clear();
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

    public int getRecurring() {
        return recurring;
    }

    public void setRecurring(int recurring) {
        this.recurring = recurring;
    }

    public int getOneTime() {
        return oneTime;
    }

    public void setOneTime(int oneTime) {
        this.oneTime = oneTime;
    }

    public ArrayList<ServicePackage> getSp() {
        return sp;
    }

    public void setSp(ArrayList<ServicePackage> sp) {
        this.sp = sp;
    }

}
