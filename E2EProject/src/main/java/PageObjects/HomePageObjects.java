package PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageObjects {
	
	WebDriver driver;	// you need declare the webdriver globally and receive the return variable of the constructor 

	
	//this is the constructor to initiate the driver in test case class 
	public HomePageObjects(WebDriver driver) {
		
		this.driver=driver;
	}
	
		private By signin=By.xpath("//nav[@class='pull-right']/ul/li[4]/a");// this is the locator of login link in homepage
		
		private By title=By.className("text-center");// this is the locator of the text "FEATURED COURSES"
		
		private By navbar=By.xpath("//ul[@class='nav navbar-nav navbar-right']");// this is the locator of the entire navigation bar
		
		
		public WebElement getSignin() {// this is the web element of login link in homepage
			
			return driver.findElement(signin);
		}
	
		public WebElement title() {// this is the web element of the text "FEATURED COURSES"
			
			return driver.findElement(title);
		}
		
		public WebElement navBar() {
			
			return driver.findElement(By.xpath("//ul[@class='nav navbar-nav navbar-right']"));
		}
		
		
		//since the pop up window comes every time with this method we close the pop window every time we access the page.
				public WebElement winClose() {
				
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


				String winid = driver.getWindowHandle();// first you have to get the new pop up windows id
				driver.switchTo().window(winid);// then you have to switch in to that window so you can close it
				 return driver.findElement(By.xpath("//div[@class='sumome-react-wysiwyg-move-handle']/div/div[2]"));// now you are closing the window by clicking the close button
			}
    
}
