package com.qa.wisupDEV_Test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.pageLayer.AddATask;
import com.qa.pageLayer.CartPage;
import com.qa.pageLayer.Dashboard;
import com.qa.pageLayer.FeedbackPage;
import com.qa.pageLayer.HireResourcePage;
import com.qa.pageLayer.LoginPage;
import com.qa.pageLayer.ProfilePage;
import com.qa.wishupDEV.utility.TestBase;

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
