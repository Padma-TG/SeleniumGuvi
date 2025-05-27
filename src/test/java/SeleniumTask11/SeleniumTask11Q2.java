package SeleniumTask11;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class SeleniumTask11Q2 {

	public static void main(String[] args) 
	{
		//1.Launch the browser
		WebDriver driver=new EdgeDriver();
		
		//2.opening url
		driver.get("http://the-internet.herokuapp.com/nested_frames");
		
		//3.maximizing
		driver.manage().window().maximize();
		
		//4.implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//5.switching to the top frame
		WebElement topframe=driver.findElement(By.cssSelector("frame[name='frame-top']"));
		driver.switchTo().frame(topframe);
		
		//6.verify that there are three frames
		//List<WebElement> innerframe=driver.findElements(By.tagName("frame"));
		//List<WebElement> innerframe=driver.findElements(By.cssSelector("frame"));
		List<WebElement> innerframe=driver.findElements(By.xpath("//frame"));
		if(innerframe.size() == 3)
		{
			System.out.println("Verified that there are three frames in top");
		}
		else
		{
			System.out.println("Verification failed for count 3");
		}			
		
		//7.switch to the left
		WebElement leftframe=driver.findElement(By.cssSelector("frame[src='/frame_left']"));
		driver.switchTo().frame(leftframe);
		
		//8.verify that left frame has a text "LEFT"
		String textofleftframe = driver.findElement(By.xpath("//body[contains(text(),'LEFT')]")).getText();
		String Expectleft = "LEFT";
		if(textofleftframe.equals(Expectleft))
		{
			System.out.println("Verified left frame has a text LEFT");
		}
		else
		{
			System.out.println("Failed to verify left text");
		}
		
		//9.switch back to top frame
		driver.switchTo().parentFrame();

		//10.switch to middle frame
		WebElement middleframe=driver.findElement(By.cssSelector("frame[src='/frame_middle']"));
		driver.switchTo().frame(middleframe);
		
		//11.verify that middle frame has a text "Middle"
		String textofmiddleframe=driver.findElement(By.cssSelector("div[id='content']")).getText();
		String Expectedmiddle="MIDDLE";
		if(textofmiddleframe.equals(Expectedmiddle))
		{
			System.out.println("Verified middle frame has a text MIDDLE");
		}
		else
		{
			System.out.println("Failed to verify middle text");
		}		
		
		//12.switch back to top frame
		driver.switchTo().parentFrame();

		//13.switch to right frame
		WebElement rightframe=driver.findElement(By.xpath("//frame[@src='/frame_right']"));
		driver.switchTo().frame(rightframe);
		
		//14.verify that right frame has a text "Right"
		String textofrightframe=driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]")).getText();
		String Expectedright="RIGHT";
		if(textofrightframe.equals(Expectedright))
		{
			System.out.println("Verified right frame has a text RIGHT");
		}
		else
		{
			System.out.println("Failed to verify right text");
		}
		
		//15.switch back to top frame
		driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();

		
		//16.switch to bottom frame
		WebElement bottomframe=driver.findElement(By.cssSelector("frame[src='/frame_bottom']"));
		driver.switchTo().frame(bottomframe);
		
		//17.verify that left frame has a text "Bottom"
		String textofbottomframe=driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]")).getText();
		String Expectedbottom="BOTTOM";
		if(textofbottomframe.equals(Expectedbottom))
		{
			System.out.println("Verified bottom frame has a text BOTTOM");

		}
		else
		{
			System.out.println("Failed to verify bottom text");

		}
		
		//18.Switch back to the top frame.
		driver.switchTo().defaultContent();
		
		//19.closing the browser		
		driver.quit();

	}

}
