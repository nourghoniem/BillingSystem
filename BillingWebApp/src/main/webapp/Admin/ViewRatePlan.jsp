<%-- 
    Document   : ViewRatePlan
    Created on : May 16, 2022, 6:37:47 PM
    Author     : Salma
--%>


<%@page import="com.google.gson.Gson"%>
<%@page import="com.google.gson.GsonBuilder"%>
<%@page import="com.billing.rateplan.RatePlan"%>
<%@page import="java.util.List"%>
<%@page import="com.billing.rateplan.RatePlanHandler"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%-- 
    Document   : UploadCdr
    Created on : May 16, 2022, 5:20:15 PM
    Author     : Salma
--%>


<%@include file="header.jsp" %>
<% RatePlanHandler rp= RatePlanHandler.getRatePlanHanlder();
   List<RatePlan> rps=rp.GetCurrentRatePlans();
   GsonBuilder gsonBuilder = new GsonBuilder();
     Gson gson = gsonBuilder.create();
     String rs= gson.toJson(rps);
  %>
    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
        <%@include file="sidebar.jsp" %>
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
                <%@include file="topbar.jsp" %>
                <!-- End of Topbar -->
<div class="container-fluid">

                    <!-- Page Heading -->
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">Rate Plans</h1>
                    </div>

                    <div class="row" id="rps">

                        <!-- Earnings (Monthly) Card Example -->
                       
                        <!-- Tasks Card Example -->
                      <div class="row">

                          <div class="col-lg-6" id="details" style="display: 
                                 none">

                            <!-- Default Card Example -->
                            <div class="card mb-4" >
                                <div class="card-header"  >
                                    Default Card Example
                                </div>
                                <div class="card-body details">
                                    This card uses Bootstrap's default styling with no utility classes added. Global
                                    styles are the only things modifying the look and feel of this default card example.
                                </div>
                            </div>

                

                   
                <!-- Begin Page Content -->
            <script src="js/viewRatePlan.js" type="text/javascript"></script>
                <script >
                    $("document").ready(function () {
                                 displayRateplans(<%=rs%>);
                  });
                    
                </script>
               
</body>

</html>
