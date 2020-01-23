package com.utilities;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot {
	
	public static void captureScreenshot(WebDriver driver,String screenShotName)
	{
	
	try {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(source, new File("./screenshots/"+screenShotName+".png"));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		
	System.out.println("Exception while taking screenshot" +e.getMessage());
	}
	
	
	}

}
