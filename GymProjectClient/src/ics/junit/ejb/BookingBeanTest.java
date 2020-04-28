package ics.junit.ejb;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.ics.ejb.Booking;
import org.ics.ejb.GymMember;
import org.ics.ejb.TrainingSession;

import junit.framework.TestCase;

public class BookingBeanTest extends TestCase {
	
	Booking booking;

	public BookingBeanTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		Context context = new InitialContext();
		
		booking = (Booking)context.lookup("java:app/GymProject/Booking!org.ics.Booking");
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		
		booking = null;
	}
	
	public void testBookingMethods() throws Exception {
		
		GymMember gymMember = new GymMember(4567, "Lena", "lena@lena.com", "0704567", "Lenagatan 1", null);
		TrainingSession session = new TrainingSession();
		
		booking.setBookingId(1234);
		booking.setGymMember(gymMember);
		booking.setTrainingSession(session);
	}
	
	public void testBookingMethods2() throws Exception{
		booking.setBookingId(1222);
		assertEquals(booking.getBookingId(), 1222);
	}

}
