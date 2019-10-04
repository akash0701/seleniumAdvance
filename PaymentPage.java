package com.infosys.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.infosys.setup.BasePage;

public class PaymentPage {
	private WebDriver driver;
	
	By bankwireButton=By.className("bankwire");
	By bankwireText=By.cssSelector("h3[class='page-subheading']");
	By confirm=By.cssSelector("button[class='button btn btn-default button-medium']");

	public WebDriver getDriver() {
		return driver;
	}

	public PaymentPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void click(By b) {
		driver.findElement(b).click();
	}
	
	public OrderHistory pay() {
		OrderHistory o=null;
		click(bankwireButton);
		BasePage.log.info("Clicked on 'Pay by Bankwire' link");
		if(driver.findElement(bankwireText).getText().equals("BANK-WIRE PAYMENT.")) {
			BasePage.log.info("'Bank Wire Payment' displayed");
			click(confirm);
			BasePage.log.info("Clicked on 'Proceed'");
			o=new OrderHistory(driver);
		}
		return o;
	}

}
