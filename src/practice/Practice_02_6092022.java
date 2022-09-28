package practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Practice_02_6092022 {
	public static void main(String[] args) {
	
	System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	WebDriverWait wait = new WebDriverWait(driver,10);
	
	driver.findElement(By.cssSelector("#autocomplete")).sendKeys("ind");
	wait.until(ExpectedConditions.elementToBeClickable(By.linkText("India")));
	Actions act = new Actions(driver);
	act.moveToElement(driver.findElement(By.linkText("India"))).build().perform();
	driver.findElement(By.linkText("India")).click();
	
	String text = driver.findElement(By.cssSelector("#autocomplete")).getText();
	System.out.println(text);
	
	}
	
}
