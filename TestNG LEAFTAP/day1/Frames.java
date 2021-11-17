package week2.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class Frames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	     ChromeDriver driver = new ChromeDriver();
		
	    // Step 1) open the URL and maximize it 
		driver.get("http://www.leafground.com/pages/frame.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		// Step 2) Go to the first frame by webelement
		WebElement frame1 = driver.findElement(By.xpath("//iframe[@src='default.html']"));
		driver.switchTo().frame(frame1);
		
		// Step 3) click the button inside the first frame.
		driver.findElement(By.id("Click")).click();
		
		// Step 4) Come out of the frame to default content
		driver.switchTo().defaultContent();
		
		// Step 5) Switch to second frame in the page
		WebElement outerframe = driver.findElement(By.xpath("//iframe[@src='page.html']"));
		driver.switchTo().frame(outerframe);
		
		// Step 6) Switch to inner frame 
		WebElement innerframe = driver.findElement(By.xpath("//iframe[@src='nested.html']"));
		driver.switchTo().frame(innerframe);
		
		driver.findElement(By.xpath("//button[@id='Click1']")).click();
		
		driver.switchTo().defaultContent();
         	}
	

}
