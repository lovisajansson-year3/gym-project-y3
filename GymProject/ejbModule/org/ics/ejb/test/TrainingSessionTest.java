package org.ics.ejb.test;

import junit.framework.TestCase;

import java.util.Date;
import java.util.Set;

import org.ics.ejb.Booking;
import org.ics.ejb.TrainingSession;

public class TrainingSessionTest extends TestCase {
	
	long expectedSessionId;
	String expectedInstructor;
	Date expectedStartTime;
	String expectedType;
	Integer expectedLength; 
	String expectedRoomNumber;
	Set<Booking> expectedBookings;
	TrainingSession session1;
	TrainingSession session2;

	public TrainingSessionTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		expectedSessionId = 1111;
		expectedInstructor = "Tove";
		//expectedStartTime = 2020-03-12;
		expectedType = "Spinning";
		expectedLength = 1; 
		expectedRoomNumber ="Room 1";
		expectedBookings = null;
		session1 = new TrainingSession();
		session2 = new TrainingSession();
		
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		session1 = null;
		session2 = null;
	}

	public void testGetSessionId() {
		fail("Not yet implemented");
	}

	public void testSetSessionId() {
		fail("Not yet implemented");
	}

	public void testGetInstructor() {
		fail("Not yet implemented");
	}

	public void testSetInstructor() {
		fail("Not yet implemented");
	}

	public void testGetStartTime() {
		fail("Not yet implemented");
	}

	public void testSetStartTime() {
		fail("Not yet implemented");
	}

	public void testGetType() {
		fail("Not yet implemented");
	}

	public void testSetType() {
		fail("Not yet implemented");
	}

	public void testGetLength() {
		fail("Not yet implemented");
	}

	public void testSetLength() {
		fail("Not yet implemented");
	}

	public void testGetRoomNumber() {
		fail("Not yet implemented");
	}

	public void testSetRoomNumber() {
		fail("Not yet implemented");
	}

	public void testGetBookings() {
		fail("Not yet implemented");
	}

	public void testSetBookings() {
		fail("Not yet implemented");
	}

}
