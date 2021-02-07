package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(className="login")
	private WebElement signIn;
	
	public HomePage(WebDriver driver) {
		
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}
	
	
	public void launchApplication(String url) {
		driver.get(url);
		wait.until(ExpectedConditions.visibilityOf(signIn));
	}
	
	public void goToSignInPage() {
		signIn.click();
	}

}
