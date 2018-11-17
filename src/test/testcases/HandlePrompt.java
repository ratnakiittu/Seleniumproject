package test.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HandlePrompt {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		
		driver.get("file:///c:/Users");

	}

}
