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
<%@include  file="header.jsp" %>

<link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
<!-- Page Wrapper -->
<div id="wrapper">


    
   <%@include file="sidebar.jsp" %>
    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

        <!-- Main Content -->
        <div id="content">

            <%@include file="topbar.jsp" %>

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


                                <button type="button" style="position: relative; /* left: 1350px; */ user-select: auto;/* right: 0%; */left: 85%;" class="btn btn-info" data-toggle="modal" data-target="#addProductModal">
                                    Add Customer

                            </button>

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
                                                    <input type="text" style="width: 100px; position: relative; left: 10px" class="form-control input-sm" id="rprice" name="rprice" placeholder="100LE">
                                                    <p id="rpriceval" style="color: red; display:none;"></p>
                                                </div>
                                                <div>
                                                    <label for="oprice" style="padding-top: 20px; position: relative; left: 10px">One-time Service</label>
                                                    <input type="text" style="width: 100px; position: relative; left: 10px" class="form-control input-sm" id="oprice" name="oprice" placeholder="100LE">
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
                                            var emailregex = /^\b[A-Z0-9._%-]+@[A-Z0-9.-]+\.[A-Z]{2,4}\b$/i;
                                            var msisdn_regex = /^(\d{14})$/;
                                            var name_regex = /^(?![\s.]+$)[a-zA-Z\s.]*$/
                                            var name = $('#name').val();
                                            var bill_cycle = $('#bill_cycle').val();
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

                                                if (!regex.test(recurring)) {
                                                    $('#rpriceval').text("recurring should be a number..");
                                                    $('#rpriceval').show();
                                                } else {
                                                    $('#rpriceval').hide();
                                                }


                                                if (!regex.test(one_time)) {
                                                    $('#opriceval').text("one time should be a number..");
                                                    $('#opriceval').show();
                                                } else {
                                                    $('#opriceval').hide();
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
                                                        name: name,
                                                        email: email,
                                                        msisdn: msisdn,
                                                        rateplan: rateplan,
                                                        recurring: recurring,
                                                        one_time: one_time,
                                                        bill_cycle: bill_cycle

                                                    },

                                                    success: function (data) {

                                                        $('#success-message').show();
                                                        $("#add_product_submit").prop("disabled", true);
                                                        setTimeout(function () {

                                                            $('#addProductModal.modal.fade.show').hide();
                                                            $('body').removeClass('modal-open');
                                                            $('.modal-backdrop').remove();


                                                        }, 2000);
                                                        setTimeout(function () {
                                                            location.reload();
                                                        }, 3000);

                                                    },
                                                    error: function (resp) {
                                                        alert("error")
                                                    }
                                                });
                                            }
                                        });


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





<%@include file="footer.jsp" %>