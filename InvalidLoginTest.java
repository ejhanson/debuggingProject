package DebugTest.DebuggingTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class InvalidLoginTest {
	WebDriver driver;

	@Test
	public void invalidLoginTest() {
		driver = new ChromeDriver();
		
		driver.get("https://www.saucedemo.com/");
		
		String username = "incorrect_user";
		String password = "secret_sauce";
		
		//Login Page Elements
		UsefulMethods.loginMethod(username, password, driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		
		//Error Appears
		WebElement loginError = driver.findElement(By.xpath("//button[@class= normalize-space('error-message-container error')]"));
		
		String errorMessage = loginError.getText();
		System.out.println(errorMessage);
		try { 
		      Assert.assertEquals(errorMessage, "Epic sadface: Username and password do not match any user in this service.", "Invalid Login Test Failed, error not found:");
		      System.out.println("Invalid Login Attempt Blocked");
		      }
		catch(AssertionError e) {
		      Reporter.log(e.toString());
		      System.out.println("Test failed. See report for details");
		      Assert.fail();
		      }
		//driver.close();
		
	}
}
