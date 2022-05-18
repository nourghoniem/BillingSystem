<%-- 
    Document   : sidebar
    Created on : May 3, 2022, 2:11:54 PM
    Author     : Salma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
  <!-- Sidebar -->
            <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

                <!-- Sidebar - Brand -->
                <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
                    <div class="sidebar-brand-icon rotate-n-15">
                        <i class="fas fa-globe" ></i>
                    </div>
                    <div class="sidebar-brand-text mx-3">ORG</div>
                </a>

                <!-- Divider -->
                <hr class="sidebar-divider my-0">

                <!-- Nav Item - Dashboard -->
               
                 <hr class="sidebar-divider">
                <!-- Divider -->
                  <div class="sidebar-heading">
                 Up Streams
                </div>
                <li class="nav-item">
                    <a class="nav-link" href="UploadCdr.jsp">
                        <i class="fas fa fa-folder-open-o"></i>
                        <span>Upload CDR</span></a>
                </li>
                <hr class="sidebar-divider">
                <!-- Heading -->
                <div class="sidebar-heading">
                    Manage Users
                </div>
                <li class="nav-item">
                    <a class="nav-link" href="customers_management_page.jsp">
                       <i class="fas fa-group" ></i>
                        <span>Users</span></a>
                </li>
                <!-- Divider -->
                
              
                
<!--                 Heading -->
 <hr class="sidebar-divider">
                                <div class="sidebar-heading">
                                    Manage Rate plans
                                </div>
                
<!--                                 Nav Item - Pages Collapse Menu -->
                                <li class="nav-item">
                                    <a class="nav-link " href="#" data-toggle="collapse" data-target="#collapseTwo"
                                       aria-expanded="true" aria-controls="collapseTwo">
                                        <i class="fas fa-fw fa-cog"></i>
                                         <span> Actions </span>
                                    </a>
                                    <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                                        <div class="bg-white py-2 collapse-inner rounded">
                                            
                                       
                    <a class="collapse-item" href="ViewRatePlan.jsp">
                    
                        <span> Display Rate Plans</span></a>
              

         
                    <a class="collapse-item" href="AddRatePlan.jsp">
                       
                        <span>Add new Rate Plan</span></a>
              
                    <a class="collapse-item" href="AddServicePkg.jsp">
                       
                        <span>Add Service Package</span></a>
               

              
                                        </div>
                                    </div>
                                </li>

 <hr class="sidebar-divider">

 <div class="sidebar-heading">
                   invoices
                </div>
                <li class="nav-item">
                    <a class="nav-link" href="#">
                        <i class="fas fa-fw fa-file-pdf-o"></i>
                        <span>Display invoices </span></a>
                </li>
                <hr class="sidebar-divider">
                 <li class="nav-item">
                    <a class="nav-link" href="#">
                       <i class="fas fa fa-sign-out"></i>
                        <span>Log Out </span></a>
                </li>
                <!-- Divider -->
               

                <!-- Sidebar Toggler (Sidebar) -->
              

            </ul>
            <!-- End of Sidebar -->