package org.ics.ejb.test;

import junit.framework.TestCase;
import org.ics.ejb.Booking;
import org.ics.ejb.GymMember;
import org.ics.ejb.TrainingSession;

public class BookingTest extends TestCase {
	long expectedBookingId;
	GymMember expectedGymMember;
	TrainingSession expectedTrainingSession;

	public BookingTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		expectedBookingId = 122;
		expectedGymMember = (2323, "Lena", "lena@gmail.com", 070, "Lenagatan 2", "Spinning");
		TrainingSession expectedTrainingSession;
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testGetBookingId() {
		fail("Not yet implemented");
	}

	public void testGetGymMember() {
		fail("Not yet implemented");
	}

	public void testSetGymMember() {
		fail("Not yet implemented");
	}

	public void testGetTrainingSession() {
		fail("Not yet implemented");
	}

	public void testSetTrainingSession() {
		fail("Not yet implemented");
	}

	public void testSetBookingId() {
		fail("Not yet implemented");
	}

}
