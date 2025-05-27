package SeleniumTask11;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class SeleniumTask11Q1 
{
	public static void main(String[] args) 
	{
		//1.Launching the browser
		WebDriver driver=new EdgeDriver();
		
		//2.opening the url
		driver.get("https://the-internet.herokuapp.com/windows");
		
		//3.maximizing the window
		driver.manage().window().maximize();
		
		//4.add implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		String titleofmainpage=driver.getTitle();
		System.out.println("Title of main page is "+titleofmainpage);
		
		//5.storing main window
		String mainwindow=driver.getWindowHandle();
		
		//6.Clicking
		driver.findElement(By.xpath("//a[text()='Click Here']")).click();
		
		//7.Getting all windows using getwindowhandles and using for each to switch
		Set<String> allwindows=driver.getWindowHandles();
		
		for(String wind:allwindows)
		{
			if(!wind.equals(mainwindow))
			{
				driver.switchTo().window(wind);
				break;
			}
		}		
		System.out.println("New page title is: "+driver.getTitle());
		String newpagetitle=driver.findElement(By.xpath("//h3[text()='New Window']")).getText();
		String Expectednewpage="New Window";
		if(newpagetitle.equals(Expectednewpage))
		{
			System.out.println("Verified New window text is present");
		}
		else
		{
			System.out.println("Failed to verify new window text");
		}
		
		driver.close();
		driver.switchTo().window(mainwindow);

		//verifying parent window is still on
		String backtoparent =driver.getTitle();
		String orgparent="The Internet";
		if(backtoparent.equals(orgparent))
		{
			System.out.println("Parent window is active and title is "+driver.getTitle());
		}
		else
		{
			System.out.println("Parent window is not active "+driver.getTitle());
		}
		
		//closing the browser instance
		driver.quit();
	}

}
