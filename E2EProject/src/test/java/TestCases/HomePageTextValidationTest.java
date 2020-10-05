package TestCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObjects.HomePageObjects;
import Resources.Base;
import Resources.testUtil;

public class HomePageTextValidationTest extends Base{
	
	public static Logger log = LogManager.getLogger(Base.class.getName());

	
	@BeforeClass
	public void InitiateDriverAndSite() throws IOException {
		
		driver =initializeDriver();
		log.info("Browser strated successfully");
		log.error("Browser could not be started");
		
		driver.get(prop.getProperty("url"));
		log.info("site intiatated");
		log.error("Site could not be found");
		
	}	
	
	
	@Test
	public void basePageNavigation() throws IOException {
		
				
		// we are creating an object of LoginPageObject to avail it's methods
	
		HomePageObjects hp = new HomePageObjects(driver);
		
		hp.winClose().click();// we are closing the pop up window with the method that we created in HomePageObject class 
		log.info("Pop up window is closed");
	
	
		Assert.assertEquals(hp.title().getText(), prop.getProperty("text"));//you are getting the text(FEATURED COURSES) with the web element and comparing it with actual text which we have stored in data.properties file in key text.. 
		log.info("The title matched with the expected result");
		log.error("Title did not match with expected result");	
		
			}
	
	@AfterClass
	public void browserClose() {
		
		driver.close();
	}

}
