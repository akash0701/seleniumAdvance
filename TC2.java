package com.infosys.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.infosys.pageobjects.AddToCart;
import com.infosys.pageobjects.AddressPage;
import com.infosys.pageobjects.HomePage;
import com.infosys.pageobjects.OrderHistory;
import com.infosys.pageobjects.PaymentPage;
import com.infosys.pageobjects.ShippingPage;
import com.infosys.pageobjects.SignInPage;
import com.infosys.pageobjects.SummaryPage;
import com.infosys.setup.BasePage;

public class TC2 extends BasePage {
  @Test
  public void test() throws Exception {
	  boolean result=false;
	  
	  try {
		  HomePage hp=new HomePage(getDriver());
		  AddToCart ac=hp.clickDresses();
		  if(!ac.equals(null)) {
			  SummaryPage sp=ac.addToCart();
			  
			  if(!sp.equals(null)) {
				  SignInPage si=sp.proceedCheckout();
				  
				  if(!si.equals(null)) {
					  AddressPage ap=si.signIn();
					  
					  if(!ap.equals(null)) {
						  ShippingPage sh=ap.addressVerify();
						  
						  if(!sh.equals(null)) {
							  PaymentPage pp=sh.proceed();
							  
							  if(!pp.equals(null)) {
								  OrderHistory oh=pp.pay();
								  
								  if(!oh.equals(null)) {
									  result=oh.verifyOrder();
								  }
							  }
						  }
					  }
				  }
			  }
		  }
		  assertTrue(result);
		  BasePage.log.info("Executed successful");
		} catch(Exception e) {
			BasePage.log.error(e.getMessage());
		}
	  
	  
  }
}
