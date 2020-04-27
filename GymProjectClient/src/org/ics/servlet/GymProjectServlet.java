package org.ics.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
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
 * Servlet implementation class GymServlet
 */
@WebServlet("/GymServlet")
public class GymProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB 
	FacadeLocal facade;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GymProjectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	/**
		PrintWriter out = response.getWriter(); 

		out.println("<!DOCTYPE html><html><head>"); 
		out.println("<title>Gym</title>"); 
		out.println("<meta charset=\"ISO-8859-1\">"); 
		out.println("</head><body>"); 
		out.println("<h2>Medlemmar:</h2>");
		
		GymMember g = new GymMember();
		g.setName("lovisa");
		g.setAddress("malmo");
		g.setPhoneNumber("123");
		
		GymMember m = new GymMember();
		m.setName("lena");
		m.setAddress("lund");
		m.setPhoneNumber("123");
		TrainingSession s = new TrainingSession();
		s.setLength(2);
		s.setInstructor("lovi");
//		
		Booking b = new Booking();
		b.setGymMember(facade.findByMemberId(4));
		b.setTrainingSession(facade.findBySessionId(3));
		facade.createBooking(b);
		facade.createTrainingSession(s);
//		
		facade.createGymMember(g);
		facade.createGymMember(m);
		
		//H�mta alla Employees
		List<GymMember> allGymMembers = facade.findAll();
		for (GymMember gm: allGymMembers) {
			out.println("<h4>Hittade: "+ g.getClass().getSimpleName());
			out.println(" Id: "+ gm.getMemberId());
			out.println(" -"+ gm.getName());
			out.println(" -"+ gm.getAddress());
			out.println("</h4>"); }
		GymMember tempc = facade.findByMemberId(1);
		ArrayList<Booking> allBookings = facade.findAllBookingsForGymMember(tempc);
		if(!allBookings.isEmpty()) {
			for(Booking bb :allBookings) {
				out.println("<h4>Hittade: "+ bb.getClass().getSimpleName());
				out.println(" Id: "+ bb.getBookingId());
				out.println(" -"+ bb.getGymMember().getMemberId());
				out.println("</h4>");
			}
		}
		ArrayList<GymMember> allBookingsfor = facade.getAllGymMembersWithBookingsForTrainingSession(40);
		if(!allBookingsfor.isEmpty()) {
			for(GymMember bbb :allBookingsfor) {
				out.println("<h4>Hittade: "+ bbb.getClass().getSimpleName());
				out.println(" name: "+ bbb.getName());
				out.println("</h4>");
			}

		}**/

	}
	
}

