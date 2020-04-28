package org.ics.ejb.test;

import junit.framework.TestCase;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.ics.ejb.Booking;
import org.ics.ejb.TrainingSession;


public class TrainingSessionTest extends TestCase {
	
	
	long expectedSessionId;
	String expectedInstructor;
	Date expectedStartTime; //<= new Date(int year, int month, int date, int hrs, int min, int sec);
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
		String sdate = "2020-06-08 10:00:00.000";
		DateFormat d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
				expectedStartTime = null;
				try {
					expectedStartTime = d.parse(sdate);
				} catch (ParseException e) {
					
				}
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
		assertNotNull(session1);
//		assertEquals(expectedSessionId, session1.getSessionId());
	}

	public void testSetSessionId() {
		long expectedSessionId2 = 22;
		session1.setSessionId(expectedSessionId2);
	//	assertEquals(expectedSessionId2, session2.getSessionId());
	}

	public void testGetInstructor() {
//		assertEquals(expectedInstructor, session1.getInstructor());
	}

	public void testSetInstructor() {
		String expectedInstructor2 = "Björn";
		session1.setInstructor(expectedInstructor2);
//		assertEquals(expectedInstructor2, session2.getInstructor());
	}

	public void testGetStartTime() {
//		assertEquals(expectedStartTime, session1.getStartTime());
	}

	public void testSetStartTime() {
		Date expectedStartTime2 = expectedStartTime;
		session1.setStartTime(expectedStartTime);
		assertEquals(expectedStartTime, session1.getStartTime());
	}

	public void testGetType() {
//		assertEquals(expectedType, session1.getType());
	}

	public void testSetType() {
		String expectedType2 = "Running";
		session1.setType(expectedType2);
//		assertEquals(expectedType, session1.getType());
	}

	public void testGetLength() {
		assertEquals(expectedLength, session1.getLength());
	}

	public void testSetLength() {
		Integer expectedLength2 = 20;
		session1.setLength(expectedLength2);
//		assertEquals(expectedLength, session1.getLength());
	}

	public void testGetRoomNumber() {
//		assertEquals(expectedRoomNumber, session1.getRoomNumber());
	}

	public void testSetRoomNumber() {
		String expectedRoomNumber2 = "20";
		session1.setRoomNumber(expectedRoomNumber2);
//		assertEquals(expectedRoomNumber, session1.getRoomNumber());
	}

	public void testGetBookings() {
		assertEquals(expectedBookings, session1.getBookings());
	}

	public void testSetBookings() {
		Set<Booking> expectedBookings2 = s1(200, "Lina", "lina@gmail.com", 07220, "Linagatan 2", "Spinning");
		session1.setBookings(expectedBookings2);
		assertEquals(expectedBookings, session1.getBookings());
	}

	private Set<Booking> s1(int i, String string, String string2, int j, String string3, String string4) {
		// TODO Auto-generated method stub
		return null;
	}
}
