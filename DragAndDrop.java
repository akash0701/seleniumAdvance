package com.infosys.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.infosys.setup.BasePage;

public class DragAndDrop {
	private WebDriver driver;
	
	By photoManager=By.id("Photo Manager");
	By frame1=By.cssSelector("iframe.demo-frame[src='../../demoSite/practice/droppable/photo-manager.html']");
	By gallery=By.id("gallery");
	By image1=By.cssSelector("#gallery > li:nth-child(1)");
	By trash=By.id("trash");
	
	
	
	public DragAndDrop(WebDriver driver) {
		this.driver=driver;
	}
	
	public void clickPhotoManager() {
		driver.findElement(photoManager).click();
		BasePage.log.info("Clicked Photo Manager button");
	}
	
	public void switchFrame() {
		driver.switchTo().frame(driver.findElement(frame1));
		BasePage.log.info("Switch to Frame");
	}
	
	public void dragAndDropItem() throws Exception  {
		Actions action=new Actions(driver);
		action.dragAndDrop(driver.findElement(image1), driver.findElement(trash)).perform();
		Thread.sleep(1000);
		BasePage.log.info("Thumbnail dragged and dropped to trash");
	}
	
	public boolean dragAndDrop() throws Exception  {
		
		clickPhotoManager();
		
		switchFrame();
		
		WebElement list=driver.findElement(gallery);
		
		List<WebElement> beforeThumbnails = list.findElements(By.tagName("li"));
		int beforeCount=beforeThumbnails.size();
		
		dragAndDropItem();
		
		List<WebElement> afterThumbnails = list.findElements(By.tagName("li"));
		int afterCount=afterThumbnails.size();
		
		if(beforeCount-afterCount==1)
			return true;
		return false;
		
	}

}
