package com.qa.pageLayer_ForPOM;

import java.util.Properties;

import org.openqa.selenium.By;
import com.qa.wishupDEV.utility.PropertiesConfigUtility;
import com.qa.wishupDEV.utility.TestBase;

public class LoginPage extends TestBase {
	Properties Obj_configProp = PropertiesConfigUtility.configprop("config");
	By By_emailField = By.id("email");
	By By_passwordField = By.xpath("//input[@type='password']");
	By By_logInSubmit = By.xpath("//input[@type='submit']");
	//By WE_userName = By.xpath("//div[@class='right menu']/div[@class='ui simple dropdown item']");

	public String login(String Str_email, String Str_pwd)
	{
			
		//Enter valid email in the field
		driver.findElement(By_emailField).sendKeys(Str_email); //monikasjadhav8395@gmail.com
		
		//Enter valid Password in the field
		driver.findElement(By_passwordField).sendKeys(Str_pwd);  //#MonikaJ
	
		//Click on logIn button 
		driver.findElement(By_logInSubmit).click();
		
		String Str_currentURLAfterLogin = driver.getCurrentUrl();
		return Str_currentURLAfterLogin;
	}
	

}
