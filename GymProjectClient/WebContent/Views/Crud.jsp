
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


<body style="height: 1802px; ">
<div class="navbar">
		<a href="Home.jsp">Home</a> <a href="About.jsp">About</a> <a
		class="active" href="Crud.jsp">Test</a>

	</div>

<%@ include file="../Styles/Header.html" %>

	
	</div>
<br>
<div class="row">
 <div class="add">
	<legend>Add Gym Member:</legend>
	<label for="name">Full Name</label>    	
	<input class="effect-1" type="text" name="name" id="name" placeholder=""required >
 
	<br> <label for="email">Email:* </label><input class="effect-1"type="text" 		name="email" id="email" required>

	<br> <label for="phoneNumber">Phone number:* </label>
	<input class="effect-1"type="number" name="phoneNumber" id="phoneNumber" required> 	<br>
	<label for="address">Address:* </label>
	<input type="text" class="effect-1"name="address" id="address" required>

	<br>

	<div class="create">
	<input type="button" value="CREATE" name="CreateGymMember" id="CreateGymMember">
	</div>
		    <br>
	
 	<div class="pick">
	 <legend for="memberId">Pick GymMember to display values for, update or delete: </legend><br><br><select name="memberId" id="memberId"><option value="" disabled 
         selected>Select memberId</option></select>
	 <br> 
	 <br>
	 <input type="button" value="Update Member"     name="Up dateGymMember"id="UpdateGymMember">
	 <input type="button" name="DeleteByMemberId" id="DeleteByMemberId" value="Delete 	 Member" />
	 <br>
	 <span id="memberError" class="error" ></span>
	 <span id="memberSuccess" class="success"></span> 
  	 <br>
	</div>
			
</div>
	<div class="add">
	<legend>Add TrainingSession:</legend>
	<label for="instructor">Instructor:*</label> <select id="instructor" name="instructor"required>
	<option value="Lovisa">Lovisa</option>
	<option value="Lena">Lena</option>
	<option value="Tove">Tove</option>
	<option value="Lisa">Lisa</option>
	</select><br>

	<label for="startDate">Startdate:*</label> 
	<input type="date" id="startDate" name="startDate" value="2018-07-22" min="2018-01-01"max="2021-01-01" required>	
 	<br><label for="startTime">Starttime:*</label> 
 	<select id="startTime" required name="startTime">
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
	<option value="spinning">spinning</option>
	<option value="crossfit">crossfit</option>
	</select><br>
	<label for="roomNumber">Room number:*</label> <select id="roomNumber" name="roomNumber"required>
					<option value="EC01">EC01</option>
					<option value="EC101">EC101</option>
				</select><br><br>
	<div class="create">
	 	<input type="button" value="Create Training Session" name="CreateTrainingSession" 		id="CreateTrainingSession">
	</div>
	<div class="pick">
<legend for="sessionId">Pick Session to display values for, update or delete:</legend><br><br><select name="sessionId" id="sessionId"></select><br>

<br> <input type="button" value="Update Session" name="UpdateTrainingSession" id="UpdateTrainingSession">
 <input type="button" value="Delete Session" name="DeleteTrainingSession" id="DeleteTrainingSession">
<br>
<span id="sessionError" class="error"></span>
<span id="sessionSuccess" class="success"></span>
<br>
</div>
		</div>
		<div id="Booking" class="add">
				<legend>Add Booking:</legend><label for="bookingMemberId">
				MemberId:*</label><select class="id" name="bookingMemberId" id="bookingMemberId" required></select>
				<br><label for="bookingSessionId"> TrainingSessionId:*</label> <select class="id"name="bookingSessionId" id="bookingSessionId"required></select> <br> 

	<br>	<div class="create">
<input type="button" id="CreateBooking" name="CreateBooking"value="Create Booking" >
</div>

<div class="pick">
<legend for="bookingId">Pick Booking to display values for or delete:</legend><br><br><select name="bookingId" id="bookingId"></select>
<br>
<br> 
<input type="button" value="Delete Booking" name="DeleteBooking" id="DeleteBooking">
<br>
<span id="bookingError" class="error" ></span>
<span id="bookingSuccess" class="success"></span>
<br>
</div>
</div>
</div>
<br>

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