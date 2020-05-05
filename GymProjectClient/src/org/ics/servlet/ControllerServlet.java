package org.ics.servlet;


import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.ics.ejb.Booking;
import org.ics.ejb.GymMember;
import org.ics.ejb.TrainingSession;
import org.ics.facade.FacadeLocal;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	FacadeLocal facade;
    /**
     * @see HttpServlet#HttpServlet()
     */
	private static final String CONTENT_TYPE = "text/html; charset=ISO-8859-1";
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setAttribute("allGymMembers", facade.findAll());
		req.setAttribute("allTrainingSessions", facade.findAllTrainingSessions());
		req.setAttribute("allBookings", facade.findAllBookings());
		System.out.println("hallå");
	
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/Views/Gym.jsp");
        requestDispatcher.forward(req, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession(true);
		System.out.println("hej");
		String url = null;//Get hidden field
		String button = req.getParameter("button");
		req.setAttribute("gsuccess", null);
		req.setAttribute("gerror", null);
		req.setAttribute("tsuccess", null);
		req.setAttribute("terror", null);
		req.setAttribute("bsuccess", null);
		req.setAttribute("berror", null);
		String msg="";
		String errormsg="";
		if (button.equals("Create GymMember"))  {
			GymMember g = new GymMember();
			g.setName(req.getParameter("name"));
			g.setAddress(req.getParameter("address"));
			g.setEmail(req.getParameter("email"));
			g.setPhoneNumber(req.getParameter("phoneNumber"));
			facade.createGymMember(g);
			msg="gym member "+ g.getMemberId()+" created";
			req.setAttribute("gsuccess",  msg);
			session.setAttribute("gsuccess",  msg);


			
		} 
		else if (button.equals("Create TrainingSession"))  {
			TrainingSession t = new TrainingSession();
			t.setInstructor(req.getParameter("instructor"));
			String sdate= req.getParameter("startDate");
			String stime = req.getParameter("startTime");
			String sDate=sdate+stime;
			sDate = sDate+":00.000";
			DateFormat d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			Date d2 = null;
			
			try {
				d2 = d.parse(sDate);
				t.setStartTime(d2);
			} catch (ParseException e) {
			}
			t.setRoomNumber(req.getParameter("roomNumber"));
			t.setType(req.getParameter("type"));
			if(facade.alreadyExists(t.getInstructor(), t.getStartTime())==true) {
				errormsg = "this instructor already has a session at this time";
				req.setAttribute("terror", errormsg);
				return;
			}else {
				facade.createTrainingSession(t);
				msg = "session "+t.getSessionId()+" created";
				req.setAttribute("tsuccess", msg);
			}
			}
		else if (button.equals("Update GymMember"))  {
			long id = Long.parseLong(req.getParameter("allMembers"));
			GymMember g = facade.findByMemberId(id);
			g.setName(req.getParameter("name"));
			g.setAddress(req.getParameter("address"));
			g.setEmail(req.getParameter("email"));
			g.setPhoneNumber(req.getParameter("phoneNumber"));
			facade.updateGymMember(g);
			msg="gym member "+g.getMemberId()+" updated";
			req.setAttribute("gsuccess",  msg);
		}else if (button.equals("Delete GymMember"))  {
			long id = Long.parseLong(req.getParameter("allMembers"));
			facade.deleteGymMember(id);
			msg="gym member " + id+" deleted";
			req.setAttribute("gsuccess", msg );
		}else if(button.equals("Update TrainingSession")){
			long id = Long.parseLong(req.getParameter("allTrainingSessions"));
			TrainingSession t = facade.findBySessionId(id);
			t.setInstructor(req.getParameter("instructor"));
			String sdate= req.getParameter("startDate");
			String stime = req.getParameter("startTime");
			String sDate=sdate+stime;
			sDate = sDate+":00.000";
			DateFormat d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			Date d2 = null;
			try {
				d2 = d.parse(sDate);
				t.setStartTime(d2);
			} catch (ParseException e) {
			}
			t.setRoomNumber(req.getParameter("roomNumber"));
			t.setType(req.getParameter("type"));
			if(facade.alreadyExists(t.getInstructor(), t.getStartTime())==true) {
				errormsg="this instructor already has a session at this time";
				req.setAttribute("terror", errormsg);
				return;
			}else {
				facade.updateTrainingSession(t);
				msg = "session "+t.getSessionId()+" updated";
				req.setAttribute("tsuccess", msg);
			}
		}else if(button.equals("Delete TrainingSession")){
			long id = Long.parseLong(req.getParameter("allTrainingSessions"));
			facade.deleteTrainingSession(id);
			msg="session "+id+" deleted";
			req.setAttribute("tsuccess", id );
		}else if(button.equals("Create Booking")){
			long sid = Long.parseLong(req.getParameter("bookingTrainingSessions"));
			long mid = Long.parseLong(req.getParameter("bookingGymMembers"));
			if(facade.alreadyExists(mid, sid)==true) {
				errormsg="this member is already booked on this session";
				req.setAttribute("berror", errormsg);
			}else {
				Booking b = new Booking();
				b.setGymMember(facade.findByMemberId(mid));
				b.setTrainingSession(facade.findBySessionId(sid));
				facade.createBooking(b);
				msg="booking "+b.getBookingId()+" created";
				req.setAttribute("bsuccess", msg);
			}

		}else if(button.equals("Delete Booking")) {
			long bid = Long.parseLong(req.getParameter("allBookings"));
			msg ="booking "+bid+" deleted";
			facade.deleteBooking(bid);
			req.setAttribute("bsuccess", msg);
		}

		
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/Views/Gym.jsp");
        doGet(req,response);
	}

}
