package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Practice_01_05092022 {
	public static void main(String[] args) {
	
	System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	WebDriverWait wait = new WebDriverWait(driver,5);
	WebElement checkbox = driver.findElement(By.xpath("//label[@for='benz']"));
	String optionText = checkbox.getText();
	checkbox.click();
	
	System.out.println("Text is "+optionText);
	
	WebElement dropDown = driver.findElement(By.id("dropdown-class-example"));
	Select option = new Select(dropDown);
	option.selectByVisibleText(optionText);
	
	driver.findElement(By.cssSelector("input[name='enter-name']")).sendKeys(optionText);
	driver.findElement(By.id("alertbtn")).click();
	String alertText = driver.switchTo().alert().getText();
	if(alertText.contains(optionText))
	{
		Assert.assertTrue(true);
	}
	driver.quit();
	}
	
}
