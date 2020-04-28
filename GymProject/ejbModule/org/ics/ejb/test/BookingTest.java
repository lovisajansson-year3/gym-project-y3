package org.ics.ejb.test;

import junit.framework.TestCase;

import java.util.Date;
import java.util.Set;

import org.ics.ejb.Booking;
import org.ics.ejb.GymMember;
import org.ics.ejb.TrainingSession;

public class BookingTest extends TestCase {
	long expectedBookingId;
	GymMember expectedGymMember;
	TrainingSession expectedTrainingSession;
	
	Booking booking1;
	Booking booking2;

	public BookingTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		expectedBookingId = 122;
		expectedGymMember = g1 (2323, "Lena", "lena@gmail.com", 070, "Lenagatan 2", "Spinning");
		expectedTrainingSession = t1 (213, "Lena", 2020-9-9, "Spinning", 20,00,00, 123, 133);
		
		booking1 = new Booking();
		booking2 = new Booking();
		
	}

	private TrainingSession t1(int i, String string, int j, String string2, int k, int l, int m, int n, int o) {
		// TODO Auto-generated method stub
		return null;
	}

	private GymMember g1(int i, String string, String string2, int j, String string3, String string4) {
		// TODO Auto-generated method stub
		return null;

	}

	protected void tearDown() throws Exception {
		super.tearDown();
		booking1 = null;
		booking2 = null;
	}

	public void testGetBookingId() {
		assertNotNull(booking1);
	//	assertEquals(expectedBookingId, booking1.getBookingId());
	}

	public void testGetGymMember() {
		assertEquals(expectedGymMember, booking1.getGymMember());
	}

	public void testSetGymMember() {
		GymMember expectedGymMember2 = g1(13, "Lisa", "Lisa@live.se", 1233, "Lisasväg 3", null);
		booking1.setGymMember(expectedGymMember2);
		assertEquals(expectedGymMember2, booking1.getGymMember());
	}

	public void testGetTrainingSession() {
		assertEquals(expectedTrainingSession, booking1.getTrainingSession());
	}

	public void testSetTrainingSession() {
		TrainingSession expectedTrainingSession2 = t1(899, "Tove", "2020-06-08 10:00:00.000", "Spinning", 2, "20B", null);
		booking1.setTrainingSession(expectedTrainingSession2);
		assertEquals(expectedTrainingSession2, booking1.getTrainingSession());
	}

	private TrainingSession t1(int i, String string, String string2, String string3, int j, String string4,
			Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	public void testSetBookingId() {
		long bookingId2 = 2;
		booking1.setBookingId(bookingId2);
	//	assertEquals(bookingId2, booking2.getBookingId());
	}
	
	public void testEquals() {
		assertTrue(!booking1.equals(null));
		assertEquals(booking1, booking1);
		//assertEquals(booking1, new Booking());
		assertTrue(!booking1.equals(booking2));
	}

}
