package com.infosys.pageobjects;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.infosys.setup.BasePage;

public class OrderHistory {
	private WebDriver driver;
	
	By refNo=By.cssSelector("#center_column > div");
	By amount=By.cssSelector("#center_column > div > span");
	By backToOrder=By.cssSelector("a[title='Back to orders']");
	
	By orderRef=By.xpath("//*[@id='order-list']/tbody/tr/td[1]");
	By orderDate=By.xpath("//*[@id='order-list']/tbody/tr[1]/td[2]");
	By orderAmount=By.xpath("//*[@id='order-list']/tbody/tr[1]/td[3]/span");
	By expandButton=By.xpath("//*[@id='order-list']/tbody/tr[1]/td[1]/span");
	By paymentType=By.xpath("//*[@id='order-list']/tbody/tr[2]/td/div/div[1]/div[2]");
	
	private String refNoVar;
	private String amountVar;
	private String dateVar;
	

	public WebDriver getDriver() {
		return driver;
	}

	public OrderHistory(WebDriver driver) {
		this.driver=driver;
	}
	
	public void getOrderInfo() {
		refNoVar=driver.findElement(refNo).getText();
		amountVar=driver.findElement(amount).getText();
		LocalDate date=LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		dateVar=date.format(formatter);
		BasePage.log.info("'Reference No.','Amount' and 'Date' stored successfully");
				
	}
	
	public void click(By b) {
		driver.findElement(b).click();
	}
	
	public boolean verifyOrder() throws Exception {
		getOrderInfo();
		
		click(backToOrder);
		BasePage.log.info("Clicked on 'Back to Order'");
		Thread.sleep(2000);
		if(refNoVar.contains(driver.findElement(orderRef).getText())) {
			BasePage.log.info("Order Reference Number matched");
			if(driver.findElement(orderDate).getText().equals(dateVar)){
				BasePage.log.info("Date matched");
				if(driver.findElement(orderAmount).getText().equals(amountVar)){
					BasePage.log.info("Amount matched");
					click(expandButton);
					
					if(driver.findElement(paymentType).getText().equals("Bank wire")) {
						BasePage.log.info("Payment mode is 'Bank Wire'");
						screenshot("src\\test\\java\\Resources\\OrderHistory.png");
						BasePage.log.info("Screenshot taken successfully");
						return true;
					}
				}
			}
		}
		
		return false;
		
	}
	
	private void screenshot(String path) throws Exception {
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(path));
	}

}
