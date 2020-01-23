package com.tests;



import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import com.pages.LoginPage;
import com.utilities.BrowserFactory;
import com.utilities.BrowserFactoryGrid;
import com.utilities.PropertyUtil;
import com.utilities.WebEvents;



public class LoginTest  {
	
	
	WebDriver driver;
	
	SoftAssert assertion = new SoftAssert();
	
	
    
   
	
	
	@BeforeMethod
	@Parameters("browser")
	public void setUp(String browserName)  {
		
		
		
		
		
		
		
		
		

		// initialize browser and open application

		long threadId = Thread.currentThread().getId();
		System.out.println(threadId);

	driver=BrowserFactory.startBrowser(driver, browserName);
	driver.get(PropertyUtil.getPropertyKey("test_Url_Unstable"));

	}

	@AfterMethod
	public void tearDown() {
		
		
	    
	

		driver.quit();
		
	

	}

		

		@Test(description = "verify login with valid credentials", priority = 1)
		//@Severity(SeverityLevel.BLOCKER)
		//@Description("verify login with valid credentials")

		public void test_Login_Valid_Credentials()  {

			LoginPage loginObject = new LoginPage(driver);

			WebEvents.waitHere(6);

			

			// enter username

			loginObject.enter_UserName("mccainlightadmin");
			WebEvents.waitHere(6);

			// enter password

			loginObject.enter_Password("r3sson");
			WebEvents.waitHere(6);

			// click Login

			loginObject.click_Login();
			WebEvents.waitHere(4);

			// verify field overview is displayed

			assertion.assertTrue(loginObject.verify_FieldOverview_IsDisplayed());

			
			WebEvents.waitHere(5);

			long threadId = Thread.currentThread().getId();
			System.out.println(threadId);

			assertion.assertAll();
		}

		@Test(description = "verify error snack bar with invalid credentials", priority = 2)
		//@Severity(SeverityLevel.NORMAL)
		//@Description("verify login with valid credentials")

		public void test_errorSnackBar_inValid_Credentials() {

			LoginPage loginObject = new LoginPage(driver);

		

			WebEvents.waitHere(6);

			loginObject.enter_UserName("abc");
			

			// enter invalid password

			loginObject.enter_Password("123");
			

			// click Login

			loginObject.click_Login();
			WebEvents.waitHere(7);

			// verify error snack bar is displayed

			assertion.assertTrue(loginObject.verify_ErrorSnackBar_IsDisplayed());

			// verify error snack bar text

		
		assertion.assertTrue(loginObject.verify_errorSnackBar_Text("The username or password you entered is incorrect"));

			
			WebEvents.waitHere(5);

			long threadId = Thread.currentThread().getId();
			System.out.println(threadId);

			assertion.assertAll();

		}


}
