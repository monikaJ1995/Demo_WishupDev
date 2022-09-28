package com.qa.pageLayer_ForPOM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.qa.wishupDEV.utility.TestBase;

public class ProfilePage extends TestBase {

	By WE_toolExp = By.xpath("//span[text()='Tool Expertise']");
	By WE_tools = By.xpath("//div[@class='top-tools tool-names']");
	By WE_techSkills = By.xpath("//span[text()='Technical Skills']");
	By WE_topSkills = By.xpath("//div[contains(@class,'top-skills tool-names')]");
	By WE_viewAllSkills = By.xpath("//div[contains(text(),'View all skills')]");
	By WE_skillSet = By.xpath("//div[@class='more-skills']");
	By WE_hireMeBtn = By.xpath("//a[@class='hire-me-button']");
	By WE_quarterlyPlanToggle = By.id("toggler");
	By WE_selectThisPlan = By.xpath("//div[@class='select-popular-button']/a[@class='half-url']");
	By WE_goToCart = By.xpath("//button[contains(text(),'Go to cart')]");
	public String getToolsForResource()
	{
		//click on tools expertise option
		driver.findElement(WE_toolExp).click();

		//Fetch tools available on resource profile
		String Str_tools = driver.findElement(WE_tools).getText();
		return Str_tools;
	}

	public String getSkillsForResource()
	{
		//verify skills for resource
		String Str_skills = null;
		try {
			//Click on Tech skills option
			driver.findElement(WE_techSkills).click();
			Thread.sleep(1000);

			//Get available top skills of resource
			Str_skills = driver.findElement(WE_topSkills).getText();

			//Look for the presence of view all skills button
			WebElement WE_viewAllSkills = driver.findElement(this.WE_viewAllSkills);
			Thread.sleep(2000);	

			/*If view all skills button is available & enabled then click on it 
			 * & get all skills available with resource*/ 
			if(WE_viewAllSkills.isEnabled())
			{
				//Click on view all skills button
				WE_viewAllSkills.click();
				Thread.sleep(1000);
				//Get all skills displayed on screen & store in variable
				Str_skills = driver.findElement(WE_skillSet).getText();
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
			driver.findElement(WE_hireMeBtn).click();
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
			driver.findElement(WE_quarterlyPlanToggle).click();
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
			driver.findElement(WE_selectThisPlan).click();
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
		driver.findElement(WE_goToCart).click();
		String Str_currentURL = driver.getCurrentUrl();
		return Str_currentURL;
	}
}
