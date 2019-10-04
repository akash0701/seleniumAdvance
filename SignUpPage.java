package com.infosys.pageobjects;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.infosys.setup.BasePage;

public class SignUpPage {
	
	private WebDriver driver;
	
	By email=By.id("email_create");
	By submit1=By.id("SubmitCreate");
	
	By form=By.id("account-creation_form");
	By gender=By.id("id_gender1");
	By firstname=By.id("customer_firstname");
	By lastname=By.id("customer_lastname");
	By password=By.id("passwd");
	By days=By.id("days");
	By months=By.id("months");
	By years=By.id("years");
	By newsletter=By.id("newsletter");
	By special=By.id("optin");
	
	By company=By.id("company");
	By address1=By.id("address1");
	By address2=By.id("address2");
	By city=By.id("city");
	By state=By.id("id_state");
	By pincode=By.id("postcode");
	By country=By.id("id_country");
	By additionalInfo=By.id("other");
	By homephone=By.id("phone");
	By mobilephone=By.id("phone_mobile");
	By alias=By.id("alias");
	By submit2=By.id("submitAccount");
	
	
	
	public SignUpPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void sendEmailId() {
		driver.findElement(email).sendKeys(randomString() + "@infy.com");
		BasePage.log.info("Entered random Email address");
	}
	
	
	public void clickCreateAccount() {
		driver.findElement(submit1).click();
		BasePage.log.info("Clicked on Create account button");	
	}
	
	public boolean emailSubmit() {		
		try
		{
			sendEmailId();
			clickCreateAccount();
			return true;
			
		}
		catch(Exception e)
		{
			BasePage.log.error(e.getMessage());	
		}
		
		return false;
	}
	
	public String randomString() {
		int length = 12;
	    boolean useLetters = true;
	    boolean useNumbers = true;
	    String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
	    return generatedString;
	}
	
	public MyAccountPage createAccount() {
		MyAccountPage acc=null;
		if(emailSubmit()) {
			try
			{
				File file=new File("src\\test\\java\\Resources\\TestCase1.xlsx");
				FileInputStream in=new FileInputStream(file);
				XSSFWorkbook workbook=new XSSFWorkbook(in);
				
				XSSFSheet sheet1=workbook.getSheet("Personal");
				
				driver.findElement(gender).click();
				BasePage.log.info("Clicked on 'Mr.' radio button");
				
				driver.findElement(firstname).sendKeys(sheet1.getRow(1).getCell(0).getStringCellValue());
				BasePage.log.info("Entered Firstname");
				
				driver.findElement(lastname).sendKeys(sheet1.getRow(1).getCell(1).getStringCellValue());
				BasePage.log.info("Entered Lastname");
				
				driver.findElement(password).sendKeys(sheet1.getRow(1).getCell(2).getStringCellValue());
				BasePage.log.info("Entered password");
				new Select(driver.findElement(days)).selectByValue(String.valueOf((int)sheet1.getRow(1).getCell(3).getNumericCellValue()));
				new Select(driver.findElement(months)).selectByValue(String.valueOf((int)sheet1.getRow(1).getCell(4).getNumericCellValue()));
				new Select(driver.findElement(years)).selectByValue(String.valueOf((int)sheet1.getRow(1).getCell(5).getNumericCellValue()));
				BasePage.log.info("Selected Date of Birth");
				
				driver.findElement(newsletter).click();
				Thread.sleep(1000);
				driver.findElement(special).click();
				BasePage.log.info("Clicked on Checkboxes");
				
				XSSFSheet sheet2=workbook.getSheet("Address");
				
				driver.findElement(company).sendKeys(sheet2.getRow(1).getCell(0).getStringCellValue());
				BasePage.log.info("Entered Company name");
				driver.findElement(address1).sendKeys(sheet2.getRow(1).getCell(1).getStringCellValue());
				driver.findElement(address2).sendKeys(sheet2.getRow(1).getCell(2).getStringCellValue());
				BasePage.log.info("Entered Address");
				driver.findElement(city).sendKeys(sheet2.getRow(1).getCell(3).getStringCellValue());
				BasePage.log.info("Entered City");
				new Select(driver.findElement(state)).selectByVisibleText(sheet2.getRow(1).getCell(4).getStringCellValue());
				BasePage.log.info("Selected State");
				Thread.sleep(1000);
				
				driver.findElement(pincode).sendKeys(String.valueOf((long)sheet2.getRow(1).getCell(5).getNumericCellValue()));
				BasePage.log.info("Entered PostalCode");
				new Select(driver.findElement(country)).selectByVisibleText(sheet2.getRow(1).getCell(6).getStringCellValue());
				BasePage.log.info("Selected Country");
				Thread.sleep(1000);
				
				driver.findElement(additionalInfo).sendKeys(sheet2.getRow(1).getCell(7).getStringCellValue());
				BasePage.log.info("Entered Additional Info");
				
				driver.findElement(homephone).sendKeys(String.valueOf((long)sheet2.getRow(1).getCell(8).getNumericCellValue()));
				driver.findElement(mobilephone).sendKeys(String.valueOf((long)sheet2.getRow(1).getCell(9).getNumericCellValue()));
				BasePage.log.info("Entered Contact Number");
				
				driver.findElement(alias).clear();
				driver.findElement(alias).sendKeys(sheet2.getRow(1).getCell(10).getStringCellValue());
				BasePage.log.info("Entered Alias for Account");
				
				driver.findElement(submit2).click();
				BasePage.log.info("Clicked on Submit button");
				
				workbook.close();
				in.close();
				
				acc=new MyAccountPage(driver);
				
			}
			catch(Exception e)
			{
				BasePage.log.error(e.getMessage());
				
			}
		}
		return acc;		
	}

}
