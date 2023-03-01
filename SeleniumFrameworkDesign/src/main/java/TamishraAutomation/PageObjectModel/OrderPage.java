package TamishraAutomation.PageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TamishraAutomation.AbstractComponents.AbstractComponents;

public class OrderPage extends AbstractComponents {
	
	WebDriver driver;
	public OrderPage(WebDriver driver) {
		
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".totalRow button")
	WebElement forCheckOut;
	
	@FindBy(css="tr td:nth-child(3)")
	private List<WebElement> orderItems;
	
	public boolean verifyOrderDisplayed(String Item) {
		
		boolean match= orderItems.stream().anyMatch(cartItem->cartItem.getText().equalsIgnoreCase(Item));
		return match;
	}
	
}
