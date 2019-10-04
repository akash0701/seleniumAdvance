package com.infosys.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.infosys.setup.BasePage;

public class HomePage {
	
	private WebDriver driver;
	
	By signin=By.cssSelector("a[class='login']");
	By dresses=By.xpath("//*[@id='block_top_menu']/ul/li[2]/a");
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public SignUpPage clickSignin() {
		SignUpPage s=null;
		driver.findElement(signin).click();
		BasePage.log.info("Clicked on Sigin link");
		s=new SignUpPage(driver);
		return s;
	}
	
	public AddToCart clickDresses() {
		AddToCart ac=null;
		driver.findElement(dresses).click();
		BasePage.log.info("Clicked on Dresses tab");
		ac=new AddToCart(driver);
		return ac;
	}

}
