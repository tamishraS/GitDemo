package TamishraAutomation;


import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import TamishraAutomation.PageObjectModel.CartPage;
import TamishraAutomation.PageObjectModel.CheckOutPage;
import TamishraAutomation.PageObjectModel.ConformationPage;
import TamishraAutomation.PageObjectModel.LandingPage;
import TamishraAutomation.PageObjectModel.ProductCatalogue;
import TamishraAutomation.TestComponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ErrorValidationTest extends BaseTest {

			
		@Test(groups="ErrorHandling")
		public void loginErrorValidation() throws IOException {
		
		String Item= "ZARA COAT 3";
		String Cont= "India";
		ProductCatalogue productCatalogue=landingPage.LoginApplication("senapatitamishra1@gmail.com", "Dholu@18");
		Assert.assertEquals( "Incorrect email or password." , landingPage.getErrorMessage());
		
		
		}
		
		@Test
		public void productErrorValidation() throws IOException {
		
		String Item= "ZARA COAT 3";
		String Cont= "India";
		
		ProductCatalogue productCatalogue=landingPage.LoginApplication("senapatitamishra1@gmail.com", "Dholu@17");
		List<WebElement> prod= productCatalogue.getProductList();
		productCatalogue.productAddToCart(Item);
		CartPage cartPage=productCatalogue.goToCart();
		Boolean match=cartPage.verifyCartProducts("ZARA COAT 33");
		Assert.assertFalse(match);
		
		}
	}

