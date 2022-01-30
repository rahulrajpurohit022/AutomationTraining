package Assesment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Locaters {
	
	
	
//	@FindBy(id = "user-name")
//	WebElement UserName;
//	
//	@FindBy(name = "password")
//	WebElement Password;
//	
//	@FindBy(name = "login-button")
//	WebElement LoginButton;
	
	WebDriver driver;

@BeforeTest
	public void Login() {
	System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
	driver = new ChromeDriver();
	//Locaters login=PageFactory.initElements(driver, Locaters.class);
	
	
	driver.get("https://www.saucedemo.com/");
	driver.manage().window().maximize();
	
	WebElement UserName = driver.findElement(By.name("user-name"));
	WebElement Password = driver.findElement(By.name("password"));
	WebElement LoginButton = driver.findElement(By.name("login-button"));
	

	UserName.sendKeys("standard_user");
	Password.sendKeys("secret_sauce");
	LoginButton.click();
}	
	
	public void FirstScenario() {
		WebElement Item = driver.findElement(By.xpath("//div[text() = 'Sauce Labs Backpack']"));
		Item.click();
		WebElement AddToCart = driver.findElement(By.xpath("//button[@class = \"btn btn_primary btn_small btn_inventory\"]"));
		AddToCart.click();
		WebElement Cart = driver.findElement(By.xpath("//span[@class=\"shopping_cart_badge\"]"));
		Cart.click();
	}
	
	
	public void SecondtScenario() {
		WebElement AddCart = driver.findElement(By.xpath("//button[@id = \"add-to-cart-sauce-labs-backpack\"]"));
		AddCart.click();
		WebElement Cart = driver.findElement(By.xpath("//span[@class=\"shopping_cart_badge\"]"));
		Cart.click();
	}
	
	@Test
	public void ThirdScenario() {
		WebElement Sort = driver.findElement(By.xpath("//select[@class = 'product_sort_container']"));
		Select sel = new Select(Sort);
		sel.selectByVisibleText("Name (A to Z)");
		WebElement AddCart = driver.findElement(By.xpath("//button[@id = \"add-to-cart-sauce-labs-backpack\"]"));
		AddCart.click();
		WebElement Cart = driver.findElement(By.xpath("//span[@class=\"shopping_cart_badge\"]"));
		Cart.click();
	}
	
	
	
	@AfterTest
	public void Checkout() {
	WebElement Checkout = driver.findElement(By.xpath("//button[@name = \"checkout\"]"));
	Checkout.click();
	WebElement FirstName = driver.findElement(By.name("firstName"));
	WebElement LastName = driver.findElement(By.name("lastName"));
	WebElement PostCode = driver.findElement(By.name("postalCode"));
	FirstName.sendKeys("Tom");
	LastName.sendKeys("Gill");
	PostCode.sendKeys("302015");
	WebElement Continue = driver.findElement(By.xpath("//input[@name = \"continue\"]"));
	Continue.click();
	//WebElement VerifyItem = driver.findElement(By.xpath("//div[text() = 'Sauce Labs Backpack']"));
	WebElement Finish = driver.findElement(By.xpath("//button[@name = \"finish\"]"));
	Finish.click();
	WebElement ConfirmationMsg = driver.findElement(By.xpath("//span[@class = \"title\"]"));
	Assert.assertTrue(ConfirmationMsg.getText().equals("CHECKOUT: COMPLETE!"));
	System.out.println(ConfirmationMsg.getText());
	driver.quit();
	
}	
	
}
