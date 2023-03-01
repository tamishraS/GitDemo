package TamishraAutomation.PageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TamishraAutomation.AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents {
	
	WebDriver driver;
	public CartPage(WebDriver driver) {
		
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".totalRow button")
	WebElement forCheckOut;
	
	@FindBy(css="div.cartSection h3")
	private List<WebElement> cartItems;
	
	public boolean verifyCartProducts(String Item) {
		
		boolean match= cartItems.stream().anyMatch(cartItem->cartItem.getText().equalsIgnoreCase(Item));
		return match;
	}
	public CheckOutPage goToCheckOut() {
		forCheckOut.click();
		return new CheckOutPage(driver);
	}
	

}
