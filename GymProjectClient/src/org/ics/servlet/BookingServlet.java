package org.ics.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import org.ics.ejb.Booking;
import org.ics.ejb.GymMember;
import org.ics.ejb.TrainingSession;
import org.ics.facade.FacadeLocal;

/**
 * Servlet implementation class BookingServlet
 */
@WebServlet("/BookingServlet/")
public class BookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	FacadeLocal facade;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pathInfo = request.getPathInfo();
		System.out.println(pathInfo);
		if
		(pathInfo==null||pathInfo.equals("/")) {
			List<Booking> bookings = facade.findAllBookings();
			System.out.println(bookings.size());
			sendAsJson(response, bookings); 
			System.out.println("findallbookings");
			
			return; 
		}
		String[] splits = pathInfo.split("/");
		if(splits.length!=2) {
			System.out.println("splitlength2");
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		String id = splits[1];
		Booking booking = facade.findByBookingId(Integer.parseInt(id));
		if(booking==null) {
			System.out.println("bookingisnull");
			response.sendError(HttpServletResponse.SC_NOT_FOUND, "session doesnt exist");
			
		}else {
		sendAsJson(response,booking);
		}	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pathInfo = request.getPathInfo(); 
		System.out.println(pathInfo);
		if(pathInfo == null || pathInfo.equals("/")){ 
			BufferedReader reader = request.getReader();
			Booking b = parseJsonBooking(reader);
			if(b.getTrainingSession()==null||b.getGymMember()==null) {
				response.sendError(HttpServletResponse.SC_NOT_FOUND, "session or gymMember doesnt exist");

			}else {
				try { 
					b = facade.createBooking(b); 
					System.out.println(b.getBookingId()+ " created");
				}catch(Exception e) {
					System.out.println("duplicate key"); 
					} 
				sendAsJson(response,b ); 
			}
		}
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
		Booking b = facade.findByBookingId(Integer.parseInt(id)); 
		if (b == null) { 
			response.sendError(HttpServletResponse.SC_NOT_FOUND ); 
			return;
		}else {
			try {
				facade.deleteBooking(Integer.parseInt(id));   
				System.out.println("booking deleted");
			}catch(Exception e){
				System.out.println(e.getMessage());
				response.sendError(HttpServletResponse.SC_CONFLICT ); 
				return;
			}	
		}
	}

	private void sendAsJson(HttpServletResponse response, Booking b)throws IOException{
		PrintWriter out = response.getWriter(); 
		response.setContentType("application/json"); 
		if (b != null) { 
		
			out.print("{\"bookingId\":"); 
			out.print("\"" + b.getBookingId() + "\"");
			out.print(",\"memberId\":"); 
			out.print("\"" +b.getGymMember().getMemberId()+"\"");
			out.print(",\"sessionId\":"); 
			out.print("\"" +b.getTrainingSession().getSessionId()+"\"}"); 
			} else { 
				out.print("[ ]"); 
				} 
		out.flush(); } 
	private void sendAsJson(HttpServletResponse response, List<Booking> bookings) throws IOException { 
		System.out.println("sendasjsonlist");
		PrintWriter out = response.getWriter(); 
		response.setContentType("application/json"); 
		if (bookings != null) { 
			JsonArrayBuilder array = Json.createArrayBuilder(); 
			for (Booking b : bookings) { 
				JsonObjectBuilder o = Json.createObjectBuilder(); 
				o.add("bookingId", b.getBookingId()); 
				o.add("sessionId", b.getTrainingSession().getSessionId()); 
				o.add("memberId", b.getGymMember().getMemberId()); 
				array.add(o); 
				} 
			JsonArray jsonArray = array.build(); 
			out.print(jsonArray); 
			} else { 
				out.print("[]"); 
				} 
			out.flush(); } 
	private Booking parseJsonBooking(BufferedReader br) { 
		JsonReader jsonReader = null;    
		JsonObject jsonRoot = null;    
		jsonReader = Json.createReader(br);    
		jsonRoot = jsonReader.readObject();    
		Booking b = new Booking();    
		TrainingSession t = facade.findBySessionId(Integer.parseInt((jsonRoot.getString("sessionId"))));
		GymMember g = facade.findByMemberId(Integer.parseInt((jsonRoot.getString("memberId"))));    
		b.setTrainingSession(t); 
		b.setGymMember(g);    
		return b; 
		} 

		
}
