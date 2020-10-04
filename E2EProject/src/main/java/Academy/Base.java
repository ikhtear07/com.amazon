package Academy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
	
	// we have open a class which will create broiwser object for all other class/test cases
	
		WebDriver driver;
	
	public WebDriver initializeDriver () throws IOException {
		Properties prop = new Properties();// this file will read from the fileinputstream class connections
		FileInputStream fis = new FileInputStream("C:\\Users\\Taufik\\Documents\\Selenium-RahulShetty\\SeleniumRahulShettyJavaFiles\\E2EProject\\src\\main\\java\\Academy\\data.properties"); 
		prop.load(fis);// we passed the file to properties for reading
		String browserName=prop.getProperty("browser");//from the file it will look for the value of browser
		
		
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chorme.driver", "C:\\Users\\Taufik\\Documents\\Selenium-RahulShetty\\API\\2.Chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();			
		} else if (browserName.equalsIgnoreCase("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Taufik\\Documents\\Selenium-RahulShetty\\API\\3.Firefoxdriver\\geckodriver.exe");
			driver = new  FirefoxDriver();			
		} else if (browserName.equalsIgnoreCase("ie")) {
			
			 System.setProperty("webdriver.ie.driver", "C:\\Users\\Taufik\\Documents\\Selenium-RahulShetty\\API\\4.InternetExplorere\\IEDriverServer.exe");

			 driver = new  InternetExplorerDriver();
				
		}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		return driver;
	}
		
}
