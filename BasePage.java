package com.infosys.setup;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class BasePage {
	private WebDriver driver;
	public static Logger log;
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public void initilaize(String browser, String url) {

		switch (browser) {
		case "IE":
			System.setProperty("webdriver.ie.driver", "src\\test\\java\\Drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.get(url);
			break;
		case "FF":
			System.setProperty("webdriver.gecko.driver", "src\\test\\java\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.get(url);
			break;
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "src\\test\\java\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(url);
			break;
		default:
			driver = new ChromeDriver();
			driver.get(url);
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@BeforeSuite
	public void logInitialisation() {
		log = Logger.getLogger(getClass());

	}

	@BeforeClass
	@Parameters({ "brow", "url1" })
	public void setup(String browser, String url) {
		initilaize(browser, url);
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}

}
