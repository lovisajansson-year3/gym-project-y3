package org.ics.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ics.ejb.GymMember;
import org.ics.ejb.TrainingSession;
import org.ics.facade.Facade;
import org.ics.facade.FacadeLocal;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB 
	FacadeLocal facade;

	    public void init() {
	    	
	    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String button_clicked = request.getParameter("button_clicked");
		if (button_clicked==null) {
			//no form submitted
		}else if("Create Gym Member".equals(button_clicked)) {
            GymMember g = new GymMember();
			g.setName(request.getParameter("name"));
			g.setEmail(request.getParameter("email"));
			g.setAddress(request.getParameter("address"));
			g.setPhoneNumber(request.getParameter("phoneNumber"));
			facade.createGymMember(g);
        } else if("Create Training Session".equals(button_clicked)) {
        	TrainingSession t = new TrainingSession();
        	t.setInstructor(request.getParameter("instructor"));
        	t.setLength(1);
        	t.setRoomNumber(request.getParameter("roomNumber"));
        	String time= request.getParameter("startTime");
        	String startDate = request.getParameter("startDate");
        	String date = startDate +" "+ time+":00.00";
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SS");
            Date d = null;
			try {
				d=dateFormat.parse(date);

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			t.setStartTime(d);
        	t.setType("type");
        	Map<String, String> messages = new HashMap<String, String>();
		    request.setAttribute("messages", messages); // Now it's available by ${messages}
			if(facade.alreadyExists(t.getInstructor(),t.getStartTime())==false) {
				facade.createTrainingSession(t);
			}else {
				messages.put("alreadyExists", "There is already a training session at this time for this instructor");

			}
        	
        	
        }
	         request.setAttribute("allMembers", facade.findAll()); 
	         request.setAttribute("allTrainingSessions", facade.findAllTrainingSessions());
	         request.setAttribute("allBookings", facade.findAllBookings());
	         RequestDispatcher rd =  
	             request.getRequestDispatcher("testing.jsp");  
	          rd.forward(request, response); 
	           
	        
	}
	}


