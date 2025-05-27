package SeleniumTask10;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class SeleniumTask10Q1static 
{
	public static void main(String[] args)
	{
		//1.Launching the Edgedriver
		WebDriver driver =new EdgeDriver();
		
		//2.maximize the window
		driver.manage().window().maximize();
		
		//3.open url
		//driver.get("https://jqueryui.com/datepicker/");
		
		//4.open url using navigate
		driver.navigate().to("https://jqueryui.com/datepicker/");
		
		//5.impicitwait-It tells the WebDriver to wait for a certain amount of time when trying to find an element before throwing a NoSuchElementException.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//6 i.switching to the frame that contains date picker using index since there is no id or name for direct access
		//driver.switchTo().frame(0);
		
		//6 ii.switching to frame using class name
		//WebElement classname=driver.findElement(By.className("demo-frame"));
		//driver.switchTo().frame(classname);
		
		//6 iii.switching to frame using 
		WebElement pathway=driver.findElement(By.xpath("//iframe[contains(@src,'/resources/demos/')]"));
		driver.switchTo().frame(pathway);
		
		//7.try clicking the textbox of date
		driver.findElement(By.id("datepicker")).click();
		
		//8.selecting next month
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		
		//9.selecting date 22
		driver.findElement(By.xpath("//a[text()='22']")).click();
		
		//10.gettext from textbox to validate
		String fdate=driver.findElement(By.id("datepicker")).getAttribute("value");
		System.out.println(fdate);
		
		//11.close
		driver.close();
		
		//12.quit webdriver instance
		driver.quit();
	}

}
