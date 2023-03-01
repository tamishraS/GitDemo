package TamishraAutomation.PageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TamishraAutomation.AbstractComponents.AbstractComponents;

public class ProductCatalogue extends AbstractComponents{
	WebDriver driver;
	public ProductCatalogue(WebDriver driver) {
		
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(css="div.mb-3")
	List<WebElement> products;
	
	@FindBy(css=".toast-message")
	List<WebElement> spinner;
	
	By productsBy= By.cssSelector("div.mb-3");
	By addToCart= By.cssSelector(".w-10");
	By toastMessage= By.cssSelector(".toast-message");
	public List<WebElement> getProductList() {
		
		waitForElementToAppear(productsBy);
		return products;
	}
	
	public WebElement getProductByName(String Item) {
		
		WebElement prod= getProductList().stream().filter(product->product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(Item)).findFirst().orElse(null);
		return prod;
		
	}
	
	public void productAddToCart(String Item) {
		WebElement prod= getProductByName(Item);
		prod.findElement(addToCart).click();
		waitForElementToAppear(toastMessage);
	}
	
	
	
	

}
