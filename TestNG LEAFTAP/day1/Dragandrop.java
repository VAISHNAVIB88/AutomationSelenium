/*
 * package week2.day1;
 * 
 * import java.util.List; import java.util.concurrent.TimeUnit;
 * 
 * import org.openqa.selenium.By; import org.openqa.selenium.WebDriver; import
 * org.openqa.selenium.WebElement; import
 * org.openqa.selenium.chrome.ChromeDriver; import
 * org.openqa.selenium.interactions.Actions;
 * 
 * import io.github.bonigarcia.wdm.WebDriverManager;
 * 
 * public class Dragandrop {
 * 
 * public static void main(String[] args) {
 * WebDriverManager.chromedriver().setup(); WebDriver driver = new
 * ChromeDriver();
 * 
 * driver.get("http://www.leafground.com/pages/sortable.html");
 * driver.manage().window().maximize();
 * driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
 * 
 * // Find the Webelement
 * 
 * // table WebElement sortabletable = driver.findElement(By.id("sortable"));
 * List<WebElement> listofitems =sortabletable.findElements(By.tagName("li"));
 * 
 * WebElement item1 = listofitems.get(0); WebElement item4 = listofitems.get(3);
 * 
 * int x = item4.getLocation().getX();
 * 
 * //WebElement item1 = driver.findElement(By.id("//li[text()='Item 1']"));
 * //WebElement item2 = driver.findElement(By.id("//li[text()='Item 4']"));
 * Actions builder = new Actions(driver);
 * builder.clickAndHold(item1).dragAndDrop(item1,
 * item4).release(item1).perform();
 * 
 * }
 * 
 * }
 */