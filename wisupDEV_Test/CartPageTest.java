package com.qa.wisupDEV_Test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.pageLayer.CartPage;
import com.qa.pageLayer.HireResourcePage;
import com.qa.pageLayer.LoginPage;
import com.qa.pageLayer.ProfilePage;
import com.qa.wishupDEV.utility.TestBase;

public class CartPageTest extends TestBase{
	LoginPage Obj_login;
	HireResourcePage Obj_hire;
	CartPage Obj_cart;
	
	@BeforeClass
	public void setup()
	{
		launch();
		Obj_login = new LoginPage();
		Obj_hire = new HireResourcePage();
		Obj_cart = new CartPage();
		//Login to app
		Obj_login.login();
	}
 
	@Test
	public void hireResourceFromCart()
	{
		Obj_hire.goToCart();
		Obj_cart.selectTermsOfUse();
		Obj_cart.proceedToPay();
		Obj_cart.selectPaymentMode();
		Obj_cart.enterCardDetails();
		String Str_paymentStatus= Obj_cart.completeThePayment();
		//Verify payment status
		Assert.assertEquals(Str_paymentStatus, "Paid");
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}


}
