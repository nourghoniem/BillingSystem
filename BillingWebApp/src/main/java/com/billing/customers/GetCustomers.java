/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.billing.customers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.StringJoiner;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nour
 */
public class GetCustomers extends HttpServlet {

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp)
            throws ServletException, IOException {
         CustomerHandler customerHandler = CustomerHandler.getRatePlanHanlder();
        String result ="";
        StringJoiner s = new StringJoiner(" ");  
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        String check = request.getParameter("check");
        if(check.equalsIgnoreCase("none")){
             
             result = "";
                List<Customer> customers = customerHandler.getCustomers();
             for (Customer c : customers) {
                 result = " <tr>\n" +
"                                            <td>"+c.getName()+"</td>\n" +
"                                            <td>"+c.getMsisdn()+"</td>\n" +
"                                            <td>"+c.getEmail()+"</td>\n" +
"                                            <td>"+c.getRateplan_name()+"</td>\n" +
"                                            <td>"+c.getBill_cycle()+"</td>\n" +                                         
"                                        </tr>";
                 s.add(result); 
             }
       
        }else{
          
             List<Customer> customers_search = customerHandler.getCustomersSearch(check);
             result = "";
             for (Customer c : customers_search) {
                 result = " <tr>\n" +
"                                            <td>"+c.getName()+"</td>\n" +
"                                            <td>"+c.getMsisdn()+"</td>\n" +
"                                            <td>"+c.getEmail()+"</td>\n" +
"                                            <td>"+c.getRateplan_name()+"</td>\n" +
"                                            <td>"+c.getBill_cycle()+"</td>\n" +

"                                        </tr>";
              
               s.add(result);
               
             }
        }
       out.println(s);
    }
    

  

}
