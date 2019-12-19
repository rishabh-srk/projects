package com.functions;

import org.openqa.selenium.WebElement;

public class Validate {
	
	//function to verify element is displayed on webpage
	
	public static boolean element_Is_Displayed(WebElement e) {
		boolean b=e.isDisplayed();
		return b;
	
	}
	
	//function to verify text
	
	public static boolean  verify_Text(WebElement e,String message)
	{
		return e.getText().equals(message);
		
	}

}
