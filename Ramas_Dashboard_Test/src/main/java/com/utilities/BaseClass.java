package com.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public WebDriver driver;

	@BeforeMethod
	@Parameters("browser")
	public void setUp(String browserName) {

		// initialize browser and open application

		long threadId = Thread.currentThread().getId();
		System.out.println(threadId);

		driver = BrowserFactory.startBrowser(driver, browserName);
		
		

		driver.get(PropertyUtil.getPropertyKey("test_Url_Unstable"));

	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
			Screenshot.captureScreenshot(driver, result.getName());
			System.out.println("screenshot for failure test::"+result.getName());
		

		}

		long threadId = Thread.currentThread().getId();
		System.out.println(threadId);

		driver.quit();

	}

}
