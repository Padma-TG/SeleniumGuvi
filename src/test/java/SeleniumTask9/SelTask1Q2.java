package SeleniumTask9;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelTask1Q2 
{

	public static void main(String[] args) 
	{
		//1.Launch the browser
		WebDriver driver=new ChromeDriver();
		
		//2.navigates to https://www.demoblaze.com/
		//driver.get("https://www.demoblaze.com/");
		driver.navigate().to("https://www.demoblaze.com/");
		
		
		//3.maximize the window
		driver.manage().window().maximize();
		
		//4.get title
		String titleget=driver.getTitle();
		
		String actualtitle="STORE";
		if(actualtitle.equals(titleget))
		{
			System.out.println("Page landed on correct website");
		}
		else
		{
			System.out.println("Page not landed on correct website");
		}
		
		//5.close
		driver.close();
	}

}
