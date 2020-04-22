<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<title>Exempel1 JSP</title></head><body><% response.setHeader("Refresh", "5"); %><% String namn = "Mats"; Date d = new Date();%>
<h1><%= namn %></h1><p>Senastuppdaterad<%= d %></p>
</body>
</html>