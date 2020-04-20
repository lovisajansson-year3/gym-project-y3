<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ page import="java.util.*"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
if(request.getParameterNames()!=null){
	Enumeration e = request.getParameterNames();
	while(e.hasMoreElements()){
	 String paramName = (String)e.nextElement();
	 out.println(paramName+"=");
	 out.println(request.getParameter(paramName)+"<br>");
}
}
out.println("<br><p>");
out.println(request.getParameter("name")+"</p>");
%>
</body>
</html>