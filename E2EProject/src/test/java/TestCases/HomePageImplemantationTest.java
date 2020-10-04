package TestCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.HomePageObjects;
import PageObjects.LoginPageObject;
import Resources.Base;

public class HomePageImplemantationTest extends Base{
	
	public static Logger log = LogManager.getLogger(Base.class.getName());


	@BeforeMethod
	public void InitiateDriverAndSite() throws IOException {
		
		driver =initializeDriver();
		log.info("Browser strated successfully");
		log.error("Browser could not be started");
		
		driver.get(prop.getProperty("url"));
		log.info("site intiatated");
		log.error("Site could not be found");
		
	}
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String username, String password) throws IOException {
		
			
				
		// we are creating an object of LoginPageObject to avail it's methods
		HomePageObjects hp = new HomePageObjects(driver);// we are closing the pop up window with the method(winclose) that we created in HomePageObject class 
		
		hp.winClose().click();// we are closing the pop up window with the method that we created in HomePageObject class 
		log.info("Pop up window is closed");
		
		hp.getSignin().click();// then we are clicking on the signin link to go the login page
		
		// we are creating an object of LoginPageObject to avail it's methods
		LoginPageObject lp = new LoginPageObject(driver);
		lp.typeUsername().sendKeys(username);
		log.info("Username is typed successfully");
		
		lp.typePassword().sendKeys(password);
		log.info("Password is written successfully");
		
		lp.logIn().click();
		log.info("Log in button was clicked");
		log.error("Log in could not be clicked");
		
	}
	
	@DataProvider
	public Object[][] getData() {
		
		// by this method we will provide all the data to text boxes on the above method
		
		Object[][] data=new Object[2][2];// we have opened 2 rows and 2 columns. it denotes  the length of the array
		
		// below we are inserting data as per their index number
		data[0][0]= "Tomcruise@usa.com";
		data[0][1]="12345";
		
	 	data[1][0]="nicole@usa.com";
		data[1][1]="123456";
		
		return data;		
		
	}
	@AfterMethod
	public void browserClose() {
		
		driver.close();
	}

}
