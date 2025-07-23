package learnAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class searchGoogle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		WebElement searchBar =driver.findElement(By.xpath("//textarea[@name=\"q\"]"));
		searchBar.sendKeys("facebook.com");
		searchBar.submit();
		

	}

}
