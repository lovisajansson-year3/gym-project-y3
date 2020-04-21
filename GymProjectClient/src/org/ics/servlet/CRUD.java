package org.ics.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ics.ejb.GymMember;
import org.ics.facade.FacadeLocal;

/**
 * Servlet implementation class CRUD
 */
@WebServlet("/CRUD/*")
public class CRUD extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	FacadeLocal facade;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CRUD() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String pathInfo = request.getPathInfo();
		if
		(pathInfo==null||pathInfo.equals("/")) {
			System.out.println("alla");
			System.out.println(pathInfo);
			List<GymMember> allMembers = facade.findAll();
			sendAsJson(response,allMembers);
			return;
		}
		String[] splits = pathInfo.split("/");
		if(splits.length!=2) {
			System.out.println("alla2");
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		String id = splits[1];
		GymMember member = facade.findByMemberId(Integer.parseInt(id));
		sendAsJson(response,member);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pathInfo = request.getPathInfo(); 
		if(pathInfo == null || pathInfo.equals("/")){
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return; 
			} 
		String[] splits = pathInfo.split("/"); 
		if(splits.length != 2) { 
			response.sendError(HttpServletResponse.SC_BAD_REQUEST); 
			return; 
			} 
		String id = splits[1]; 
		GymMember m = facade.findByMemberId(Integer.parseInt(id)); 
		if (m != null) { 
			facade.deleteGymMember(Integer.parseInt(id));      } 
		sendAsJson(response, m); 
	}
	private void sendAsJson(HttpServletResponse response, GymMember member)throws IOException{
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		if(member!=null) {
			out.print("{\"memberId\":");
			out.print("\""+member.getMemberId()+"\"}");
			out.print("{\"name\":");
			out.print("\""+member.getName()+"\"}");
			out.print("{\"address\":");
			out.print("\""+member.getAddress()+"\"}");
			out.print("{\"phoneNumber\":");
			out.print("\""+member.getPhoneNumber()+"\"}");
			out.print("{\"email\":");
			out.print("\""+member.getEmail()+"\"}");
			
		}else {
			out.print("{}");
		}
		out.flush();
	}
	private void sendAsJson(HttpServletResponse response, List<org.ics.ejb.GymMember> members) throws IOException { 
		PrintWriter out = response.getWriter(); 
		response.setContentType("application/json"); 
		if (members != null) { 
			JsonArrayBuilder array = Json.createArrayBuilder();
			for (GymMember member : members) { 
				JsonObjectBuilder o = Json.createObjectBuilder();
				out.print("{\"memberId\":");
				out.print("\""+member.getMemberId()+"\"}");
				out.print("{\"name\":");
				out.print("\""+member.getName()+"\"}");
				out.print("{\"address\":");
				out.print("\""+member.getAddress()+"\"}");
				out.print("{\"phoneNumber\":");
				out.print("\""+member.getPhoneNumber()+"\"}");
				out.print("{\"email\":");
				out.print("\""+member.getEmail()+"\"}");
				array.add(o);
			}
			JsonArray jsonArray = array.build(); 
			out.print(jsonArray); 
			} 
		else { 
			out.print("[]"); 
			}
		out.flush(); } 


}