package ics.junit.ejb;


import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import junit.framework.Assert;
import junit.framework.TestCase;
import org.ics.ejb.GymMember;
import org.ics.facade.FacadeLocal;

import junit.framework.TestCase;

public class FacadeTest extends TestCase {

	FacadeLocal facade;
	GymMember g;
	long expectedMemberId;
	
	public FacadeTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		System.getProperty(Context.PROVIDER_URL);
		Context ctx = new InitialContext( ); 		
		
		facade=(FacadeLocal)ctx.lookup("java:app/GymProject/Facade"+"!org.ics.facade.FacadeLocal");
		//g = facade.createGymMember(g);
		expectedMemberId = 1234;
		//g.setMemberId(expectedMemberId);
		
	}
	
	public void testCreateGymMemberMethod() throws Exception {
		GymMember g = new GymMember();
		g.setName("lovisa");
		g.setAddress("malmo");
		GymMember g2 = facade.createGymMember(g);
		assertEquals(g.getAddress(),g2.getAddress());



		
		}
	public void testFindByMemberIdMethod() throws Exception {
		facade.findByMemberId(expectedMemberId);
		
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		facade=null;
	}


}
