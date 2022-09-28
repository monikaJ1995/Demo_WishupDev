package practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Practice_01_6092022 {
	public static void main(String[] args) {
	
	System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	WebDriverWait wait = new WebDriverWait(driver,5);
	
//	driver.findElement(By.xpath("//div[contains(@class,'nav-outer')]//a[text()='Practice']")).click();
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,600)");
	
	List<WebElement> rowsInTable = driver.findElements(By.cssSelector(".table-display tr"));
	int rowCount = rowsInTable.size();
	System.out.println("Total Number of rows are: "+rowCount);
	
	List<WebElement> columnsInTable = driver.findElements(By.cssSelector(".table-display tr th"));
	int columnCount = columnsInTable.size();
	System.out.println("Total Number of rows are: "+columnCount);
	
	String content = driver.findElement(By.cssSelector(".table-display tr:nth-child(3)")).getText();
	System.out.println(content);
	
	}
	
}
