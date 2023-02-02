package validate_neoStoxTestClass;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import neoStoxPOMClass.Utility;



   public class Listener extends Base implements ITestListener
{
	
	   
	    
	    public void onTestFailure(ITestResult result)
	 {
		   
		   try 
		{
			
			   Utility.takeScreenshot(driver, result.getName());
		} 
		   
		  catch (IOException e)
	    {
 			
			  e.printStackTrace();
		}
		   
	}
        
       public void onTestSuccess(ITestResult result) 
     {
    	   try 
   		{
   			Utility.takeScreenshot(driver, result.getName());
   		} 
   		   
   		  
    	   catch (IOException e)
   	    {
    			
   			  e.printStackTrace();
   		}
    	   
    	  Reporter.log("Test Case is ---> " +result.getName()+ "Pass", true); 
    	   
    	   
     }
	  // 1st commont add space in try block 
	   
}
