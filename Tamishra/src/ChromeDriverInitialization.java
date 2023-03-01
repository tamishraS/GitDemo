import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.google.common.base.Strings;


public class ChromeDriverInitialization {

	public static void main(String[] args) throws Exception {
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\tamishra.senapati\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		System.out.println(driver.findElements(By.tagName("a")).size());
		WebElement footer= driver.findElement(By.cssSelector("div#gf-BIG"));
		System.out.println(footer.findElements(By.tagName("a")).size());
		WebElement DiscountCoupons= footer.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(DiscountCoupons.findElements(By.tagName("a")).size());
		for(int i=1;i<DiscountCoupons.findElements(By.tagName("a")).size();i++){
			
			String OpenNewTab= Keys.chord(Keys.CONTROL, Keys.ENTER);
			DiscountCoupons.findElements(By.tagName("a")).get(i).sendKeys(OpenNewTab);
			Thread.sleep(500L);
		}
		Set<String> allTabs=driver.getWindowHandles();
		Iterator<String> itr= allTabs.iterator();
		while(itr.hasNext())
		{
			String tab= itr.next();
			driver.switchTo().window(tab);
			System.out.println(driver.getTitle());
		}
	}

}
