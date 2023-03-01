import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calender {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\tamishra.senapati\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.airindiaexpress.in/en");
		
		driver.findElement(By.cssSelector("#departureDateButton")).click();
		
		//To select April month
		while(!driver.findElement(By.xpath("//th[@title='Select Month']")).getText().contains("April")) {
			driver.findElement(By.xpath("//span[@title='Next Month']")).click();
		}
		
			
		
		
		//To Select 25th Jan 2023
		List<WebElement> Dates=driver.findElements(By.cssSelector(".day"));
		int count=driver.findElements(By.cssSelector(".day")).size();
		
		for(int i=0; i<count;i++)
		{
			String s= driver.findElements(By.cssSelector(".day")).get(i).getText();
			if(s.equalsIgnoreCase("25")) {
				
				driver.findElements(By.cssSelector(".day")).get(i).click();
				break;
			}
		}

	}

}
