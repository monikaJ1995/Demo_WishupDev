package com.qa.wisupDEV_TestSimple;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.pageLayerSimple.AddATask;
import com.qa.pageLayerSimple.CartPage;
import com.qa.pageLayerSimple.Dashboard;
import com.qa.pageLayerSimple.FeedbackPage;
import com.qa.pageLayerSimple.HireResourcePage;
import com.qa.pageLayerSimple.LoginPage;
import com.qa.pageLayerSimple.ProfilePage;
import com.qa.wishupDEV.utilitySimple.TestBase;

public class FeedbackPageTest extends TestBase{
	LoginPage Obj_login;
	HireResourcePage Obj_hire;
	Dashboard Obj_dashboard;
	FeedbackPage Obj_feedback;
	@BeforeClass
	public void setup()
	{
		launch();
		Obj_login = new LoginPage();
		Obj_hire = new HireResourcePage();
		Obj_dashboard = new Dashboard();
		Obj_feedback = new FeedbackPage();
		//Login to app
		Obj_login.login();
		Obj_hire.backToDashboard();
	}
 
	@Test
	public void createATask()
	{
		Obj_dashboard.clickOnFeedback();
		Obj_feedback.createFeedback();
		Obj_feedback.giveFeedback();
		Obj_feedback.selectFromToDate();
		Obj_feedback.giveStarRating();
		Obj_feedback.enterComments();
		String Str_respMsg = Obj_feedback.submitFeedback();
		//verify success msg of recorded feedback
		Assert.assertEquals(Str_respMsg, "Feedback recorded successfully");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}


}
