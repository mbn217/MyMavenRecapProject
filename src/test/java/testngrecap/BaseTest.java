package testngrecap;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	ChromeDriver driver;
	
	
	
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	

	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
        driver.quit();
	}
	

	
	
	

}
