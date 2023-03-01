package Default;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Basics {
	
	@Test(groups="Smoke")
	public void c1() {
		System.out.println("Hello");
	}
	
	@Test
	public void c2() {
		System.out.println("Hi");
		Assert.assertTrue(false);
	}

}
