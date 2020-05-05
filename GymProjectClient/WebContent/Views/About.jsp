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
<script src="../Scripts/Javascript.js"></script>

<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../Styles/mystyle.css">

</head>
<body style="height: 1802px;">
<div class="navbar">
		<a href="Home.jsp">Home</a> <a class="active"href="About.jsp">About</a><a href="${pageContext.request.contextPath}/ControllerServlet">Book</a> <a
		  href="Crud.jsp">Rest</a><a  href="Test.jsp">Test</a>

	</div>
<%@ include file="../Styles/Header.html" %>



</div>
<br>
<div class="about-section">
  <h1>About Us Page</h1>
  <p>Some text about who we are and what we do.</p>
  <p>Resize the browser window to see that this page is responsive by the way.</p>
</div>

<h2 style="text-align:center">Our Team</h2>
<div class="row">
  <div class="column">
    <div class="card">
      <img src="team-member.gif"  style="width:100%">
      <div class="container">
        <h2>Lovisa Jansson</h2>
        <p class="title">CEO & Founder</p>
        <p>blablabl</p>
        <p>lo6788ja-s@student.lu.se</p>
       <a href="mailto:lo6788ja-s@student.lu.se?subject=your title&body=TThe message">
<input type="button"value="Contact" id="contact"></a>
      <br><br>
      </div>
    </div>
  </div>
  <div class="column">
    <div class="card">
      <img src="team-member.gif" style="width:100%">
      <div class="container">
        <h2>Lena Bergenström</h2>
        <p class="title">CEO & Founder</p>
        <p>Some text that describes me lorem ipsum ipsum lorem.</p>
        <p>le7352be-s@student.lu.se</p>
         <a href="mailto:le7352be-s@student.lu.se?subject=your title&body=TThe message">
<input type="button"value="Contact" id="contact"></a><br><br>
      </div>
    </div>
  </div>
  <div class="column">
    <div class="card">
      <img src="team-member.gif" alt="Jane" style="width:100%">
      <div class="container">
        <h2>Lisa Jakobsson</h2>
        <p class="title">CEO & Founder</p>
        <p>Some text that describes me lorem ipsum ipsum lorem.</p>
        <p>li7232ja-s@student.lu.se</p>
        <a href="mailto:li7232ja-s@student.lu.se
?subject=your title&body=TThe message">
<input type="button"value="Contact" id="contact"></a><br><br>

      </div>
    </div>
  </div>
  <div class="column">
    <div class="card">
      <img src="team-member.gif"  style="width:100%">
      <div class="container">
        <h2>Tove Larsson</h2>
        <p class="title">CEO & Founder</p>
        <p>Some text that describes me lorem ipsum ipsum lorem.</p>
        <p>to6502la-s@student.lu.se</p>
        <a href="mailto:to6502la-s@student.lu.se?subject=your title&body=TThe message">
<input type="button"value="Contact" id="contact"></a><br><br>

      </div>
    </div>
  </div>
  </div>
  <%@ include file="../Styles/Footer.html" %>


</body>
</html>
