package learnAutomation;

import java.util.Iterator;
import java.util.List;

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
		driver.manage().window().fullscreen();
	
		
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
	driver.switchTo().frame(Frames);
	WebElement Icon = driver.findElement(By.xpath("//div[@id=\"resizable\"]/div[3]"));
	obj.dragAndDropBy(Icon, 300, 100).perform();
	driver.switchTo().defaultContent();
	
	
}	
		
	
public void scrollAndSelect() {
	driver.findElement(By.xpath("//a[text()=\"Selectable\"]")).click();
	WebElement	Frames = driver.findElement(By.xpath("//div[@id=\"content\"]//descendant::iframe"));
	driver.switchTo().frame(Frames);
	WebElement scrollable=driver.findElement(By.xpath("//ol[@id=\"selectable\"]//li[3]"));
	WebElement stop = driver.findElement(By.xpath("//ol[@id=\"selectable\"]//li[7]"));
	obj.dragAndDrop(scrollable, stop).perform();
	driver.switchTo().defaultContent();
	
}

public void sortable() {
	driver.findElement(By.xpath("//a[text()=\"Sortable\"]")).click();
	WebElement	Frames = driver.findElement(By.xpath("//div[@id=\"content\"]//descendant::iframe"));
	driver.switchTo().frame(Frames);
	List <WebElement> item = driver.findElements(By.className("ui-state-default"));
	System.out.println(item.size());
	
   for(int i=0 ;i<item.size();i++) {
	   WebElement current = driver.findElements(By.cssSelector("#sortable li")).get(i); // refresh DOM
       WebElement target = driver.findElements(By.cssSelector("#sortable li")).get(6);  // 7th item (index 6)

       if (i != 6) { // Don't drag item 7 to itself
           obj.clickAndHold(current)
               .moveToElement(target)
               .moveByOffset(0, 10) // fine-tune position
               .release()
               .perform();
       }
	   
	    try {
	    	Thread.sleep(1500);
	    	
	    }catch(Exception io) {}
	
     }
   System.out.println("sorted");
	
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ActionClass obj1 = new ActionClass();
		obj1.setup();
		obj1.dragAndDrop();
		obj1.resizable();
		obj1.scrollAndSelect();
		obj1.sortable();
		
         }

}
