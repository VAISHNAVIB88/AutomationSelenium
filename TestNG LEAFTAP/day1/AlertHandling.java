package week2.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertHandling {

	public static void main(String[] args) throws InterruptedException  {
		// TODO Auto-generated method stub
		
		/*
		 * Set up the chromedriver and launch the chrome browser get the url and
		 * maximise the window
		 */
     System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
     ChromeDriver driver = new ChromeDriver();
     driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
     
     driver.switchTo().frame(0);
     driver.findElementByXPath("//button[text()='Try it']").click();
     Alert alert = driver.switchTo().alert();
    
      Thread.sleep(2000);
   
        String text = alert.getText();
		System.out.println(" alert text:" + text);
		
		String name = "Vaishnavi";
		alert.sendKeys(name);
        alert.accept();
     
		
		 String text1 = driver.findElement(By.id("demo")).getText();
		 if (text1.contains(name));
		 {
		 System.out.println("Text matched"); 
		 } 
     
		
     driver.switchTo().defaultContent();
	}

}
