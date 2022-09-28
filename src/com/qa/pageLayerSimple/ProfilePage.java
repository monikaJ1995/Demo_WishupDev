package com.qa.pageLayerSimple;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.qa.wishupDEV.utilitySimple.TestBase;

public class ProfilePage extends TestBase {


	public String getToolsForResource()
	{
		//click on tools expertise option
		WebElement WE_toolExp = driver.findElement(By.xpath(Obj_locatorsProp.getProperty("WE_toolExp")));
		WE_toolExp.click();

		//Fetch tools available on resource profile
		WebElement WE_tools = driver.findElement(By.xpath(Obj_locatorsProp.getProperty("WE_tools")));
		String Str_tools = WE_tools.getText();
		return Str_tools;
	}

	public String getSkillsForResource()
	{
		//verify skills for resource
		String Str_skills = null;
		try {
			//Click on Tech skills option
			WebElement WE_techSkills = driver.findElement(By.xpath(Obj_locatorsProp.getProperty("WE_techSkills")));
			WE_techSkills.click();
			Thread.sleep(1000);

			//Get available top skills of resource
			WebElement WE_topSkills = driver.findElement(By.xpath(Obj_locatorsProp.getProperty("WE_topSkills")));
			Str_skills = WE_topSkills.getText();

			//Look for the presence of view all skills button
			WebElement WE_viewAllSkills = driver.findElement(By.xpath(Obj_locatorsProp.getProperty("WE_viewAllSkills")));
			Thread.sleep(2000);	

			/*If view all skills button is available & enabled then click on it 
			 * & get all skills available with resource*/ 
			if(WE_viewAllSkills.isEnabled())
			{
				//Click on view all skills button
				WE_viewAllSkills.click();

				//Get all skills displayed on screen & store in variable
				WebElement WE_skillSet = driver.findElement(By.xpath(Obj_locatorsProp.getProperty("WE_skillSet")));
				Thread.sleep(1000);
				Str_skills = WE_skillSet.getText();
			}		
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		catch(NoSuchElementException e)
		{
			e.printStackTrace();
		}
		return Str_skills;
	}


	public void hireMe()
	{
		try {
			//Click on Hire me button
			WebElement WE_hireMeBtn = driver.findElement(By.xpath(Obj_locatorsProp.getProperty("WE_hireMeBtn")));
			WE_hireMeBtn.click();
			Thread.sleep(2000);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	public void selectQuarterlyPlan()
	{
		try
		{
			//Click on toggle button for quarterly plan
			WebElement WE_quarterlyPlanToggle = driver.findElement(By.id(Obj_locatorsProp.getProperty("WE_quarterlyPlanToggle")));
			WE_quarterlyPlanToggle.click();
			Thread.sleep(1000);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	public void selectHalfDayPlan()
	{
		try {
			//Click on select this plan under half day section
			WebElement WE_selectThisPlan = driver.findElement(By.xpath(Obj_locatorsProp.getProperty("WE_selectThisPlan")));  //   //section[@id='laptop-display']//div[normalize-space()='Half Day']
			WE_selectThisPlan.click();
			Thread.sleep(1000);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	public String goToCart()
	{
		//Click on go to cart
		WebElement WE_goToCart = driver.findElement(By.xpath(Obj_locatorsProp.getProperty("WE_goToCart")));
		WE_goToCart.click();
		String Str_currentURL = driver.getCurrentUrl();
		return Str_currentURL;
	}
}
