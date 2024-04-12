<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    	<!-- <link   rel="stylesheet" 
    	    	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" 
    	    	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" 
    	    	crossorigin="anonymous">
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" 
				integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" 
				crossorigin="anonymous"></script>
				
		<link   href="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css" rel="stylesheet">
	    <script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
	    <script src="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js"></script> -->
	    
	    <link   href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
		<link   rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
				
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exception Page</title>
    </head>
<body class="bg-dark">
<div>
	<div style="text-align:center; color:red;">
	<br>
		<h2> .....Application encountered an error..... </h2>
		<br>
	</div>
	
	<div>
		<h2 style="text-align:center; color:red;"> Exception </h2>
		<br>
		
		
		<div class="table-responsive">
            <table class="table table-dark table-striped table-hover table-bordered">
            <br>
                <%-- <thead>
                    <tr  class="text-primary table-light">
                        <th scope="col">Exception</th>
                        <th scope="col">${error}</th>
                    </tr>
                </thead> --%>
                <tbody class="table-group-divider">
                        <tr>
                            <td style="text-align:center;">Exception</td>
                            <td class="flex-wrap">${error}</td>
                            
                        </tr>
                </tbody>
            </table>
		
		
		<%-- <div>
			<p style="margin-left: 40px; margin-right:30px;">${error}</p>
		</div> --%>
	</div>
</div>

<%-- <div class="toast fade show" id="myToast">
        <div class="toast-header">
            <strong class="me-auto"><i class="bi-gift-fill"></i> Exception!</strong>
            <small>occoured now...</small>
            <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
        </div>
        <div class="toast-body">
            <p>${error}</p>
        </div>
</div>

<script>
    $(document).ready(function() {
        /* toastr.success('Exception occurred!', 'error'); */
        $("#myToast").toast("show");
    }); 
</script> --%>


<!-- <script>
$(document).ready(function(){
    $("#myBtn").click(function(){
        $("#myToast").toast("show");
    });
});
</script> -->
	
</body>
</html>