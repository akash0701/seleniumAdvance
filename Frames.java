package com.infosys.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.infosys.setup.BasePage;

public class Frames {
	private WebDriver driver;
	
	By frameTab=By.id("iFrame");
	By appiumThumbnail=By.xpath("//*[@id='portfolio_items']/div[9]/a");
	By appiumWindow=By.xpath("//*[@id='wrapper']/div/div[1]/div/div/div/div[2]/h1");
	By frame1=By.cssSelector("iframe[src='http://www.globalsqa.com/trainings/']");
	
	
	public Frames(WebDriver driver) {
		this.driver=driver;
	}
	
	public void clickFrameTab() {
		driver.findElement(frameTab).click();
		BasePage.log.info("Clicked on Frame tab");
		
	}
	
	public void switchFrame() {
		driver.switchTo().frame(driver.findElement(frame1));
		BasePage.log.info("Switched to Frame");
		
	}
	
	public void clickApiumTab() {
		driver.findElement(appiumThumbnail).click();
		BasePage.log.info("Appium training clicked successfully");
	}
	
	public boolean verifyFrame() throws Exception {
		clickFrameTab();
		
		Thread.sleep(2000);
		
		switchFrame();
		
		clickApiumTab();
		
		if(driver.findElement(appiumWindow).getText().equals("Appium Training"))
			return true;
		return false;
	}

}
