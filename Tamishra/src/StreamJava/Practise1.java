package StreamJava;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Practise1 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\tamishra.senapati\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		driver.findElement(By.xpath("//tr/th[1]")).click();
		
		List<WebElement> elementList= driver.findElements(By.xpath("//tr/td[1]"));
		List<String> originalList= elementList.stream().map(s->s.getText()).collect(Collectors.toList());
		
		List<String> sortedList= originalList.stream().sorted().collect(Collectors.toList());
		
		Assert.assertTrue(originalList.equals(sortedList));
		
		List<Object> price;
		do {
		
		List<WebElement> elementLists= driver.findElements(By.xpath("//tr/td[1]"));
		price= elementLists.stream().filter(s->s.getText().contains("Rice")).map(s->getVeggiePrice(s)).collect(Collectors.toList());
		price.forEach(s->System.out.println(s));
		if(price.size()<1) {
			
			driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
		}
		}
		while(price.size()<1);
		
		
		
		
		

	}

	private static Object getVeggiePrice(WebElement s) {
		
		String priceValue= s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return priceValue;
	}

}
