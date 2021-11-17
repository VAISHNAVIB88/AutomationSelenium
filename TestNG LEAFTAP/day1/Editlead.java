package week2.day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Editlead extends BasicLogin {

	@Test	
	public  void runTC005() throws InterruptedException {
	    
		

		
		// Step 10) Click Findleads button using xpath
		driver.findElement(By.linkText("Find Leads")).click();
		
	    // Step11) sort the list of required findleads with input
		driver.findElement(By.xpath("((//label[text()=\"First name:\"])[3]/following::input)[1]")).sendKeys("Vaishnavi");
		
		// Step 12) Click Find Leads button
		driver.findElement(By.xpath("//button[text()=\"Find Leads\"]")).click();
		Thread.sleep(2000);
        
		WebElement leadlist = driver.findElement(By.xpath("//div[@class='x-grid3-body']"));
		List<WebElement> eachrow = leadlist.findElements(By.tagName("table"));
		
		WebElement allcoloumns = eachrow.get(1);
		List<WebElement> eachcoloumn = allcoloumns.findElements(By.tagName("td"));
		WebElement firstelement1= eachcoloumn.get(0);
		
		firstelement1.findElement(By.xpath("((//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])//a)[1]")).click();
		
		driver.getTitle();
		
		String newcompanyname = "ANZ";
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(newcompanyname);
		
		driver.findElement(By.className("smallSubmit")).click();
		
		String verifycname = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		if(newcompanyname.equals(verifycname)){
		System.out.println("changed name is displayed");
	}
		else
		{
			System.out.println("Edit is not working");
		
		}
	}

}
