package learnAutomation;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


public class WebTables {
	
	
	WebDriver driver;
	
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.asx.com.au/markets/trade-our-cash-market/equity-market-prices");
		WebDriverWait explicit = new WebDriverWait(driver,Duration.ofSeconds(10));
		explicit.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id=\"onetrust-accept-btn-handler\"]"))).click();
	}
	
	
	
	public void dynamicTable() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Wait until at least one row is present
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
		    By.xpath("//*[@id=\"home_top_twenty\"]/div/div[1]/div/div[1]/table/tr")
		));
		
	List<WebElement>tableRow = driver.findElements(By.xpath("/html/body/main/div/div/div[2]/form/div[2]/table/tbody/tr"));
	
	List<WebElement> tableCol = driver.findElements(By.xpath("//*[@id=\"home_top_twenty\"]/div/div[1]/div/div[1]/table/tr[2]/td"));
	
	System.out.println(tableRow.size());
	for(int i= 2; i<=tableRow.size();i++) {
		
		for(int j=1;j<=tableCol.size();j++) {
			
			System.out.println(driver.findElement(By.xpath("//*[@id=\"home_top_twenty\"]/div/div[1]/div/div[1]/table/tr["+ i +"]/td["+ j +"]")).getText());
		}
		System.out.println();
		
	}
	
	
	
	
	
	}
	
	
	public static void main(String [] args) {
		
		WebTables tables= new WebTables();
		tables.setup();
		tables.dynamicTable();
		
	}
	 
}