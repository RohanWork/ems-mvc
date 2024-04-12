<%@ include file="Footer.jspf"%>
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
        <title>Audit Page</title>
    </head>
    <body class="bg-dark">
    <!-- <div class="container"> -->
    <div  align="center" >
    		<br>
	        <br>
	        <br>
            	<h1 class="text-primary">Audit List</h1>
            <br>
            <br>
    </div>
        <div class="table-responsive">
            <table class="table table-dark table-striped table-hover table-bordered">
            <br>
                <thead>
                    <tr  class="text-primary table-light">
                        <th scope="col">Id</th>
                        <th scope="col">Name</th>
                        <th scope="col">Age</th>
                        <th scope="col">Gender</th>
                        <th scope="col">Email</th>
                        <th scope="col">Address</th>
                        <th scope="col">Contact</th>
                        <th scope="col">Department</th>
                        <th scope="col">Salary</th>
                        <th scope="col">RowInsTms</th>
                        <th scope="col">RowDelTms</th>
                        <th scope="col">Action</th>
                        <th scope="col">Token</th>
                        <th scope="col">Modifier</th>
                    </tr>
                </thead>
                <tbody class="table-group-divider">
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
                            <td>${employee.modifier}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    <!-- </div> -->
    </body>
</html>
