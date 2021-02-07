package com.automation.browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserUtils {
	
	public static WebDriver driver;
	
	
	public static WebDriver getBrowser(String browserName) {
		
		if(browserName.toUpperCase().equals("FIREFOX")) {
			System.setProperty("webdriver.gecko.driver", "src/main/java/com/automation/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browserName.toUpperCase().equals("IE")) {
			System.setProperty("webdriver.ie.driver", "src/main/java/com/automation/drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else {
			System.setProperty("webdriver.chrome.driver", "src/main/java/com/automation/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		return driver;
	}

}
