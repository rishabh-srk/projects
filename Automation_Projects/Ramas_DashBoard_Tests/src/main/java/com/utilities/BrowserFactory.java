package com.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
	
	public static WebDriver startBrowser(WebDriver driver,String browserName)
	{
	    if (browserName
	            .equalsIgnoreCase("Chrome")) {
	        System.setProperty("webdriver.chrome.driver", PropertyUtil.getPropertyKey("chromePath"));
	        driver=new ChromeDriver(); 
	    } else if (browserName
	            .equalsIgnoreCase("Firefox")) {
	    	System.setProperty("webdriver.gecko.driver", PropertyUtil.getPropertyKey("fireFoxPath"));
			driver = new FirefoxDriver();
	    } else if (browserName
	            .equalsIgnoreCase("Edge")) {
	    	System.setProperty("webdriver.ie.driver", PropertyUtil.getPropertyKey("edgePath"));
			driver = new InternetExplorerDriver();
	    } else {
	        System.out.println("Broweser name not mentioned properly");
	        System.exit(0);
	    }
	           driver.manage().window().maximize();
	
	return driver;
	}

}
