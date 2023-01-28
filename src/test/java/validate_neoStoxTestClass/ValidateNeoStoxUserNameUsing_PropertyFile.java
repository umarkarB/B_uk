package validate_neoStoxTestClass;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import neoStoxPOMClass.NeoStoxDashBoardPage;
import neoStoxPOMClass.NeoStoxHomePage;
import neoStoxPOMClass.NeoStoxPasswordPage;
import neoStoxPOMClass.NeoStoxSignInPage;
import neoStoxPOMClass.Utility;
 

  @Listeners(validate_neoStoxTestClass.Listener.class)
   
public class ValidateNeoStoxUserNameUsing_PropertyFile extends Base
{
 
	NeoStoxHomePage home;
	NeoStoxSignInPage signIn;
	NeoStoxPasswordPage pass;
	NeoStoxDashBoardPage dash;
	//String sc ="TcId-1002";
	
	
    @BeforeClass
    public void launchNeoStoxApp() throws IOException
      {
		
    	launchBrowser();
		home   = new NeoStoxHomePage(driver);
		signIn = new NeoStoxSignInPage(driver);
		pass   = new NeoStoxPasswordPage(driver);
		dash   = new NeoStoxDashBoardPage(driver);
    	  
      }

    @BeforeMethod
    public void loginToNeoStox() throws EncryptedDocumentException, IOException, InterruptedException
    {
    	home. clickOnSignInButton();
    	Utility.implicitWait(1000, driver);
  
    	signIn.enterMobileNumber(Utility.readDataFromPropertyFile("Mobile"));
    	Thread.sleep(1000);
        signIn.clickOnSignInButton();
        
        Utility.implicitWait(1000, driver);
    	pass.enterPassword(Utility.readDataFromPropertyFile("password"));
        pass.clickOnSubmitButton();
        
        Utility.implicitWait(1000, driver);
        dash.handlePopUp(driver);
      }

 
    @Test 
    public void validateUserName() throws EncryptedDocumentException, IOException, InterruptedException
    {
  
    	
    	//Assert.fail();

    	Assert.assertEquals(dash.getActualUserName(),Utility.readDataFromPropertyFile("userName"),"Actual and Expected user name are  not matching TC is failed"  ); 
       
       //Assert.assertEquals(false, false);
    	
    	//Utility.implicitWait(1000, driver);
    	//Utility.takeScreenshot(driver, Utility.readDataFromPropertyFile("TCID"));
    	//Thread.sleep(1000);
    }
    
    
      @Test
      public void validateACBalance()
    {
    	
    	Assert.assertNotNull(dash.getAcBalance(),"AC balance is null Tc fail" );
    	
    }
    
    
      @AfterMethod
      public void logOutFromNeoStox() throws InterruptedException 
    {
    	
    	  dash.logOutFromNeoStox();
    
    }

      @AfterClass
      public void closeNeoStoxApp() throws InterruptedException 
    {
    	 driver.close();
    	 Reporter.log("closing neoStox appliction", true);
    	 Thread.sleep(1000);
     
    }

}
