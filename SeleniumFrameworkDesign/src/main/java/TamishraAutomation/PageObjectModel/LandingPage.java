package TamishraAutomation.PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TamishraAutomation.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents{
	WebDriver driver;
	public LandingPage(WebDriver driver) {
		
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	//WebElement userEmail= driver.findElement(By.id("userEmail"));
	//WebElement userPaswd= driver.findElement(By.id("userPassword"));
	//WebElement submit= driver.findElement(By.id("login"));
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPaswd;
	
	@FindBy(id="login")
	WebElement submit;
	
	@FindBy(css=".ng-trigger-flyInOut")
	WebElement errorMessage;
	
	public ProductCatalogue LoginApplication(String Email,String Paswd) {
		
		userEmail.sendKeys(Email);
		userPaswd.sendKeys(Paswd);
		submit.click();
		ProductCatalogue productCatalogue= new ProductCatalogue(driver);
		return productCatalogue;
	}
	
	public String getErrorMessage() {
		
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
		
		
	}
	
	public void goTo() {
		
		driver.get("https://rahulshettyacademy.com/client/");
	}

}
