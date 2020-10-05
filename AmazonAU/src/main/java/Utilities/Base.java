package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class Base {
	
	public WebDriver driver;
	public static Properties prop;
	
	
	public static void initializeDriver() throws FileNotFoundException {
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("User.dir" + "\\src\\main\\java\\Utilities\\data.properties"));
		
		System.out.println(fis);
		
		
	}

	
	public static void main(String[] args) throws FileNotFoundException {
		
	String a = System.getProperty("user.dir" + "\\src\\main\\java\\Utilities\\data.properties");
	System.out.println(a);
	System.out.println(System.getProperty("user.dir" + "\\src\\main\\java\\Utilities\\data.properties"));
	}
	
}
