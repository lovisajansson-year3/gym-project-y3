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
<script src="${pageContext.request.contextPath}/Script/MainScript.js"></script>
<script>


</script>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Styles/mystyle.css">

</head>

<body style="height: 2302px; ">
<div class="navbar">
		<a href="${pageContext.request.contextPath}/Views/Home.jsp">Home</a> <a href="${pageContext.request.contextPath}/Views/About.jsp">About</a><a class="active" href="${pageContext.request.contextPath}/ControllerServlet">Book</a> <a
		 href="${pageContext.request.contextPath}/Views/Crud.jsp">Rest</a><a  href="${pageContext.request.contextPath}/Views/Test.jsp">Test</a>

	</div>
<%@ include file="../Styles/Header.html" %>

	
	</div>
<br>
<div class="row">

 <div class="add">
	
<form name="form"action="${pageContext.request.contextPath}/ControllerServlet"method="post" )>

<legend>Add Gym Member:</legend>
<label for="name">Full Name</label>  <br>
<input type="text" name="name" size="25" maxlength="25" id="name2" required></input><br>
<label for="email">Email:* </label><br>
<input type="text" name="email" size="25" maxlength="25"id="email2" required></input><br>
<label for="phoneNumber">Phone number:* </label><br>
<input type="number" name="phoneNumber" size="25" maxlength="25"id="phoneNumber2" required></input><br>
<label for="address">Address:* </label><br>
<input type="text" name="address" size="25" maxlength="25"id="address2" required></input>
	<div class="create">
<br>
<input type="submit" name="button" value="Create GymMember" required/>



<span id="memberCreateError2" class="error" >
<% String gerrormsg = (String)request.getAttribute("gerror"); %>
<% if (gerrormsg == null) 
{ %>
<% } else { 
%>
<%= gerrormsg %><br>
<% } %>
      </span>
<span id="memberCreateSuccess2" class="success">
<% String gsuccessmsg = (String)request.getAttribute("gsuccess"); %>
<% if (gsuccessmsg == null) 
{ %>
<% } else { 
%>
<%= gsuccessmsg %><br>
<% } %>
      </span>

</div>
<div class="pick">
	 <legend for="memberId">Pick GymMember to update or delete: </legend><br><br>
 		 
<select name="allGymMembers">
    <c:forEach items="${allGymMembers}" var="GymMember">
    
        <option value="${GymMember.memberId}">${GymMember.memberId}</option>
    </c:forEach>
</select>
<button type="submit" name="button"  value="Update GymMember">Update GymMember</button>
<button type="submit" name="button" formnovalidate value="Delete GymMember">Delete GymMember</button>

</div>
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
				<div class="create">
	
<span id="sessionCreateError2" class="error" >
<% String terrormsg = (String)request.getAttribute("terror"); %>
<% if (terrormsg == null) 
{ %>
<% } else { 
%>
<%= terrormsg %><br>
<% } %> 
      </span>
<span id="sessionCreateSuccess2" class="success">
<% String tsuccessmsg = (String)request.getAttribute("tsuccess"); %>
<% if (tsuccessmsg == null) 
{ %>
<% } else { 
%>
<%= tsuccessmsg %><br>
<% } %>
     
</span> 
<input type="submit" name="button" value="Create TrainingSession" id="CreateTrainingSessionJ"/>
<br>
</div>
	<div class="pick">
<legend for="sessionId">Pick Session to display values for, update or delete:</legend><br>
<select name="allTrainingSessions">
    <c:forEach items="${allTrainingSessions}" var="TrainingSession">
    
        <option value="${TrainingSession.sessionId}">${TrainingSession.sessionId}</option>
    </c:forEach>
    </select>
    <button type="submit" name="button"  value="Update TrainingSession">Update TrainingSession</button>
<button type="submit" name="button" formnovalidate value="Delete TrainingSession">Delete TrainingSession</button>
    </div>
</form>

</div>
<div class="add">
	
<form action="/GymProjectClient/ControllerServlet"method="post">

<legend>Add Booking:</legend><label for="bookingMemberId">
				MemberId:*</label>
         <select name="bookingMemberId" required>
    <c:forEach items="${allGymMembers}" var="GymMember">
    
        <option value="${GymMember.memberId}">${GymMember.memberId}</option>
    </c:forEach></select>
				<br><label for="bookingSessionId"> TrainingSessionId:*</label> 
				<select name="bookingSessionId" required>
    <c:forEach items="${allTrainingSessions}" var="TrainingSession">
    
        <option value="${TrainingSession.sessionId}">${TrainingSession.sessionId}</option>
    </c:forEach> </select><br> 
<div class="create">
	<br>	
	
<span id="bookingCreateError2" class="error" >
<% String berrormsg = (String)request.getAttribute("berror"); %>
<% if (berrormsg == null) 
{ %>
<% } else { 
%>
<%= berrormsg %><br>
<% } %>
      </span>
<span id="bookingCreateSuccess2" class="success">
 <% String bsuccessmsg = (String)request.getAttribute("bsuccess"); %>
<% if (bsuccessmsg == null) 
{ %>
<% } else { 
%>
<%= bsuccessmsg %><br>
<% } %>
</span> 
<input type="submit" name="button" value="Create Booking"/>

	
	<div class="pick">
<legend for="bookingId">Pick Booking to display values for or delete:</legend><br>
 <select name="allBookings">
    <c:forEach items="${allBookings}" var="Booking">
    
        <option value="${Booking.bookingId}">${Booking.bookingId}</option>
    </c:forEach>
    </select>
<button type="submit" name="button" formnovalidate value="Delete Booking">Delete Booking</button>
</div>
</form>
<br>
</div>	
</div>r
<br>
<table id="gymMemberTable2">
<thead>
<tr>
    <th>memberId</th>
    <th>name</th> 
    <th>email</th>
    <th>phoneNumber</th> 
    <th>address</th> 
    </tr>
    </thead>
    <c:forEach var="gymMember" items="${allGymMembers}">
                <tr>
                    <td><c:out value="${gymMember.memberId}" /></td>
                    <td><c:out value="${gymMember.name}" /></td>
                    <td><c:out value="${gymMember.email}" /></td>
                    <td><c:out value="${gymMember.phoneNumber}" /></td>
                    <td><c:out value="${gymMember.address}" /></td>
                    
                </tr>
            </c:forEach>
</table>	
<table id="trainingSessionTable2">
<thead>
<tr>
 <th>sessionId</th> 
    <th>instructor</th>
    <th>startTime</th> 
    <th>roomNumber</th>
   </tr>
   
    </thead>
    <tr>
    <c:forEach var="trainingSession" items="${allTrainingSessions}">
                <tr>
                    <td><c:out value="${trainingSession.sessionId}" /></td>
                    <td><c:out value="${trainingSession.instructor}" /></td>
                    <td><c:out value="${trainingSession.startTime}" /></td>
                    <td><c:out value="${trainingSession.roomNumber}" /></td>
                </tr>
            </c:forEach>
    </table>
    <table id="bookingTable2">
<thead>
<tr>
        <th>bookingId</th> 

    <th>sessionId</th>
    <th>memberId</th> 
    </tr>
    </thead>
   <c:forEach var="booking" items="${allBookings}">
                <tr>
                    <td><c:out value="${booking.bookingId}" /></td>
                    <td><c:out value="${booking.gymMember.memberId}" /></td>
                    <td><c:out value="${booking.gymMember.memberId}" /></td>
                    
                </tr>
            </c:forEach>
 
</table>	

<%@include file="../Styles/Footer.html"%></body>
</html>
