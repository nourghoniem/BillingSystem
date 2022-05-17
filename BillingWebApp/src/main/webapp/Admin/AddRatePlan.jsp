<%-- 
    Document   : AddRatePlan
    Created on : May 17, 2022, 5:11:15 AM
    Author     : Salma
--%>

<%@page import="com.billing.servicepackage.ServicePackageHandler"%>
<%@page import="com.billing.rateplan.RatePlanHandler"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.google.gson.GsonBuilder"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="header.jsp" %>

<% GsonBuilder gsonBuilder = new GsonBuilder();
   Gson gson = gsonBuilder.create();
    String nonrating=gson.toJson(RatePlanHandler.getRatePlanHanlder().getNonRatings());
    String freeUnits=gson.toJson(ServicePackageHandler.getServicePackageHandler().getFreeServices());
    String servicePkgs=gson.toJson(ServicePackageHandler.getServicePackageHandler().getServices());
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
                     
            <div class="card ">
                <div class="card-body">
                    <h2 class="title">Add RatePlan</h2>
                    <p></p>
                      <p></p>
                    <form method="POST">
                        <div class="row ">
                            <div class="col-4">
                               
 
                                       
                                <input type="text" id="search_input" class="form-control bg-light border-0 small" placeholder="Enter Rate Plan Name" aria-label="Search" aria-describedby="basic-addon2" name="rpName">
                                
                            </div>
                               <div class="col-4">
                               
 
                                    
                                <input type="text" id="search_input" class="form-control bg-light border-0 small" placeholder="Enter Price" aria-label="Search" aria-describedby="basic-addon2" name="rpPrice">
                                
                            </div>
                            </div>
                        <p></P>
                        <hr class="sidebar-divider my-0" style="margin-top: 3%">
                         <div class="row ">
                            <div class="col-4">
                                <p style="display:inline; color: red">Add Service Packages to Rate Plan</p>   
                               <hr class="sidebar-divider my-0" style="margin-top: 3%">
                               
                                <div id="svpk">
                            
                                </div>
                            </div>
                            </div>
                        <div class="row ">
                            <div class="col-4">
                                <p style="display:inline; color: red">Add freeUnits to Rate Plan</p>   
                               <hr class="sidebar-divider my-0" style="margin-top: 3%">
                               
                                <div id="fpk">
                            
                                </div>
                            </div>
                            </div>
                        
                              <div class="row ">
                            <div class="col-4">
                                <p style="display:inline; color: red">Add Other Services</p>   
                               <hr class="sidebar-divider my-0" style="margin-top: 3%">
                               
                                <div id="opk">
                            
                                </div>
                            </div>
                            </div>
                          <div class="row ">
                              <input type="submit" value="Add New Rate Plan" class="btn btn-primary btn-icon-split" />
                            </div>
                        
                    </form>
                </div>
            </div>
      
                    <!-- /.container-fluid -->
                    <label id="uplStatus" style="display: none"></label>
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
       
        <script>
            $("document").ready(function(){
                 getServices(<%=servicePkgs %>);
            getFreeUnits(<%=freeUnits%>);
            getnonRating(<%=nonrating %>);
                
            });
           
        </script>
        <script src="js/newRatePlan.js"></script>
        <!-- Bootstrap core JavaScript-->
        <%@include file="footer.jsp" %>