package com.qa.wishupDEV.Common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.wishupDEV.utilitySimple.TestBase;

public class LoginTest extends TestBase{

	@BeforeMethod()
	public void setup()
	{
		//Launch URL
		launch();
	}
	@Test(priority=1, enabled=true)
	public void verifyLogInWithValidCredential() throws InterruptedException
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
		Thread.sleep(1000);
		
		//Click on logIn button
		WebElement WE_logInSubmit = driver.findElement(By.xpath("//input[@type='submit']"));
		WE_logInSubmit.click();
		Thread.sleep(2000);

		//Fetch Username & validate expected & Actual for suceessful signIn
		WebElement WE_userName = driver.findElement(By.xpath("//div[@class='right menu']/div[@class='ui simple dropdown item']"));      //div[contains(text(),'Sanket')]
		Assert.assertEquals(WE_userName.getText(), "mj");

		//Click on Username to get Logout option
		WE_userName.click();
		Thread.sleep(1000);

		//Signout from application
		WebElement WE_logOut = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
		WE_logOut.click();				
	}
	@Test(priority=2,enabled=false)
	public void verifySignInWithInvalidCredential() throws InterruptedException
	{
		//Click on signin 
		WebElement WE_logInBtn = driver.findElement(By.xpath("//div[@class='right menu']//a[text()='Login']"));    //      //a[text()='Login']
		WE_logInBtn.click();

		//Enter invalid email
		WebElement WE_emailField = driver.findElement(By.id("email"));   ////input[@id='email']
		WE_emailField.sendKeys("monikasjadhav895@gmail.com");

		//Enter valid Password
		WebElement WE_passwordField = driver.findElement(By.xpath("//input[@type='password']"));
		WE_passwordField.sendKeys("123456");
		Thread.sleep(1000);
		
		//Click on logIn button
		WebElement WE_logInSubmit = driver.findElement(By.xpath("//input[@type='submit']"));
		WE_logInSubmit.click();
		Thread.sleep(1000);

		
		//Validate Failure in login with error msg
		WebElement WE_errorMsg = driver.findElement(By.xpath("//p[contains(text(),'Account does not exist.')]"));
		System.out.println(WE_errorMsg.getText());
		Assert.assertEquals(WE_errorMsg.getText(), "Account does not exist. Click here to signup");
	}

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
