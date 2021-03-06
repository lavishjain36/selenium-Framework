package resources;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
	
   public WebDriver driver;
   public Properties prop;
	public WebDriver initializerDriver() throws IOException
	{
		 prop=new Properties();
		//connect dot.propeties file link here 
		FileInputStream fis=new FileInputStream("E:\\Selenium4\\E2EProject\\src\\main\\java\\resources\\data.properties");
	
				
	prop.load(fis);
	String browserName=prop.getProperty("browser");
	System.out.println(browserName);
	
	
	if(browserName.equals("chrome")) {

		System.setProperty("webdriver.chrome.driver", "C://work/chromedriver.exe");
		
		//create driver object  only once 
		 driver = new ChromeDriver();

		//WebDriver driver = new ChromeDriver();
	}
	
	else if(browserName.equals("firefox")) {
		
		System.setProperty("webdriver.gecko.driver", "C://work/geckodriver.exe");
		 driver = new FirefoxDriver();
	}
	
	else if(browserName.equals("IE")) {

		System.setProperty("webdriver.ie.driver", "C://work/IEDriverServer.exe");
		 driver = new InternetExplorerDriver();
	}
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	return driver;
	}
	
	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException {
		TakesScreenshot ts= (TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destinationFile=System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
	     FileUtils.copyFile(source, new File(destinationFile));
	     return destinationFile;
	
	}
	
}
