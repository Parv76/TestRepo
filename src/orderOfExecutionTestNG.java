
	// Import TestNG annotations
	import org.testng.annotations.BeforeSuite;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.AfterSuite;
	
	public class orderOfExecutionTestNG {

	    // Runs once before the entire test suite
	    @BeforeSuite
	    public void beforeSuite() {
	        System.out.println("Before Suite");
	    }

	    // Runs before the first test method in the class
	    @BeforeClass
	    public void beforeClass() {
	        System.out.println("Before Class");
	    }

	    // Runs before each test method
	    @BeforeMethod
	    public void beforeMethod() {
	        System.out.println("Before Method");
	    }

	    // The first test method
	    @Test
	    public void testMethod1() {
	        System.out.println("Executing Test Method 1");
	    }

	    // The second test method
	    @Test
	    public void testMethod2() {
	        System.out.println("Executing Test Method 2");
	    }

	    // Runs after each test method
	    @AfterMethod
	    public void afterMethod() {
	        System.out.println("After Method");
	    }

	    // Runs after all test methods in the class
	    @AfterClass
	    public void afterClass() {
	        System.out.println("After Class");
	    }

	    // Runs once after the entire test suite
	    @AfterSuite
	    public void afterSuite() {
	        System.out.println("After Suite");
	    }

	}

