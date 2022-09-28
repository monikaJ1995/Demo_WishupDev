package com.qa.wisupDEV_Test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.pageLayer.AddATask;
import com.qa.pageLayer.CartPage;
import com.qa.pageLayer.Dashboard;
import com.qa.pageLayer.HireResourcePage;
import com.qa.pageLayer.LoginPage;
import com.qa.pageLayer.ProfilePage;
import com.qa.wishupDEV.utility.TestBase;

public class AddATaskTest extends TestBase{
	LoginPage Obj_login;
	HireResourcePage Obj_hire;
	Dashboard Obj_dashboard;
	AddATask Obj_addTask;
	@BeforeClass
	public void setup()
	{
		launch();
		Obj_login = new LoginPage();
		Obj_hire = new HireResourcePage();
		Obj_dashboard = new Dashboard();
		Obj_addTask = new AddATask();
		//Login to app
		Obj_login.login("monika.jadhav@wishup.co","wishup123");
		Obj_hire.backToDashboard();
	}
 
	@Test
	public void createATask()
	{
		Obj_dashboard.clickOnAddATask();
		Obj_addTask.enterTaskName();
		Obj_addTask.enterTaskDescription();
		Obj_addTask.selectResourceForAssignment();
		Obj_addTask.clickOnCreateTaskButton();
		Obj_addTask.selectCategory();
		Obj_addTask.enterStepsToDoTask();
		String Str_currentURL = Obj_addTask.clickOnSaveDetails();
		//verify successful creation of task
		Assert.assertEquals(Str_currentURL, "https://app-dev.wishup.co/org/90014/my_tasks");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}


}
