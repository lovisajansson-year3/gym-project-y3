package ics.test;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(GymMemberTest.class);
		suite.addTestSuite(FacadeLocalTest.class);
		//$JUnit-END$
		return suite;
	}

}
