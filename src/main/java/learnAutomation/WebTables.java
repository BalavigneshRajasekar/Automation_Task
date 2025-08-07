package learnAutomation;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;


public class WebTables {
	
	
	WebDriver driver;
	
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.tutorialspoint.com/selenium/practice/webtables.php");
		
	}
	
	
	
	public void dynamicTable() {
		
		
	List<WebElement>tableRow = driver.findElements(By.xpath("/html/body/main/div/div/div[2]/form/div[2]/table/tbody/tr"));
	
	List<WebElement> tableCol = driver.findElements(By.xpath("/html/body/main/div/div/div[2]/form/div[2]/table/tbody/tr[1]/td"));
	
	System.out.println(tableRow.size());
	for(int i= 1; i<=tableRow.size();i++) {
		
		for(int j=1;j<=tableCol.size();j++) {
			
			System.out.print(driver.findElement(By.xpath("/html/body/main/div/div/div[2]/form/div[2]/table/tbody/tr["+ i +"]/td["+ j +"]")).getText()+" " );
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