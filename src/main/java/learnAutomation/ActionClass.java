package learnAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;


public class ActionClass {
	 
	WebDriver driver;
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		
	}
	
public void dragAndDrop() {
	WebElement Frames = driver.findElement(By.xpath("//div[@id=\"content\"]//preceding::iframe"));
	driver.switchTo().frame(Frames);
	Actions obj = new Actions(driver);
	WebElement drag = driver.findElement(By.id("draggable"));
	WebElement drop = driver.findElement(By.id("droppable"));
	
	obj.dragAndDrop(drag, drop).perform();
	
	
}
	
		
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ActionClass obj1 = new ActionClass();
		obj1.setup();
		obj1.dragAndDrop();
		
         }

}
