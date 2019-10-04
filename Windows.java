package com.infosys.pageobjects;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.infosys.setup.BasePage;

public class Windows {
	private WebDriver driver;
	
	By clickHere=By.xpath("//*[@id='post-2632']/div[2]/div/div/div[1]/a");
	
	
	public Windows(WebDriver driver) {
		this.driver=driver;
	}
	
	public void click() {
		driver.findElement(clickHere).click();
		BasePage.log.info("Clicked on button to open New tab");
		
	}
	
	public Frames switchTabs() throws Exception {
		String newTab="";
		Frames f=null;
		
		click();
		
		Set<String> handles = driver.getWindowHandles();
		
		if(handles.size()>1) {
		
			for(String handle:handles) {
				driver.switchTo().window(handle);
				if(driver.getCurrentUrl().equals("http://www.globalsqa.com/demo-site/frames-and-windows#")) {				
					newTab=driver.getWindowHandle();
				}
				else
					driver.close();
			}
			
			driver.switchTo().window(newTab);
			BasePage.log.info("Switched to newly opened tab");
			
			f=new Frames(driver);
		}
		
		return f;
	}

}
