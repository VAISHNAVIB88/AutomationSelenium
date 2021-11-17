package week2.day1;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;



public class screenshotfullpage {



	public static void main(String[] args) throws IOException  {
		 
		/* Step 1)
		 * Set up the chromedriver and launch the chrome browser get the url and
		 * maximise the window
		 */
         WebDriverManager.chromedriver().setup();
         WebDriver driver = new ChromeDriver();
	     driver.get("https://www.nopcommerce.com/en/demo");
	     driver.manage().window().maximize();
	     driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		 // Step 2) Capture Fullpage screenshot
	     
	     TakesScreenshot ts = (TakesScreenshot)driver;
	     File src = ts.getScreenshotAs(OutputType.FILE);
	     File trg = new File(".\\screenshot\\homepage1.png");
	     FileUtils.copyFile(src, trg);
	     
	     // Step 3) Capture portion of the page
	     WebElement phonescreenshot = driver.findElement(By.className("desktop-store-image"));
	     File src1 = phonescreenshot.getScreenshotAs(OutputType.FILE);
	     File trg1 = new File(".\\screenshot\\homepage2.png");
	     FileUtils.copyFile(src1, trg1);
	     
	     
	     // Step 4) Capture particular webelement
	     WebElement logo = driver.findElement(By.xpath("//img[@title='nopCommerce']"));
	     File src2 = logo.getScreenshotAs(OutputType.FILE);
	     File trg2 = new File(".\\screenshot\\logo.png");
	     FileUtils.copyFile(src2, trg2);
	     driver.close();
	}

	

}
