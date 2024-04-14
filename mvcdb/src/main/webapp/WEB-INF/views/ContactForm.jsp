<%@ include file="Footer.jspf"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="Navigation.jspf"%>
<html>
<head>
    	<link   href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" 
    		    rel="stylesheet" 
    		    integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" 
    		    crossorigin="anonymous">
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" 
				integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" 
				crossorigin="anonymous">
		</script>
			
	<!-- <style>
	  table {
        border-collapse: collapse;
        table-layout: fixed;
        width: auto;
      }
      table tr {
        /* border: 1px solid #666; */
        word-break: break-all;
      }
	</style> -->
			
	<!-- 
	<link   href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
	<link   rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
 	-->	
	<title>Register Employee</title>
</head>
<body class="bg-dark">
<div class="container">
    <div class="row justify-content-center">
        <div class="col-lg-6">
        <div class="table-responsive">
        <form:form action="saveEmployee" method="post" modelAttribute="employee">
            <table class="table table-striped table-dark">
            
                <tr class="col-md-4" id="errorRow">
            		<td class="flex-wrap" colspan="4" align="center" style="color:red">${error} </td>
            	</tr>
                <tr class="col-md-4">
                    <td>Name</td>
                    <td style="text-align: right;">:</td>
                    <td><form:input path="name" required="true"/></td>
                </tr>
                <tr class="col-md-4" id="errorRow">
            		<td class="flex-wrap" colspan="4" align="center" style="color:red">${errorAge} </td>
            	</tr>
                <tr class="col-md-4">
                    <td>Age</td>
                    <td style="text-align: right;">:</td>
                    <td><form:input path="age" required="true"/></td>
                </tr>
                <tr class="col-md-4" id="errorRow">
            		<td class="flex-wrap" colspan="4" align="center" style="color:red"></td>
            	</tr>
                <tr class="col-md-4">
		            <td>Gender</td>
		            <td style="text-align: right;">:</td>
		            <td>
		                <input type="radio" name="gender" id="gender_male" value="male" required="true" ${employee.gender == 'male' ? 'checked' : ''}> Male
		                <input type="radio" name="gender" id="gender_female" value="female" required="true" ${employee.gender == 'female' ? 'checked' : ''}> Female
		            </td>
		        </tr>
		        <tr class="col-md-4" id="errorRow">
            		<td colspan="4" align="center" style="color:red">${errorEmail} </td>
            	</tr>
                <tr class="col-md-4">
                    <td>Email</td>
                    <td style="text-align: right;">:</td>
                    <td><form:input path="email" type="email" required="true"/></td>
                </tr>
                <tr class="col-md-4" id="errorRow">
            		<td class="flex-wrap" colspan="4" align="center" style="color:red"></td>
            	</tr>
                <tr class="col-md-4">
                    <td>Address</td>
                    <td style="text-align: right;">:</td>
                    <td><form:input path="address" type="textarea" rows="4" required="true"/></td>
                </tr>
                <tr class="col-md-4" id="errorRow">
            		<td colspan="4" align="center" style="color:red">${errorTelephone} </td>
            	</tr>
                <tr class="col-md-4">
                    <td>Contact No.</td>
                    <td style="text-align: right;">:</td>
                    <td><form:input path="telephone" type="number" required="true"/></td>
                </tr>
                <tr class="col-md-4" id="errorRow">
            		<td class="flex-wrap" colspan="4" align="center" style="color:red"></td>
            	</tr>
                <tr class="col-md-4">
                    <td>Department</td>
                    <td style="text-align: right;">:</td>
                    <td><form:input path="department" required="true"/></td>
                </tr>
                <tr class="col-md-4" id="errorRow">
            		<td colspan="4" align="center" style="color:red">${errorPassword} </td>
            	</tr>
                <tr class="col-md-4">
				    <td>Password</td>
				    <td style="text-align: right;">:</td>
				    <td><form:input path="password" type="password" name="password" minlength="6" maxlength="16" required="true"/></td>
				</tr>
				<tr class="col-md-4" id="errorRow">
            		<td colspan="4" align="center" style="color:red">${errorSalary} </td>
            	</tr>
                <tr class="col-md-4">
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
    	</div>
 		</div>
    </div>
    
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
	
	<script>
		window.onbeforeunload = function() 
		{ 
			return "Your work will be lost."; 
		};
	</script>
    
</body>
</html>
