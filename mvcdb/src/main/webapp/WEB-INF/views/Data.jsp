<%@ include file="Footer.jspf"%><html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <title>Home Page</title>
    </head>
<body class="bg-dark">
    <div align="center">
    		<br>
	        <br>
	        <br>
            	<h1 class="text-primary">Employee's List</h1>
            <br>
            <br>
            <br>
    </div>
        <div class="table-responsive">
            <table class="table table-dark table-striped table-hover table-bordered">
                <thead>
                    <tr  class="table-light">
                        <th scope="col">Id</th>
                        <th scope="col">Name</th>
                        <th scope="col">Age</th>
                        <th scope="col">Gender</th>
                        <th scope="col">Email</th>
                        <th scope="col">Address</th>
                        <th scope="col">Contact</th>
                        <th scope="col">Department</th>
                        <th scope="col">Salary</th>
                        <th scope="col">Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="employee" items="${listEmployee}" varStatus="status">
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
                            <td>
								<a href="editEmployee?id=${employee.id}" class="btn btn-warning btn-block">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp;
								<a href="deleteEmployee?id=${employee.id}" class="btn btn-danger btn-block">Delete</a>
							</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    <div>
    </div>
    </body>
</html>
