package com.qa.pageLayerSimple;

import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.qa.wishupDEV.utilitySimple.PropertiesConfigUtility;
import com.qa.wishupDEV.utilitySimple.TestBase;

public class AddATask extends TestBase {
 
	public void enterTaskName()
	{
		//Enter task name
		WebElement WE_taskName = driver.findElement(By.xpath(Obj_locatorsProp.getProperty("WE_taskName")));
		WE_taskName.sendKeys("task1");
		
	}
	public void enterTaskDescription()
	{
		try {
		//Enter task description
		WebElement WE_description = driver.findElement(By.xpath(Obj_locatorsProp.getProperty("WE_description")));
		WE_description.sendKeys("This is task created for Demo testing");
		Thread.sleep(1000);
	}
	catch(InterruptedException e)
	{
		e.printStackTrace();
	}
	}

	public void selectResourceForAssignment()
	{
		try {
		//Select resource for assignment
		WebElement WE_selectResource = driver.findElement(By.xpath(Obj_locatorsProp.getProperty("WE_selectResource")));
		WE_selectResource.click();
		Thread.sleep(1000);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	public void clickOnCreateTaskButton()
	{
		try {
		//Click on create task button
		WebElement WE_createTaskBtn = driver.findElement(By.xpath(Obj_locatorsProp.getProperty("WE_createTaskBtn")));
		WE_createTaskBtn.click();
		Thread.sleep(1000);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	public void selectCategory()
	{
		try {
		//Select Category
		WebElement WE_selectCat = driver.findElement(By.xpath(Obj_locatorsProp.getProperty("WE_selectCat")));
		WE_selectCat.sendKeys("Administration");
		Thread.sleep(1000);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	public void enterStepsToDoTask()
	{
		try {
		//Enter steps to do task
		WebElement WE_stepsBox = driver.findElement(By.tagName(Obj_locatorsProp.getProperty("WE_stepsBox")));
		WE_stepsBox.sendKeys("Task for Demo");
		Thread.sleep(2000);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	public String clickOnSaveDetails()
	{
		//Click on save details
		WebElement WE_saveDetails = driver.findElement(By.xpath(Obj_locatorsProp.getProperty("WE_saveDetails")));
		WE_saveDetails.click();
		String Str_currentURL = driver.getCurrentUrl();
		return Str_currentURL;
	}
}
