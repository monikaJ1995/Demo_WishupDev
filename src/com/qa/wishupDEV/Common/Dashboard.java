package com.qa.wishupDEV.Common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.wishupDEV.utilitySimple.Login;
import com.qa.wishupDEV.utilitySimple.TestBase;

public class Dashboard extends TestBase {

	@BeforeClass
	public void setup()
	{
		launch();
	}
	@BeforeMethod
	public void login() throws InterruptedException
	{
		Login.login();

		//Click on back to dashboard button
		WebElement WE_backToDashboard = driver.findElement(By.xpath("//a[@class='ui fluid basic button']"));
		WE_backToDashboard.click();
	}

	@Test(enabled=false)
	public void verifyCreateATask() throws InterruptedException
	{
		System.out.println("On dashboard");
		//Click on Add a task button
		WebElement WE_addATask = driver.findElement(By.xpath("//a[contains(@class,'create_task_button')]"));
		WE_addATask.click();
		Thread.sleep(1000);

		//Enter task name
		WebElement WE_taskName = driver.findElement(By.xpath("//div[@class='ui computer tablet only grid']//input[contains(@name,'name')]"));
		WE_taskName.sendKeys("task1");
		Thread.sleep(1000);

		//Enter task description
		WebElement WE_description = driver.findElement(By.xpath("//trix-editor[@input='task_details']"));
		WE_description.sendKeys("This is task created for Demo testing");
		Thread.sleep(1000);

		//Select resource for assignment
		WebElement WE_selectResource = driver.findElement(By.xpath("(//div[@class='ui computer tablet only grid']//div[contains(text(),'mj')])"));
		WE_selectResource.click();
		Thread.sleep(1000);

		//Click on create task button
		WebElement WE_createTaskBtn = driver.findElement(By.xpath("//div[@class='ui computer tablet only grid']//button[text()=' Create this task']"));
		WE_createTaskBtn.click();
		Thread.sleep(1000);

		//Select Category
		WebElement WE_selectCat = driver.findElement(By.xpath("(//input[@class='search'])"));
		WE_selectCat.sendKeys("Administration");
		Thread.sleep(1000);

		//Enter steps to do tas
		WebElement WE_stepsBox = driver.findElement(By.tagName("trix-editor"));
		WE_stepsBox.sendKeys("Task for Demo");

		//Enter steps to do tas
		WebElement WE_saveDetails = driver.findElement(By.xpath("//div[@class='ui computer tablet only grid']//button[@type='submit']"));
		WE_saveDetails.click();

		Assert.assertEquals(driver.getCurrentUrl(), "https://app-dev.wishup.co/org/90014/my_tasks");
	}

	@Test(enabled=true)
	public void verifyGenerateWeeklyReport() throws InterruptedException
	{

		System.out.println("On dashboard");
		//Click on Add a task button
		WebElement WE_dashboard = driver.findElement(By.xpath("//span[text()='Dashboard']"));
		WE_dashboard.click();
		Thread.sleep(1000);

		WebElement WE_msg = driver.findElement(By.xpath("//strong/preceding::span[contains(text(),'Total time spent this week')]"));
		Assert.assertEquals(WE_msg.getText(), "");
		System.out.println("Assert pass");

	}

	@Test(enabled=false)
	public void verifyGiveFeedback() throws InterruptedException
	{

		System.out.println("On dashboard");
		//Click on Feedback 
		WebElement WE_feedback = driver.findElement(By.xpath("//span[text()='Feedback']"));
		WE_feedback.click();
		Thread.sleep(1000);

		//Click on create feedback button
		WebElement WE_createFB = driver.findElement(By.xpath("(//div[contains(@class,'ui workspace')]//a[normalize-space()='Create a feedback'])"));
		WE_createFB.click();
		Thread.sleep(1000);


		//Enter give feedback
		WebElement WE_giveFeedback = driver.findElement(By.xpath("(//span[contains(text(),'Give feedback')])[6]"));
		WE_giveFeedback.click();
		Thread.sleep(1000);

		//Select from date
		WebElement WE_fromdate= driver.findElement(By.cssSelector("div[id='slot_start_date'] input"));
		WE_fromdate.sendKeys("August 1, 2022");

		//Select to date
		WebElement WE_todate= driver.findElement(By.cssSelector("div[id='slot_end_date'] input"));
		WE_todate.sendKeys("August 8, 2022");

		//select 5star rating
		WebElement WE_star= driver.findElement(By.xpath("(//i[@class='star icon'])[3]"));
		WE_star.click();

		//Send the feedback
		WebElement WE_msg = driver.findElement(By.name("message"));
		WE_msg.sendKeys("Great Work!!");

		//Submit Feedback click
		WebElement WE_submitbutton= driver.findElement(By.xpath("//div[@type='submit']"));
		WE_submitbutton.click();

		WebElement WE_successMsg = driver.findElement(By.xpath("//div[text()='Feedback recorded successfully']"));
		Assert.assertEquals(WE_successMsg.getText(), "Feedback recorded successfully");

	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}



}
