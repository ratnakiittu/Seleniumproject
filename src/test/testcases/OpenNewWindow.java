package test.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class OpenNewWindow {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  driver.get("https://google.com/");
		  
		  WebElement link_Gmail = driver.findElement(By.linkText("Gmail"));
		  Actions Act = new Actions(driver);
		  
		  //open gmail page in new tab
		  Act.contextClick(link_Gmail).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		  
		  //open gmail page in new window
		 // Act.contextClick(link_Gmail).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		  

	}

}
