<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="org.ics.ejb.GymMember"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"> </script>
<script src="../Script/MainScript.js"></script>
<script src="../Script/GymMemberScript.js"></script>
<script src="../Script/TrainingSessionScript.js"></script>
<script src="../Script/BookingScript.js"></script>

<link rel="stylesheet" type="text/css" href="../Styles/mystyle.css">

</head>
<body style="height: 1792px; ">


<%@ include file="../Styles/Header.html" %>

	<nav>
		<a href="Home.jsp">Home</a> <a href="About.jsp">About</a> <a
			class="active" href="Crud.jsp">Test</a>

	</nav>
	<section id="main">
		<p>Create, Read, Update or Delete</p>
</section>
<div id="forms">			
<div id="GymMember">
	<fieldset id="GymMemberFS">
	<legend>Add Gym Member:</legend>
	<label for="name">Full name:* </label>
	<input type="text" name="name" id="name" required >
	<br> <label for="email">Email:* </label><input type="text" name="email" id="email" required>
	<br> <label for="phoneNumber">Phone number:* </label>
	<input type="number" name="phoneNumber" id="phoneNumber" required> <br>
	<label for="address">Address:* </label>
	<input type="text" name="address" id="address" required>
	<br><br>
<div class="create">
	<input type="button" value="Create Gym Member" name="CreateGymMember" 	id="CreateGymMember"></div>

			

		<br>	<br><label for="memberId">Pick GymMember to display values for,<br> update or delete: </label><br><select name="memberId" id="memberId"><option value="" disabled selected>Select memberId</option></select>
			<br> <input type="button" value="Update Gym Member" name="UpdateGymMember" id="UpdateGymMember">
<span id="memberError" class="error" ></span>
			<span id="memberSuccess" class="success"></span>
		  <br><input type="button" name="DeleteByMemberId" id="DeleteByMemberId" value="delete by memberid" />
		    <br>
	
				</fieldset>
</div>
<div id="TrainingSession">
			<fieldset id="TrainingSessionFS">
				<legend>Add TrainingSession:</legend>
				<label for="instructor">Choose an instructor:*</label> <br><select id="instructor" name="instructor"required>
					<option value="Lovisa">Lovisa</option>
					<option value="Lena">Lena</option>
					<option value="Tove">Tove</option>
					<option value="Lisa">Lisa</option>
				</select><br>
				<br> <label for="startDate">Start date:*</label> 
				<br><input type="date"
					id="startDate" name="startDate" value="2018-07-22" min="2018-01-01"
					max="2021-01-01" required>
 				
 				<br><label for="startTime">Choose a time:*</label> 
 				<br><select id="startTime" required name="startTime">
					<option value="10:00">10:00</option>
					<option value="11:00">11:00</option>
					<option value="12:00">12:00</option>
					<option value="13:00">13:00</option>
					<option value="14:00">14:00</option>
					<option value="15:00">15:00</option>
					<option value="16:00">16:00</option>
					<option value="17:00">17:00</option>
				</select><br>
				<br> <label for="type">Choose an session type:*</label> 	<br><select id="type" name="type"required>
					<option value="spinning">spinning</option>
					<option value="crossfit">crossfit</option>
				</select><br>
				<br> <label for="roomNumber">Choose a room number:*</label><br> <select
					id="roomNumber" name="roomNumber"required>
					<option value="EC01">EC01</option>
					<option value="EC101">EC101</option>
				</select><br>
		<br><div class="create"> <input type="button" value="Create Training Session" name="CreateTrainingSession" id="CreateTrainingSession"></div>
<br>Pick Session to display values for,<br> update or delete:<select name="sessionId" id="sessionId"></select>
			<span id="sessionError" class="error"></span>
			<span id="sessionSuccess" class="success"></span>

<br> <input type="button" value="Update Training Session" name="UpdateTrainingSession" id="UpdateTrainingSession">
<br> <input type="button" value="Delete Training Session" name="DeleteTrainingSession" id="DeleteTrainingSession">
		</fieldset>
		</div>
		<div id="Booking">
			<fieldset id="BookingFS">
				<legend>Add Booking:</legend>
				MemberId:*<br> <select name="bookingMemberId" id="bookingMemberId" required></select>
				<br> TrainingSessionId number:*<br> <select name="bookingSessionId" id="bookingSessionId"required></select> <br> 

	<br>	<div class="create">
<input type="button" id="CreateBooking" name="CreateBooking"value="Create Booking" ></div>
<br><br><br><p>Pick Booking to display values<br> for or delete:</p><br><select name="bookingId" id="bookingId"></select>
			<span id="bookingError" class="error" ></span>
			<span id="bookingSuccess" class="success"></span>

<br> <input type="button" value="Delete Booking" name="DeleteBooking" id="DeleteBooking">


			</fieldset>
</div>


</div>
<br><div id="tables">	
<table id="gymMemberTable">
<thead>
    <th>memberId</th>
    <th>name</th> 
    </thead>
    <tbody id="gymMemberBody">
    </tbody>
 
</table>	
<table id="trainingSessionTable">
<thead>
    <th>instructor</th>
    <th>sessionId</th> 
    </thead>
    <tbody id="trainingSessionBody">
    </tbody>
    <table id="bookingTable">
<thead>
    <th>sessionId</th>
    <th>memberId</th> 
    </thead>
    <tbody id="bookingBody">
    </tbody>
 
</table>	
<%@include file="../Styles/Footer.html"%></body>
</html>