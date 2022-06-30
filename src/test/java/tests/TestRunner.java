package tests;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;

@SuppressWarnings("deprecation")
public class TestRunner {

	public static void main(String[] args) {
	    TestListenerAdapter tla = new TestListenerAdapter();
	    TestNG testng = new TestNG();
	    testng.setTestClasses(new Class[] { CreationSaisieTest.class });
	   testng.addListener(tla);
	    testng.run();
	}

}
