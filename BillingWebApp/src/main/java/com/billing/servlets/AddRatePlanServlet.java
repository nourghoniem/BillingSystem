/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.billing.servlets;

import com.billing.rateplan.RatePlan;
import com.billing.rateplan.RatePlanHandler;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Michael Ramez
 */
public class AddRatePlanServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int[] = request.getParameterValues("")
        String rpName = request.getParameter("rpName");
        int rpPrice = Integer.parseInt(request.getParameter("rpPrice"));
        int nonRatingId = Integer.parseInt(request.getParameter("otherPkgs"));
        int freeUnitId = Integer.parseInt(request.getParameter("freePkgs"));
        String[] stringServicePackageIds = request.getParameterValues("svpid");
        int[] servicePackageIds = new int[stringServicePackageIds.length];
        for (int i = 0; i < stringServicePackageIds.length; i++){
            servicePackageIds[i] = Integer.parseInt(stringServicePackageIds[i]);
        }      
        RatePlan ratePlan = new RatePlan(servicePackageIds, nonRatingId, freeUnitId, rpName, rpPrice);
        RatePlanHandler ratePlanHandler = RatePlanHandler.getRatePlanHanlder();
        ratePlanHandler.AddServiceRatePlan(ratePlan);
        response.sendRedirect("ViewRatePlan.jsp");
        
    }

}
