package com.tests;

import java.net.MalformedURLException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.pages.LoginPage;
import com.utilities.BaseClass;

import com.utilities.WebEvents;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class LoginTest extends BaseClass {

	SoftAssert assertion = new SoftAssert();

	@Test(description = "verify login with valid credentials", priority = 1)
	@Severity(SeverityLevel.BLOCKER)
	@Description("verify login with valid credentials")

	public void test_Login_Valid_Credentials() throws MalformedURLException {

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
	@Severity(SeverityLevel.NORMAL)
	@Description("verify login with valid credentials")

	public void test_errorSnackBar_inValid_Credentials() {

		LoginPage loginObject = new LoginPage(driver);

	

		WebEvents.waitHere(6);

		loginObject.enter_UserName("abc");
		WebEvents.waitHere(6);

		// enter invalid password

		loginObject.enter_Password("123");
		WebEvents.waitHere(6);

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
