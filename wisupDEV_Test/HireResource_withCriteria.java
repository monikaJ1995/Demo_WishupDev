package com.qa.wisupDEV_Test;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.pageLayer.HireResourcePage;
import com.qa.pageLayer.LoginPage;
import com.qa.pageLayer.ProfilePage;
import com.qa.wishupDEV.utility.TestBase;

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
		//Click on Virtual Assistant category
		Obj_hire.selectCatergoryForResource("digital marketing manager");//virtual assistant
		
		//Set available hrs filter to 4hr
		Obj_hire.setAvailableHrsFilter();
		
		//Get list of Resource which are available for 4 or more hrs
		List<WebElement> WEList_availableProfiles = Obj_hire.getListOfAvailableProfiles();
		int Int_countOfProfiles = WEList_availableProfiles.size();
		System.out.println("Profile count: "+Int_countOfProfiles);
		int Int_viewProfileIndex = 1;
		
		//Iterate through the list one by one & add resource to cart once criteria met.
		for(WebElement WE_profile:WEList_availableProfiles)
		{
			//View resource profile
			Obj_hire.viewResourceProfile(Int_viewProfileIndex);
			System.out.println("Opened profile at number: "+Int_viewProfileIndex);
			
			//Verify resource have "MS Office" as tool experience
			try {
				Thread.sleep(1000);
				//Click on tool Expertise button
				String Str_tools = Obj_profile.getToolsForResource();
				System.out.println("Clicked on tools expertise button");

				if(Str_tools.contains("MS Office"))
				{
					System.out.println("Resource have expertise in MS Office");
					
					//Verify resource have "Poster designing" as a skill in skill set
					String Str_skillSet = Obj_profile.getSkillsForResource();
					Thread.sleep(2000);		
					
					if(Str_skillSet.contains("Poster Designing"))
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
				driver.navigate().to("https://app-dev.wishup.co/hire?bandwidth=4&search=&sort_by=&profiles=digital+marketing+manager"
						/*"https://app.wishup.co/hire?bandwidth=4&search=&sort_by=&profiles=virtual+assistant"*/);//virtual+assistant
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
