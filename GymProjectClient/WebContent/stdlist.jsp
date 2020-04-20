<%@page import="org.ics.ejb.GymMember"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html> 
  <head> 
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
   <title>Student List</title> 
  </head> 
  <body> 
      <h1>Displaying Student List</h1> 
      <table border ="1" width="500" align="center"> 
         <tr bgcolor="00FF7F"> 
          <th><b>Student Name</b></th> 
          <th><b>Student Age</b></th> 
          <th><b>Course Undertaken</b></th> 
         </tr> 
        <%-- Fetching the attributes of the request object 
             which was previously set by the servlet  
              "StudentServlet.java" 
        --%>  
        <%ArrayList<GymMember> std =  
            (ArrayList<GymMember>)request.getAttribute("data"); 
        for(GymMember s:std){%> 
        <%-- Arranging data in tabular form 
        --%> 
            <tr> 
                <td><%=s.getName()%></td> 
            </tr> 
            <%}%> 
        </table>  
        <hr/> 
    </body> 
</html> 