package com.qa.pageLayer_ForPOM;

import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.wishupDEV.utility.PropertiesConfigUtility;
import com.qa.wishupDEV.utility.TestBase;

public class AddATask extends TestBase {

	@FindBy(xpath = "//div[@class='ui computer tablet only grid']//input[contains(@name,'name')]")
	WebElement WE_taskName;

	@FindBy(xpath = "//trix-editor[@input='task_details']")
	WebElement WE_description;

	@FindBy(xpath = "(//div[@class='ui computer tablet only grid']//div[contains(text(),'mj')])")
	WebElement WE_selectResource;

	@FindBy(xpath = "//div[@class='ui computer tablet only grid']//button[text()=' Create this task']")
	WebElement WE_createTaskBtn;

	@FindBy(xpath = "(//input[@class='search'])")
	WebElement WE_selectCat;

	@FindBy(tagName = "trix-editor")
	WebElement WE_stepsBox;

	@FindBy(xpath = "//div[@class='ui computer tablet only grid']//button[@type='submit']")
	WebElement WE_saveDetails;

	public AddATask()
	{
		PageFactory.initElements(driver, this);
	}
	public void enterTaskName()
	{
		//Enter task name
		WE_taskName.sendKeys("task1");
	}
	public void enterTaskDescription()
	{
		try {
			//Enter task description
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
		WE_saveDetails.click();
		String Str_currentURL = driver.getCurrentUrl();
		return Str_currentURL;
	}
}
