package com.infosys.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.infosys.setup.BasePage;

public class AddressPage {
	private WebDriver driver;

	By deliveryAddress = By.id("address_delivery");
	By invoiceAddress = By.id("address_invoice");
	By proceed = By.name("processAddress");

	public WebDriver getDriver() {
		return driver;
	}

	public AddressPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void click(By b) {
		driver.findElement(b).click();
	}

	public ShippingPage addressVerify() {
		ShippingPage p=null;
		WebElement delAddress = driver.findElement(deliveryAddress);
		List<WebElement> list1 = delAddress.findElements(By.tagName("li"));

		WebElement billAddress = driver.findElement(invoiceAddress);
		List<WebElement> list2 = billAddress.findElements(By.tagName("li"));

		if (list1.size() == list2.size()) {
			for (int i = 1; i < list1.size() - 1; i++) {
				if(!list1.get(i).getText().equals(list2.get(i).getText()))
						return p;
			}
		}
		else
			return p;
		
		BasePage.log.info("'Delivery Address' and 'Invoice Address' matched");

		click(proceed);
		BasePage.log.info("Clicked on Proceed");
		p=new ShippingPage(driver);
		return p;
	}

}
