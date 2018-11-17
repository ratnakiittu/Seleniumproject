package test.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CssSelector {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		  driver.manage().window().maximize();
		  driver.get("http://demo.nopcommerce.com/register");
		  
		  driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Testing Masters");
		  driver.findElement(By.cssSelector("input[id='FirstName']")).sendKeys("Testing Masters");
		  driver.findElement(By.cssSelector("input[id='FirstName'][name='FirstName']")).sendKeys("Testing Masters");
		  driver.findElement(By.cssSelector("input.text[id='FirstName']")).sendKeys("Testing Masters");
	
		  driver.findElement(By.cssSelector("input[id^^='First']")).sendKeys("Testing Masters");
		  driver.findElement(By.cssSelector("input[id$='Name']")).sendKeys("Testing Masters");
		  driver.findElement(By.cssSelector("input[id*='irst']")).sendKeys("Testing Masters");
		  
		  
	}
	

}
