package SeleniumTask10;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class SeleniumTask10Q2 
{
	public static void main(String[] args) 
	{
		//1.Launching the browser
		WebDriver driver=new EdgeDriver();
		
		//2.opening the url
		driver.get("https://jqueryui.com/droppable/");
		
		//3.maximizing the window
		driver.manage().window().maximize();
		
		//4.implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//5.switching to frame since source and target are inside frame
		driver.switchTo().frame(0);
		
		//6storing source and target in webelement so that we can pass in action drag and drop method
		WebElement source=driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement target=driver.findElement(By.xpath("//div[@id='droppable']"));
		
		//7.To perform drag and drop we are using action class
		Actions action=new Actions(driver);
		
		//8.Using drag and drop method with action obj and perform is mandatory
		action.dragAndDrop(source,target).perform();
		
		//9.Getting target element using gettext method
		String ftext=driver.findElement(By.xpath("//p[text()='Dropped!']")).getText();
		String actualtext="Dropped!";
		
		//10.comparing actual and target element text
		if(ftext.equalsIgnoreCase(actualtext))
		{
			System.out.println("Pass !Text changed to Dropped"+ftext);
		}
		else
		{
			System.out.println("Fail!Text hasnt changed"+ftext);
		}
		//11.Checking background color  using css,background returns all details of background we need only colr so using background-color
		String bgcolor=target.getCssValue("background-color");
		System.out.println(bgcolor);
		
		//12.validating with expected color using rgba value
		String Expectedbg="rgba(255, 250, 144, 1)";
		if(Expectedbg.equals(bgcolor))
		{
			System.out.println("background color matched");
		}
		else
		{
			System.out.println("Background colr is not match");
		}
		
		//13.closing the browser
		driver.close();
		
	}

}
