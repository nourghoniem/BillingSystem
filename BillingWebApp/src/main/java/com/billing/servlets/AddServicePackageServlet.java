/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.billing.servlets;

import com.billing.servicepackage.ServicePackage;
import com.billing.servicepackage.ServicePackageHandler;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Michael Ramez
 */
public class AddServicePackageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int serviceId = Integer.parseInt(request.getParameter("serviceId"));
        int serviceTypeId = Integer.parseInt(request.getParameter("service_type_id"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        ServicePackage servicePackage = new ServicePackage(amount, serviceId, serviceTypeId);
        ServicePackageHandler servicePackageHandler = ServicePackageHandler.getServicePackageHandler();
        servicePackageHandler.AddServicePackage(servicePackage);
        response.sendRedirect("AddRatePlan.jsp");
    }

    
}
