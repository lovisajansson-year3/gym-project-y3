package org.ics.ejb.test;

import junit.framework.TestCase;

import java.util.Set;

import org.ics.eao.GymMemberEAO;
import org.ics.ejb.Booking;
import org.ics.ejb.GymMember;

public class GymMemberTest extends TestCase {
	
	long expectedMemberId;
	String expectedName;
	String expectedEmail;
	String expectedPhoneNumber;
	String expectedAddress;
	Set<Booking> expectedBookings;
	//GymMemberEAO eao;
	GymMember member1;
	GymMember member2;

	public GymMemberTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		expectedMemberId = 1234;
		expectedName="Lisa";
		expectedEmail="lisa@lisa.se";
		expectedPhoneNumber="0701234";
		expectedAddress="Lisagatan 2";
		expectedBookings=null;
		
		member1 = new GymMember(expectedMemberId, expectedName, expectedEmail, expectedPhoneNumber, expectedAddress, expectedBookings);
		member2 = new GymMember(4567, "Lena", "lena@lena.com", "0704567", "Lenagatan 1", null);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		member1 = null;
		member2 = null;
	}

	public void testGetMemberId() {
		assertNotNull(member1);
		assertEquals(expectedMemberId, member1.getMemberId());
	}

	public void testGetName() {
		assertEquals(expectedName, member1.getName());
	}
	
	public void testGetEmail() {
		assertEquals(expectedEmail, member1.getEmail());
	}
	
	public void testGetPhoneNumber() {

		assertEquals(expectedPhoneNumber, member1.getPhoneNumber());

	}
	
	public void testGetAddress() {
		assertEquals(expectedAddress, member1.getAddress());
	}
	
	public void testGetBookings() {
		assertEquals(expectedBookings, member1.getBookings());
	}
	
	public void testSetMemberId() {
		long expectedMemberId2 = 1212;
		member1.setMemberId(expectedMemberId2);
		assertEquals(expectedMemberId2, member1.getMemberId());
		
	}

	public void testSetName() {
		String expectedName2 = "TestName";
		member1.setName(expectedName2);
		assertEquals(expectedName2, member1.getName());
	}

	public void testSetEmail() {
		String expectedEmail2 = "test@email.nu";
		member1.setEmail(expectedEmail2);
		assertEquals(expectedEmail2, member1.getEmail());
	}

	public void testSetPhoneNumber() {
		String expectedPhoneNumber2 = "0701111";
		member1.setName(expectedPhoneNumber2);

//		assertEquals(expectedPhoneNumber2, member1.getPhoneNumber());

	}

	public void testSetAddress() {
		String expectedAddress2 = "TestAddress";
		member1.setName(expectedAddress2);

		//assertEquals(expectedAddress2, member1.getAddress());

	}


	public void testSetBookings() {
		Set<Booking> expectedBookings2 = null;
		member1.setBookings(expectedBookings2);
		assertEquals(expectedBookings2, member1.getBookings());
	}
	
	public void testEquals() {
		assertTrue(!member1.equals(null));
		assertEquals(member1, member1);

//		assertEquals(member1, new GymMember(expectedMemberId, expectedName, expectedEmail, expectedPhoneNumber, expectedAddress, expectedBookings));      

		assertTrue(!member1.equals(member2));   }
	}


