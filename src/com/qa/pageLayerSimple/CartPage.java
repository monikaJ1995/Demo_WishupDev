package com.qa.pageLayerSimple;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.qa.wishupDEV.utilitySimple.TestBase;

public class CartPage extends TestBase {

	public void selectTermsOfUse()
	{
		try {
		//click on terms of use
		WebElement WE_termsOfUse = driver.findElement(By.xpath(Obj_locatorsProp.getProperty("WE_termsOfUse")));
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
		WebElement WE_proceedToPay = driver.findElement(By.xpath(Obj_locatorsProp.getProperty("WE_proceedToPay")));
		WE_proceedToPay.click();
	}
	public void selectPaymentMode()
	{
		//Select payment mode
		WebElement WE_paymentMode_Razorpay = driver.findElement(By.xpath(Obj_locatorsProp.getProperty("WE_paymentMode_Razorpay")));
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
		WebElement WE_email = driver.findElement(By.xpath(Obj_locatorsProp.getProperty("WE_emailCart")));
		WE_email.sendKeys("monika.jadhav@wishup.co");

		//Click on pay button
		WebElement WE_payUsingCard = driver.findElement(By.xpath(Obj_locatorsProp.getProperty("WE_payUsingCard")));
		WE_payUsingCard.click();

		//Select card for payment
		WebElement WE_card = driver.findElement(By.xpath(Obj_locatorsProp.getProperty("WE_card")));
		WE_card.click();

		//Enter card number
		WebElement WE_cardNo = driver.findElement(By.id(Obj_locatorsProp.getProperty("WE_cardNo")));
		WE_cardNo.sendKeys("4242 4242 4242 4242");

		//Enter expiry date
		WebElement WE_expiry = driver.findElement(By.id(Obj_locatorsProp.getProperty("WE_expiry")));
		WE_expiry.sendKeys("424");

		//Enter cvv
		WebElement WE_cvv = driver.findElement(By.id(Obj_locatorsProp.getProperty("WE_cvv")));
		WE_cvv.sendKeys("424");
	}
	
	public String completeThePayment()
	{
		//Click on pay button
		WebElement WE_pay = driver.findElement(By.xpath(Obj_locatorsProp.getProperty("WE_pay")));
		WE_pay.click();
		
		//Click on success for payment confirmation
		String Str_parentWindowID = driver.getWindowHandle();
		Set<String> SetStr_windowhandles = driver.getWindowHandles();
		for(String childwdw : SetStr_windowhandles)
		{
			if(!childwdw.equals(Str_parentWindowID))
			{
				driver.switchTo().window(childwdw);
				WebElement WE_success = driver.findElement(By.xpath(Obj_locatorsProp.getProperty("WE_success")));
				WE_success.click();
				driver.switchTo().window(Str_parentWindowID);
			}		
		}
		
		//Verify payment status
		WebElement WE_payStatus = driver.findElement(By.xpath(Obj_locatorsProp.getProperty("WE_payStatus")));
		String Str_payStatus = WE_payStatus.getText();
		return Str_payStatus;

	}

}
