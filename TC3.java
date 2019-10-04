package com.infosys.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.infosys.pageobjects.DragAndDrop;
import com.infosys.setup.BasePage;

public class TC3 extends BasePage{

	@Test
	public void test() {
		try {
			DragAndDrop obj = new DragAndDrop(getDriver());
			assertTrue(obj.dragAndDrop());
			BasePage.log.info("Executed successful");
		} catch(Exception e) {
			BasePage.log.error(e.getMessage());
		}
	}
	
	@BeforeClass
	@Parameters({ "brow", "url2" })
	public void setup(String browser, String url) {
		initilaize(browser, url);
	}

}
