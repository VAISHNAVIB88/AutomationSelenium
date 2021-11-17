package week2.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Windowhandling {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		
		driver.get("https://www.irctc.co.in/");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		driver.findElementByPartialLinkText("FLIGHTS").click();
		
		Set<String> currentwindow = driver.getWindowHandles();
		List<String> windowlist = new ArrayList<String>(currentwindow);
		driver.switchTo().window(windowlist.get(1));
		
		String text = driver.findElementByXPath("//div[@class='block-nav-right d-none d-md-block'][2]").getText();
		System.out.println("Mail id is:"+text);
		
	    driver.switchTo().window(windowlist.get(0));
	    System.out.println("first window :"+ driver.getTitle());
	    
	    driver.close();
	}
	
}
