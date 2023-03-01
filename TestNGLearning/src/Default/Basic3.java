package Default;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Basic3 {
	
	@Test
	public void webAutoHomeLoan() {
		
		System.out.println("webHomeLoan");
	}
	@Test(dependsOnMethods={"webAutoHomeLoan","APIauto"})
	public void mobileAutoHomeLoan() {
		
		System.out.println("mobileAutoHomeLoan");
		
	}
	
	@Test
	public void APIauto() {
		
		
		System.out.println("APIAutoHomeLoan");
	}
	
	@BeforeClass
	public void beforeClass() {
		
		System.out.println("@@@@@@@@@@@@");
	}

}
