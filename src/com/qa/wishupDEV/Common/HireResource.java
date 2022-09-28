package com.qa.wishupDEV.Common;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.pageLayerSimple.LoginPage;
import com.qa.wishupDEV.utilitySimple.Login;
import com.qa.wishupDEV.utilitySimple.TestBase;

public class HireResource extends TestBase {

	@BeforeClass
	public void setup()
	{
		launch();
	}

	@BeforeMethod
	public void logIn() throws InterruptedException
	{
		//login to application
		Login.login();
	}

	@Test(enabled=false)
	public void verifyNumberOfVAs_addtoCart() throws InterruptedException
	{
		//Click on virtual assistant category
		WebElement WE_VA_Category = driver.findElement(By.xpath("//span[text()='virtual assistant']"));
		WE_VA_Category.click();

		//Find number of profiles available 
		List<WebElement> WEList_VA_Qty = driver.findElements(By.partialLinkText("Profile"));
		Assert.assertEquals(WEList_VA_Qty.size(), 21);

		WebElement WE_slider = driver.findElement(By.className("slider"));
		Actions Obj_Action = new Actions(driver);
		Obj_Action.dragAndDropBy(WE_slider, 4, 0).perform();

		/*----------Select a Resource from VA category who is available for 4 hours a day---------*/
		List<WebElement> WEList_availableHrs = driver.findElements(By.xpath("//div[@class='flex']/child::div[@class='appeal']"));
		/*problem:   clicks on 1st view profile button*/
		for (WebElement WE_hrs:WEList_availableHrs)
		{
			if(WE_hrs.getText().equals("4"))
			{
				WebElement WE_viewProfile = driver.findElement(By.partialLinkText("View Profile"));
				WE_viewProfile.click();
				break;
			}
		}

		/*-----------Verify that the resource has MSOffice in his tools Expertise 
		 * and CRM in technical skills-------------------------------*/

		WebElement WE_toolExp = driver.findElement(By.xpath("//span[text()='Tool Expertise']"));
		WE_toolExp.click();

		WebElement WE_tools = driver.findElement(By.xpath("//div[@class='top-tools tool-names']"));
		Assert.assertFalse(WE_tools.getText().contains("MS Office"));
		System.out.println("Tools verification done");
		
		WebElement WE_techSkills = driver.findElement(By.xpath("//span[text()='Technical Skills']"));
		WE_techSkills.click();
		Thread.sleep(1000);

		WebElement WE_viewSkills = driver.findElement(By.xpath("//div[contains(text(),'View all skills')]"));
		WE_viewSkills.click();
		Thread.sleep(2000);
		WebElement WE_skillSet = driver.findElement(By.xpath("//div[@class='more-skills']"));
		Assert.assertFalse(WE_skillSet.getText().contains("CRM"));
		System.out.println("Tech skills verification done");
		Thread.sleep(1000);

		/*Hire resource*/
		//Click on Hire me button
		WebElement WE_hireMeBtn = driver.findElement(By.xpath("//a[@class='hire-me-button']"));
		WE_hireMeBtn.click();
		Thread.sleep(1000);

		//Click on toggle button for quarterly plan
		WebElement WE_quarterlyPlanToggle = driver.findElement(By.id("toggler"));
		WE_quarterlyPlanToggle.click();
		Thread.sleep(1000);

		//Click on select this plan under half day section
		WebElement WE_selectThisPlan = driver.findElement(By.xpath("//div[@class='select-popular-button']/a[@class='half-url']"));  //   //section[@id='laptop-display']//div[normalize-space()='Half Day']
		WE_selectThisPlan.click();
		Thread.sleep(1000);

		//Click on go to cart
		WebElement WE_successMsg1 = driver.findElement(By.xpath("//div[@id='confirm-redirect']//h3")); //          //h3[text()='Plan is added to the cart!']
		if(WE_successMsg1.getText().equals("Plan is added to the cart!"))
		{
			WebElement WE_goToCart = driver.findElement(By.xpath("//button[contains(text(),'Go to cart')]"));
			WE_goToCart.click();
			Assert.assertTrue(driver.getCurrentUrl().equals("https://app-dev.wishup.co/cart"));
		}
		else
		{
			WebElement WE_alreadyAdded_Ok = driver.findElement(By.xpath("//button[contains(text(),'Ok')]"));
			WE_alreadyAdded_Ok.click();
			Assert.assertTrue(driver.getCurrentUrl().equals("https://app-dev.wishup.co/hire"));
			System.out.println("assert success for already added item");
		}

	}

	@Test(enabled=true)
	public void verifyHireResourceFromCart() throws InterruptedException
	{
		//Click on add to cart
		WebElement WE_cart = driver.findElement(By.xpath("//a[@class='cart-icon']"));
		WE_cart.click();

		//verify amount
		WebElement WE_termsOfUse = driver.findElement(By.xpath("//input[@type='checkbox']/following::label[text()='I agree to the ']"));
		JavascriptExecutor Obj_js =(JavascriptExecutor)driver;
		Obj_js.executeScript("arguments[0].click();", WE_termsOfUse);
		Thread.sleep(1000);

		WebElement WE_proceedToPay = driver.findElement(By.xpath("//input[@type='submit']"));
		WE_proceedToPay.click();

		WebElement WE_paymentMode_Razorpay = driver.findElement(By.xpath("//button[text()='Pay via Razorpay']"));
		WE_paymentMode_Razorpay.click();
		
		driver.switchTo().frame(0);
		WebElement WE_email = driver.findElement(By.xpath("//input[@id='email']"));
		WE_email.sendKeys("monika.jadhav@wishup.co");

		WebElement WE_payUsingCard = driver.findElement(By.xpath("//div[@role='button']"));
		WE_payUsingCard.click();

		WebElement WE_card = driver.findElement(By.xpath("//button[@method='card']"));
		WE_card.click();

		WebElement WE_cardNo = driver.findElement(By.id("card_number"));
		WE_cardNo.sendKeys("4242 4242 4242 4242");

		WebElement WE_expiry = driver.findElement(By.id("card_expiry"));
		WE_expiry.sendKeys("424");

		WebElement WE_cvv = driver.findElement(By.id("card_cvv"));
		WE_cvv.sendKeys("424");

		WebElement WE_pay = driver.findElement(By.xpath("//div[@role='button']"));
		WE_pay.click();
		
		String Str_parentWindowID = driver.getWindowHandle();
		Set<String> SetStr_windowhandles = driver.getWindowHandles();
		for(String childwdw : SetStr_windowhandles)
		{
			if(!childwdw.equals(Str_parentWindowID))
			{
				driver.switchTo().window(childwdw);
				WebElement WE_success = driver.findElement(By.xpath("//button[text()='Success']"));
				WE_success.click();
				driver.switchTo().window(Str_parentWindowID);
			}		
		}
		WebElement WE_payStatus = driver.findElement(By.xpath("//div[text()='Paid']"));
		Assert.assertEquals(WE_payStatus.getText(), "Paid");

	}

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
