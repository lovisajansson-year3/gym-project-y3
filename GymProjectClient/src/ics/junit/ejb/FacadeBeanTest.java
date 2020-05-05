package ics.junit.ejb;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.ics.ejb.GymMember;
import org.ics.facade.Facade;
import org.ics.facade.FacadeLocal;

import junit.framework.TestCase;

public class FacadeBeanTest extends TestCase {
	
	FacadeLocal facade;
	GymMember g;

	public FacadeBeanTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		Context context = new InitialContext();
		
		facade = (FacadeLocal)context.lookup("java:app/GymProject/Facade!org.ics.facade.FacadeLocal");
		g = facade.createGymMember(g);
		g.setMemberId(1234);
		//g = facade.findByMemberId(1234);
		System.out.println("TEST");
	}
	
	public void testGymMemberMethods() throws Exception {
		assertNotNull(g);
	}
	
	public void testGymMemberMethods2() throws Exception {
		System.out.println("From test:" + g.getMemberId());
		assertEquals(g.getMemberId(), 1234);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		facade = null;
	}

}
