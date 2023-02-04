package org.mm;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class FlightBooking {
	//Create a variable 
	public WebDriver driver;
	//public Webdriver BaseUrl; 


	@BeforeClass
	public void setUp() {

		try {


			//Thread.sleep(1000);
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			//Thread.sleep(1000);
			driver.get("https://demo.guru99.com/test/newtours/");
			//Thread.sleep(1000);

			// This will print our title of the page
			System.out.println("Validate that the page title is: "+driver.getTitle()); 
			// This will validate the page
			Assert.assertEquals(driver.getTitle(), "Welcome: Mercury Tours");

		}catch(Exception e) {

		}
	}

	@Test(priority = 1)
	public void UserRegisterTest() {
		try {


			WebElement userRegisterLink =driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[2]/a"));
			userRegisterLink.click();
			//WebElements for Register Page
			WebElement userFirstName=driver.findElement(By.name("firstName"));
			WebElement userLastName= driver.findElement(By.name("lastName"));
			WebElement userPhone=driver.findElement(By.name("phone"));
			WebElement userEmail=driver.findElement(By.name("userName"));
			WebElement userAddress=driver.findElement(By.name("address1"));
			WebElement userCity=driver.findElement(By.name("city"));
			WebElement userState=driver.findElement(By.name("state"));
			WebElement userPostalCode=driver.findElement(By.name("postalCode"));
			WebElement useruserName=driver.findElement(By.name("email"));
			WebElement userPassword=driver.findElement(By.name("password"));
			WebElement userConfirmPassword=driver.findElement(By.name("confirmPassword"));




			userFirstName.sendKeys("Israt");
			userLastName.sendKeys("Jahan");
			userPhone.sendKeys("333-4444-15555");
			userEmail.sendKeys("israt2@gamil.com");
			userAddress.sendKeys("511 main st");
			userCity.sendKeys("Woodbridge");

			userState.sendKeys("NC");
			userPostalCode.sendKeys("22193");

			Select country = new Select (driver.findElement(By.name("country")));
			country.selectByVisibleText("ALBANIA");

			useruserName.sendKeys("Israt2");
			userPassword.sendKeys("Pass123");
			userConfirmPassword.sendKeys("Pass123");

			// Will do explicit wait statement


			driver.findElement(By.name("submit")).click();

			WebElement registerConfirmationMessage = driver.findElement(By.xpath("//*[contains(text(),'Note: Your user name is Israt2.')]"));
			Assert.assertTrue(registerConfirmationMessage.isDisplayed(), "registerConfirmationMessage web element is not displayed");

			//This will print our title of the page
			System.out.println("Validate that the confirmation message of the Register page is: "+registerConfirmationMessage.getText()); 

		}catch(Exception e)
		{
			
		}


	}


	@AfterClass
	public void CloseBrowser() {

		try {
			driver.quit();

		}catch(Exception e) {

		}
	}
}



