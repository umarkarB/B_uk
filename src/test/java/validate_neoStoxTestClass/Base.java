package validate_neoStoxTestClass;

 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import neoStoxPOMClass.Utility;

public class Base
{
	
    protected static WebDriver driver;
	
	public void launchBrowser()
	{
		 
		
    
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");

		//created object of chromedriver
	    driver= new ChromeDriver();
	    
		driver.manage().window().maximize();
		
	    driver.get("https://neostox.com/");
		 
	    //driver.get(Utility.readDataFromPropertyFile("URL"));
		
		
		Utility.implicitWait(1000, driver);
		
		Reporter.log("lounching neoStox Application / browser ", true);
	}

}
