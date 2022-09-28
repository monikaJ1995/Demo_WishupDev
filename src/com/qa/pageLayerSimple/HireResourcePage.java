package com.qa.pageLayerSimple;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.qa.wishupDEV.utilitySimple.TestBase;

public class HireResourcePage extends TestBase {

	public void selectCatergoryForResource()
	{
		//Click on virtual assistant category
		WebElement WE_VA_Category = driver.findElement(By.xpath(Obj_locatorsProp.getProperty("WE_VA_Category")));
		WE_VA_Category.click();
	}
	public int getNumberOfResources()
	{
		//Find number of profiles available 
		List<WebElement> WEList_VA_Qty = driver.findElements(By.partialLinkText(Obj_locatorsProp.getProperty("WEList_VA_Qty")));
		int Int_countOfResource = WEList_VA_Qty.size();
		//Assert.assertEquals(WEList_VA_Qty.size(), 21);
		return Int_countOfResource;
	}
	public void setAvailableHrsFilter()
	{
		//Set available hours for 4 hr
		WebElement WE_slider = driver.findElement(By.className(Obj_locatorsProp.getProperty("WE_slider")));
		Actions Obj_Action = new Actions(driver);
		Obj_Action.dragAndDropBy(WE_slider, 4, 0).perform();
	}

	public void viewResourceProfile()
	{
		List<WebElement> WEList_availableHrs = driver.findElements(By.xpath(Obj_locatorsProp.getProperty("WEList_availableHrs")));
		/*problem:   clicks on 1st view profile button*/
		for (WebElement WE_hrs:WEList_availableHrs)
		{
			if(WE_hrs.getText().equals("8"))
			{
				WebElement WE_viewProfile = driver.findElement(By.partialLinkText(Obj_locatorsProp.getProperty("WE_viewProfile")));
				WE_viewProfile.click();
				break;
			}
		}
	}

	public void goToCart()
	{
		//Click on add to cart
		WebElement WE_cart = driver.findElement(By.xpath(Obj_locatorsProp.getProperty("WE_cart")));
		WE_cart.click();
//		WebElement Str_warnMsg = driver.findElement(By.xpath(Obj_locatorsProp.getProperty("Str_warnMsg")));
//		String Str_warnigMsg = Str_warnMsg.getText();
//		return Str_warnigMsg;
	}
	public void backToDashboard()
	{
		//Click on back to dashboard button
		WebElement WE_backToDashboard = driver.findElement(By.xpath(Obj_locatorsProp.getProperty("WE_backToDashboard")));
		WE_backToDashboard.click();
	}

}
