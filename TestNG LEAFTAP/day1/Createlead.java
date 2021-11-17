package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;



public class Createlead extends BasicLogin {

	@Test(dataProvider = "Array Data")
	public void runTC001(String Companyname, String firstName, String Lastname, String firstNameLocal, String personalTitle, String annualRevenue, String leadformDescription,  String phoneCode, String primaryPhonenum, String primarymail ) {

		// Step 9) click create lead link
		driver.findElement(By.linkText("Create Lead")).click();

		// Step 10) Find the company name and type the company name
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(Companyname);

		// Step 11) Find the first name and type the first name
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstName);

		// Step 11) Find the last name and type the last name
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(Lastname);

		// Finding Elements using Xpath
		// Step 12) Find the first name(local) and type the value
		driver.findElement(By.xpath("//input[@id=\"createLeadForm_firstNameLocal\"]")).sendKeys(firstNameLocal);

		// Step 13) Find the Salutation and type the value
		driver.findElement(By.xpath("//input[@id=\"createLeadForm_personalTitle\"]")).sendKeys(personalTitle);

		// Drop-down selection using Select Class
		// Step 14) Choose Employee for source drop-down using Select by Value
		WebElement firstdropdown = driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select sourcedropdown = new Select(firstdropdown);
		sourcedropdown.selectByValue("LEAD_EMPLOYEE");

		// Drop-down selection using Select Class
		// Step 15) Choose eCommerce Site Internal Campaign for Marketing Campaign
		// drop-down using Select by Index
		WebElement thirddropdown = driver.findElement(By.id("createLeadForm_industryEnumId"));
		Select Marketingdropdown = new Select(thirddropdown);
		Marketingdropdown.selectByIndex(4);

		// Step 16)Find Element for annual revenue using Xpath and type the value
		driver.findElement(By.xpath("//input[@id=\"createLeadForm_annualRevenue\"]")).sendKeys(annualRevenue);

		// Drop-down selection using Select Class
		// Step 17) Choose Employee for industry drop-down using Select by Index
		WebElement seconddropdown = driver.findElement(By.id("createLeadForm_industryEnumId"));
		Select industrydropdown = new Select(seconddropdown);
		industrydropdown.selectByIndex(3);

		// Drop-down selection using Select Class
		// Step 18) Choose S-Corporation for ownership drop-down using Select by Index
		WebElement fourthdropdown = driver.findElement(By.id("createLeadForm_ownershipEnumId"));
		Select ownershipdropdown = new Select(fourthdropdown);
		ownershipdropdown.selectByVisibleText("S-Corporation");

		// Step 19) Enter text in Description field
		driver.findElement(By.id("createLeadForm_description")).sendKeys(leadformDescription);

		// Step 20) Enter the value in country code by clearing the old value
		driver.findElement(By.id("createLeadForm_primaryPhoneCountryCode")).clear();
		driver.findElement(By.id("createLeadForm_primaryPhoneCountryCode")).sendKeys(phoneCode);

		// Step 20) Enter the value in country code
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(primaryPhonenum);

		// Step 21) Enter mail id
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys(primarymail);

		// Step 22) Print the new title
		// title = driver.getTitle();
		System.out.println("The current title is" + driver.getTitle());

		// Step23 ) Get the current URL of the page
		System.out.println("The current URL is" + driver.getCurrentUrl());

		// DateTimeFormatter.ofPattern("MMMM
		// YYYY").format(LocalDate.now().plusDays(10));
		// Step 23) Choose Country as New Zealand from Drop-down
		//
		WebElement fifthdropdown = driver.findElement(By.id("createLeadForm_generalCountryGeoId"));
		Select countrydropdown = new Select(fifthdropdown);
		countrydropdown.selectByVisibleText("New Zealand");

		// Click Create lead button
		driver.findElement(By.className("smallSubmit")).click();

	}

}
