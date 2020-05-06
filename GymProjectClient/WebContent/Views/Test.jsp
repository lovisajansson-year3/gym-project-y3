<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="org.ics.ejb.GymMember"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"> 
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.min.js"></script>
<script src="../Scripts/Javascript.js"></script>
<link rel="stylesheet" type="text/css" href="../Styles/mystyle.css">

<head>
<meta charset="ISO-8859-1">

</head>
<body>


	<div class="navbar">
		<a href="${pageContext.request.contextPath}/Views/Home.jsp">Home</a> <a href="${pageContext.request.contextPath}/Views/About.jsp">About</a><a href="${pageContext.request.contextPath}/ControllerServlet">Book</a> <a
		 href="${pageContext.request.contextPath}/Views/Crud.jsp">Rest</a><a class="active" href="${pageContext.request.contextPath}/Views/Test.jsp">Test</a>

	</div>
	<%@ include file="../Styles/Header.html" %>
	<br><br>
	</div>
	<div class = "row">
	
	<div class="column">
	<div class="test">
<legend>Välj test:</legend>
<form action="${pageContext.request.contextPath}/TestServlet"method="get"name="youPickItForm">
<select name="suite">
<option value="ics.junit.ejb.FacadeTest">ics.junit.ejb.FacadeTest</option>
</select>
<button type="submit" name="button" value="Run">Run</button>
</form>
</div>
</div>
</div>
	
	<%@ include file="../Styles/Footer.html" %>
	
</body>
</html>