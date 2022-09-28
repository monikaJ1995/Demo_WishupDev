package com.qa.pageLayer_ForPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.qa.wishupDEV.utility.TestBase;

public class WeeklyReportPage extends TestBase {
	By WE_WeeklyReportmsg = By.xpath("//strong/preceding::span[contains(text(),'Total time spent this week')]");

	public String generatePreviousWeekReport()
	{
		//verify the weekly report generated
		String Str_msg = driver.findElement(WE_WeeklyReportmsg).getText();
		return Str_msg;
	}	
}
