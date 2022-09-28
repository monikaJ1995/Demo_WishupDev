package practice;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.wishupDEV.utilitySimple.PropertiesConfigUtility;

public class CartPopUp {
	static WebDriver driver;
	public static Properties Obj_configProp = PropertiesConfigUtility.configprop("config") ;
	public static Properties Obj_locatorsProp = PropertiesConfigUtility.configprop("locators");
	
	public static void main(String[]args) throws InterruptedException
	{
		System.setProperty(Obj_configProp.getProperty("key"), Obj_configProp.getProperty("chrome"));
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://app-dev.wishup.co/estimate/90102/new_user_pay?sub_id=undefined&va_id=undefined");
		
		Thread.sleep(1000);
//		Click on Pay via razorpay
		driver.findElement(By.xpath("//button[contains(text(),'Razorpay')]")).click();
		
		//enter email
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("monika@123.com");
		Thread.sleep(1000);
		
		driver.quit();
	}
}
