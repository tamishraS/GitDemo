import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLoc {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\tamishra.senapati\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		WebElement findNameTag= driver.findElement(By.name("name"));
		System.out.println(driver.findElement(with(By.tagName("label")).above(findNameTag)).getText());
		
		WebElement clickSubmit= driver.findElement(By.xpath("//label[@for='dateofBirth']"));
		driver.findElement(with(By.tagName("input")).below(clickSubmit)).click();
		
		WebElement leftLocator= driver.findElement(By.cssSelector("label.form-check-label"));
		driver.findElement(with(By.tagName("input")).toLeftOf(leftLocator)).click();
		
		WebElement rightLocator= driver.findElement(By.id("inlineRadio1"));
		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(rightLocator)).getText());
		
		

	}

}
