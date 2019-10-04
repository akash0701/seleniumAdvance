package com.infosys.pageobjects;

import org.openqa.selenium.WebDriver;

public class MyAccountPage {
	private WebDriver driver;
	
	public MyAccountPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public boolean verifyTitle() {
		if(driver.getTitle().equals("My account - My Store"))
			return true;
		return false;
	}

}
