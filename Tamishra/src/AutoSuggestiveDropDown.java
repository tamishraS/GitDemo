import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestiveDropDown {

	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\tamishra.senapati\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		//To input "Ind" in textbox
		WebElement auto= driver.findElement(By.id("select-class-example"));
		auto.findElement(By.id("autocomplete")).sendKeys("Ind");
		Thread.sleep(3000);
		
		//To check if "India" is there in autoSuggestive values and click on it
		WebElement autoValues= driver.findElement(By.id("ui-id-1"));
		
		List<WebElement> suggestion= autoValues.findElements(By.cssSelector("li div.ui-menu-item-wrapper"));
		for(int i=0;i< suggestion.size();i++) {
			
			String countries= driver.findElements(By.cssSelector("li div.ui-menu-item-wrapper")).get(i).getText();
			//System.out.println(countries);
			if(countries.equalsIgnoreCase("India")) {
				
				suggestion.get(i).click();
				System.out.println("Suggestion 'India' is there.");
				break;
			}
			
		}

	}

}
