package Default;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Basics1 {
	
	@AfterTest
	public void afterTest() {
		System.out.println("I'm last but not least");
	}
	@Test(groups="Smoke")
	public void c3() {
		System.out.println("Bye");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("I'm first");
	}
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("I'm fist in Suite");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("I'm last in Suite");
	}
	
	
}
