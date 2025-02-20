package DebugTest.DebuggingTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UsefulMethods {
	
	public static void loginMethod(String username, String password, WebDriver driver) {
		WebElement usernameField = driver.findElement(By.cssSelector("#user-name"));
		WebElement passwordField = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.id("login-button"));
		
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		
		loginButton.click();
	}
}
