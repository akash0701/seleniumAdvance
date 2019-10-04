package com.infosys.testcases;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import org.testng.annotations.Test;

import com.infosys.pageobjects.HomePage;
import com.infosys.pageobjects.MyAccountPage;
import com.infosys.pageobjects.SignUpPage;
import com.infosys.setup.BasePage;

public class TC1 extends BasePage{
  @Test
  public void test() {
	  try {
		  HomePage hp=new HomePage(getDriver());
		  SignUpPage s=hp.clickSignin();
		  
		  if(!s.equals(null)) {
			  MyAccountPage m=s.createAccount();
			  if(!m.equals(null)) {
				  assertTrue(m.verifyTitle());
			  }
			  else
				  fail();
		  }
		  else
			  fail();
		  BasePage.log.info("Executed successful");
		} catch(Exception e) {
			BasePage.log.error(e.getMessage());
		}
	  
	  
  }
}
