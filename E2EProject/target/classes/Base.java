package Resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;


public class Base {
	
	// we have open a class which will create broiwser object for all other class/test cases
	
		public static WebDriver driver;
		public Properties prop;
		
		public WebDriver initializeDriver () throws IOException {
		prop = new Properties();// this file will read from the fileinputstream class connections
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties"); 
		
		prop.load(fis);// we passed the file to properties for reading
		
		//for selecting browser we will not use property class and data.properties file anymore 		
		//String browserName=prop.getProperty("browser");//from the file it will look for the value of browser
		
		
		// from now on we will select browser form jenkins (we can select that from cmd too through mvn)
		// use the following get property to select browser
		String browserName=System.getProperty("browser");// it will select browser from jenkins
		
		
		if (browserName.contains("chrome")) {// we had to use .contains so it will check only partial text from chromeheadless from data.properties
			System.setProperty("webdriver.chorme.driver", "C:\\Users\\Taufik\\Documents\\Selenium-RahulShetty\\API\\2.Chromedriver\\chromedriver.exe");
			
			ChromeOptions options = new ChromeOptions();// this class adds feature to chrome driver. here it is enabling chrome driver to run in headless mode. 
			
			if (browserName.contains("headless")) {// we are adding this if clause to instruct if the chosen chrome browser is written as "chromeheadless" in data.properties so it executes in headless mode.
			options.addArguments("--headless"); //with this method of chrome options we are adding feature of headless mode
			}
			driver = new ChromeDriver(options);			
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
