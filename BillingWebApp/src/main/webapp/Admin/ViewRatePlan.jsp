<%-- 
    Document   : AddRatePlan
    Created on : May 17, 2022, 5:11:15 AM
    Author     : Salma
--%>

<%@page import="com.billing.servicepackage.ServicePackage"%>
<%@page import="com.billing.servicepackage.ServicePackage"%>
<%@page import="com.billing.servicepackage.ServicePackageHandler"%>
<%@page import="com.billing.rateplan.RatePlan"%>
<%@page import="java.util.List"%>
<%@page import="com.billing.rateplan.RatePlanHandler"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.google.gson.GsonBuilder"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="header.jsp" %>
<% GsonBuilder gsonBuilder = new GsonBuilder();
   Gson gson = gsonBuilder.create();
    RatePlanHandler rp= RatePlanHandler.getRatePlanHanlder();
   List<RatePlan> rps=rp.GetCurrentRatePlans();
      for(RatePlan rep:rps){
         List<Integer> svp=ServicePackageHandler.getServicePackageHandler().getServicePkgs(rep.getId());
         for(int spid:svp){
             ServicePackage sp=ServicePackageHandler.getServicePackageHandler().getService(spid);
             rep.getSp().add(sp);
         }
         
      }
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

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                 <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">Rate Plans</h1>
                    </div>

                    <div class="row" id="rps">
                       
                            </div>

                    <!-- /.container-fluid -->
                    
                </div>
                <!-- End of Main Content -->

                <!-- Footer -->
                <footer class="sticky-footer bg-white">
                    <div class="container my-auto">
                        <div class="copyright text-center my-auto">
                            <span>Copyright &copy; Your Website 2020</span>
                        </div>
                    </div>
                </footer>
                <!-- End of Footer -->

            </div>
            <!-- End of Content Wrapper -->

        </div>
        <!-- End of Page Wrapper -->

        <!-- Scroll to Top Button-->
        <a class="scroll-to-top rounded" href="#page-top">
            <i class="fas fa-angle-up"></i>
        </a>

        <!-- Logout Modal-->
        <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
            aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                        <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">×</span>
                        </button>
                    </div>
                    <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                    <div class="modal-footer">
                        <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                        <a class="btn btn-primary" href="login.html">Logout</a>
                    </div>
                </div>
            </div>
        </div>
   <script src="js/viewRatePlan.js" type="text/javascript"></script>
                <script >
                    $("document").ready(function () {
                        console.log(<%=rs%>);
                                 displayRateplans(<%=rs%>);
                  });
                    
                </script>
        <!-- Bootstrap core JavaScript-->
        <%@include file="footer.jsp" %>