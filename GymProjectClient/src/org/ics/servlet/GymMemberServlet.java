package org.ics.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
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
@WebServlet("/GymMemberServlet/*")
public class GymMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	FacadeLocal facade;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GymMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String pathInfo = request.getPathInfo();
		if
		(pathInfo==null||pathInfo.equals("/")) {
			List<GymMember> members = facade.findAll(); 
			sendAsJson(response, members); 			
			return;
		}
		String[] splits = pathInfo.split("/");
		if(splits.length!=2) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		String id = splits[1];
		GymMember member = facade.findByMemberId(Integer.parseInt(id));
		if(member!=null) {
			sendAsJson(response,member);
		}else {
			response.sendError(HttpServletResponse.SC_NOT_FOUND, "member doesnt exist");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pathInfo = request.getPathInfo(); 
		if(pathInfo == null || pathInfo.equals("/")){ 
			BufferedReader reader = request.getReader();
			GymMember m = parseJsonGymMember(reader); 
			try { 
				m = facade.createGymMember(m); 
			}catch(Exception e) {
				System.out.println("facade error creating member");
			} 
			sendAsJson(response, m); 
			}
		}
	

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		BufferedReader reader = request.getReader(); 
		GymMember m = parseJsonGymMember(reader); 
		if(facade.findByMemberId(Long.parseLong(id))!=null) {
			try { 
				m.setMemberId(Long.parseLong(id));
				m = facade.updateGymMember(m); 
				sendAsJson(response, m); 
			}catch(Exception e) { 
				System.out.println("facade Update Error"); 
			} 
		}else {
			response.sendError(HttpServletResponse.SC_NOT_FOUND, "member doesnrt exist");
			return;
		}
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
		if (m == null) { 
			response.sendError(HttpServletResponse.SC_NOT_FOUND ); 
			return;
		}else {
			try {
				facade.deleteGymMember(Integer.parseInt(id));   
			}catch(Exception e){
				
				response.sendError(HttpServletResponse.SC_CONFLICT ); 
				return;
			}
			
		}
	}
	private void sendAsJson(HttpServletResponse response, GymMember m)throws IOException{
		PrintWriter out = response.getWriter(); 
		response.setContentType("application/json"); 
		if (m != null) { 
		
			out.print("{\"name\":"); 
			out.print("\"" + m.getName() + "\"");
			out.print(",\"address\":"); 
			out.print("\"" +m.getAddress()+"\"");
			out.print(",\"email\":"); 
			out.print("\"" +m.getEmail()+"\"");
			out.print(",\"memberId\":"); 
			out.print("\"" +m.getMemberId()+"\"");
			out.print(",\"phoneNumber\":"); 
			out.print("\"" +m.getPhoneNumber()+"\"}"); 
			} else { 
				out.print("[ ]"); 
				} 
		out.flush(); } 
	private void sendAsJson(HttpServletResponse response, List<GymMember> members) throws IOException { 
		
		PrintWriter out = response.getWriter(); 
		response.setContentType("application/json"); 
		if (members != null) { 
			JsonArrayBuilder array = Json.createArrayBuilder(); 
			for (GymMember m : members) { 
				JsonObjectBuilder o = Json.createObjectBuilder(); 
				o.add("memberId", m.getMemberId()); 
				o.add("name", m.getName()); 
				o.add("address", m.getAddress()); 
				o.add("phoneNumber", m.getPhoneNumber()); 
				o.add("email", m.getEmail()); 
				array.add(o); 
				} 
			JsonArray jsonArray = array.build(); 
			out.print(jsonArray); 
			} else { 
				out.print("[]"); 
				} 
			out.flush(); } 
	private GymMember parseJsonGymMember(BufferedReader br) { 
		JsonReader jsonReader = null;    
		JsonObject jsonRoot = null;    
		jsonReader = Json.createReader(br);    
		jsonRoot = jsonReader.readObject();    
		GymMember gymMember = new GymMember();    
		gymMember.setName(jsonRoot.getString("name")); 
		gymMember.setAddress(jsonRoot.getString("address"));    
		gymMember.setEmail(jsonRoot.getString("email"));    
		gymMember.setPhoneNumber(jsonRoot.getString("phoneNumber"));    
		
		return gymMember; 
		} 
	

}