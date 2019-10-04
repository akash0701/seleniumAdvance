package com.infosys.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.infosys.setup.BasePage;

public class SignInPage {
	private WebDriver driver;
	
	By email=By.id("email");
	By password=By.id("passwd");
	By submit=By.id("SubmitLogin");
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public SignInPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void sendEmail() {
		driver.findElement(email).sendKeys("mohit.chauhan1@infy.com");
		BasePage.log.info("Entered Email Address");
	}
	
	public void sendPassword() {
		driver.findElement(password).sendKeys("Password1");
		BasePage.log.info("Entered Password");
	}
	
	public void clickLogin() {
		driver.findElement(submit).click();
		BasePage.log.info("Clicked on Login button");
	}
	
	public AddressPage signIn() {
		AddressPage a=null;
		sendEmail();
		sendPassword();
		clickLogin();
		
		a=new AddressPage(driver);
		return a;
	}

}
