package junitrecap;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class myJunitRecap {

	@Test//anotation to make the method a test case
	public void verifyCrurrentOfferLabel() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver(); //driver have a reference in the memory == not null
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
        Thread.sleep(5000);
        driver.quit();
	}

}
