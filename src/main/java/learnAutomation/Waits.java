package learnAutomation;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.bouncycastle.oer.its.ieee1609dot2.basetypes.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Waits {
	 
	WebDriver driver;
	Actions action;

	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		action = new Actions(driver);
		driver.get("https://www.ebay.com/");
	}
	
 
	
	public void explicitWait() {
		
		WebElement electronics = driver.findElement(By.xpath("//div[@id=\"vl-flyout-nav\"]//ul//li[3]//a[text()=\"Electronics\"]"));
		action.moveToElement(electronics).perform();
		//Explicit Wait
		WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
		WebElement apple=driver.findElement(By.xpath("//*[@id=\"vl-flyout-nav\"]/ul/li[3]/div[2]/div[1]/nav[2]/ul/li[1]/a"));
		wait.until(ExpectedConditions.visibilityOf(apple));
		
		apple.click();
	}
	
	
	
	public void fluidWait() {
		driver.navigate().back();
		WebElement electronics = driver.findElement(By.xpath("//div[@id=\"vl-flyout-nav\"]//ul//li[3]//a[text()=\"Electronics\"]"));
		action.moveToElement(electronics).perform();
		//Fluent Wait
		 FluentWait <WebDriver>fluent = new FluentWait<WebDriver>(driver)
				 .withTimeout(java.time.Duration.ofSeconds(10))
		         .pollingEvery(java.time.Duration.ofSeconds(2))
		         .ignoring(NoSuchElementException.class);
		 
		WebElement samsung=driver.findElement(By.xpath("//*[@id=\"vl-flyout-nav\"]/ul/li[3]/div[2]/div[1]/nav[2]/ul/li[2]/a"));  
		 fluent.until(ExpectedConditions.visibilityOf(samsung)).click();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Waits waitsObject = new Waits();
		waitsObject.setup();
		waitsObject.explicitWait();
		waitsObject.fluidWait();
	
		
         }

}
