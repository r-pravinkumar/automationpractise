package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private long timeout = 30;
	
	@FindBy(css="input[id=email]")
	private WebElement emailIDTxt;
	
	@FindBy(css="input[id=passwd]")
	private WebElement passwordTxt;
	
	@FindBy(css="button[id=SubmitLogin]")
	private WebElement signInbtn;
	
	public SignInPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, timeout);
		PageFactory.initElements(driver, this);
	}
	
	public void loginApp(String username, String password) {
		emailIDTxt.sendKeys(username);
		passwordTxt.sendKeys(password);
		signInbtn.click();
		
	}
	
	

}
