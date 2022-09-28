package com.qa.wisupDEV_TestSimple;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.pageLayerSimple.CartPage;
import com.qa.pageLayerSimple.HireResourcePage;
import com.qa.pageLayerSimple.LoginPage;
import com.qa.pageLayerSimple.ProfilePage;
import com.qa.wishupDEV.utilitySimple.TestBase;

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
