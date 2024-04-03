<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Audit Page</title>
    </head>
    <body class="bg-dark">
    	<div align="center">
    		
	        <h1 class="text-primary"><br>Audit List</h1><br><br>
	        <table border="1" class="table table-striped table-responsive table-dark">
	        	<th style="text-align: center;">Id</th>
	        	<th style="text-align: center;">Name</th>
	        	<th style="text-align: center;">Age</th>
	        	<th style="text-align: center;">Gender</th>
	        	<th style="text-align: center;">Email</th>
	        	<th style="text-align: center;">Address</th>
	        	<th style="text-align: center;">Contact No.</th>
	        	<th style="text-align: center;">Department</th>
	        	<th style="text-align: center;">Salary</th>
	        	<th style="text-align: center;">RowInsTms</th>
	        	<th style="text-align: center;">RowDelTms</th>
	        	<th style="text-align: center;">Action</th>
	        	<th style="text-align: center;">Token</th>
	        	
				<c:forEach var="employee" items="${auditList}" varStatus="status">
	        	<tr>
	        		<td>${employee.id}</td>
	        		<td>${employee.name}</td>
	        		<td>${employee.age}</td>
	        		<td>${employee.gender}</td>
					<td class="flex-wrap">${employee.email}</td>
					<td class="flex-wrap">${employee.address}</td>
					<td>${employee.telephone}</td>
					<td>${employee.department}</td>
					<td>${employee.salary}</td>		
					<td>${employee.rowInsTime}</td>	
					<td>${employee.rowDelTime}</td>	
					<td>${employee.status}</td>	
					<td>${employee.token}</td>						
	        	</tr>
				</c:forEach>	        	
			</table>
    	</div>
    </body>
</html>
