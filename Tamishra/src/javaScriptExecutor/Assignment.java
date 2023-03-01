package javaScriptExecutor;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\tamishra.senapati\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)");
		
		List<WebElement> rows= driver.findElements(By.cssSelector(".table-display tbody tr"));
		int r=rows.size();
		System.out.println("No of rows"+" = "+r);
		
		List<WebElement> columns= driver.findElements(By.cssSelector(".table-display tbody tr th"));
		int c= columns.size();
		System.out.println("No of columns"+" = "+c);
		
//		List<WebElement> texts=driver.findElements(By.cssSelector(".table-display tbody tr:nth-child(3)"));
//		for(int i=0;i<texts.size();i++) {
//			
//			String s=driver.findElements(By.cssSelector(".table-display tbody tr:nth-child(3)")).get(i).getText();
//			System.out.print(s);
//		}
		
		List<WebElement> SecondRow= driver.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));
		
		
		System.out.println(SecondRow.get(0).getText());
		System.out.println(SecondRow.get(1).getText());
		System.out.println(SecondRow.get(2).getText());
		

	}

}
