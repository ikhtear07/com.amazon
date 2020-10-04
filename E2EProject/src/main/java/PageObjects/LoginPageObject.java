package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObject {
	
	WebDriver driver; // you need declare the webdriver globally and receive the return variable of the constructor 
	
	//this is the constructor to initiate the driver in test case class 
	public LoginPageObject (WebDriver driver) {
		
		this.driver=driver;		
	}
	
	private By username=By.id("user_email");// this is the locator of username text box
	
	private By password=By.id("user_password");// this is the locator of password text box
	
	private By login=By.name("commit"); // this is the locator of login button box
	
	
	public WebElement typeUsername() {// this is the web element of usename text box
		
		return driver.findElement(username);
	}
	
	public WebElement typePassword() {// this is the web element of password text box
		
		return driver.findElement(password);
	}
	
	public WebElement logIn() {// this is the web element of login button
		
		return driver.findElement(login);
	}
}
