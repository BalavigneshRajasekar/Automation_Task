package learnAutomation;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Waits {
	 
	WebDriver driver;
	Actions obj;
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		obj = new Actions(driver);
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().fullscreen();
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Waits obj1 = new Waits();
	
		
         }

}
