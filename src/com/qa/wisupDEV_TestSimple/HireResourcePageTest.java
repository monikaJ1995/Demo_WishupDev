package com.qa.wisupDEV_TestSimple;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.pageLayerSimple.HireResourcePage;
import com.qa.pageLayerSimple.LoginPage;
import com.qa.wishupDEV.utilitySimple.TestBase;

public class HireResourcePageTest extends TestBase{
	LoginPage Obj_login;
	HireResourcePage Obj_hire;

	@BeforeMethod
	public void setup()
	{
		launch();
		Obj_login = new LoginPage();
		Obj_hire = new HireResourcePage();
		//Login to app
		Obj_login.login();
	}
	@Test
	public void verifyNumberOfVAsOnPage()
	{
		//Select virtual assistant category
		Obj_hire.selectCatergoryForResource();
		
		//Verify the count of total VAs on filtered page
		int Int_resourceCount = Obj_hire.getNumberOfResources();
		Assert.assertEquals(Int_resourceCount, 21);
	}

	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}


}
