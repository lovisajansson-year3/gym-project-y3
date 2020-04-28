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

	public BookingTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		expectedBookingId = 122;
		expectedGymMember = g1 (2323, "Lena", "lena@gmail.com", 070, "Lenagatan 2", "Spinning");
		expectedTrainingSession = t1 (213, "Lena", 2020-9-9, "Spinning", 20,00,00, 123, 133);
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
