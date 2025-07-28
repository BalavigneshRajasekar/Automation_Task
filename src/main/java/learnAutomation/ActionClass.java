package learnAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;


public class ActionClass {
	 
	WebDriver driver;
	Actions obj;
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		obj = new Actions(driver);
		driver.get("https://jqueryui.com/droppable/");
	
		
	}
	
public void dragAndDrop() {
	WebElement	Frames = driver.findElement(By.xpath("//div[@id=\"content\"]//descendant::iframe"));
	driver.switchTo().frame(Frames);
	WebElement drag = driver.findElement(By.id("draggable"));
	WebElement drop = driver.findElement(By.id("droppable"));
	obj.dragAndDrop(drag, drop).perform();
	driver.switchTo().defaultContent();
	
	
}
public void resizable() {
	driver.findElement(By.xpath("//a[text()=\"Resizable\"]")).click();
	WebElement	Frames = driver.findElement(By.xpath("//div[@id=\"content\"]//descendant::iframe"));
	System.out.println("switched");
	driver.switchTo().frame(Frames);
	System.out.println("switched");
	WebElement Icon = driver.findElement(By.xpath("//div[@id=\"resizable\"]/div[3]"));
	obj.dragAndDropBy(Icon, 300, 100).perform();
	
	
	
}	
		
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ActionClass obj1 = new ActionClass();
		obj1.setup();
		obj1.dragAndDrop();
		obj1.resizable();
		
         }

}
