package SeleniumTask10;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumTask10Q3 
{
	public static void main(String[] args) 
	{
		//1.Launching webdriver
		WebDriver driver =new EdgeDriver();
		
		//2.opening the url
		driver.get("https://www.guvi.in/");
		
		//3.maximizing the window
		driver.manage().window().maximize();
		
		//4.implicit wait to avoid no such exception
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//5.Locating sign up button using xpath
		driver.findElement(By.xpath("//a[text()='Sign up']")).click();
		
		//6.registering the details
		driver.findElement(By.id("name")).sendKeys("Demo User");
		
		driver.findElement(By.id("email")).sendKeys("p11demouser1234567@gmail.com");
		
		driver.findElement(By.xpath("//input[@class='form-control password-err']")).sendKeys("demopassword123@");
		
		driver.findElement(By.cssSelector("input.form-control.countrycode-left")).sendKeys("8765432190");
		
		driver.findElement(By.xpath("//a[text()='Sign Up']")).click();
		
		//Next page,using select dropdown,storing the location to use in select class
		WebElement dropdown1=driver.findElement(By.xpath("//select[@id='profileDrpDwn']"));
		dropdown1.click();
		
		//using select class
		Select select1=new Select(dropdown1);
		
		//calling select method using dropdown
		select1.selectByIndex(1);
		
		WebElement dropdown2=driver.findElement(By.xpath("//select[@id='degreeDrpDwn']"));
		dropdown2.click();
		Select select2=new Select(dropdown2);
		select2.selectByValue("Other");
		
		driver.findElement(By.cssSelector("input[id='year'][class='form-control']")).sendKeys("2019");
		//driver.findElement(By.xpath("//a[text()='May be later']")).click();
		driver.findElement(By.xpath("//a[@id='details-btn']")).click();
		
		String finalstr=driver.findElement(By.xpath("//h1[text()='Almost Done! Check Your Inbox!']")).getText();
		System.out.println(finalstr);
		String Expectedstr="Almost Done! Check Your Inbox!";
		
		if(Expectedstr.equalsIgnoreCase(finalstr))
		{
			System.out.println("Successful signup");
		}
		else
		{
			System.out.println("Failed to signup");
		}
		driver.navigate().back();
		driver.findElement(By.id("login-btn")).click();
		//p2demouser1234567@gmail.com
		driver.findElement(By.id("email")).sendKeys("padmagoutam1611@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Raamrisshan@4622");
		WebElement checkbox1=driver.findElement(By.id("logged-in"));
		checkbox1.click();

		if(checkbox1.isSelected())
		{
			System.out.println("Keep me Logged in Option checked in");
		}
		else 
		{
			System.out.println("Failed to select checkbox");
		}
		
		driver.findElement(By.id("login-btn")).click();
		driver.findElement(By.xpath("//div[@id='dropdown_title']")).click();
		String fpage=driver.getTitle();
		System.out.println(fpage);
		String Real="GUVI | courses";
		if(fpage.equals(Real))
		{
			System.out.println("Successful Login");
		}
		else
		{
			System.out.println("Failed Login");
		}
		//close
		driver.quit();
		
	
	}

}
