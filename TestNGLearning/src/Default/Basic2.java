package Default;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Basic2 {
	@Parameters({"carURL"})
	@Test
	public void webAutocarLoan(String u) {
		
		System.out.println("webCarLoan");
		System.out.println(u);
	}
	
	@Test(dataProvider="getData")
	public void mobileSignOutCar(String UserName, String Password) {
		
		System.out.println("Sign out");
		System.out.println(UserName);
		System.out.println(Password);
		
	}
	
	@Parameters({"URL","Key/UserName"})
	@Test
	public void mobileAutocarLoan(String urlName, String key) {
		
		System.out.println("mobileAutocarLoan");
		System.out.println(urlName);
		System.out.println(key);
		
	}
	
	@Test(groups="Smoke")
	public void APIauto() {
		
		
		System.out.println("APIAutocarLoan");
	}
	
	@Test(enabled=false)//To ignore this method
	public void mobileSignIn() {
		
		System.out.println("SignIn");
	}
	
	@Test(timeOut=4000)//to wait for 40sec 
	public void mobileSignOut() {
		
		System.out.println("SignOut");
	}
	
	@AfterMethod
	public void beforeMethod() {
		
		System.out.println("**************");
	}
	
	@DataProvider
	public Object[][] getData(){
		
		//1st combo- username & password- good credit history
		//2nd combo- no credit history
		//3rd combo- fraudelent credit history
		Object[][] data= new Object[3][2];
		//case1
		data[0][0]="FirstUserName";
		data[0][1]="FirstPassword";
		
		//case2
		data[1][0]="SecondUserName";
		data[1][1]="SecondPassword";
		
		//case 3
		data[2][0]="ThirdUserName";
		data[2][1]="ThirdPassword";
		
		return data;
	
	}
	
	

}
