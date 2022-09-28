package com.qa.wishupDEV.Common;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.pageLayerSimple.HireResourcePage;
import com.qa.pageLayerSimple.LoginPage;
import com.qa.pageLayerSimple.ProfilePage;
import com.qa.wishupDEV.utilitySimple.Login;
import com.qa.wishupDEV.utilitySimple.TestBase;

public class HireResource_withCriteria extends TestBase {
	LoginPage Obj_login;
	HireResourcePage Obj_hire;
	ProfilePage Obj_profile;

	@BeforeClass
	public void setup()
	{
		launch();
	}

	@BeforeMethod
	public void logIn()
	{
		Obj_login = new LoginPage();
		Obj_hire = new HireResourcePage();
		Obj_profile = new ProfilePage();
		//Login to app
		Obj_login.login();
	}

	@Test(enabled=true)
	public void addResourceToCartWithMatchedCriteria()
	{
		//Click on digital marketing category
		WebElement WE_DMarketing_Category = driver.findElement(By.xpath("//section[contains(@class,'ui computer only')]//span[text()='digital marketing manager']"));
		WE_DMarketing_Category.click();

		//Set available hrs filter to 4hr
		Obj_hire.setAvailableHrsFilter();
		
		//Get list of Resource who is available for 4 hours a day
		List<WebElement> WEList_availableHrs = driver.findElements(By.xpath("//div[@class='cards']//div[@class='card-data']/descendant::div[contains(text(),'4')]"));
		int Int_countOfProfiles =WEList_availableHrs.size();//2

		int Int_viewProfileIndex = 1;
		//Iterate through the list one by one & add resource to cart once criteria met.
		for(WebElement WE_hrs:WEList_availableHrs)
		{
			System.out.println("Int_viewProfileIndex at start: "+Int_viewProfileIndex);
			//View resource profile
			WebElement WE_viewProfile = driver.findElement(By.xpath("(//div[@class='cards']//div[@class='card-data']/descendant::div[contains(text(),'4')]/ancestor::div[@class='flex align-items-center justify-content-between']/following-sibling::div[@class='flex align-items-center justify-content-between']/a)["+Int_viewProfileIndex+"]"));
			WE_viewProfile.click();
			System.out.println("Opened profile");

			//Verify resource have "MS Office" as tool experience
			try {
				Thread.sleep(1000);
				//Click on tool Expertise button
				Obj_profile.getToolsForResource();
				System.out.println("Clicked on tools expertise button");

				WebElement WE_tools = driver.findElement(By.xpath("//div[@class='top-tools tool-names']"));
				if(WE_tools.getText().contains("MS Office"))
				{

					System.out.println("Resource have expertise in MS Office");

					//Verify resource have "Poster designing" as a skill in skill set
					Obj_profile.getSkillsForResource();
					Thread.sleep(2000);

					WebElement WE_skillSet = driver.findElement(By.xpath("//div[@class='more-skills']"));
					if(WE_skillSet.getText().contains("Poster Designing"))
					{
						System.out.println("Resource have Poster Designing as skill");
						//Click on Hire me button
						Obj_profile.hireMe();
						Thread.sleep(1000);

						//Click on toggle button for quarterly plan
						Obj_profile.selectQuarterlyPlan();
						Thread.sleep(1000);

						//Click on select this plan under half day section
						Obj_profile.selectHalfDayPlan();
						Thread.sleep(1000);
						System.out.println("Half day plan is selected & resource is added to the cart");
					}
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


			finally {
				driver.navigate().to("https://app-dev.wishup.co/hire?bandwidth=4&search=&sort_by=&profiles=digital+marketing+manager");
				System.out.println("navigated back to the resource list");
				if(Int_viewProfileIndex<Int_countOfProfiles)
				{
					Int_viewProfileIndex++;
					System.out.println("Int_viewProfileIndex after increment: "+Int_viewProfileIndex);
				}
			}
		}
	}

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
