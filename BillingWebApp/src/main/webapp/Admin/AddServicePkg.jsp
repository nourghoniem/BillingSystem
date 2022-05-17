<%-- 
    Document   : AddRatePlan
    Created on : May 17, 2022, 5:11:15 AM
    Author     : Salma
--%>

<%@page import="com.billing.servicepackage.ServicePackage"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.billing.servicepackage.ServicePackageHandler"%>
<%@page import="com.billing.rateplan.RatePlanHandler"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.google.gson.GsonBuilder"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="header.jsp" %>

<% GsonBuilder gsonBuilder = new GsonBuilder();
   Gson gson = gsonBuilder.create();
    ArrayList<ServicePackage> eventTypes=ServicePackageHandler.getServicePackageHandler().getAllEventTypes();
    
   
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
                    <h2 class="title">Add New Service Package</h2>
                    <p></p>
                      <p></p>
                    <form method="GET">
                        <div class="row">
                                        <div class="col-sm-12 col-md-6">
                                            <div class="dataTables_length" ><label>Select Event Type <select id="evt" name="serviceId" aria-controls="dataTable" class="custom-select custom-select-sm form-control form-control-sm" onchange="javascript: dynamicdropdown(this.options[this.selectedIndex].value);">
                                                     <option value="" >Select Event Type</option>
                                                        <% for(ServicePackage sp:eventTypes){%>
                                                         
                                                      <option value=<%=sp.getService_id()%> ><%= sp.getService_type()%></option>
                                                      <%}%>
                                                    </select> </label></div>
                                        </div>
                                      
                                    </div>
                              <div class="row">
                                        <div class="col-sm-12 col-md-4">
                                            <div class="dataTables_length" ><label>Select Zone Package <select id="zpk" name="service_type_id"  aria-controls="dataTable" class="custom-select custom-select-sm form-control form-control-sm">
                                                      
                                                    </select> </label></div>
                                        </div>
                                       
                                    </div>
                        
                        <div class="row">
                        <div class="col-sm-12 col-md-4">
                            <div id="dataTable_filter" class="dataTables_filter"><label>Amount<input type="text" name="amount" class="form-control form-control-sm" placeholder="" aria-controls="dataTable"></label></div>
                                        </div>
                          </div>
                           <div class="row " style="user-select: auto;justify-content: center;width: 100%;/* height: 50%; */">
                              <input type="submit" value="Add New Service Package" class="btn btn-primary btn-icon-split btn-lg" style="user-select: auto;height: -21%;">
                            </div>
                    </form>
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
          function dynamicdropdown(listindex)
    { 
        document.getElementById("zpk").options.length = 0;
        
        switch (listindex)
        {
          
        case "1" :
            document.getElementById("zpk").options[0]=new Option("Select zone package","");
            document.getElementById("zpk").options[1]=new Option("on-net","1");
            document.getElementById("zpk").options[2]=new Option("cross-net","2");
            document.getElementById("zpk").options[3]=new Option("roaming","3");
            document.getElementById("zpk").options[4]=new Option("international","4");
            break;
        case "2" :
           document.getElementById("zpk").options[0]=new Option("Select zone package","");
            document.getElementById("zpk").options[1]=new Option("on-net","1");
            document.getElementById("zpk").options[2]=new Option("cross-net","2");
          
            break;
            case "3" :
            document.getElementById("zpk").options[0]=new Option("Select zone package","");
            document.getElementById("zpk").options[1]=new Option("cross-net","2");
           
            break;
        }
        return true;
    }
        </script>

        <!-- Bootstrap core JavaScript-->
        <%@include file="footer.jsp" %>