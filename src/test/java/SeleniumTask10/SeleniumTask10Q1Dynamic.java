package SeleniumTask10;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class SeleniumTask10Q1Dynamic
{
	public static void main(String[] args)
	{
		WebDriver driver = new EdgeDriver();
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		String targetdate="22";
		//switch to frame since its a class name storing it in webelement
		WebElement framevalue=driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(framevalue);
		
		//call method
		selectedDate(driver,targetdate);
		String fdate=driver.findElement(By.id("datepicker")).getAttribute("value");
		System.out.println(fdate);
		driver.quit();
		
		
	}

	private static void selectedDate(WebDriver driver, String targetdate) 
	{
		driver.findElement(By.id("datepicker")).click();
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		driver.findElement(By.xpath("//a[text()='"+targetdate+"']")).click();
		
	}

}
