<%@ include file="Footer.jspf"%><html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
<meta charset="ISO-8859-1">
<title>Login Page</title>

<style>
    .table{
        margin-top: 30%;
    }
</style>

</head>
<body class="bg-dark">
<div class="container">
    <div class="row justify-content-center margin-top:20px;">
        <div class="col-lg-6">
        <div class="table-responsive">
        <form:form action="login" method="post" modelAttribute="employee">
            <table class="table table-striped table-dark">
            
                <tr class="col-md-4" id="errorRow">
            		<td class="flex-wrap" colspan="4" align="center" style="color:red">${error}</td>
            	</tr>
                <tr class="col-md-4">
                    <td style="text-align: right;">Email</td>
                    <td style="text-align: right;">:</td>
                    <td><form:input path="email" type="email" required="true"/></td>
                </tr>
                <tr class="col-md-4">
				    <td style="text-align: right;">Password</td>
				    <td style="text-align: right;">:</td>
				    <td><form:input path="password" type="password" name="password" minlength="6" maxlength="16" required="true"/></td>
				</tr>
                <tr>
                    <td align="center" colspan="8" align="center"><input type="submit" value="Login" class="btn btn-success"/></td>
                </tr>
            </table>
        </form:form>
        </div>
    	</div>
 		</div>
    </div>
</body>
</html>