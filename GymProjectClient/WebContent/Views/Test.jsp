<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="org.ics.ejb.GymMember"%>
<%@page import="java.util.ArrayList"%>
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
<%@ include file="../Styles/Header.html" %>

	<nav>
		<a href="Home.jsp">Home</a> <a  href="About.jsp">About</a> <a
			href="Crud.jsp">Crud</a><a class="active" href="Test.jsp">Test</a>

	</nav>

	<section id="test">
		<p>Här kan du välja en eller flera av följande test:</p>
		<form action="TestServlet"method="get"name="youPickItForm">
			<select name="suite"size="2"multiple>
				<option value="ics.junit.ejb.GymMemberBeanTest">ics.junit.ejb.GymMemberBeanTest</option>
				<option value="ics.junit.ejb.TrainingSessionBeanTest">ics.junit.ejb.TrainingSessionBeanTest</option>
				<option value=ics.junit.ejb.BookingBeanTest">ics.junit.ejb.BookingBeanTest</option>
			</select>
			<input type="submit"value="Run"/></form>

</body>
</html>