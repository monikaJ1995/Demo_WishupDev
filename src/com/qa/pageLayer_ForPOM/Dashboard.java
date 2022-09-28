package com.qa.pageLayer_ForPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.wishupDEV.utility.TestBase;

public class Dashboard extends TestBase {

	@FindBy(xpath = "//a[contains(@class,'create_task_button')]")
	WebElement WE_addATask;
	
	@FindBy(xpath = "//span[text()='Dashboard']")
	WebElement WE_dashboard;
	
	@FindBy(xpath = "//span[text()='Feedback']")
	WebElement WE_feedback;
	
	public Dashboard()
	{
		PageFactory.initElements(driver, this);
	}
	public void clickOnAddATask()
	{
		try {
			//Click on Add a task button
			WE_addATask.click();
			Thread.sleep(1000);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	public void clickOnDashboard()
	{
		try {
			//Click on Add a task button
		WE_dashboard.click();
			Thread.sleep(1000);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	public void clickOnFeedback()
	{
		try {
			//Click on Feedback 
			WE_feedback.click();
			Thread.sleep(1000);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}
