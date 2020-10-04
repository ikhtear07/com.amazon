package Academy;

import java.io.IOException;

import org.testng.annotations.Test;

public class HomePage extends Base{
	
	
	@Test
	public void basePageNavigation() throws IOException {
		
		driver =initializeDriver();
		driver.get("http://www.qaclickacademy.com/");
		
	}

}
