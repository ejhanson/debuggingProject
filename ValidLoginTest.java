package DebugTest.DebuggingTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;


public class ValidLoginTest {
WebDriver driver;

	@Test
	public void validLoginTest() {
		driver = new ChromeDriver();
		
		driver.get("https://www.saucedemo.com/");
		
		String username = "problem_user";
		String password = "secrets_sauce";
		
		//Login Page Elements
		UsefulMethods.loginMethod(username, password, driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		
		//Home Page Elements
		  WebElement pageHeader = driver.findElement(By.xpath("//div[class='app_logo']"));
		//Get the page title
		  String pageTitle = pageHeader.getText();
		
		try { 
		      Assert.assertEquals(pageTitle, "Swag Labs", "Login Test Unsuccessful, the page did not load correctly:");
		      System.out.println("Login successful: The page loaded correctly");
		      }
		catch(AssertionError e) {
		      Reporter.log(e.toString());
		      System.out.println("Test failed. See report for details");
		      Assert.fail();
		      }
		driver.close();
		
	}
}
