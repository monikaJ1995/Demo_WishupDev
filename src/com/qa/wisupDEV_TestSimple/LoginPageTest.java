package com.qa.wisupDEV_TestSimple;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.pageLayerSimple.LoginPage;
import com.qa.wishupDEV.utilitySimple.TestBase;

public class LoginPageTest extends TestBase{
	LoginPage obj_login;
	@BeforeMethod
	public void setup()
	{
		launch();
		obj_login = new LoginPage();
	}
	@Test
	public void verifyLogin()
	{
		//Login to app
		obj_login.login();
		//Verify successful login by verifying username
		String Str_UserName = obj_login.verifySuceessfulLogin();
		Assert.assertEquals(Str_UserName, "mj");
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	

}
