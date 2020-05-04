<%@page import="org.ics.ejb.GymMember"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"> 
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath}/Script/GymMemberScript.js"></script>

<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Styles/mystyle.css">

</head>
<body style="height: 1802px;">

<body style="height: 2302px; ">
<div class="navbar">
		<a href="Home.jsp">Home</a> <a href="About.jsp">About</a> <a
		class="active" href="Crud.jsp">Test</a>

	</div>

<%@ include file="../Styles/Header.html" %>

	
	</div>
<br>
<div class="row">

 <div class="add">
	
<form action="${pageContext.request.contextPath}/ControllerServlet"method="post" onSubmit="return isGymMemberFormValid2()">

<legend>Add Gym Member:</legend>
<label for="name">Full Name</label>  <br>
<input type="text" name="name" size="25" maxlength="25" id="name2"></input><br>
<label for="email">Email:* </label><br>
<input type="text" name="email" size="25" maxlength="25"id="email2"></input><br>
<label for="phoneNumber">Phone number:* </label><br>
<input type="number" name="phoneNumber" size="25" maxlength="25"id="phoneNumber2"></input><br>
<label for="address">Address:* </label><br>
<input type="text" name="address" size="25" maxlength="25"id="address2"></input>

<input type="submit" name="createGymMember" value="Create GymMember"/>



<span id="memberCreateError" class="error" ></span>
<span id="memberCreateSuccess" class="success"></span> 	 
<select name="allGymMembers">
    <c:forEach items="${allGymMembers}" var="GymMember">
    
        <option value="${GymMember.memberId}">${GymMember.memberId}</option>
    </c:forEach>
</select>
<input type="submit" name="button" value="Update GymMember"/>
<input type="submit" name="button" value="Delete GymMember"/>

 </form>	
</div>	
<div class="add">
	
<form action="/GymProjectClient/ControllerServlet"method="post">

<legend>Add Training Session:</legend>
<label for="instructor">Instructor</label>  <br>
<input type="text" name="instructor" size="25" maxlength="25"></input><br>
<label for="startDate">StartDate:* </label><br>
<input type="date" id="startDate" name="startDate" value="0000-00-00" min="2018-01-01"max="2021-01-01" required><br>
<label for="phoneNumber">Phone number:* </label><br>
<br><label for="startTime">Starttime:*</label> 
 	<select id="startTime" required name="startTime">
 	<option value="" disabled 
         selected></option>
	<option value="10:00">10:00</option>
	<option value="11:00">11:00</option>
	<option value="12:00">12:00</option>
	<option value="13:00">13:00</option>
	<option value="14:00">14:00</option>
	<option value="15:00">15:00</option>
	<option value="16:00">16:00</option>
	<option value="17:00">17:00</option>
	</select><br><label for="type">Type:*</label>
<select id="type" name="type"required>
<option value="" disabled 
         selected></option>
	<option value="spinning">spinning</option>
	<option value="crossfit">crossfit</option>
	</select><br>
	<label for="roomNumber">Room number:*</label> <select id="roomNumber" name="roomNumber"required>
					<option value="" disabled 
         selected></option>
					<option value="EC01">EC01</option>
					<option value="EC101">EC101</option>
				</select><br>
	<span id="sessionCreateError" class="error" ></span>
	 <span id="sessionCreateSuccess" class="success"></span> 
  
<input type="submit" name="createTrainingSession" value="Create Session" id="CreateTrainingSessionJ"/>
<input name="operation" value="createTrainingSession" type="hidden">
</form>
<select name="allTrainingSessions">
    <c:forEach items="${allTrainingSessions}" var="TrainingSession">
    
        <option value="${TrainingSession.sessionId}">${TrainingSession.sessionId}</option>
    </c:forEach>
    </select>
</div>
<div class="add">
	
<form action="/GymProjectClient/ControllerServlet"method="post">

<legend>Add Booking:</legend>
<legend>Add Booking:</legend><label for="bookingMemberId">
				MemberId:*</label>
         <select name="bookingMemberId" required>
    <c:forEach items="${bookingGymMembers}" var="GymMember">
    
        <option value="${GymMember.memberId}">${GymMember.memberId}</option>
    </c:forEach></select>
				<br><label for="bookingSessionId"> TrainingSessionId:*</label> 
				<select name="allTrainingSessions" required>
    <c:forEach items="${bookingTrainingSessions}" var="TrainingSession">
    
        <option value="${TrainingSession.sessionId}">${TrainingSession.sessionId}</option>
    </c:forEach> </select><br> 

	<br>	
	<span id="bookingCreateError" class="error" ></span>
	 <span id="bookingCreateSuccess" class="success"></span> 
  

<input type="submit" name="createBooking" value="Create Booking" id="CreateBookingJ"/>
<input name="operation" value="createBooking" type="hidden">
</form>
<br>
  	<select name="allBookings">
    <c:forEach items="${allBookings}" var="Booking">
    
        <option value="${Booking.bookingId}">${Booking.bookingId}</option>
    </c:forEach>
    </select>
</div>	

	
</div>

<%@include file="../Styles/Footer.html"%></body>
</html>
