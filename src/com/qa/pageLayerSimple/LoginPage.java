package com.qa.pageLayerSimple;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.qa.wishupDEV.utilitySimple.PropertiesConfigUtility;
import com.qa.wishupDEV.utilitySimple.TestBase;

public class LoginPage extends TestBase {
	public void login()
	{
		//Click on login 
		WebElement WE_logInBtn = driver.findElement(By.xpath(Obj_locatorsProp.getProperty("WE_logInBtn")));    //      //a[text()='Login']
		WE_logInBtn.click();

		//Enter valid email
		WebElement WE_emailField = driver.findElement(By.id(Obj_locatorsProp.getProperty("WE_emailField")));   ////input[@id='email']
		WE_emailField.sendKeys(Obj_configProp.getProperty("userName")); //monikasjadhav8395@gmail.com

		//Enter valid Password
		WebElement WE_passwordField = driver.findElement(By.xpath(Obj_locatorsProp.getProperty("WE_passwordField")));
		WE_passwordField.sendKeys(Obj_configProp.getProperty("pwd"));  //#MonikaJ


		//Click on logIn button
		WebElement WE_logInSubmit = driver.findElement(By.xpath(Obj_locatorsProp.getProperty("WE_logInSubmit")));
		WE_logInSubmit.click();
	}
	public String verifySuceessfulLogin()
	{
		//Fetch User name & validate expected & Actual for suceessful signIn
		WebElement WE_userName = driver.findElement(By.xpath(Obj_locatorsProp.getProperty("WE_userName")));      //div[contains(text(),'Sanket')]
		String Str_UserName = WE_userName.getText();
		return Str_UserName;
	}
	
}
