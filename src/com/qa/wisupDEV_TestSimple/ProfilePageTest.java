package com.qa.wisupDEV_TestSimple;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.pageLayerSimple.HireResourcePage;
import com.qa.pageLayerSimple.LoginPage;
import com.qa.pageLayerSimple.ProfilePage;
import com.qa.wishupDEV.utilitySimple.TestBase;

public class ProfilePageTest extends TestBase{
	LoginPage Obj_login;
	HireResourcePage Obj_hire;
	ProfilePage Obj_profile;
	
	@BeforeClass
	public void setup()
	{
		launch();
		Obj_login = new LoginPage();
		Obj_hire = new HireResourcePage();
		Obj_profile = new ProfilePage();
		//Login to app
		Obj_login.login();
		
		//Click on virtual assistant category
		Obj_hire.selectCatergoryForResource();
		
		//Set available hrs as 4hr
		Obj_hire.setAvailableHrsFilter();
		
		//Click on view profile button
		Obj_hire.viewResourceProfile();
	}
 
	@Test(priority=1, enabled=false)
	public void verifyToolsExpertise()
	{
		//Verify the resource has MS office tools experience
		String Str_tools = Obj_profile.getToolsForResource();
		/****True***/Assert.assertTrue(Str_tools.contains("MS Office"));
	}
	
	@Test(priority=2, enabled=false)
	public void verifySkills()
	{
		//Verify the skill "CRM" is available in skill set for resource
		String Str_skills = Obj_profile.getSkillsForResource();
		Assert.assertFalse(Str_skills.contains("CRM"));
	}
	
	@Test(priority=3)
	public void addResourceToCart()
	{
		//Click on hire me button
		Obj_profile.hireMe();
		Obj_profile.selectQuarterlyPlan();
		Obj_profile.selectHalfDayPlan();
		String Str_currentURL = Obj_profile.goToCart();
		Assert.assertEquals(Str_currentURL, "https://app-dev.wishup.co/cart");
	}
	
	

	@AfterClass
	public void teardown()
	{
		driver.quit();
	}


}
