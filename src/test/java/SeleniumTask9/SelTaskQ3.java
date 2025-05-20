package SeleniumTask9;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelTaskQ3 
{
	public static void main(String[] args) 
	{
		//1.Launch the browser
		WebDriver driver=new ChromeDriver();
		
		//2.navigate
		driver.navigate().to("https://www.wikipedia.org/");
		
		//3.maximize the browser window
		driver.manage().window().maximize();
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		
		//4.search for the query a
		driver.findElement(By.name("search")).sendKeys("Artificial Intelligence"+Keys.ENTER);		
		
		//5.clicks on history
       // driver.findElement(By.linkText("History")).click();
        
		driver.findElement(By.xpath("//span[text()='History']")).click();
		//driver.findElement(By.id("toc-History-sublist")).click();
        
		//6.print the title
		WebElement Title =driver.findElement(By.id("History"));
        System.out.println("Section Title: " + Title.getText());
        
        //7.close the browser
        driver.close();
	}


}
