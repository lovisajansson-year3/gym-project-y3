package org.ics.ejb.test;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(BookingTest.class);
		suite.addTestSuite(GymMemberTest.class);
		suite.addTestSuite(TrainingSessionTest.class);
		//$JUnit-END$
		return suite;
	}

}
