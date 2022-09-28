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
import com.qa.pageLayer.WeeklyReportPage;
import com.qa.wishupDEV.utility.TestBase;

public class WeeklyReportTest extends TestBase{
	LoginPage Obj_login;
	HireResourcePage Obj_hire;
	Dashboard Obj_dashboard;
	WeeklyReportPage Obj_report;
	@BeforeClass
	public void setup()
	{
		launch();
		Obj_login = new LoginPage();
		Obj_hire = new HireResourcePage();
		Obj_dashboard = new Dashboard();
		Obj_report = new WeeklyReportPage();
		//Login to app
		Obj_login.login();
		Obj_hire.backToDashboard();
	}
 
	@Test
	public void generateWeeklyReport()
	{
		Obj_dashboard.clickOnDashboard();
		String Str_msg = Obj_report.generatePreviousWeekReport();
		Assert.assertEquals(Str_msg, "");
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}


}
