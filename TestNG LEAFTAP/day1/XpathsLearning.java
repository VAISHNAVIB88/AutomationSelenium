package week2.day1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class XpathsLearning {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps");
		driver.manage().window().maximize();
		
		//Login Page of Leaftaps//
		driver.findElementByXPath("//input[@id='username']").sendKeys("Demosalesmanager");
		driver.findElementByXPath("//input[@id='password']").sendKeys("crmsfa");
		driver.findElementByXPath("//input[@class='decorativeSubmit']").click();
		driver.findElementByXPath("//a[contains(text(),'CRM/SFA')]").click();
		driver.findElementByXPath("//a[text()='Create Lead']").click();
		driver.findElementByXPath("//input[@id='createLeadForm_companyName']").sendKeys("ANZ");
		driver.findElementByXPath("//input[@id='createLeadForm_firstName']").sendKeys("Vaishnavi");
		driver.findElementByXPath("//input[@id='createLeadForm_lastName']").sendKeys("Babu");
		
		WebElement dropdown = driver.findElementByXPath("//select[@id='createLeadForm_dataSourceId']");
	    dropdown.sendKeys("Cold Call");	
		driver.findElementByXPath("//input[@class='smallSubmit']").click();
		String text = driver.findElementByXPath("//span[@id='viewLead_companyName_sp']").getText();
		System.out.println(text);
		driver.findElementByXPath("//a[text()='Find Leads']").click();
		driver.findElementByXPath("//input[@name='firstName']").sendKeys("Vaishnavi");
		driver.findElementByXPath("//input[@name='firstName']").sendKeys("Babu");
		driver.findElementByXPath("//input[@name='companyName']").sendKeys("ANZ");
		driver.findElementByXPath("//button[@text()='Find Leads']").click();
	}

}
