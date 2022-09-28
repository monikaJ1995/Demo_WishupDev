package com.qa.wishupDEV.utilitySimple;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
		public static WebDriver driver;
		public static Properties Obj_configProp = PropertiesConfigUtility.configprop("config") ;
		public static Properties Obj_locatorsProp = PropertiesConfigUtility.configprop("locators");
		public static void launch()
		{
			System.setProperty(Obj_configProp.getProperty("key"), Obj_configProp.getProperty("chrome"));
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(Obj_configProp.getProperty("url"));
		}
	public static void main(String[] args) {
		new TestBase();
		launch();
		driver.quit();
	}
}
