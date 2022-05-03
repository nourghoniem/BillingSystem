

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%@include file="header.jsp" %>

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
                    <form method="POST" enctype="multipart/form-data" class="box has-advanced-upload"  id="upload"
                        style="transition: all .15s ease-in-out, background-color .15s linear;
                                                                                            border: 4px solid #fff;
                                                                                            box-shadow: inset 0 2px 4px rgb(0 0 0 / 75%);
                                                                                            padding: 5rem 8rem;
                                                                                            width: 100%;
                                                                                            font-size: 1.25rem;
                                                                                            display: block;">
                        <div class="box-input" style="text-align: center;">
                          
                            <img src="https://www.nicepng.com/png/detail/108-1084516_upload-to-cloud-blue-button-upload-cloud-icon.png" width="30%">
                            <div style="diplay:flex;justify-content: space-around;margin-top:5px">
                            <input type="file" id="files" multiple style="margin-bottom: 20px;height:fit-content " 
                                >
                            <input type="button" value="Upload" onclick="startUploading()" style="background: #4e73df;border-radius: 3px;color: #f8f9fc;border: none;
                                   "/></div>
                            
                             <div id='progress-bar-container' style='height: 40px;border: 1px solid #9a9a9a;'>
			<div id='progress-bar' style='height: 100%; background: #4e73df; width: 0%;height: 40px'></div>
                             </div></div>
                         
                        
		</div>
		<div id="uploding-file"></div>


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

        <!-- Bootstrap core JavaScript-->
        <script src="asset/vendor/jquery/jquery.min.js"></script>
        <script src="asset/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="asset/vendor/jquery-easing/jquery.easing.min.js"></script>

        <!-- Custom scripts for all pages-->
        <script src="asset/js/sb-admin-2.min.js"></script>
        <script> 
       	/* Globle variables */
	var totalFileSize, totalUploadedSize, totalFileCount, fileUploadedCount;
	
	/* start uploading files */
	function startUploading() {
		var files=document.getElementById('files').files;
		totalFileCount = files.length;
		totalUploadedSize = 0;
		fileUploadedCount = 0;
		totalFileSize = 0;		
		for (var i = 0; i < totalFileCount; i++) {
			totalFileSize += files[i].size;
		}
		// upload through ajax call
		uploadFile();
	}
	
	/* one by one file will be uploaded to the server by ajax call*/
	function uploadFile() {
		var file = document.getElementById('files').files[fileUploadedCount];
		var xhr = new XMLHttpRequest();
		var fd = new FormData();		
		fd.append("multipartFile", file);
		xhr.upload.addEventListener("progress", onUploadProgress, false);
		xhr.addEventListener("load", onUploadComplete, false);
		xhr.addEventListener("error", onUploadError, false);
		xhr.open("POST", "HandlingUpload");
		xhr.send(fd);
		// update which file is uploading
		document.getElementById('uploding-file').innerHTML="Uploading "+file.name;
	}
	
	/* This function will continueously update the progress bar */
	function onUploadProgress(e) {
		if (e.lengthComputable) {
			var percentComplete = parseInt((e.loaded + totalUploadedSize) * 100	/ totalFileSize);
			var bar = document.getElementById('progress-bar');
			bar.style.width = percentComplete + '%';
			bar.innerHTML = percentComplete + ' % complete';
		} else {
			alert('unable to compute');
		}
	}
	
	/* This function will call when upload is completed */
	function onUploadComplete(e) {
		totalUploadedSize += document.getElementById('files').files[fileUploadedCount].size;
		fileUploadedCount++;
		if (fileUploadedCount < totalFileCount) {
			//ajax call if more files are there 
			uploadFile();
		} else {
			var bar = document.getElementById('progress-bar');
			bar.style.width = '100%';
			bar.innerHTML = '100% complete';
			document.getElementById('uploding-file').innerHTML="";
		}
	}

	/* This function will call when an error come while uploading */
	function onUploadError(e) {
		alert("Something went wrong!");
	}
        </script>

</body>

</html>