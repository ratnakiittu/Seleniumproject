package test.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GetEditValue {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://testingmasters.com/hrm/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath(".//*[@id='txtUsername']")).sendKeys ("user02");
		driver.findElement(By.xpath(".//*[@id='txtPassword']")).sendKeys("pass1234");
		
		//Get Textbox Value
		
		String un = driver.findElement(By.id("txtUsername")).getAttribute("value");
		System.out.println("Textbox value is:"+un);
		//Get Page URL
		
		String URL = driver.getCurrentUrl();
		System.out.println("URL is:"+ URL);
		
		//Get Page Source
		String pagesrc = driver.getPageSource();
		System.out.println("Page Source:"+ pagesrc);
		
	}

}
