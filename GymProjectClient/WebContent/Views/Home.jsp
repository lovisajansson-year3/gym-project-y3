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
<body>
<div class="navbar">
		<a href="Home.jsp">Home</a> <a href="About.jsp">About</a> <a
		class="active" href="Crud.jsp">Test</a>

	</div>

<%@ include file="../Styles/Header.html" %>


</div>
	
<div class="buttonRow">
 <div class="img">
  <a href="https://www.w3schools.com"><img src="../Styles/holidays.png" width="60" height="60"></a>
  <p>Start booking</p>
</div>
<div class="vl"></div>
<div class="img">
  <a href="https://www.w3schools.com"><img src="../Styles/web-programming.png" width="60" height="60"></a>
  <p>Learn more about us</p>
</div>
<div class="vll"></div>
<div class="img">
  <a href="https://www.w3schools.com"><img src="../Styles/flasks.png" width="60" height="60"></a>
  <p>Test our website</p>
</div>
</div>

<aside>
<table id="asideTable">
<tr>
<th><span id="city"></span></th> <th><span></span></th> <th><span></span></th>
<th><span id="ipNbr"></span></th>
</tr> <tr>
<td><span id="degree"></span></td> <td><span id="weather"></span></td> <td><span></span></td> <td><span></span></td>
</tr> <tr>
<td colspan="4"><span id="sunrise"></span></td> </tr>
<tr>
<td colspan="4"><span id="sunset"></span></td>
</tr>
</table> </aside>



<%@ include file="../Styles/Footer.html" %>


</body>
</html>