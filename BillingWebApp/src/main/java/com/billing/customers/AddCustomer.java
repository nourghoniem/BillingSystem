/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.billing.customers;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nour
 */
public class AddCustomer extends HttpServlet {
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp)
            throws ServletException, IOException {
        
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String msisdn = request.getParameter("msisdn");
        String rateplan = request.getParameter("rateplan");
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-dd");
       
        String bill_cycle = request.getParameter("bill_cycle");
        String[] columns = bill_cycle.split("-");
        Integer recurring = Integer.parseInt(request.getParameter("recurring"));
        Integer one_time = Integer.parseInt(request.getParameter("one_time"));
        LocalDate date = LocalDate.of(Integer.parseInt(columns[0]),Integer.parseInt(columns[1]), Integer.parseInt(columns[2]));
        Customer customer = new Customer(name, email, msisdn, rateplan, date, recurring, one_time);
        CustomerHandler customerHandler = CustomerHandler.getRatePlanHanlder();
        int customer_id = customerHandler.addCustomer(customer);
        out.println(customer_id);
//        customerHandler.addContract(customer, customer_id);
        
        
        
     
    }

}
