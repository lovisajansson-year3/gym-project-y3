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
<script src="../Script/WeatherScript.js"></script>


<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../Styles/mystyle.css">
</head>
<body style="height: 1402px;">
<div class="navbar">
		<a href="${pageContext.request.contextPath}/Views/Home.jsp">Home</a> <a class="active"href="${pageContext.request.contextPath}/Views/About.jsp">About</a><a href="${pageContext.request.contextPath}/ControllerServlet">Book</a> <a
		  href="${pageContext.request.contextPath}/Views/Crud.jsp">Rest</a><a  href="${pageContext.request.contextPath}/Views/Test.jsp">Test</a>

	</div>
<%@ include file="../Styles/Header.html" %>





</div>
<br>
<div class="about-section">

  <h1 style="text-align:center;font-weight:bold">About Us Page</h1>

  <p>The gym was founded in 2020 and immediately became a success for all fitness enthusiats in Lund. Here at GympingLund we care for each other and everyone is welcome. Enjoy!</p>
  <p> </p>
</div>


<h2 style="text-align:center;font-weight:bold">Meet our team</h2>


<div class="row">
  <div class="column">
    <div class="card">
      <img src="https://scontent.fmmx1-1.fna.fbcdn.net/v/t1.0-9/71189732_10221290263072910_4763093528395907072_n.jpg?_nc_cat=103&_nc_sid=09cbfe&_nc_ohc=G_50solF7qIAX8vEvPG&_nc_ht=scontent.fmmx1-1.fna&oh=0a99bc234f6d8682f118e6e6ae122fbf&oe=5ED687C2"  style="width:100%">
      <div class="container">
        <h2>Lovisa Jansson</h2>
        <p class="title">CEO & Founder</p>
        <p>I love spinning and I'm a big fan of <br>being outdoors!</p>
        <p>lo6788ja-s@student.lu.se</p>
       <a href="mailto:lo6788ja-s@student.lu.se?subject=your title&body=TThe message">
<input type="button"value="Contact" id="contact"></a>
      <br><br>
      </div>
    </div>
  </div>
  <div class="column">
    <div class="card">
      <img src="https://scontent.fmmx1-1.fna.fbcdn.net/v/t1.0-9/89537489_10206256608210939_8519067378212929536_n.jpg?_nc_cat=100&_nc_sid=09cbfe&_nc_ohc=2m_ITRcaEDoAX9zA0kD&_nc_ht=scontent.fmmx1-1.fna&oh=c32fefdd3b652529272e1ac7b8fd410d&oe=5ED903F4" style="width:100%">
      <div class="container">
        <h2>Lena Bergenström</h2>
        <p class="title">CEO & Founder</p>
        <p>GympaLund is my passion!<br> It's the best job in the world!</p>
        <p>le7352be-s@student.lu.se</p>
         <a href="mailto:le7352be-s@student.lu.se?subject=your title&body=TThe message">
<input type="button"value="Contact" id="contact"></a><br><br>
      </div>
    </div>
  </div>
  <div class="column">
    <div class="card">
      <img src="https://scontent.fmmx1-1.fna.fbcdn.net/v/t1.0-9/19399382_1454915187878251_8251526793150036300_n.jpg?_nc_cat=107&_nc_sid=09cbfe&_nc_ohc=LR13iEvt-FEAX9x31gg&_nc_ht=scontent.fmmx1-1.fna&oh=361884703e9ce888251dc287ffda6c54&oe=5ED77976" style="width:100%">
      <div class="container">
        <h2>Lisa Jakobsson</h2>
        <p class="title">CEO & Founder</p>
        <p>Every workout is a good workout, <br>let's do this together!</p>
        <p>li7232ja-s@student.lu.se</p>
        <a href="mailto:li7232ja-s@student.lu.se
?subject=your title&body=TThe message">
<input type="button"value="Contact" id="contact"></a><br><br>

      </div>
    </div>
  </div>
  <div class="column">
    <div class="card">
      <img src="https://scontent.fmmx1-1.fna.fbcdn.net/v/t1.0-9/29695202_10209934431472175_2434226721364833617_n.jpg?_nc_cat=100&_nc_sid=09cbfe&_nc_ohc=QnxpPtY748cAX-F4_Tp&_nc_ht=scontent.fmmx1-1.fna&oh=a36933e28e1f4509669ee91b04e18f62&oe=5ED77ACB"  style="width:100%">
      <div class="container">
        <h2>Tove Larsson</h2>
        <p class="title">CEO & Founder</p>
        <p>My passion is helping others <br> reach their fitness goals!</p>
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