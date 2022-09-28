package com.qa.wishupDEV.utilitySimple;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.qa.wishupDEV.utilitySimple.TestBase;

public class Login extends TestBase {

	public static void login()
	{
		//Click on login 
		WebElement WE_logInBtn = driver.findElement(By.xpath("//div[@class='right menu']//a[text()='Login']"));    //      //a[text()='Login']
		WE_logInBtn.click();

		//Enter valid email
		WebElement WE_emailField = driver.findElement(By.id("email"));   ////input[@id='email']
		WE_emailField.sendKeys(Obj_configProp.getProperty("userName")); //monikasjadhav8395@gmail.com

		//Enter valid Password
		WebElement WE_passwordField = driver.findElement(By.xpath("//input[@type='password']"));
		WE_passwordField.sendKeys(Obj_configProp.getProperty("pwd"));  //#MonikaJ


		//Click on logIn button
		WebElement WE_logInSubmit = driver.findElement(By.xpath("//input[@type='submit']"));
		WE_logInSubmit.click();
	}
	

}
