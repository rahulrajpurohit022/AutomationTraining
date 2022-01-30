package Assesment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseClass {

	public static WebDriver driver;

	@BeforeMethod
	public void Login() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");

		WebElement UserName = driver.findElement(By.name("user-name"));
		WebElement Password = driver.findElement(By.name("password"));
		WebElement LoginButton = driver.findElement(By.name("login-button"));

		UserName.sendKeys("standard_user");
		Password.sendKeys("secret_sauce");
		LoginButton.click();
	}
	
	@AfterMethod
	public void Checkout() {
		
		driver.findElement(By.id("checkout")).click();
		driver.findElement(By.name("firstName")).sendKeys("Tom");
		driver.findElement(By.name("lastName")).sendKeys("Gill");
		driver.findElement(By.name("postalCode")).sendKeys("302015");	
		driver.findElement(By.xpath("//input[@name = \"continue\"]")).click();
		driver.findElement(By.xpath("//button[@name = \"finish\"]")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//span[@class = \"title\"]")).getText().equals("CHECKOUT: COMPLETE!"));
		
		driver.quit();
		

}

}
