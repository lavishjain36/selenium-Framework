package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.Base;

public class validateTitle extends Base{
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializerDriver();
		log.info("Driver is initialized");
		
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Homepage");

		
	}
	
	
	//it goes to dataprovider=getdata and bring the data
   
	@Test
	public void basePageNavigation() throws IOException {
	
	
		//one is inheritance
		//creating Object to that class & invoke methods of it
		LandingPage l=new LandingPage(driver);
	
		//compare the text from browser with actual text
		Assert.assertEquals(l.getTitle().getText(), "FEATURED123 COURSES");
		log.info("Successfully validated Text Message");

	
	}
	

	@AfterTest
	public void teardown() {
		driver.close();
	}
	


}
