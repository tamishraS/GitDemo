import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assgnment {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\tamishra.senapati\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		//select checkBox
		driver.findElement(By.xpath(" //div[@id='checkbox-example']/fieldset/label[2]/input")).click();
		System.out.println(driver.findElement(By.xpath(" //div[@id='checkbox-example']/fieldset/label[2]")).getText());
		String checkBox= driver.findElement(By.xpath(" //div[@id='checkbox-example']/fieldset/label[2]")).getText();
		
		//Select dropDown same as checkBox
		WebElement dropDown= driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));
		Select s= new Select(dropDown);
		s.selectByVisibleText(checkBox);
		//to enter in alert box & click Alert button
		driver.findElement(By.id("name")).sendKeys(checkBox);
		driver.findElement(By.id("alertbtn")).click();
		
		//Switch to alert & check if checkBox text is available
		String alertText= driver.switchTo().alert().getText();
		if(alertText.contains(checkBox)) {
			
			System.out.println("Alert message is successful");
		}else {
			
			System.out.println("failure");
		}
		
	}

}
