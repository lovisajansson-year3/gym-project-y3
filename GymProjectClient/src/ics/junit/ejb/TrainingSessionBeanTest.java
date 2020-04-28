package ics.junit.ejb;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.ics.ejb.TrainingSession;

import junit.framework.TestCase;

public class TrainingSessionBeanTest extends TestCase {
	
	TrainingSession session;

	public TrainingSessionBeanTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		Context context = new InitialContext();
		
		session =(TrainingSession)context.lookup("java:app/Gymproject/TrainingSession!org.ics.GymMember");
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		session = null;
	}
	public void testTrainingSessionMethods() throws Exception {
		
		session.setSessionId(12);
		session.setInstructor("Tuva");
		String sdate = "2020-06-08 10:00:00.000";
		
		Date startTime = new Date();
		DateFormat d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");	
			startTime = null;
				try {
					startTime = d.parse(sdate);
				} catch (ParseException e) {
					
				}
		session.setStartTime(startTime);
		session.setType("Spinning");
		session.setLength(2);
		session.setRoomNumber("23C");
		session.setBookings(null);
	}
	
	public void testTrainingSessionMethods2() throws Exception{
		session.setInstructor("Tove");
		assertEquals(session.getInstructor(), "Tove");
	}


}
