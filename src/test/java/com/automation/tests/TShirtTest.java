package com.automation.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.automation.browser.BrowserUtils;
import com.automation.pages.HomePage;
import com.automation.pages.SignInPage;
import com.automation.pages.TShirtProductConfig;

public class TShirtTest {
	
	public WebDriver driver;
	public HomePage hpage;
	public SignInPage spage;
	public TShirtProductConfig tshirtpage;
	public int noOfQuantity = 3;
	
	@BeforeTest
	public void setUp() {
		driver = BrowserUtils.getBrowser("CHROME");
		driver.manage().window().maximize();
		hpage = new HomePage(driver);
		spage = new SignInPage(driver);
		tshirtpage = new TShirtProductConfig(driver);
	}
	
	@Test
	public void tshirtProductTest() {
				
		hpage.launchApplication("http://automationpractice.com/index.php");
		hpage.goToSignInPage();
		spage.loginApp("jetblue@grr.la", "jetblue");
		tshirtpage.goToTShirtTab();
		tshirtpage.addProductToCart("Faded Short Sleeve T-shirts");
		Assert.assertEquals(tshirtpage.getCartConfirmation().getText(), "Product successfully added to your shopping cart");
		tshirtpage.proceedToCheckOut();
		
		String productDesc="Faded Short Sleeve T-shirts\n" +
				"SKU : demo_1\n" + 
				"Color : Orange, Size : S";
		
		Assert.assertEquals(tshirtpage.getProductDesc().getText(), productDesc);
		
		tshirtpage.increaseQuantityTo(noOfQuantity);
		Assert.assertEquals(tshirtpage.getTotalPrice().getText(), "$"+((noOfQuantity*16.51) + 2));
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
