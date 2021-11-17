package week2.day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Duplicatelead extends BasicLogin {

	@Test
	public  void runTC004() throws InterruptedException {


		
		// Step 10) Click Findleads button using xpath
		driver.findElement(By.linkText("Find Leads")).click();
		
		// Step 11) Click email tab
		driver.findElement(By.xpath("(//span[@class='x-tab-strip-text '])[3]")).click();
		
	    // Step 11) Enter the email address
	    driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("vaishnavi.b88@gmail.com");
		
	    // Step 12) Click on findleads button
		driver.findElement(By.xpath("//button[text()=\"Find Leads\"]")).click();
		Thread.sleep(3000);
		
	    // Step 13) find the table with list of leads 
	    WebElement wholetable = driver.findElement(By.xpath("//div[@class='x-grid3-scroller']"));
	    List<WebElement> allRows = wholetable.findElements(By.tagName("div"));
	    WebElement allcols = allRows.get(0);
	    List<WebElement> firstid = allcols.findElements(By.tagName("td"));
	    
	    // Step 14) Find the first element by lead id and print 
	    WebElement firstleadid = firstid.get(0);
	    WebElement elementtoduplicate = firstleadid.findElement(By.xpath("((//td[@class='x-grid3-col x-grid3-cell x-grid3-td-firstName '])//a)[1]"));
	    String text = elementtoduplicate.getText();
	    
	    System.out.println(text);
	   
	    // Step 15) click the selected lead id
	    elementtoduplicate.click();
	    
	    // Step 16) Click Duplicate id button
	    driver.findElement(By.xpath("//a[text()='Duplicate Lead']")).click();
	    
	    // Step 17) Verify the title
	    driver.getTitle();
	    
	    // Step 18) Click CreateId
	    driver.findElement(By.className("smallSubmit")).click();
	    
	    // step 19) Verify the first name of Duplicate Lead Id is same as the deleted id first name
	    String text2 = driver.findElement(By.id("viewLead_firstName_sp")).getText();
	    if(text.equals(text2)) {
	    	System.out.println("the duplicate id first name is same as selected lead id name");
	    }
	    else {
	    	
	    	System.out.println("Duplicate is not same as the selected lead id ");
	    }
	    
	    }
	    
	   
	}


