package com.qa.pageLayer_ForPOM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


import com.qa.wishupDEV.utility.TestBase;

public class HireResourcePage extends TestBase {
	String category;
	int Int_viewProfileIndex;
	By WE_VA_Category = By.xpath("//span[text()='"+category+"']");
	By WE_slider = By.className("slider");
	By WEList_availableProfiles = By.xpath("//section[@class='ui computer only client_dashboard grid va-list-container']//div[@class='appeal']");
	By WE_viewProfile = By.xpath("(//section[@class='ui computer only client_dashboard grid va-list-container']//button[@class='profile-button'])["+Int_viewProfileIndex+"]");
	By WE_cart = By.xpath("//a[@class='cart-icon']");
	By WE_warnMsg = By.xpath("//div[@class='ui warning message']");
	By WE_backToDashboard = By.xpath("//a[@class='ui fluid basic button']");
	
	public void selectCatergoryForResource(String category)
	{
		this.category = category;
		//Click on virtual assistant category
		driver.findElement(WE_VA_Category).click();
	}
	public List<WebElement> getListOfAvailableProfiles()
	{
		//Find number of profiles available 
		List<WebElement> WEList_availableProfiles = driver.findElements(this.WEList_availableProfiles);
		return WEList_availableProfiles;
	}
	public void setAvailableHrsFilter()
	{
		//Set available hours for 4 hr
		WebElement WE_slider = driver.findElement(this.WE_slider);
		Actions Obj_Action = new Actions(driver);
		Obj_Action.dragAndDropBy(WE_slider, 4, 0).perform();
	}

	public void viewResourceProfile(int Int_viewProfileIndex)
	{
		Int_viewProfileIndex = this.Int_viewProfileIndex;
		driver.findElement(WE_viewProfile).click();
	}

	public void goToCart()
	{
		//Click on add to cart
		driver.findElement(WE_cart).click();

	}
	public void backToDashboard()
	{
		//Click on back to dashboard button
		driver.findElement(WE_backToDashboard).click();
	}

}
