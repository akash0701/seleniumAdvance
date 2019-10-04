package com.infosys.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.infosys.setup.BasePage;

public class SummaryPage {
	private WebDriver driver;
	
	By button1=By.cssSelector("a[class='button btn btn-default standard-checkout button-medium']");
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public SummaryPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public SignInPage proceedCheckout() {
		SignInPage s=null;
		driver.findElement(button1).click();
		BasePage.log.info("Clicked on 'Proceed to Checkout' under Summary");
		s=new SignInPage(driver);
		return s;
	}

}
