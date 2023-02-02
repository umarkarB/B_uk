package neoStoxPOMClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
 import java.time.Duration;
import java.util.Properties;
import java.util.Random;

 import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

import net.bytebuddy.utility.RandomString;

public class Utility
  {
	
	 //excel
	 //wait
	 //screenShot
	 //scrolIntoView
	// read data from property File
	   
	
	   
	public static String readDataFromPropertyFile(String key ) throws IOException
	   {
	   //1. creating an object of Properties file
	
	        Properties prop = new Properties();
	   
	   // 2. create obje of fileinputstrem
	   
		
	        FileInputStream myFile= new FileInputStream("C:\\Users\\bhagw\\eclipse-workspace\\Stocks\\myProperty.properties");
			
	  // 3. load file
			
			
	        prop.load(myFile);
	   
	  // 4. read data from file
			
			String value = prop.getProperty(key);
			
			Reporter.log("Read Data from Properties file ", true);
			Reporter.log(value, true);
			
			return value;
	   }
	
	   public static String readDataFromExcel(int row, int cell) throws EncryptedDocumentException, IOException
	 {
	
		   File myFile=new File("D:\\WorkBookXl.xlsx");
		   Sheet mySheet = WorkbookFactory.create(myFile).getSheet("Sheet4");
		   String value = mySheet.getRow(row).getCell(cell).getStringCellValue();

		   Reporter.log("Reading Data from excel Row is --> "+row+" Cell is -->" +cell, true);
		   Reporter.log("Data  is "+ value, true);
	
		   return value;
		    
	}
	   
	   public static void implicitWait(int time,WebDriver driver)
	   {
		  
		   driver.manage().timeouts().implicitlyWait(Duration.ofMillis(time));
		   
           Reporter.log("Waiting for "+ time + "ms", true);
	   }
	   
	   
	 
	   public static void takeScreenshot(WebDriver driver,String myFile) throws IOException
	   {
		     String sr= RandomString.make(2);
		    
		     File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
			 File dest=new File("E:\\New folder\\newscreen\\ScreenShot\\"+  myFile+sr+ ".png");

			 FileHandler.copy(src, dest);
			 
			 Reporter.log("taking ScreenShot ", true);
			 
			 Reporter.log("screen shot taken and saved at --->" + dest, true);
	   }
	   
	   public static void scrollIntoView(WebDriver driver,WebElement element)
	   {
		   
		   JavascriptExecutor js = (JavascriptExecutor)driver;
		   
		   js.executeScript("arguments[0].scrollIntoView(true)", element);
		   
		   Reporter.log("Scrooling into view --> "+element.getText(), true);
		   
	   }

	
	

}
