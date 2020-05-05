package ics.test;

import org.ics.ejb.GymMember;

import junit.framework.TestCase;

public class GymMemberTest extends TestCase {
	String expectedName;   
	String expectedAddress;   
	String expectedPhoneNumber;
	long expectedMemberId;
	
	GymMember g;
	GymMember g2;
	
	public GymMemberTest(String name) {
		super(name);
	    
	}

	protected void setUp() throws Exception {
		super.setUp();
		 expectedName =   "Mats"; 
	     expectedAddress =   "Lund";  
	     expectedPhoneNumber =   "12345";
	     expectedMemberId = 1234;
	     
	     g=new GymMember(expectedMemberId, expectedName,expectedAddress,expectedPhoneNumber);      
	     g2 =   new GymMember(1222, "Eva",  "Malmö",  "54321");
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		g=null;
		g2=null;
	}

	public void testGetMemberId() {
//		fail("Not yet implemented");
	}

	public void testSetMemberId() {
//		fail("Not yet implemented");
	}

	public void testGetName() {
		assertNotNull(g);
		assertEquals(expectedName, g.getName());	}

	public void testSetName() {
	      String expectedName2 =   "Test";     
	      g.setName(expectedName2);     
	      assertEquals(expectedName2, g.getName());	}

	public void testGetEmail() {
	//	assertEquals(expectedEmail, g.getEmail());
	}

	public void testSetEmail() {
	/*	String expectedEmail2 = "TestEmail";
				g.setEmail(expectedEmail2);
				assertEquals(expectedEmail2, g.getEmail());*/
	}

	public void testGetPhoneNumber() {
		   assertEquals(expectedPhoneNumber, g.getPhoneNumber());	}

	public void testSetPhoneNumber() {
		   String expectedPhone2 =   "54321";       
		   g.setPhoneNumber(expectedPhone2); 
		   assertEquals(expectedPhone2, g.getPhoneNumber());	}

	public void testGetAddress() {
		assertNotNull(g);      
		assertEquals(expectedAddress, g.getAddress());	}

	public void testSetAddress() {
		   String expectedAddress2 =   "TestStad";
		   g.setAddress(expectedAddress2);    
		   assertEquals(expectedAddress2, g.getAddress());	}

	public void testGetBookings() {
//		fail("Not yet implemented");
	}

	public void testSetBookings() {
//		fail("Not yet implemented");
	}
	  public void testEquals() {      
		  assertTrue(!g.equals(null));  
		  assertEquals(g,g);
		//  assertEquals(g, new GymMember(expectedName,expectedAddress,expectedPhoneNumber));    
		  assertTrue(!g.equals(g2));   
		  } 

}
