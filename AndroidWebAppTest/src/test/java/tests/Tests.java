package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Tests extends BaseClass {
	
	static String expectedTitleebay ="Electronics, Cars, Fashion, Collectibles & More | eBay";
	static String expectedTitledaraz ="Online Shopping Sri Lanka: Clothes, Electronics & Phones | Daraz.lk";
	
	@Test
	public void test1() throws InterruptedException {
		
		driver.get("https://www.ebay.com");
		
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitleebay);
		System.out.println("Title is correct");
		Thread.sleep(2000);
		
		driver.findElement(By.id("gh-ac")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("gh-ac")).sendKeys("mobiles");
		Thread.sleep(2000);
		driver.findElement(By.id("gh-f")).sendKeys(Keys.RETURN);
		
	//	driver.findElement(By.name("q")).sendKeys("appium");
	//	driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		
		System.out.println("Completed Test1");
	}

}
