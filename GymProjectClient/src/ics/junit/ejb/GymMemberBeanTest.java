package ics.junit.ejb;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.ics.ejb.GymMember;


import junit.framework.TestCase;

public class GymMemberBeanTest extends TestCase {
	
	GymMember g;

	public GymMemberBeanTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		Context context = new InitialContext();
		
		g=(GymMember)context.lookup("java:app/GymProject/GymMember!org.ics.ejb.GymMember");
		
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		g=null;
	}
	public void testGymMemberMethods() throws Exception {
		g.setName("Mats");
		g.setAddress("Lund");
		assertEquals(g.getName(),"Mats");
		assertEquals(g.getAddress(),"Lund");
		}
	public void testGymMemberMethods2() throws Exception {
		g.setAddress("Halmstad");
		assertEquals(g.getAddress(),"Halmstad");}
	}