package week2.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Mergelead extends BasicLogin {

	public static void main(String[] args) {
		
		
	    // Step 0) Setup the chromedriver 
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe"); 
		// Step 1) Launch the chrome browser (Class Name -> ChromeDriver)
		ChromeDriver driver = new ChromeDriver();            
		// Step 2) Load the URL (http://leaftaps.com/opentaps/control/main) -> get
		driver.get("http://leaftaps.com/opentaps");   
		// Step 3) Maximize the chrome browser
		driver.manage().window().maximize();                                         
		
		// Login Page of Leaftaps//
		
		//Finding Elements using locators
		// Step 4) Find the Username using locators & type Demosalesmanager
		WebElement eleUsername = driver.findElementById("username");
		eleUsername.sendKeys("Demosalesmanager");
		
		// Step 5) Find the Password using locators & type crmsfa
		WebElement elePassword = driver.findElementById("password");
		elePassword.sendKeys("crmsfa");
		
		// Step 6) Find the login button and click
		WebElement eleLogin = driver.findElementByClassName("decorativeSubmit");
		eleLogin.click();
		
		
		// Step 7) Verify the title of the current web-page
		System.out.println(driver.getTitle());
		
		// Step 8)click CRM/SFA link
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//Step 9)Click Leads tab
		driver.findElement(By.linkText("Leads")).click();
		
		// Step 10)Click Mergelead
		driver.findElement(By.linkText("Merge Leads")).click();
		
		// Step 11) click fromlead button and interact with findleads window
		driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[1]")).click();
		
		Set<String> winodwlist = driver.getWindowHandles();
		List<String> Listofwindows = new ArrayList<String>(winodwlist);
		driver.switchTo().window(Listofwindows.get(1));
		
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("vaishnavi");
		driver.findElement(By.className("x-btn-text")).click();	
		
		//List<WebElement> table = driver.findElements(By.xpath("//div[@class='x-grid3-body']"));
		
		//WebElement allrows = table.get(0);
		//List<WebElement> eachrow = allrows.findElements(By.tagName("div"));
		
		//WebElement allcolomns = eachrow.get(0);
		//List<WebElement> eachcolomn = allcolomns.findElements(By.xpath("//div[@class='x-grid3-row   ']//table"));
		
		
		

	}

}
