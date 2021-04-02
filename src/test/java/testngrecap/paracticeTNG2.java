package testngrecap;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class paracticeTNG2 extends BaseTest{

	@Test
	public void clickOnSell() throws InterruptedException {
		String expectedLabel = "The basics";
		driver.get("https://www.ebay.com/");
		Thread.sleep(1000);
		driver.findElement(By.linkText("Sell")).click();
		String actualLabel = driver.findElement(By.xpath("//h2[contains(text(),'The basics')]")).getText();
		Assert.assertEquals(actualLabel, expectedLabel);
        
        
	}
	
}
