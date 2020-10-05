package Academy;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.HomePageObjects;
import PageObjects.LoginPageObject;
import resources.Base;

public class HomePageImplemantation extends Base{
	
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String username, String password) throws IOException {
		
		driver =initializeDriver();
		driver.get("http://www.qaclickacademy.com/");
		
		// since there is pop up window we had to close it first
		
		String winid = driver.getWindowHandle();// first you have to get the new pop up windows id
		driver.switchTo().window(winid);// then you have to switch in to that window so you can close it
		driver.findElement(By.xpath("//div[@class='sumome-react-wysiwyg-move-handle']/div/div[2]")).click();// now you are closing the window by clicking the close button
		
		
		// we are creating an object of LoginPageObject to avail it's methods
		HomePageObjects hp = new HomePageObjects(driver);
		
		hp.getSignin().click();
		
		// we are creating an object of LoginPageObject to avail it's methods
		LoginPageObject lp = new LoginPageObject(driver);
		lp.typeUsername().sendKeys(username);
		lp.typePassword().sendKeys(password);;
		lp.logIn().click();
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

}
