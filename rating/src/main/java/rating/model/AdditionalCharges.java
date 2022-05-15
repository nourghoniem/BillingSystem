/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rating.model;

import java.util.ArrayList;
import rating.database.DatabaseManagement;

/**
 *
 * @author Aya Mostafa
 */
public class AdditionalCharges {
    
  
    private Double one_time = 0.0; 
    private Double recurring = 0.0;
    private Double non_rating = 0.0;

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
