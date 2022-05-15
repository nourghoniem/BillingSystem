<%-- 
    Document   : add_product
    Created on : Mar 17, 2022, 4:54:31 PM
    Author     : nour
--%>

<%@page import="com.iti.ecommerce.essentials.model.Product"%>
<%@page import="com.iti.ecommerce.essentials.dbconnection.DatabaseManagement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Integer id = Integer.parseInt(request.getParameter("id"));
    DatabaseManagement data = new DatabaseManagement();
    Product getProduct = data.getProductById(id);
%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Admin's Page</title>

        <!-- Custom fonts for this template-->
        <link href="css/all.min.css" rel="stylesheet" type="text/css">

        <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">


        <!-- Custom styles for this template-->
        <link href="css/sb-admin-2.min.css" rel="stylesheet">
        <script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
        <script src="bootstrap.confirm.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
        <script src='bootbox.min.js'></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <link href="E-Commerce/web/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">

    </head>

    <body id="page-top">

        <!-- Page Wrapper -->
        <div id="wrapper">

            <!-- Sidebar -->
            <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

                <!-- Sidebar - Brand -->
                <!-- Sidebar - Brand -->
                <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
                    <div class="sidebar-brand-icon rotate-n-15">
                        <i class="fas fa-laugh-wink"></i>
                    </div>
                    <div class="sidebar-brand-text mx-3">SB Admin <sup>2</sup></div>
                </a>

                <!-- Divider -->
                <hr class="sidebar-divider my-0">
                <!-- Nav Item - Tables -->
                <!-- Nav Item - Dashboard -->
                <li class="nav-item">
                    <a class="nav-link" href="products_management_page.jsp">
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
                        <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                            <i class="fa fa-bars"></i>
                        </button>

                        <!-- Topbar Search -->
                        <form class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
                            <div class="input-group">
                                <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
                                <div class="input-group-append">
                                    <button class="btn btn-primary" type="button">
                                        <i class="fas fa-search fa-sm"></i>
                                    </button>
                                </div>
                            </div>
                        </form>

                        <!-- Topbar Navbar -->
                        <ul class="navbar-nav ml-auto">

                            <!-- Nav Item - Search Dropdown (Visible Only XS) -->
                            <li class="nav-item dropdown no-arrow d-sm-none">
                                <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <i class="fas fa-search fa-fw"></i>
                                </a>
                                <!-- Dropdown - Messages -->
                                <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in" aria-labelledby="searchDropdown">
                                    <form class="form-inline mr-auto w-100 navbar-search">
                                        <div class="input-group">
                                            <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
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
                                <a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <i class="fas fa-bell fa-fw"></i>
                                    <!-- Counter - Alerts -->
                                    <span class="badge badge-danger badge-counter">3+</span>
                                </a>
                                <!-- Dropdown - Alerts -->
                                <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="alertsDropdown">
                                    <h6 class="dropdown-header">
                                        Alerts Center
                                    </h6>

                                    <a class="dropdown-item text-center small text-gray-500" href="#">Show All Alerts</a>
                                </div>
                            </li>

                            <!-- Nav Item - Messages -->
                            <li class="nav-item dropdown no-arrow mx-1">
                                <a class="nav-link dropdown-toggle" href="#" id="messagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <i class="fas fa-envelope fa-fw"></i>
                                    <!-- Counter - Messages -->
                                    <span class="badge badge-danger badge-counter">7</span>
                                </a>
                                <!-- Dropdown - Messages -->
                                <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="messagesDropdown">
                                    <h6 class="dropdown-header">
                                        Message Center
                                    </h6>

                                    <a class="dropdown-item text-center small text-gray-500" href="#">Read More Messages</a>
                                </div>
                            </li>

                            <div class="topbar-divider d-none d-sm-block"></div>

                            <!-- Nav Item - User Information -->
                            <li class="nav-item dropdown no-arrow">
                                <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <span class="mr-2 d-none d-lg-inline text-gray-600 small">Admin</span>
                                    <img class="img-profile rounded-circle" src="img/undraw_profile.svg">
                                </a>
                                <!-- Dropdown - User Information -->
                                <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
                                    <a class="dropdown-item" href="#">
                                        <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                        Profile
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

                    <!-- Modal -->
                    <div class="modal fade" id="editStaffModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">Edit Product</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <form action="" id="editProduct" method= "POST">
                                    <div class="modal-body">
                                        <div style="display:none" id="success-message" class="alert alert-success" role="alert">
                                            Product data are successfully edited!
                                        </div>
                                        <div class="form-group col-md-6 col-sm-6">
                                            <label for="description"> Description </label>
                                            <textarea class="form-control input-sm" required id="description" required="" name="decription" width="1000px" placeholder=""><% out.println(getProduct.getDescription()); %> </textarea>
                                            <p id="descval" style="color: red; display:none;"></p>
                                        </div>
                                        <div class="form-group col-md-6 col-sm-6">
                                            <label for="quantity"> Quantity </label>
                                            <input type="number" class="form-control input-sm" id="quantity" required="" name="quantity" min="1" max="100" step="1" value="<% out.println(getProduct.getQuantity()); %>" required placeholder="">
                                            <p id="quantityval" style="color: red; display:none;"></p>
                                        </div>
                                        <div class="form-group col-md-6 col-sm-6">
                                            <label for="price">Price</label>
                                            <input type="text" class="form-control input-sm" required="" id="price" name="price"  placeholder="" value="<% out.println(getProduct.getPrice()); %>" required >
                                            <p id="priceval" style="color: red; display:none;"></p>
                                        </div>
                                        <div style="display: none;" class="form-group col-md-6 col-sm-6">
                                            <label for="id">id</label>
                                            <input type="text" class="form-control input-sm" required="" id="id" name="id"  placeholder="" value="<% out.println(id); %>" >
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                                        <button type="submit" id="edit_product_submit" name="editStaff" class="btn btn-primary">Edit Product</button>
                                    </div>
                                </form>
                                <script>
                                    $(document).ready(function () {
                                        $("#edit_product_submit").click(function (event) {
                                            event.preventDefault();
                                            var regex = /^(\+|-)?(\d*\.?\d*)$/;
                                            var id = $('#id').val();
                                            var description = $('#description').val();
                                            var quantity = $('#quantity').val();
                                            var price = $('#price').val();
                                            if ((!regex.test(price)) || quantity == '' || price.length == '' || (!$.trim(description))) {


                                                if (quantity == '') {
                                                    $('#quantityval').text("Quantity should not be empty..");
                                                    $('#quantityval').show();
                                                } else {
                                                    $('#quantityval').hide();
                                                }
                                                if (price.length == 0) {
                                                    $('#priceval').text("Price should not be empty..");
                                                    $('#priceval').show();
                                                } else {
                                                    if (!regex.test(price)) {
                                                        $('#priceval').text("Price should be a number..");
                                                        $('#priceval').show();
                                                    } else {
                                                        $('#priceval').hide();
                                                    }
                                                }

                                                if (!$.trim(description)) {
                                                    $('#descval').text("Description should not be empty..");
                                                    $('#descval').show();
                                                } else {
                                                    $('#descval').hide();
                                                }
                                            } else {

                                                $.ajax({
                                                    type: "POST",
                                                    url: "${pageContext.request.contextPath}/editProductServlet",
                                                    data: {
                                                        id: id,
                                                        description: description,
                                                        quantity: quantity,
                                                        price: price
                                                    },
                                                    success: function (data) {
                                                        $('#success-message').show();
                                                        $("#edit_product_submit").prop("disabled", true);
                                                        setTimeout(function () {

                                                            $('#editStaffModal.modal.fade.show').hide();
                                                            $('body').removeClass('modal-open');
                                                            $('.modal-backdrop').remove();
                                                        }, 2000);
                                                    },
                                                    error: function (resp) {
                                                        console.log(resp);
                                                    }
                                                });
                                            }
                                        });
                                        $(document).ajaxStop(function () {
                                            window.location.reload();
                                        });



                                    }
                                    );

                                </script>
                            </div>
                        </div>
                    </div>
                    <!-- Modal -->
                    <div class="modal fade" id="deleteStaffModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">Delete Product</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <form action="" method= "POST">
                                    <div class="modal-body">
                                        <div>
                                            Are you sure you want to delete this product? This process cannot be undone.
                                        </div>

                                        <div class="form-group col-md-6 col-sm-6">

                                            <input style="display: none;" type="text" class="form-control input-sm" required="" id="id" name="id"  placeholder="" value="<% out.println(id); %>" >
                                        </div>
                                    </div>

                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                                        <button type="submit" id="deleteProduct" name="deleteProduct" class="btn btn-danger">Delete</button>
                                    </div>
                                </form>
                                <script>

                                    $("#deleteProduct").click(function (event) {
                                        event.preventDefault();
                                        var id = $('#id').val();
                                        $.ajax({
                                            type: "POST",
                                            url: "${pageContext.request.contextPath}/deleteProductServlet",
                                            data: {
                                                id: id

                                            },
                                            success: function (data) {

                                                window.open('products_management_page.jsp');
                                            },
                                            error: function (resp) {
                                                alert("Error");
                                            }
                                        });



                                    });

                                </script>
                            </div>
                        </div>
                    </div>
                    <!-- Begin Page Content -->
                    <div class="container-fluid">
                        <!-- Page Heading -->
                        <body>
                            <div class="panel panel-primary" style="margin:20px;">
                                <div class="panel-heading">
                                    <h3 class="panel-title" >Product Details</h3>
                                </div>
                                <img class="rounded float-left" style="position: absolute; right: 250px;" src="${pageContext.request.contextPath}/db_images/<% out.println(getProduct.getId()); %>.jpg" alt="" border=3 height=400 width=400></img>

                                <div class="panel-body">

                                    <form id="form1" action="" method= "POST">
                                        <div class="col-md-12 col-sm-12">

                                            <div class="form-group col-md-6 col-sm-6">
                                                <label for="name"> Product Name  </label>
                                                <input type="text" class="form-control input-sm" id="form-name" required="" name="name" value="<% out.println(getProduct.getProduct_name()); %>" placeholder="" readonly>
                                            </div>

                                            <div class="form-group col-md-6 col-sm-6">
                                                <label for="description">Description</label>
                                                <input type="text" class="form-control input-sm" id="form-description" required="" name="description" value="<% out.println(getProduct.getDescription()); %>" placeholder="" readonly>
                                            </div>

                                            <div class="form-group col-md-6 col-sm-6">
                                                <label for="quantity"> Quantity </label>
                                                <input type="text" class="form-control input-sm" id="form-quantity" required="" name="quantity" value="<% out.println(getProduct.getQuantity()); %>" placeholder="" readonly>
                                            </div>

                                            <div class="form-group col-md-6 col-sm-6">
                                                <label for="price"> Price </label>
                                                <input type="text" class="form-control input-sm" id="form-price" required="" name="price" value="<% out.println(getProduct.getPrice());%>" readonly>
                                            </div>
                                            <div class="col-md-12 col-sm-12">
                                                <div class="form-group col-md-3 col-sm-3 pull-right" >
                                                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#editStaffModal">
                                                        Edit
                                                    </button>
                                                    <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteStaffModal">
                                                        Delete
                                                    </button>
                                                </div>
                                            </div>

                                        </div>

                                    </form>

                                    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
                                    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
                                    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
                                    </body>
                                </div>



                                <!-- Footer -->
                                <footer class="sticky-footer bg-white">
                                    <div class="container my-auto">
                                        <div class="copyright text-center my-auto">
                                            <span>Copyright &copy; Your Website 2019</span>
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
                    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
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
                                    <a class="btn btn-primary" href="stafflog.html">Logout</a>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Bootstrap core JavaScript-->
                    <!--  <script src="vendor/jquery/jquery.min.js"></script>
                      <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
                    
                       Core plugin JavaScript
                      <script src="vendor/jquery-easing/jquery.easing.min.js"></script>-->

                    <!-- Custom scripts for all pages-->
                    <script src="js/sb-admin-2.min.js"></script>
<!--                    <script src="js/demo/datatables-demo.js"></script>
                    <script type="text/javascript" src="http://getbootstrap.com/2.3.2/assets/js/bootstrap.js"></script>-->
                 </body>

                    </html>