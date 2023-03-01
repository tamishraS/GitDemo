package TamishraAutomation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import TamishraAutomation.PageObjectModel.CartPage;
import TamishraAutomation.PageObjectModel.LandingPage;
import TamishraAutomation.PageObjectModel.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/client/");
		
		String Item= "ZARA COAT 3";
		
		
		
		driver.findElement(By.id("userEmail")).sendKeys("senapatitamishra1@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Dholu@17");
		
		driver.findElement(By.id("login")).click();
		
			
		List<WebElement> products= driver.findElements(By.cssSelector("div.mb-3"));
		
			
		Thread.sleep(3000);
		
		//WebElement prod1= products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase("IPHONE 13 PRO")).findFirst().orElse(null);
		//prod1.findElement(By.cssSelector(".w-10")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".toast-message")));
		
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".toast-message"))));
		
		driver.findElement(By.cssSelector("button[routerlink*='cart']")).click();
		
	    List<WebElement> cartItems= driver.findElements(By.cssSelector("div.cartSection h3"));
		
		
		boolean match= cartItems.stream().anyMatch(cartItem->cartItem.getText().equalsIgnoreCase(Item));
		Assert.assertTrue(match);
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".totalRow button")).click();
		
		Actions a= new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("input[placeholder='Select Country']")),"India").build().perform();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("section.ta-results")));
		driver.findElement(By.xpath("//button[contains(@class,'ta-item')])[2]")).click();
		
		driver.findElement(By.cssSelector(".action__submit")).click();
		
		String message= driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(message.equalsIgnoreCase("Thankyou for the order."));
		
		driver.close();

	}

}
