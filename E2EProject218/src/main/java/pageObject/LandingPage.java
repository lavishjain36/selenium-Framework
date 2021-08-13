package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	By signin= By.cssSelector("a[href*='sign_in']");
	By title=By.xpath("//h2[contains(text(),'Featured Courses')]");
	By NavBar=By.cssSelector(".nav");
	
	//we need to assign  alife to it by calling chrome driver here.
	
	
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	//pull the locator and feed into the method getLogin
	public WebElement getLogin( )
	{
		return	 driver.findElement(signin);	 
		 
	}
	
	public WebElement getNavigationBar( )
	{
		return	 driver.findElement(NavBar);	 
		 
	}
	public WebElement getTitle( )
	{
		return	 driver.findElement(title);	 
		 
	}
}
