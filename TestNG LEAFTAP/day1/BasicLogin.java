package week2.day1;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;
import util.ReadExcel;

public class BasicLogin {
	WebDriver driver;
	public String excelFileName;

	@Parameters({ "ExcelData" })
	@BeforeTest
	public void setData(String data) {
		excelFileName = data;
	}

	@Parameters({ "browser", "url", "Username", "Password" })
	@BeforeMethod // Open Browser and login to leaftaps
	public void browserSetup(String browser, String url, String Username, String Password) {
		/*
		 * if (browser.equalsIgnoreCase("chrome")) {
		 * WebDriverManager.chromedriver().setup(); driver = new ChromeDriver(); } else
		 * if (browser.equalsIgnoreCase("firefox")) {
		 * WebDriverManager.firefoxdriver().setup(); driver = new FirefoxDriver(); }
		 * else if (browser.equalsIgnoreCase("firefox")) {
		 * WebDriverManager.edgedriver().setup(); driver = new EdgeDriver();
		 */

		switch (browser) {
		case "chrome": {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
			break;
		case "firefox": {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
			break;
		default: {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		}

		// Step 2) Load the URL (http://leaftaps.com/opentaps/control/main) -> get
		driver.get(url);
		// Step 3) Maximize the chrome browser
		driver.manage().window().maximize();

		// Login Page of Leaftaps//

		// Finding Elements using locators
		// Step 4) Find the Username using locators & type Demosalesmanager
		WebElement eleUsername = driver.findElement(By.id("username"));
		eleUsername.sendKeys(Username);

		// Step 5) Find the Password using locators & type crmsfa
		WebElement elePassword = driver.findElement(By.id("password"));
		elePassword.sendKeys(Password);

		// Step 6) Find the login button and click
		WebElement eleLogin = driver.findElement(By.className("decorativeSubmit"));
		eleLogin.click();

		// Step 7) Verify the title of the current web-page
		System.out.println(driver.getTitle());

		// Step 8)click CRM/SFA link
		driver.findElement(By.linkText("CRM/SFA")).click();

		// Click Leads tab
		driver.findElement(By.linkText("Leads")).click();
	}

	@AfterMethod
	public void closingbrowser() {
		driver.close();
	}

	@DataProvider(name = "Array Data")
	public String[][] sendData() throws IOException
	// Create 2D array
	{
		String[][] array = ReadExcel.readExceldata(excelFileName);

		return array;

		// if not using excel and sending 2dimensional data directly

		/*
		 * String[][] array = new String[2][3]; 
		 * array[0][0] = "Testleaf";
		 * array[0][1] = "Vaishnavi"; 
		 * array[0][2] = "B";
		 * array[1][0] = "Testleaf"; 
		 * array[1][1] = "Ganesh"; 
		 * array[1][2] = "SK";
		 * array[2][0] = "Testleaf"; 
		 * array[2][1] = "Magilini"; 
		 * array[2][2] = "G";
		 * return array;
		 */
	}
}
