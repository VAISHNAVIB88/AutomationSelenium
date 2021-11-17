package week2.day1;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Deletelead extends BasicLogin{
    
	@Test(dataProvider = "Array Data")
	public void runTC003(String email) throws Exception  {
	// Step 10) Click Findleads button using xpath
	driver.findElement(By.linkText("Find Leads")).click();
	
	// Step 11) Click email tab
	driver.findElement(By.xpath("(//span[@class='x-tab-strip-text '])[3]")).click();
	
    // Step 11) Enter the email address
    driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys(email);
	
    // Step 12) Click on findleads button
	driver.findElement(By.xpath("//button[text()=\"Find Leads\"]")).click();
	Thread.sleep(3000);
	
    // Step 13) find the table with list of leads 
    WebElement wholetable = driver.findElement(By.xpath("//div[@class='x-grid3-scroller']"));
    List<WebElement> allRows = wholetable.findElements(By.tagName("div"));
    WebElement allcols = allRows.get(0);
    List<WebElement> firstid = allcols.findElements(By.tagName("td"));
    
		
    // Step 14) Condition to check if the table is not empty 
    String leadIdToDelete = new String();
    if (CollectionUtils.isNotEmpty(firstid) && firstid.size() > 1) { 
    WebElement firstleadid = firstid.get(0);
    WebElement elementToDelete = firstleadid.findElement(By.xpath("((//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first '])//a)[1]")); 
    leadIdToDelete = elementToDelete.getText(); 
    elementToDelete.click(); }
		  
	System.out.println("Lead Id To Delete "+leadIdToDelete);
	// Step 15) Delete the chosen lead id
	 driver.findElement(By.xpath("//a[@class='subMenuButtonDangerous']")).click();
		  
    // Step 16) Click Findleads button using xpath
	driver.findElement(By.linkText("Find Leads")).click();
		  
	// Step11) Search the deleted lead to make sure is deleted
	driver.findElement(By.xpath("//label[text()=\"Lead ID:\"]/following::input")).sendKeys(leadIdToDelete); 
	//Step 12) Click Find Leads button
	driver.findElement(By.xpath("//button[text()=\"Find Leads\"]")).click();
		 
	driver.findElement(By.className("x-paging-info")).getText();
	
	
}
	
}
