package org.mm;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UserRegister {
  
	//Create a variable 
		public WebDriver driver;

		@Test
		public void userRegisterTest() throws InterruptedException {
			Thread.sleep(1000);
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			Thread.sleep(1000);
			driver.get("https://demo.guru99.com/test/newtours/");
			Thread.sleep(1000);

			// This will print our title of the page
			System.out.println("Validate that the page title is: "+driver.getTitle()); 
			// This will validate the page
			Assert.assertEquals(driver.getTitle(), "Welcome: Mercury Tours");


			driver.findElement(By.linkText("REGISTER")).click();
			driver.findElement(By.name("firstName")).sendKeys("Abeda");
			driver.findElement(By.name("lastName")).sendKeys("Rahman");
			driver.findElement(By.name("phone")).sendKeys("703-544-5689");
			driver.findElement(By.name("userName")).sendKeys("abeda2@gamil.com");
			driver.findElement(By.name("address1")).sendKeys("511 main st");
			driver.findElement(By.name("city")).sendKeys("Woodbridge");

			driver.findElement(By.name("state")).sendKeys("VA");
			driver.findElement(By.name("postalCode")).sendKeys("22193");




			Select country = new Select (driver.findElement(By.name("country")));
			country.selectByVisibleText("ALBANIA");




			driver.findElement(By.name("email")).sendKeys("Abeda2");
			driver.findElement(By.name("password")).sendKeys("Pass123");
			driver.findElement(By.name("confirmPassword")).sendKeys("Pass123");

			// Will do explicit wait statement




			driver.findElement(By.name("submit")).click();

			WebElement registerConfirmationMessage = driver.findElement(By.xpath("//*[contains(text(),'Note: Your user name is Abeda2.')]"));
			Assert.assertTrue(registerConfirmationMessage.isDisplayed(), "registerConfirmationMessage web element is not displayed");

			// This will print our title of the page
			System.out.println("Validate that the confirmation message of the Register page is: "+registerConfirmationMessage.getText()); 







  }
}
