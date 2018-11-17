package test.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SwitchTabs {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  driver.get("https://google.com/");
		  
		  //open new tab using CTRL + t Keys
		  driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
		  
		  //open URL in 2nd page
		  
		  driver.navigate().to("http://facebook.com");
		  
		  //Switching between tabs using CTRL + tab keys
		  driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"\t");
		
		  //Switching between tabs using tab's content.
		  driver.switchTo().defaultContent();
	}

}
