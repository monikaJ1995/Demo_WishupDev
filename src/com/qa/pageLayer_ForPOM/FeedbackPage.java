package com.qa.pageLayer_ForPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.qa.wishupDEV.utility.TestBase;

public class FeedbackPage extends TestBase {
	By WE_createFB = By.xpath("(//div[contains(@class,'ui workspace')]//a[normalize-space()='Create a feedback'])");
	By WE_giveFeedback = By.xpath("//div[@class=\"ui client_dashboard computer only grid\"]/div[@class='ui thirteen wide column']/descendant::div/b[contains(text(),'Priyanka')]/ancestor::div[@class='name']/following-sibling::a");
	By WE_fromdate = By.xpath("div[id='slot_start_date'] input");
	By WE_todate = By.xpath("div[id='slot_end_date'] input");
	By WE_star = By.xpath("(//i[@class='star icon'])[3]");
	By WE_msg = By.name("message");
	By WE_submitbutton = By.xpath("//div[@type='submit']");
	By WE_responseMsg = By.xpath("//div[text()='Feedback recorded successfully']");
	
	public void createFeedback()
	{
		//Click on create feedback button
		try {
			driver.findElement(WE_createFB).click();
			Thread.sleep(1000);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	public void giveFeedback()
	{
		//Click on give feedback
		try {
			driver.findElement(WE_giveFeedback).click();
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
		driver.findElement(WE_fromdate).sendKeys("August 1, 2022");

		//Select to date
		driver.findElement(WE_todate).sendKeys("August 8, 2022");
	}

	public void giveStarRating()
	{
		//select 5star rating
		driver.findElement(WE_star).click();
	}

	public void enterComments()
	{
		//Enter feedback comments
		driver.findElement(WE_msg).sendKeys("Great Work!!");
	}
	public String submitFeedback()
	{
		//Submit Feedback click
		driver.findElement(WE_submitbutton).click();

		//Verify response msg
		String WE_successMsg = driver.findElement(WE_responseMsg).getText();
		return WE_successMsg;
	}

}
