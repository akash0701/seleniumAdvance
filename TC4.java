package com.infosys.testcases;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.infosys.pageobjects.Frames;
import com.infosys.pageobjects.Windows;
import com.infosys.setup.BasePage;

public class TC4 extends BasePage {
  @Test
  public void test(){
	  try {
		  Windows obj1=new Windows(getDriver());
		  
		  Frames f=obj1.switchTabs();
		  
		  if(!f.equals(null)) {
			  assertTrue(f.verifyFrame());
		  }
		  else
			  fail();
			BasePage.log.info("Executed successful");
		} catch(Exception e) {
			BasePage.log.error(e.getMessage());
		}
	  
  }
  
  @BeforeClass
	@Parameters({ "brow", "url3" })
	public void setup(String browser, String url) {
		initilaize(browser, url);
	}
}
