package Assesment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class FirstAssignment extends BaseClass{
	

	
	@Test
	public void FirstScenario() {

		driver.findElement(By.id("item_4_title_link")).click();
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		driver.findElement(By.id("shopping_cart_container")).click();
		
	}
	
	@Test
	public void SecondScenario() {

		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		driver.findElement(By.id("shopping_cart_container")).click();		
	}
	
	@Test
	public void ThirdScenario() {
		Select dropdown = new Select(driver.findElement(By.xpath("//select[@class = 'product_sort_container']")));
		dropdown.selectByVisibleText("Name (A to Z)");
		driver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)")).click();
		driver.findElement(By.id("shopping_cart_container")).click();	
	}
	

}
