<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="Navigation.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Contact</title>
</head>
<body>
	<div align="center">
		<h1>New/Edit Contact</h1>
		<form:form action="saveContact" method="post" modelAttribute="contact">
		<table>
			<form:hidden path="id"/>
			<tr>
				<td>Name:</td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td>Age:</td>
				<td><form:input path="age" /></td>
			</tr>
			<tr>
                <td align="right">Gender:</td>
                <td align="left">
                    <input type="radio" path="gender" name="gender" value="male"> Male 
                    <input type="radio" path="gender" name="gender" value="female"> Female
                </td>
            </tr>
            
			<tr>
				<td>Email:</td>
				<td><form:input path="email" type="mail"/></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><form:input path="address" type="text"/></td>
			</tr>
			<tr>
				<td>Telephone:</td>
				<td><form:input path="telephone" type="number"/></td>
			</tr>
			<tr>
				<td>Department:</td>
				<td><form:input path="department" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><form:input path="password" type="password"/></td>
			</tr>
			<tr>
				<td>Salary:</td>
				<td><form:input path="salary" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Save"></td>
			</tr>
		</table>
		</form:form>
	</div>
</body>
</html> --%>





<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="Navigation.jspf"%>
<html>
<head>
    <link   rel="stylesheet" 
    	    href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" 
    	    integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" 
    	    crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" 
			integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" 
			crossorigin="anonymous"></script>
			
	<style>
	  table {
        border-collapse: collapse;
        table-layout: fixed;
        width: auto;
      }
      table tr {
        /* border: 1px solid #666; */
        word-break: break-all;
      }
	</style>
			
	<!-- 
	<link   href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
	<link   rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
 	-->	
	<title>Register Employee</title>
</head>
<body class="bg-dark">

	<%-- <div class="alert alert-danger d-flex align-items-center" role="alert">
	  <svg class="bi flex-shrink-0 me-2" width="24" height="24" role="img" aria-label="Danger:"><use xlink:href="#exclamation-triangle-fill"/></svg>
	  <div>
	    <P>${error}</P>
	  </div>
	  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
	</div> --%>
	
	<%-- <div class="toast fade show" id="myToast">
        <div class="toast-header">
            <strong class="me-auto"><i class="bi-gift-fill"></i> Exception!</strong>
            <small>occoured now...</small>
            <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
        </div>
        <div class="toast-body">
            <p>${error}</p>
        </div>
	</div> --%>
	
	<div align="center">
		<h1 class="text-primary"><br>New/Edit Employee</h1><br><br>
	</div>
	
	<%-- <div align="center" class="table">
		<table>
			<tr id="errorRow">
            	<td colspan="4" align="center" style="color:red">${error} </td>
            </tr>
		</table>
	</div> --%>
	
    <div align="center" class="table table-striped table-dark text-white">
        
        <form:form action="saveEmployee" method="post" modelAttribute="employee">
            <table class="text-white">
            
                <%-- <tr>
                    <td><form:hidden path="id" /></td>
                </tr> --%>
                <tr>
                    <td>Name</td>
                    <td style="text-align: right;">:</td>
                    <td><form:input path="name" required="true"/></td>
                </tr>
                <tr id="errorRow">
            		<td class="flex-wrap" colspan="4" align="center" style="color:red">${errorAge} </td>
            	</tr>
                <tr>
                    <td>Age</td>
                    <td style="text-align: right;">:</td>
                    <td><form:input path="age" required="true"/></td>
                </tr>
                <tr id="errorRow">
            		<td class="flex-wrap" colspan="4" align="center" style="color:red"></td>
            	</tr>
                <tr>
		            <td>Gender</td>
		            <td style="text-align: right;">:</td>
		            <td>
		                <input type="radio" name="gender" id="gender_male" value="male" required="true" ${employee.gender == 'male' ? 'checked' : ''}> Male
		                <input type="radio" name="gender" id="gender_female" value="female" required="true" ${employee.gender == 'female' ? 'checked' : ''}> Female
		            </td>
		        </tr>
		        <tr id="errorRow">
            		<td colspan="4" align="center" style="color:red">${errorEmail} </td>
            	</tr>
                <tr>
                    <td>Email</td>
                    <td style="text-align: right;">:</td>
                    <td><form:input path="email" type="email" required="true"/></td>
                </tr>
                <tr id="errorRow">
            		<td class="flex-wrap" colspan="4" align="center" style="color:red"></td>
            	</tr>
                <tr>
                    <td>Address</td>
                    <td style="text-align: right;">:</td>
                    <td><form:input path="address" type="text" required="true"/></td>
                </tr>
                <tr id="errorRow">
            		<td colspan="4" align="center" style="color:red">${errorTelephone} </td>
            	</tr>
                <tr>
                    <td>Contact No.</td>
                    <td style="text-align: right;">:</td>
                    <td><form:input path="telephone" type="number" required="true"/></td>
                </tr>
                <tr id="errorRow">
            		<td class="flex-wrap" colspan="4" align="center" style="color:red"></td>
            	</tr>
                <tr>
                    <td>Department</td>
                    <td style="text-align: right;">:</td>
                    <td><form:input path="department" required="true"/></td>
                </tr>
                <tr id="errorRow">
            		<td colspan="4" align="center" style="color:red">${errorPassword} </td>
            	</tr>
                <tr>
				    <td>Password</td>
				    <td style="text-align: right;">:</td>
				    <td><form:input path="password" type="password" name="password" minlength="6" maxlength="16" required="true"/></td>
				</tr>
				<tr id="errorRow">
            		<td colspan="4" align="center" style="color:red">${errorSalary} </td>
            	</tr>
                <tr>
                    <td>Salary</td>
                    <td style="text-align: right;">:</td>
                    <td><form:input path="salary" required="true" minlength="4"/></td>
                </tr>
                <tr>
                    <td align="center" colspan="8" align="center"><input type="submit" value="Register" class="btn btn-success"/></td>
                </tr>
            </table>
        </form:form>
    </div>
    

	<script>
	    $(document).ready(function() {
	        /* toastr.success('Exception occurred!', 'error'); */
	        $("#myToast").toast("show");
	    }); 
	</script>
	
	<!-- <script>
	    // Show the error row after a delay (e.g., 3 seconds)
	    setTimeout(function() {
	        document.getElementById("errorRow").style.display = "table-row";
	    }, 0000); // Adjust the delay as needed (in milliseconds)
	</script> -->
    
    <!-- <script>
	    setTimeout(function() {
	        document.getElementById("errorRow").style.display = "table-row";
	        setTimeout(function() {
	            document.getElementById("errorRow").style.display = "none";
	        }, 8000); 
	    }, 0000);
	</script> -->
    
<!-- <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script	src="webjars/bootstrap-datepicker/1.0.1/js/bootstrap-datepicker.js"></script> -->
</body>
</html>
