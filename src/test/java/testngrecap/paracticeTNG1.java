package testngrecap;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class paracticeTNG1 extends BaseTest{
	
	
	/**
	 * Search for Iphone 11
	 * click on buy it Now to filter the result
	 * pick the third result from the list
	 * verify the price is equal to $639
	 * @throws InterruptedException 
	 * 
	 */
	
	@Test
	public void checkIphonePrice() throws InterruptedException {
		String expectedPrice = "509.00";
		
		driver.get("https://www.ebay.com/");
		driver.findElement(By.xpath("//input[@name='_nkw']")).sendKeys("Iphone 11");
		driver.findElement(By.xpath("//input[@type='submit' and @class='btn btn-prim gh-spr']")).click();
		driver.findElement(By.xpath("//h2[contains(text(),'Buy It Now')]")).click();
		driver.findElement(By.xpath("//ul[@class='srp-results srp-list clearfix']/li[3]/div[1]/div[1]")).click();
		String iphonePrice = driver.findElement(By.xpath("//span[contains(text(),'US $')]")).getText();
		System.out.println(iphonePrice);
		
		String[] dollarPrice = iphonePrice.split(" ");
		System.out.println("---------------");
		System.out.println(dollarPrice[0]);
		String actualPrice = dollarPrice[1].substring(1, dollarPrice[1].length());
		//Assert.assertEquals(actualPrice, expectedPrice);//hard assert 
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actualPrice, expectedPrice);
		soft.assertAll();
		
		
	}
	
	
	
	

}
