package com.utilities;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserFactoryGrid {
	
	public static DesiredCapabilities cap;
	public static String ip_Address=PropertyUtil.getPropertyKey("ipaddress");
	
	public static WebDriver startBrowser(WebDriver driver,String browserName) throws MalformedURLException
	{
	    if (browserName
	            .equalsIgnoreCase("Chrome")) {
	    	cap=new DesiredCapabilities();
	    	cap.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
	    	cap.setCapability(CapabilityType.PLATFORM_NAME, Platform.LINUX);
	    	driver=new RemoteWebDriver(new URL("http://"+ip_Address+":4444/wd/hub"),cap);
	         
	    } else if (browserName
	            .equalsIgnoreCase("Firefox")) {
	    	cap=new DesiredCapabilities();
	    	cap.setCapability(CapabilityType.BROWSER_NAME, BrowserType.FIREFOX);
	    	cap.setCapability(CapabilityType.PLATFORM_NAME, Platform.LINUX);
	    	driver=new RemoteWebDriver(new URL("http://"+ip_Address+":4444/wd/hub"),cap);
	    } else if (browserName
	            .equalsIgnoreCase("Edge")) {
	    	System.setProperty("webdriver.ie.driver", PropertyUtil.getPropertyKey("fireFoxPath"));
			driver = new InternetExplorerDriver();
	    } else {
	       
	        System.exit(0);
	    }
	           driver.manage().window().maximize();
	
	return driver;

	}

}
