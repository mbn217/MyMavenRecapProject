package recap;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class seleniumBrokenLinksMain {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver(); //driver have a reference in the memory == not null
		

        
        //navigate to a url
        driver.manage().window().maximize();
        driver.get("https://automobiles.honda.com/tools/current-offers");
        driver.findElement(By.xpath("(//input[@class='change-zip-input'])[1]")).sendKeys("20716");
        driver.findElement(By.xpath("(//button[@class='change-zip-button'])[1]")).click();
        Thread.sleep(2000);
        
        //Test case is to verify that "Current Offers" label is displayed in the webpage after clcikin submit
        
        String expectedLabel = "Current Offers";
        
        String actualLabel = driver.findElement(By.xpath("//h2[contains(text(),'Current Offers') and @class='palette-2']")).getText();
        
        System.out.println(actualLabel);
        
        if (expectedLabel.equals(actualLabel)) {
			System.out.println("The label is displayed successfully");
		}else {
			System.out.println("The label is NOT displayed ...");

		}
        
        
        
     
        
        
        Thread.sleep(5000);
        driver.quit();
	}

}
