package com.qa.wisupDEV_Test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.pageLayer.LoginPage;
import com.qa.wishupDEV.utility.TestBase;

public class LoginPageTest extends TestBase{
	LoginPage obj_login;
	@BeforeMethod
	public void setup()
	{
		launch();
		obj_login = new LoginPage();
	}
	@Test
	public void verifyLoginWithValidCredentials()
	{
		//Login to application by passing both valid UN & pwd
		String Str_actualURLAfterLogin = obj_login.login("monika.jadhav@wishup.co","wishup123");
		//Verify successful login by verifying landing page url
		Assert.assertEquals(Str_actualURLAfterLogin, "https://app-dev.wishup.co/org/90014/my_daily_reports?fb_request=true");
	}
	@Test
	public void verifyLoginWithInvalidCredentials()
	{
		//Login to application by passing valid UN & invalid pwd
		String Str_actualURLAfterLogin = obj_login.login("monika.jadhav@wishup.co","wishup123");
		//Verify un-successful login by verifying landing page url
		Assert.assertNotEquals(Str_actualURLAfterLogin, "https://app-dev.wishup.co/org/90014/my_daily_reports?fb_request=true");
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	

}
