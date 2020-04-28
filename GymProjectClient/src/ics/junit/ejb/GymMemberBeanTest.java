package ics.junit.ejb;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.ics.ejb.GymMember;

import junit.framework.TestCase;

public class GymMemberBeanTest extends TestCase {

	//GymMemberEAOLocal member;
	GymMember member1;
	
	public GymMemberBeanTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		Context context = new InitialContext();
		
		//member = (GymMemberEAOLocal)context.lookup("java:app/GymProject/GymMember!org.ics.GymMeberEAOLocal");
		member1 = (GymMember)context.lookup("java:app/GymProject/GymMember!org.ics.GymMember");
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		member1 = null;
	}
	
	public void testMemberMethods() throws Exception {
		/* memberId;
			private String name;
			private String email;
			private String phoneNumber;
			private String address;
			private Set<Booking> bookings;*/
		
		member1.setMemberId(1234);
		member1.setName("Lajsa");
		member1.setEmail("lajsa@lajsa.lajsa");
		member1.setPhoneNumber("1111");
		member1.setAddress("Lisavägen 1");
		member1.setBookings(null);
	}
	
	public void testMemberMethods2() throws Exception{
		member1.setAddress("Lenavägen 1");
		assertEquals(member1.getAddress(), "Lenavägen 1");
	}

}
