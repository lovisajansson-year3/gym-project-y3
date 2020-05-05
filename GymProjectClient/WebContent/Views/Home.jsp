<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"> </script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.min.js"></script>
<script src="../Script/WeatherScript.js"></script>
<link rel="stylesheet" type="text/css" href="../Styles/mystyle.css">

<head>
<meta charset="ISO-8859-1">
</head>
<body style="heighr:1600px;">
<div class="navbar">
		<a href="${pageContext.request.contextPath}/Views/Home.jsp">Home</a> <a href="${pageContext.request.contextPath}/Views/About.jsp">About</a><a href="${pageContext.request.contextPath}/ControllerServlet">Book</a> <a
		class="active" href="${pageContext.request.contextPath}Views//Crud.jsp">Rest</a><a href="${pageContext.request.contextPath}Views//Test.jsp">Test</a>

	</div>

<%@ include file="../Styles/Header.html" %>


</div>
	
<div class="buttonRow">
 <div class="img">
  <a href="${pageContext.request.contextPath}/ControllerServlet"><img src="../Styles/holidays.png" width="60" height="60"></a>
  <p>Start booking</p>
</div>
<div class="vl"></div>
<div class="img">
  <a href="About.jsp"><img src="../Styles/web-programming.png" width="60" height="60"></a>
  <p>Learn more about us</p>
</div>
<div class="vll"></div>
<div class="img">
  <a href="Test.jsp"><img src="../Styles/flasks.png" width="60" height="60"></a>
  <p>Test our website</p>
</div>
</div>

<%@ include file="../Styles/Footer.html" %>


</body>
</html>