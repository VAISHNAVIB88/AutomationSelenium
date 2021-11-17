package week2.day1;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Windowhandling1 {

	public static void main(String[] args) {
		
		// Step 1) Set up the chromedriver , get the URL and launch the browser.
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
        driver.get("http://www.leafground.com/pages/Window.html");
        
        // Step 2) Maximize the window
		driver.manage().window().maximize();
		
		// Step 3) Provide implicit wiat
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		// Step 4) Open HomePage
		driver.findElement(By.id("home")).click();
		
		// Step 5) Get the list of Windows
		Set<String> windows = driver.getWindowHandles();
        List<String> windowlist = new ArrayList<String>(windows);
        
        // Get the title of the current page(very first window)
        System.out.println("Tile of current Window:" +driver.getTitle()); 
        
		 // Step 6) Switch to second window and get the URL
		 driver.switchTo().window(windowlist.get(1));
		 System.out.println("URL of the second window:" +driver.getCurrentUrl());
		 
		 driver.manage().window().maximize();
		 
		 // Step 7) Click the Button icon and open the page in new window using sendkeys.
		 String tab = Keys.chord(Keys.CONTROL,Keys.RETURN);
		 driver.findElement(By.xpath("//a[@href='pages/Button.html']")).sendKeys(tab);
		
		 // Step 8) Again travel back to very first window
         driver.switchTo().window(windowlist.get(0));
         System.out.println("URL of the current window:" +driver.getCurrentUrl());
         
         
        
        	}

}
