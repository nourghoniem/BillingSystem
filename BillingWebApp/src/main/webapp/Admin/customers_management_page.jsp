<%-- 
    Document   : client_management_page
    Created on : Mar 12, 2022, 10:37:41 PM
    Author     : nour
--%>
<%@page import="com.billing.customers.Customer"%>
<%@page import="com.billing.customers.CustomerHandler"%>
<%@page import="java.nio.file.Paths"%>
<%@page import="java.nio.file.Path"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    CustomerHandler customerHandler = CustomerHandler.getRatePlanHanlder();
    List<Customer> customers = customerHandler.getCustomers();
%>

<!DOCTYPE html>
<html lang="en">
    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

        <title>SB Admin 2 - Tables</title>

        <!-- Custom fonts for this template -->
        <!--    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">-->
        <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/sb-admin-2.min.css" rel="stylesheet">
        <!--        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <!-- Custom styles for this page -->
        <!--        <link href="E-Commerce/web/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">-->

    </head>

    <body id="page-top">


        <!-- Page Wrapper -->
        <div id="wrapper">

            <!-- Sidebar -->
            <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

                <!-- Sidebar - Brand -->
                <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
                    <div class="sidebar-brand-icon rotate-n-15">
                        <i class="fas fa-laugh-wink"></i>
                    </div>
                    <div class="sidebar-brand-text mx-3">SB Admin <sup>2</sup></div>
                </a>

                <!-- Divider -->
                <hr class="sidebar-divider my-0">

                <!-- Nav Item - Dashboard -->
                <li class="nav-item">
                    <a class="nav-link" href="customers_management_page.jsp">
                        <i class="fas fa-fw fa-tachometer-alt"></i>
                        <span>Dashboard</span></a>
                </li>
                <!-- Divider -->
                <hr class="sidebar-divider">
                <!-- Heading -->
                <div class="sidebar-heading">
                    Manage Users
                </div>
                <li class="nav-item">
                    <a class="nav-link" href="client_management_page.jsp">
                        <i class="fas fa-fw fa-tachometer-alt"></i>
                        <span>Users</span></a>
                </li>
                <!-- Divider -->
                <hr class="sidebar-divider">
                <div class="sidebar-heading">
                    Manage Products
                </div>
                <li class="nav-item">
                    <a class="nav-link" href="products_management_page.jsp">
                        <i class="fas fa-fw fa-tachometer-alt"></i>
                        <span>Products</span></a>
                </li>



                <!-- Heading -->
                <!--                <div class="sidebar-heading">
                                    Interface
                                </div>
                
                                 Nav Item - Pages Collapse Menu 
                                <li class="nav-item">
                                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo"
                                       aria-expanded="true" aria-controls="collapseTwo">
                                        <i class="fas fa-fw fa-cog"></i>
                                        <span>Components</span>
                                    </a>
                                    <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                                        <div class="bg-white py-2 collapse-inner rounded">
                                            <h6 class="collapse-header">Custom Components:</h6>
                                            <a class="collapse-item" href="buttons.html">Buttons</a>
                                            <a class="collapse-item" href="cards.html">Cards</a>
                                        </div>
                                    </div>
                                </li>-->




                <!-- Divider -->
                <hr class="sidebar-divider d-none d-md-block">

                <!-- Sidebar Toggler (Sidebar) -->
                <div class="text-center d-none d-md-inline">
                    <button class="rounded-circle border-0" id="sidebarToggle"></button>
                </div>

            </ul>
            <!-- End of Sidebar -->

            <!-- Content Wrapper -->
            <div id="content-wrapper" class="d-flex flex-column">

                <!-- Main Content -->
                <div id="content">

                    <!-- Topbar -->
                    <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                        <!-- Sidebar Toggle (Topbar) -->
                        <form class="form-inline">
                            <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                                <i class="fa fa-bars"></i>
                            </button>
                        </form>

                        <!-- Topbar Search -->
                        <form
                            class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
                            <div class="input-group">
                                <input type="text" id="search_input" class="form-control bg-light border-0 small" placeholder="Search for..."
                                       aria-label="Search" aria-describedby="basic-addon2">
                                <div class="input-group-append">
                                    <button class="btn btn-primary" type="button">
                                        <i class="fas fa-search fa-sm">Search</i>
                                    </button>
                                </div>
                            </div>
                        </form>

                        <!-- Topbar Navbar -->
                        <ul class="navbar-nav ml-auto">

                            <!-- Nav Item - Search Dropdown (Visible Only XS) -->
                            <li class="nav-item dropdown no-arrow d-sm-none">
                                <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button"
                                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <i class="fas fa-search fa-fw"></i>
                                </a>
                                <!-- Dropdown - Messages -->
                                <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
                                     aria-labelledby="searchDropdown">
                                    <form class="form-inline mr-auto w-100 navbar-search">
                                        <div class="input-group">
                                            <input type="text" class="form-control bg-light border-0 small"
                                                   placeholder="Search for..." aria-label="Search"
                                                   aria-describedby="basic-addon2">
                                            <div class="input-group-append">
                                                <button class="btn btn-primary" type="button">
                                                    <i class="fas fa-search fa-sm"></i>
                                                </button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </li>

                            <!-- Nav Item - Alerts -->
                            <li class="nav-item dropdown no-arrow mx-1">
                                <a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button"
                                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <i class="fas fa-bell fa-fw"></i>
                                    <!-- Counter - Alerts -->
                                    <span class="badge badge-danger badge-counter">3+</span>
                                </a>
                                <!-- Dropdown - Alerts -->
                                <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                     aria-labelledby="alertsDropdown">
                                    <h6 class="dropdown-header">
                                        Alerts Center
                                    </h6>
                                    <a class="dropdown-item d-flex align-items-center" href="#">
                                        <div class="mr-3">
                                            <div class="icon-circle bg-primary">
                                                <i class="fas fa-file-alt text-white"></i>
                                            </div>
                                        </div>
                                        <div>
                                            <div class="small text-gray-500">December 12, 2019</div>
                                            <span class="font-weight-bold">A new monthly report is ready to download!</span>
                                        </div>
                                    </a>
                                    <a class="dropdown-item d-flex align-items-center" href="#">
                                        <div class="mr-3">
                                            <div class="icon-circle bg-success">
                                                <i class="fas fa-donate text-white"></i>
                                            </div>
                                        </div>
                                        <div>
                                            <div class="small text-gray-500">December 7, 2019</div>
                                            $290.29 has been deposited into your account!
                                        </div>
                                    </a>
                                    <a class="dropdown-item d-flex align-items-center" href="#">
                                        <div class="mr-3">
                                            <div class="icon-circle bg-warning">
                                                <i class="fas fa-exclamation-triangle text-white"></i>
                                            </div>
                                        </div>
                                        <div>
                                            <div class="small text-gray-500">December 2, 2019</div>
                                            Spending Alert: We've noticed unusually high spending for your account.
                                        </div>
                                    </a>
                                    <a class="dropdown-item text-center small text-gray-500" href="#">Show All Alerts</a>
                                </div>
                            </li>

                            <!-- Nav Item - Messages -->
                            <li class="nav-item dropdown no-arrow mx-1">
                                <a class="nav-link dropdown-toggle" href="#" id="messagesDropdown" role="button"
                                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <i class="fas fa-envelope fa-fw"></i>
                                    <!-- Counter - Messages -->
                                    <span class="badge badge-danger badge-counter">7</span>
                                </a>
                                <!-- Dropdown - Messages -->
                                <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                     aria-labelledby="messagesDropdown">
                                    <h6 class="dropdown-header">
                                        Message Center
                                    </h6>
                                    <a class="dropdown-item d-flex align-items-center" href="#">
                                        <div class="dropdown-list-image mr-3">
                                            <img class="rounded-circle" src="img/undraw_profile_1.svg"
                                                 alt="...">
                                            <div class="status-indicator bg-success"></div>
                                        </div>
                                        <div class="font-weight-bold">
                                            <div class="text-truncate">Hi there! I am wondering if you can help me with a
                                                problem I've been having.</div>
                                            <div class="small text-gray-500">Emily Fowler · 58m</div>
                                        </div>
                                    </a>
                                    <a class="dropdown-item d-flex align-items-center" href="#">
                                        <div class="dropdown-list-image mr-3">
                                            <img class="rounded-circle" src="img/undraw_profile_2.svg"
                                                 alt="...">
                                            <div class="status-indicator"></div>
                                        </div>
                                        <div>
                                            <div class="text-truncate">I have the photos that you ordered last month, how
                                                would you like them sent to you?</div>
                                            <div class="small text-gray-500">Jae Chun · 1d</div>
                                        </div>
                                    </a>
                                    <a class="dropdown-item d-flex align-items-center" href="#">
                                        <div class="dropdown-list-image mr-3">
                                            <img class="rounded-circle" src="img/undraw_profile_3.svg"
                                                 alt="...">
                                            <div class="status-indicator bg-warning"></div>
                                        </div>
                                        <div>
                                            <div class="text-truncate">Last month's report looks great, I am very happy with
                                                the progress so far, keep up the good work!</div>
                                            <div class="small text-gray-500">Morgan Alvarez · 2d</div>
                                        </div>
                                    </a>
                                    <a class="dropdown-item d-flex align-items-center" href="#">
                                        <div class="dropdown-list-image mr-3">
                                            <img class="rounded-circle" src="https://source.unsplash.com/Mv9hjnEUHR4/60x60"
                                                 alt="...">
                                            <div class="status-indicator bg-success"></div>
                                        </div>
                                        <div>
                                            <div class="text-truncate">Am I a good boy? The reason I ask is because someone
                                                told me that people say this to all dogs, even if they aren't good...</div>
                                            <div class="small text-gray-500">Chicken the Dog · 2w</div>
                                        </div>
                                    </a>
                                    <a class="dropdown-item text-center small text-gray-500" href="#">Read More Messages</a>
                                </div>
                            </li>

                            <div class="topbar-divider d-none d-sm-block"></div>

                            <!-- Nav Item - User Information -->
                            <li class="nav-item dropdown no-arrow">
                                <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <span class="mr-2 d-none d-lg-inline text-gray-600 small">Admin</span>
                                    <img class="img-profile rounded-circle"
                                         src="img/undraw_profile.svg">
                                </a>
                                <!-- Dropdown - User Information -->
                                <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                     aria-labelledby="userDropdown">
                                    <a class="dropdown-item" href="#">
                                        <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                        Profile
                                    </a>
                                    <a class="dropdown-item" href="#">
                                        <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                                        Settings
                                    </a>
                                    <a class="dropdown-item" href="#">
                                        <i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
                                        Activity Log
                                    </a>
                                    <div class="dropdown-divider"></div>
                                    <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                                        <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                        Logout
                                    </a>
                                </div>
                            </li>

                        </ul>

                    </nav>
                    <!-- End of Topbar -->

                    <!-- Begin Page Content -->
                    <div class="container-fluid">

                        <!-- Page Heading -->
                        <!--                        <h1 class="h3 mb-2 text-gray-800">Tables</h1>-->
                        <!--                        <p class="mb-4">DataTables is a third party plugin that is used to generate the demo table below.
                                                    For more information about DataTables, please visit the <a target="_blank"
                                                                                                               href="https://datatables.net">official DataTables documentation</a>.</p>-->

                        <!-- DataTales Example -->
                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h6 class="m-0 font-weight-bold text-primary">Customers' Information</h6>

                                <button type="button" style="position: relative; left: 1350px" class="btn btn-info" data-toggle="modal" data-target="#addProductModal">
                                    Add Customer

                            </div>

                            <!-- Modal -->
                            <div class="modal fade" id="addProductModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content" id="myModal" style="width:800px">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="exampleModalLabel">Add Customer</h5>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>

                                        <form method="POST"  id="addingProduct">
                                            <div class="modal-body">

                                                <div style="display:none" id="success-message" class="alert alert-success" role="alert">
                                                    Customer is successfully added!
                                                </div>

                                                <div class="row">
                                                    <div class="col-md-6">
                                                        <div class="form-group col-md-6 col-sm-6">
                                                            <label for="name"> Name </label>
                                                            <input type="text" class="form-control input-sm" id="name" required="" name="name" placeholder="">
                                                            <p id="nameval" style="color: red; display:none;"></p>
                                                        </div>
                                                        <div class="form-group col-md-6 col-sm-6">
                                                            <label for="email"> Email </label>
                                                            <input type="email" class="form-control input-sm" id="email" required="" name="email" placeholder="">
                                                            <p id="emailval" style="color: red; display:none;"></p>
                                                        </div>
                                                        <div class="form-group col-md-6 col-sm-6">
                                                            <label for="msisdn"> MSISDN </label>
                                                            <input type="text" class="form-control input-sm" id="msisdn" required="" name="msisdn" placeholder="">
                                                            <p id="msisdnval" style="color: red; display:none;"></p>
                                                        </div>

                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class = "form-group col-md-6 col-sm-6">
                                                            <label for="rateplan">Rateplan</label>
                                                            <select class="form-control input-sm"  required="" id="rateplan" name="rateplan">
                                                                <option></option>
                                                                <%                                            for (Customer c : customers) {
                                                                %>
                                                                <option><%=c.getRateplan_name()%></option>  

                                                                <%}%>
                                                            </select>
                                                            <p id="typeval" style="color: red; display:none;"></p>
                                                        </div>
                                                        <div>
                                                            <label  style="position: relative; left: 11px" for="bill_cycle">Bill Cycle</label>
                                                            <input type="date"  style="position: relative; left: 15px" required="" id="bill_cycle" min="<%=java.time.LocalDate.now()%>" value="<%=java.time.LocalDate.now()%>" name="bill_cycle"  placeholder="">
                                                            <p id="billval" style="color: red; display:none;"></p>
                                                        </div>
                                                        <div>
                                                            <label for="rprice" style="padding-top: 20px; position: relative; left: 10px">Recurring Service</label>
                                                            <input type="text" style="width: 100px; position: relative; left: 10px" class="form-control input-sm" id="rprice" required="" name="rprice" placeholder="100LE">
                                                            <p id="rpriceval" style="color: red; display:none;"></p>
                                                        </div>
                                                        <div>
                                                            <label for="oprice" style="padding-top: 20px; position: relative; left: 10px">One-time Service</label>
                                                            <input type="text" style="width: 100px; position: relative; left: 10px" class="form-control input-sm" id="oprice" required="" name="oprice" placeholder="100LE">
                                                            <p id="opriceval" style="color: red; display:none;"></p>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                                                    <button type="submit" id="add_customer_submit" name="editStaff" class="btn btn-outline-info">Add Customer</button>
                                                </div>

                                        </form>

                                        <script>

                                            $(document).ready(function () {
                                                $("#add_customer_submit").click(function (event) {
                                                    event.preventDefault();
                                                    var regex = /^(\+|-)?(\d*\.?\d*)$/;
                                                    var emailregex = /^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,4}$/;
                                                    var msisdn_regex = /^(\d{14})$/;
                                                    var name_regex = /^(?![\s.]+$)[a-zA-Z\s.]*$/
                                                    var name = $('#name').val();
                                                    var email = $('#email').val();
                                                    var msisdn = $('#msisdn').val();
                                                    var rateplan = $('#rateplan').val();
                                                    var recurring = $('#rprice').val();
                                                    var one_time = $('#oprice').val();
                                                    if ((!name_regex.test(name)) || (!msisdn_regex.test(msisdn)) || (!emailregex.test(email)) || (!regex.test(recurring)) || (!regex.test(one_time)) || email == '' || msisdn == '' || rateplan == '' || name == '') {
                                                        if (name == '') {
                                                            $('#nameval').text("name should not be empty..");
                                                            $('#nameval').show();
                                                        } else {
                                                            if (!name_regex.test(name)) {
                                                                $('#nameval').text("name should be a string..");
                                                                $('#nameval').show();
                                                            } else {
                                                                $('#nameval').hide();
                                                            }
                                                        }
                                                        if (email == '') {
                                                            $('#emailval').text("email should not be empty..");
                                                            $('#emailval').show();
                                                        } else {
                                                            if (!emailregex.test(email)) {
                                                                $('#emailval').text("invalid email");
                                                                $('#emailval').show();
                                                            } else {
                                                                $('#emailval').hide();
                                                            }
                                                        }
                                                        if (recurring == '') {
                                                            $('#rpriceval').text("recurring should not be empty..");
                                                            $('#rpriceval').show();
                                                        } else {
                                                            if (!regex.test(recurring)) {
                                                                $('#rpriceval').text("recurring should be a number..");
                                                                $('#rpriceval').show();
                                                            } else {
                                                                $('#rpriceval').hide();
                                                            }
                                                        }
                                                        if (one_time == '') {
                                                            $('#opriceval').text("one time should not be empty..");
                                                            $('#opriceval').show();
                                                        } else {
                                                            if (!regex.test(one_time)) {
                                                                $('#opriceval').text("one time should be a number..");
                                                                $('#opriceval').show();
                                                            } else {
                                                                $('#opriceval').hide();
                                                            }
                                                        }
                                                        if (msisdn == '') {
                                                            $('#msisdnval').text("msisdn should not be empty..");
                                                            $('#msisdnval').show();
                                                        } else {
                                                            if (!msisdn_regex.test(msisdn)) {
                                                                $('#msisdnval').text("msisdn should be a 14 digits..");
                                                                $('#msisdnval').show();
                                                            } else {
                                                                $('#msisdnval').hide();
                                                            }
                                                        }
                                                        if (rateplan == '') {
                                                            $('#typeval').text("rateplan should not be empty..");
                                                            $('#typeval').show();
                                                        }



                                                    } else {
                                                        $.ajax({
                                                            type: "POST",

                                                            url: "${pageContext.request.contextPath}/AddCustomer",
                                                            data: {
                                                                name: name
                                                            },

                                                            success: function (data) {
                                                                alert(data);

//                                                                $('#success-message').show();
//                                                                $("#add_product_submit").prop("disabled", true);
//                                                                setTimeout(function () {
//
//                                                                    $('#addProductModal.modal.fade.show').hide();
//                                                                    $('body').removeClass('modal-open');
//                                                                    $('.modal-backdrop').remove();
//
//
//                                                                }, 2000);

                                                            },
                                                            error: function (resp) {
                                                                alert("error")
                                                            }
                                                        });
                                                    }
                                                });

//                                                $(document).ajaxStop(function () {
//                                                    window.location.reload();
//                                                });

                                            });
                                        </script>
                                    </div>
                                </div>
                            </div>
                        </div>


                        <div class="card-body">
                            <div class="table-responsive">


                                <table class="table table-bordered" id="customer_table" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Name</th>
                                            <th>Msisdn</th>
                                            <th>Email</th>
                                            <th>Rateplan</th>
                                            <th>Bill Cycle</th>
                                            <th>Action</th>
                                        </tr>
                                    </thead>
                                    <script>
                                        $(document).ready(function () {
                                    
                                            $("#search_input").keyup(function () {
                                              
                                                var check = "";
                                                var text = $(this).val();
                                                if (text != '') {
                                                    check = text;
                                                } else {
                                                    check = "none";
                                                }
                                                $.ajax({
                                                    type: "POST",
                                                    dataType: "text",
                                                    url: "${pageContext.request.contextPath}/GetCustomers",
                                                    data: {
                                                        check: check
                                                    },

                                                    success: function (data) {
                                                        $("#tbodyid").empty();
                                                       
                                                        $("#tbodyid").html(data);

                                                    },
                                                    error: function (resp) {
                                                        alert("error")
                                                    }
                                                });

                                            });
                                        });
                                    </script>
                                   
                                    <tbody id="tbodyid">
                                           <%                                            for (Customer c : customers) {
                                    %>
                                  
                                        <tr>
                                            <td><% out.println(c.getName()); %></td>
                                            <td><% out.println(c.getMsisdn()); %></td>
                                            <td><% out.println(c.getEmail()); %></td>
                                            <td><% out.println(c.getRateplan_name()); %></td>
                                            <td><% out.println(c.getBill_cycle()); %></td>
                                            <td></td>
                                        </tr>
                                        <% }%>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

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

    <!-- Bootstrap core JavaScript-->
    <!--        <script src="vendor/jquery/jquery.min.js"></script>
            <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>-->

    <!-- Core plugin JavaScript-->
    <!--        <script src="vendor/jquery-easing/jquery.easing.min.js"></script>-->

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin-2.min.js"></script>

    <!-- Page level plugins -->
    <!--        <script src="vendor/datatables/jquery.dataTables.min.js"></script>
            <script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>-->

    <!-- Page level custom scripts -->
    <script src="js/demo/datatables-demo.js"></script>
    <script type="text/javascript" src="http://getbootstrap.com/2.3.2/assets/js/bootstrap.js"></script>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>

</html>