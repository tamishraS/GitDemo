package javaScriptExecutor;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import dev.failsafe.internal.util.Assert;

public class ScrollingExmpl {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\tamishra.senapati\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().fullscreen();
		
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		
		Thread.sleep(3000);
		
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		
		List<WebElement> value= driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int sum = 0;
		for(int i=0;i<value.size();i++) {
			
			sum= sum+Integer.parseInt(value.get(i).getText());
		}
		System.out.println(sum);
		String compSum=driver.findElement(By.cssSelector("div[class='totalAmount'] ")).getText().split(":")[1].trim();
		int total= Integer.parseInt(compSum);
		if(sum==Integer.parseInt(compSum)) {
			
			System.out.println("same result");
		}else {
			System.out.println("wrong calculation");
		}
		
		
		
		
		
	}

}
