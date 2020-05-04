
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"> 
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.min.js"></script>
<script src="../Scripts/Javascript.js"></script>

<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../Styles/mystyle.css">

</head>
<body style="height: 1802px;">
<div class="navbar">
		<a href="Home.jsp">Home</a> <a href="About.jsp">About</a> <a
		class="active" href="Crud.jsp">Test</a>

	</div>
<%@ include file="../Styles/Header.html" %>



</div>
<br>
<div class="about-section">
  <h1>About Us Page</h1>
  <p>Some text about who we are and what we do.</p>
  <p>Resize the browser window to see that this page is responsive by the way.</p>
</div>
<div class="oneMember">
<h2 style="text-align:center">Our Team</h2>
<div class="row">
  <div class="column">
    <div class="card">
      <img src="team-member.gif" alt="Jane" style="width:100%">
      <div class="container">
        <h2>Jane Doe</h2>
        <p class="title">CEO & Founder</p>
        <p>Some text that describes me lorem ipsum ipsum lorem.</p>
        <p>jane@example.com</p>
       <input type="button"value="Contact" id="contact"><br><br>
      </div>
    </div>
  </div>
  <div class="column">
    <div class="card">
      <img src="team-member.gif" alt="Jane" style="width:100%">
      <div class="container">
        <h2>Jane Doe</h2>
        <p class="title">CEO & Founder</p>
        <p>Some text that describes me lorem ipsum ipsum lorem.</p>
        <p>jane@example.com</p>
         <input type="button"value="Contact" id="contact"><br><br>
      </div>
    </div>
  </div>
  <div class="column">
    <div class="card">
      <img src="team-member.gif" alt="Jane" style="width:100%">
      <div class="container">
        <h2>Jane Doe</h2>
        <p class="title">CEO & Founder</p>
        <p>Some text that describes me lorem ipsum ipsum lorem.</p>
        <p>jane@example.com</p>
       <input type="button"value="Contact" id="contact"><br><br>

      </div>
    </div>
  </div><%@ include file="../Styles/Footer.html" %>


</body>
</html>
