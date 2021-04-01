package junitrecap;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class myJunitRecap2 {
	ChromeDriver driver;
	
	@Before
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); //driver have a reference in the memory == not null
        driver.manage().window().maximize();
        driver.get("https://automobiles.honda.com/tools/current-offers");
	}
	@After
	public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
	}
	
	
	@Test//anotation to make the method a test case
	public void verifyCrurrentOfferLabel() throws InterruptedException {	
        driver.findElement(By.xpath("(//input[@class='change-zip-input'])[1]")).sendKeys("20716");
        driver.findElement(By.xpath("(//button[@class='change-zip-button'])[1]")).click();
        Thread.sleep(2000);   
        //Test case is to verify that "Current Offers" label is displayed in the webpage after clcikin submit
        String expectedLabel = "Current Offers";       
        String actualLabel = driver.findElement(By.xpath("//h2[contains(text(),'Current Offers') and @class='palette-2']")).getText();       
        System.out.println(actualLabel);
        //hard assertion because if the assertion fails then the code will stop running and exits
        Assert.assertEquals(expectedLabel, actualLabel);
		
	}
	
	@Test//anotation to make the method a test case
	public void verifyCrurrentOfferLabel2() throws InterruptedException {
		String zipCodeToEnter = "20716";
        //navigate to a url
        driver.manage().window().maximize();
        driver.get("https://automobiles.honda.com/tools/current-offers");
        driver.findElement(By.xpath("(//input[@class='change-zip-input'])[1]")).sendKeys(zipCodeToEnter);
        driver.findElement(By.xpath("(//button[@class='change-zip-button'])[1]")).click();
        Thread.sleep(2000);
        String actualZipCodeEntered = driver.findElement(By.xpath("//input[@name='newZipcode']")).getAttribute("value");
        System.out.println(actualZipCodeEntered);
        Assert.assertEquals(zipCodeToEnter, actualZipCodeEntered);

	}
	
	

}
