package com.qa.wishupDEV.Common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.wishupDEV.utilitySimple.TestBase;

public class SignUpTest extends TestBase{

	@BeforeMethod
	public void setup()
	{
		launch();
	}

	@Test(priority=1, enabled=true)
	public void verifySignUp() throws InterruptedException {

		//Click on signup 
		WebElement signUpBtn = driver.findElement(By.xpath("//div[@class='right menu']//a[text()='Signup']"));
		signUpBtn.click();
		Thread.sleep(2000);

		//Enter User name
		WebElement userNameField = driver.findElement(By.xpath("//input[@name='name']"));
		userNameField.sendKeys("Monika J");

		//Enter email
		WebElement emailField = driver.findElement(By.xpath("//input[@name='email']"));
		emailField.sendKeys("monika.jadhav@wishup.co");
		Thread.sleep(1000);

		//Verify Captcha
		driver.switchTo().frame(0);
		WebElement captcha = driver.findElement(By.xpath("//span[@role='checkbox']"));
		captcha.click();
		Thread.sleep(3000);
		driver.switchTo().defaultContent();

		//Click on create account
		WebElement createAccount = driver.findElement(By.xpath("//input[@type='submit']"));
		createAccount.click();
		Thread.sleep(1000);

		//Verify error msg for failure
		WebElement verificationMsg = driver.findElement(By.xpath("//div[@class='ui message']"));
		System.out.println(verificationMsg.getText());
		Assert.assertNotEquals(verificationMsg.getText(), "");

		Thread.sleep(2000);

	}

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
