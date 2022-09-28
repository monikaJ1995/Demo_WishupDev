package com.qa.pageLayerSimple;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.qa.wishupDEV.utilitySimple.TestBase;

public class Dashboard extends TestBase {
	public void clickOnAddATask()
	{
		try {
			//Click on Add a task button
			WebElement WE_addATask = driver.findElement(By.xpath(Obj_locatorsProp.getProperty("WE_addATask")));
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
			WebElement WE_dashboard = driver.findElement(By.xpath(Obj_locatorsProp.getProperty("WE_dashboard")));
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
			WebElement WE_feedback = driver.findElement(By.xpath(Obj_locatorsProp.getProperty("WE_feedback")));
			WE_feedback.click();
			Thread.sleep(1000);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}
