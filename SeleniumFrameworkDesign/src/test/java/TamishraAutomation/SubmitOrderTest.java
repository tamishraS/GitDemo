package TamishraAutomation;


import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TamishraAutomation.PageObjectModel.CartPage;
import TamishraAutomation.PageObjectModel.CheckOutPage;
import TamishraAutomation.PageObjectModel.ConformationPage;
import TamishraAutomation.PageObjectModel.LandingPage;
import TamishraAutomation.PageObjectModel.OrderPage;
import TamishraAutomation.PageObjectModel.ProductCatalogue;
import TamishraAutomation.TestComponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrderTest extends BaseTest {

	String Item= "ZARA COAT 3";	
		@Test(dataProvider="getData",groups="Purchase")
		public void submitOrder(HashMap<String,String> input) throws IOException {
		
		String Cont= "India";
		
		ProductCatalogue productCatalogue=landingPage.LoginApplication(input.get("email"),input.get("paswd"));
		List<WebElement> prod= productCatalogue.getProductList();
		productCatalogue.productAddToCart(input.get("product"));
		CartPage cartPage=productCatalogue.goToCart();
		Boolean match=cartPage.verifyCartProducts(input.get("product"));
		Assert.assertTrue(match);
		CheckOutPage checkOutPage= cartPage.goToCheckOut();
		checkOutPage.SelectCountry(Cont);
		ConformationPage conformationPage= checkOutPage.SubmitOrder();
		 
		String ConformMessage= conformationPage.getConformationMessage();
		Assert.assertTrue(ConformMessage.equalsIgnoreCase("Thankyou for the order."));
		
		}
		
		@Test(dependsOnMethods= {"submitOrder"})
		public void orderHistoryTest() {
			
			//Item
			ProductCatalogue productCatalogue=landingPage.LoginApplication("senapatitamishra1@gmail.com", "Dholu@17");
			OrderPage orderPage= productCatalogue.goToOrdersPage();
			Assert.assertTrue(orderPage.verifyOrderDisplayed(Item));
		}
		
		@DataProvider
		public Object[][] getData() throws IOException {
			
//			HashMap<String,String> map= new HashMap<String,String>();
//			map.put("email", "senapatitamishra1@gmail.com");
//			map.put("paswd", "Dholu@17");
//			map.put("product", "ZARA COAT 3");
//			
//			HashMap<String,String> map1= new HashMap<String,String>();
//			map1.put("email", "senapatitamishra@gmail.com");
//			map1.put("paswd", "Dholu@17");
//			map1.put("product", "ADIDAS ORIGINAL");
			List<HashMap<String,String>> data= getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\TamishraAutomation\\Data");
			return new Object[][] {{data.get(0)},{data.get(1)}};
		}
	}

