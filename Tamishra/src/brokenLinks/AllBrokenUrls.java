package brokenLinks;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class AllBrokenUrls {

	public static void main(String[] args) throws MalformedURLException, IOException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\tamishra.senapati\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		List<WebElement> footerlinks= driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		SoftAssert sa= new SoftAssert();
		
		for(WebElement footerlink:footerlinks) {
			
			String url= footerlink.getAttribute("href");
			//System.out.println(url);
			
			HttpURLConnection conn=(HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int code=conn.getResponseCode();
			//System.out.println(code);
			sa.assertTrue(code<400, "The link with Text "+"'"+footerlink.getText()+"'"+" is broken with code "+code);
//			if(code>400) {
//				
//				
//				System.out.println("The link with Text "+"'"+footerlink.getText()+"'"+" is broken with code "+code);
//				Assert.assertTrue(false);
//			}
		}
		sa.assertAll();

	}

}
