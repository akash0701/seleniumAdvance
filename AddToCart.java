package com.infosys.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.infosys.setup.BasePage;

public class AddToCart {
	private WebDriver driver;
	
	
	By item=By.xpath("//*[@id='center_column']/ul/li[4]/div/div[2]/h5/a");
	By price=By.xpath("//*[@id='center_column']/ul/li[4]/div/div[2]/div[1]/span");
	By addToCartButton=By.cssSelector("a[class='button ajax_add_to_cart_button btn btn-default'][data-id-product='6']");
	By popUp1=By.id("layer_cart");
	By proceedButton=By.cssSelector("a[class='btn btn-default button button-medium']");
	
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public AddToCart(WebDriver driver) {
		this.driver=driver;
	}
	
	public boolean verifyDisplay(By b) {
		if(driver.findElement(b).isDisplayed())
			return true;
		return false;
		
	}
	
	public void click(By b) {
		driver.findElement(b).click();
	}
	
	public SummaryPage addToCart() throws Exception {
		SummaryPage sp=null;
		hoverElement();
		BasePage.log.info("Hover over product");
		
		if(verifyDisplay(price) && verifyDisplay(addToCartButton)) {
			BasePage.log.info("'Price' and 'Add to Cart' button displayed");
			click(addToCartButton);
			BasePage.log.info("Clicked on 'Add to Cart' button");
			Thread.sleep(2000);
			if(verifyDisplay(popUp1) && verifyDisplay(proceedButton)) {
				BasePage.log.info("'Popup' with product and 'Proceed to Checkout' button displayed");
				click(proceedButton);
				BasePage.log.info("Clicked on 'Proceed to Checkout' button");
				sp=new SummaryPage(driver);
			}
		}
		return sp;
		
	}
	
	public void hoverElement() {
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(item)).perform();
	}

}
