package ics.test;

import org.ics.ejb.GymMember;
import org.ics.facade.Facade;
import org.ics.facade.FacadeLocal;

import junit.framework.TestCase;

public class FacadeLocalTest extends TestCase {
	
	Facade facade;
	GymMember member;
	GymMember member2;
	long expectedMemberId;
	
	String expectedName;   
	String expectedAddress;   
	String expectedPhoneNumber;
	
	GymMember g;
	GymMember g2;
	

	public FacadeLocalTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		
		 expectedName =   "Mats"; 
	     expectedAddress =   "Lund";  
	     expectedPhoneNumber =   "12345";
	     expectedMemberId = 1234;
	     
	     //g = new GymMember(expectedMemberId, expectedName,expectedAddress,expectedPhoneNumber);      
	     //g2 =   new GymMember(1222, "Eva",  "Malmö",  "54321");
		//expectedMemberId = 1234;
		g = facade.createGymMember(g);
		expectedMemberId = g.getMemberId();
		//member.setMemberId(expectedMemberId);
		//g2 = facade.createGymMember(g2);
		
	}
	
	public void testCreateGymMember() {
		facade.createGymMember(g);
	}
	
	public void testFindByMemberId() {
	//assertNotNull(member);
	facade.findByMemberId(expectedMemberId);
	assertEquals(expectedMemberId, member.getMemberId());
}

	public void testEquals() {
		assertTrue(!member.equals(null));
		assertEquals(member, member);
		assertTrue(!member.equals(member2));
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		member = null;
	}

	/*public void testFindByMemberId() {
		//assertNotNull(member);
		facade.findByMemberId(expectedMemberId);
		assertEquals(expectedMemberId, member.getMemberId());
	}*/



}
