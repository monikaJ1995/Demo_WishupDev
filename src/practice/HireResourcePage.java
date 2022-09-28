package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.qa.wishupDEV.utilitySimple.TestBase;

public class HireResourcePage extends TestBase {

	public void selectCatergoryForResource(String category)
	{
		//Click on virtual assistant category
		WebElement WE_VA_Category = driver.findElement(By.xpath("//span[text()='"+category+"']"));
		WE_VA_Category.click();
	}
	public List<WebElement> getListOfAvailableProfiles()
	{
		//Find number of profiles available 
		List<WebElement> WEList_availableProfiles = driver.findElements(By.xpath("//section[@class='ui computer only client_dashboard grid va-list-container']//div[@class='appeal']"));
		return WEList_availableProfiles;
	}
	public void setAvailableHrsFilter()
	{
		//Set available hours for 4 hr
		WebElement WE_slider = driver.findElement(By.className("slider"));
		Actions Obj_Action = new Actions(driver);
		Obj_Action.dragAndDropBy(WE_slider, 4, 0).perform();
	}

	public void viewResourceProfile(int Int_viewProfileIndex)
	{
		WebElement WE_viewProfile = driver.findElement(By.xpath("(//section[@class='ui computer only client_dashboard grid va-list-container']//button[@class='profile-button'])["+Int_viewProfileIndex+"]"));
		WE_viewProfile.click();
	}

	public String goToCart()
	{
		//Click on add to cart
		WebElement WE_cart = driver.findElement(By.xpath("//a[@class='cart-icon']"));
		WE_cart.click();
		WebElement warnMsg = driver.findElement(By.xpath("//div[@class='ui warning message']"));
		String Str_warnigMsg = warnMsg.getText();
		return Str_warnigMsg;
	}
	public void backToDashboard()
	{
		//Click on back to dashboard button
		WebElement WE_backToDashboard = driver.findElement(By.xpath("//a[@class='ui fluid basic button']"));
		WE_backToDashboard.click();
	}

}
