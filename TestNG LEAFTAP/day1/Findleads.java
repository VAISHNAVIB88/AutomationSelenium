package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Findleads extends BasicLogin  {

	@Test
	public  void runTC002() throws Exception {
		
          
  
		

		
		// Step 9 Click Findleads button
		driver.findElement(By.linkText("Find Leads")).click();
		// Step 10 ) to verify if the field is enabled
		System.out.println(driver.findElement(By.xpath("((//label[text()=\"First name:\"])[1]/following::input)[2]")).isEnabled());
	    // Step11) sort the list of required findleads with input
		driver.findElement(By.xpath("((//label[text()=\"First name:\"])[3]/following::input)[1]")).sendKeys("Vaishnavi");
		// Step 12) Click Find Leads button
		driver.findElement(By.xpath("//button[text()=\"Find Leads\"]")).click();
		Thread.sleep(2000);
	    // Step13 Finding the first lead in the table
		WebElement tableElement = driver.findElement(By.xpath("(//div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder'])[10]"));
		// Step14) Click and view the selected lead
		tableElement.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();
		 
        System.out.println(driver.getTitle());
	}

	}


