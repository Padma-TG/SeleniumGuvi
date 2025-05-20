package SeleniumTask9;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelTask1Q1 
{

	public static void main(String[] args) 
	{
		//1.Launch the browser
		WebDriver driver = new FirefoxDriver();
		
		
		//2.maximizing the window
		driver.manage().window().maximize();
		
		//3.Load the url
		driver.get("http://google.com");
		
		//4.prints the url of currentpage
		String pagecurrenturl = driver.getCurrentUrl();
		System.out.println("current "+pagecurrenturl);
		
		//to get the title
		String title=driver.getTitle();
		System.out.println("title " +title);
		
		//5.reloads the page
		driver.navigate().refresh();
		
		//6.close the browser
		driver.close();
		
		
		
		
		
	}

}
