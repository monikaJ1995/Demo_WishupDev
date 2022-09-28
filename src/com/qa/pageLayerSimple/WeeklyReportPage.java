package com.qa.pageLayerSimple;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.qa.wishupDEV.utilitySimple.TestBase;

public class WeeklyReportPage extends TestBase {

	public String generatePreviousWeekReport()
	{
		//verify the weekly report generated
		WebElement WE_WeeklyReportmsg = driver.findElement(By.xpath(Obj_locatorsProp.getProperty("WE_WeeklyReportmsg")));
		String Str_msg = WE_WeeklyReportmsg.getText();
		return Str_msg;
	}	
}
