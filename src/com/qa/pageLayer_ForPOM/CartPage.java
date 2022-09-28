package com.qa.pageLayer_ForPOM;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.qa.wishupDEV.utility.TestBase;

public class CartPage extends TestBase {
	
	@FindBy(xpath = "//input[@type='checkbox']/following::label[text()='I agree to the ']")
	WebElement WE_termsOfUse;
	@FindBy(xpath = "//input[@type='submit']")
	WebElement WE_proceedToPay;
	@FindBy(xpath = "//button[text()='Pay via Razorpay']")
	WebElement WE_paymentMode_Razorpay;
	@FindBy(xpath = "//input[@id='email']")
	WebElement WE_emailCart;
	@FindBy(xpath = "//div[@role='button']")
	WebElement WE_payUsingCard;
	@FindBy(xpath = "//button[@method='card']")
	WebElement WE_card;
	@FindBy(id = "card_number")
	WebElement WE_cardNo;
	@FindBy(id = "card_expiry")
	WebElement WE_expiry;
	@FindBy(id = "card_cvv")
	WebElement WE_cvv;
	@FindBy(xpath = "//div[@role='button']")
	WebElement WE_pay;
	@FindBy(xpath = "//button[text()='Success']")
	WebElement WE_success;
	@FindBy(xpath = "//div[@class='ui olive small top right attached label']")
	WebElement WE_payStatus;
	
	public CartPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void selectTermsOfUse()
	{
		try {
			//click on terms of use
			JavascriptExecutor Obj_js =(JavascriptExecutor)driver;
			Obj_js.executeScript("arguments[0].click();", WE_termsOfUse);
			Thread.sleep(1000);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	public void proceedToPay()
	{
		//Click on proceed to pay button
		WE_proceedToPay.click();
	}
	public void selectPaymentMode()
	{
		//Select payment mode
		WE_paymentMode_Razorpay.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void enterCardDetails()
	{
		//Enter email
		driver.switchTo().frame(0);
		WE_emailCart.sendKeys("monika.jadhav@wishup.co");
		
		//Click on pay button
		WE_payUsingCard.click();

		//Select card for payment
		WE_card.click();

		//Enter card number
		WE_cardNo.sendKeys("4242 4242 4242 4242");

		//Enter expiry date
		WE_expiry.sendKeys("424");

		//Enter cvv
		WE_cvv.sendKeys("424");
	}

	public String completeThePayment()
	{
		//Click on pay button
		WE_pay.click();

		//Click on success for payment confirmation
		String Str_parentWindowID = driver.getWindowHandle();
		Set<String> SetStr_windowhandles = driver.getWindowHandles();
		for(String childwdw : SetStr_windowhandles)
		{
			if(!childwdw.equals(Str_parentWindowID))
			{
				driver.switchTo().window(childwdw);
				WE_success.click();
				driver.switchTo().window(Str_parentWindowID);
			}		
		}

		//Verify payment status
		String Str_payStatus = WE_payStatus.getText();
		return Str_payStatus;

	}

}
