package DebugTest.DebuggingTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
public class AddToCartTest {
	WebDriver driver;
	
	@Test
	public void validLoginTest() {
		driver = new ChromeDriver();
		
		driver.get("https://www.saucedemo.com/");
		
		String username = "problem_user";
		String password = "secret_sauce";
		WebDriverWait wait;
		wait = new WebDriverWait(driver, 30);
		
		UsefulMethods.loginMethod(username, password, driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		
		//items to add to cart
		  WebElement backpackButton = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
		  WebElement onesieButton = driver.findElement(By.id("add-to-cart-sauce-labs-onesie"));
		  WebElement cartBadgeButton = driver.findElement(By.xpath("//div[@class='shopping_cart_badge'"));
		  
		  //Wait for items to be clickable
		  wait.until(ExpectedConditions.elementToBeClickable(onsieButton));
		  wait.until(ExpectedConditions.elementToBeClickable(backpackButton));
		  
		  //Add two items to cart
		  onesieButton.click();
		  backpackButton.click();
		  
		  //Find the cart badge (number of items in cart)
		  String cartItemNum = cartBadgeButton.getText();
		
		
		try { 
		      Assert.assertEquals(cartItemNum, "2", "Test Unsuccessful: Items we're not added to cart correctly");
		      System.out.println(cartItemNum + " items successfully added to cart");
		      }
		catch(AssertionError e) {
		      Reporter.log(e.toString());
		      System.out.println("Test failed. See report for details");
		      Assert.fail();
		      }
		driver.close();
		
	}
}
