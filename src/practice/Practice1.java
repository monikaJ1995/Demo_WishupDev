package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Practice1 {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.findElement(By.xpath("//div[@class='form-group']/input[@name='name']")).sendKeys("Monika");
		driver.findElement(By.cssSelector("input[name*='email']")).sendKeys("monikajadhav3505@gmail.com");
		driver.findElement(By.cssSelector("#exampleInputPassword1")).sendKeys("M0nika");
		driver.findElement(By.cssSelector("#exampleCheck1")).click();
		driver.findElement(By.cssSelector("#exampleFormControlSelect1")).click();
		Select options = new Select(driver.findElement(By.cssSelector("#exampleFormControlSelect1")));
		options.selectByVisibleText("Female");
		driver.findElement(By.cssSelector("#inlineRadio2")).click();
		driver.findElement(By.cssSelector("input[type*='date']")).sendKeys("08-03-1995");
		driver.findElement(By.cssSelector("input[type*='submit']")).click();
		System.out.println(driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText());
		driver.quit();
		
		
		
		
	}

}
