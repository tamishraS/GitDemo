package TamishraAutomation.PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TamishraAutomation.AbstractComponents.AbstractComponents;

public class ConformationPage extends AbstractComponents{
	WebDriver driver;
	public ConformationPage(WebDriver driver){
		
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	

	@FindBy(css=".hero-primary")
	WebElement conformationMessage;
	
	public String getConformationMessage() {
		
		return conformationMessage.getText();
	}
	
	

}
