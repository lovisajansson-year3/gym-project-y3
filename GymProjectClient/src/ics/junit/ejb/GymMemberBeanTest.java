package ics.junit.ejb;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.ics.ejb.GymMember;
import org.ics.facade.Facade;

import junit.framework.TestCase;

public class GymMemberBeanTest extends TestCase {

	//GymMemberEAOLocal member;
	Facade memberFacade;
	
	public GymMemberBeanTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		Context context = new InitialContext();
		
		//member = (GymMemberEAOLocal)context.lookup("java:app/GymProject/GymMember!org.ics.GymMeberEAOLocal");
		//member1 = (GymMember)context.lookup("java:app/GymProject/GymMemberEAO!org.ics.eao.GymMemberEAOLocal"); //("java:app/GymProject/GymMember!org.ics.GymMember");
		memberFacade = (Facade)context.lookup("java:app/GymProject/Facade!org.ics.facade.Facade");
	
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		memberFacade = null;
	}
	
	public void testFacadeMethods() throws Exception {
		/* memberId;
			private String name;
			private String email;
			private String phoneNumber;
			private String address;
			private Set<Booking> bookings;*/
		
		GymMember gymMember = new GymMember(4567, "Lena", "lena@lena.com", "0704567", "Lenagatan 1", null);
		
		memberFacade.createGymMember(gymMember);
		
		
	}
	
	public void testFacadeMethods2() throws Exception{
		GymMember gymMember2 = new GymMember(1234, "Lisa", "lisa@lisa.com", "0704567", "Lisagatan 1", null);
		memberFacade.createGymMember(gymMember2);
		assertEquals(memberFacade.createGymMember(gymMember2), gymMember2);
	}

}
