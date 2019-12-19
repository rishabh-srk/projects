package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.functions.Validate;

import io.qameta.allure.Step;

public class LoginPage {
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='username']")
	private WebElement userName;
	

	@FindBy(how = How.ID, using = "password")
	private WebElement password;

	@FindBy(how = How.XPATH, using = "//span[text()='LOG IN']")
	private WebElement login;
	
	@FindBy(how = How.XPATH, using = "//h5[text()='Fields Overview']")
	private WebElement fields_Overview;
	
	@FindBy(how = How.ID, using = "message-id")
	private WebElement error_SnackBar;

	
	@Step("enter username in the usename field : {0}")
	public void enter_UserName(String username) {
		userName.sendKeys(username);
	}

	@Step("enter password in the password field: {0}")
	public void enter_Password(String passwrd) {
		password.sendKeys(passwrd);
	}

	@Step("click login")
	public void click_Login() {
		login.click();
		
	}

	@Step(" Verify Field overview is displayed")
	public boolean verify_FieldOverview_IsDisplayed() {
		
		boolean b=fields_Overview.isDisplayed();
		return b;
		
		
	}
	
	@Step(" Verify Error snack bar is displayed")
	public boolean verify_ErrorSnackBar_IsDisplayed()
	{
		return error_SnackBar.isDisplayed();
	}
	
	
	@Step("Error snack bar text is verified")
    public boolean verify_errorSnackBar_Text(String errorMessage) {
		
		return Validate.verify_Text(error_SnackBar, errorMessage);
		
		
	}
	

}
