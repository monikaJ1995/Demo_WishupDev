package com.qa.pageLayerSimple;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.qa.wishupDEV.utilitySimple.TestBase;

public class FeedbackPage extends TestBase {

	public void createFeedback()
	{
		//Click on create feedback button
		try {
			WebElement WE_createFB = driver.findElement(By.xpath(Obj_locatorsProp.getProperty("WE_createFB")));
			WE_createFB.click();
			Thread.sleep(1000);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	public void giveFeedback()
	{
		//Enter give feedback
		try {
			WebElement WE_giveFeedback = driver.findElement(By.xpath(Obj_locatorsProp.getProperty("WE_giveFeedback")));       // (//span[contains(text(),'Give feedback')])[6]
			WE_giveFeedback.click();
			Thread.sleep(1000);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	public void selectFromToDate()
	{
		//Select from date
		WebElement WE_fromdate= driver.findElement(By.cssSelector(Obj_locatorsProp.getProperty("WE_fromdate")));
		WE_fromdate.sendKeys("August 1, 2022");

		//Select to date
		WebElement WE_todate= driver.findElement(By.cssSelector(Obj_locatorsProp.getProperty("WE_todate")));
		WE_todate.sendKeys("August 8, 2022");
	}

	public void giveStarRating()
	{
		//select 5star rating
		WebElement WE_star= driver.findElement(By.xpath(Obj_locatorsProp.getProperty("WE_star")));
		WE_star.click();
	}

	public void enterComments()
	{
		//Enter feedback comments
		WebElement WE_msg = driver.findElement(By.name(Obj_locatorsProp.getProperty("WE_msg")));
		WE_msg.sendKeys("Great Work!!");

	}
	public String submitFeedback()
	{
		//Submit Feedback click
		WebElement WE_submitbutton= driver.findElement(By.xpath(Obj_locatorsProp.getProperty("WE_submitbutton")));
		WE_submitbutton.click();

		//Verify response msg
		WebElement WE_successMsg = driver.findElement(By.xpath(Obj_locatorsProp.getProperty("WE_successMsg")));
		return WE_successMsg.getText();
	}

}
