package com.infosys.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.infosys.setup.BasePage;

public class ShippingPage {
	private WebDriver driver;
	
	By proceedButton=By.name("processCarrier");
	By popUp1=By.cssSelector("p[class='fancybox-error']");
	By cancel=By.cssSelector("a[class='fancybox-item fancybox-close']");
	By checkBox=By.id("cgv");
	

	public WebDriver getDriver() {
		return driver;
	}

	public ShippingPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void click(By b) {
		driver.findElement(b).click();
	}
	
	public PaymentPage proceed() throws Exception {
		PaymentPage p=null;
		click(proceedButton);
		BasePage.log.info("Clicked on 'Proceed'");
		
		if(driver.findElement(popUp1).getText().equals("You must agree to the terms of service before continuing.")){
			BasePage.log.info("Message prompt displayed");
			click(cancel);
			Thread.sleep(1000);
			
			click(checkBox);
			BasePage.log.info("Checked the checkbox");
			
			click(proceedButton);
			BasePage.log.info("Clicked on 'Proceed'");
			p=new PaymentPage(driver);
		}
		
		return p;

	}

}
