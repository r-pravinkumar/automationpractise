package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TShirtProductConfig {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(xpath="//div[@id='block_top_menu']/ul/li[3]/a")
	private WebElement tshirtTab;
	
	@FindBy(css="button[name=Submit]")
	private WebElement addtoCartBtn;
	
	@FindBy(xpath="//a[@title='Proceed to checkout']")
	private WebElement proceedCheckoutBtn;
	
	@FindBy(xpath="//div[@id='layer_cart']/div/div/h2")
	private WebElement cartConfirmTxt;
	
	@FindBy(css="td.cart_description")
	private WebElement cartDescProductDetails;
	
	@FindBy(css="#summary_products_quantity")
	private WebElement cartSummaryQtyTxt;
	
	@FindBy(css=".icon-plus")
	private WebElement increaseQtyBtn;
	
	@FindBy(css="span[id=total_price]")
	private WebElement priceTxt;
	
	
	public TShirtProductConfig(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}
	
	public void goToTShirtTab() {
		wait.until(ExpectedConditions.visibilityOf(tshirtTab));
		tshirtTab.click();
	}
	
	public WebElement getProductDesc() {
		return this.cartDescProductDetails;
	}
	
	public WebElement getCartConfirmation() {
		return this.cartConfirmTxt;
	}
	
	public WebElement getTotalPrice() {
		return this.priceTxt;
	}
	
	public void addProductToCart(String productname) {
		driver.findElement(By.xpath("//a[@class='product-name' and @title='"+productname+"']")).click();;
		wait.until(ExpectedConditions.visibilityOf(addtoCartBtn));
		addtoCartBtn.click();
		wait.until(ExpectedConditions.visibilityOf(proceedCheckoutBtn));
		
	}
	
	public void proceedToCheckOut() {
		proceedCheckoutBtn.click();
	}
	
	public void increaseQuantityTo(int qty) {
		final int quantity = qty;
		for(int i=1; i<qty; i++) {
			increaseQtyBtn.click();
		}
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return cartSummaryQtyTxt.getText().equals(quantity+" Products");
			}
		});
	}
	
	

}
