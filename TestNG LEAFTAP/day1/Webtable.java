package week2.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Webtable {

	public static void main(String[] args) {
		
		//set the chromedriver and get the url to launch the browser;maximise and provide implicit wait
		WebDriverManager.chromedriver().setup();
		WebDriver  driver = new ChromeDriver();
		
		driver.get("http://www.leafground.com/pages/Window.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		// Step 1) Open Home page	
		driver.findElement(By.id("home")).click();
		
		// Step 2) Got the new window opened for Home Page
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowList = new ArrayList<String>(windowHandles);
		
		driver.switchTo().window(windowList.get(1));
		driver.findElement(By.xpath("//a[@href='pages/table.html']")).click();
		System.out.println(driver.getCurrentUrl());
		
		driver.manage().window().maximize();
		WebElement wholetable = driver.findElement(By.id("table_id"));
		List<WebElement> listoftable = wholetable.findElements(By.tagName("tr"));
		
	    for (int i = 0; i < listoftable.size(); i++) {
	    	WebElement eachrow = listoftable.get(i);
	    	
	    	List<WebElement> allcoloumns = eachrow.findElements(By.tagName("td"));
			
	   for (int j = 0; j < allcoloumns.size(); j++) {
		    WebElement eachcoloumn = allcoloumns.get(j);
		    System.out.println(eachcoloumn.getText());
	                              
	}	
}
			
}
}


