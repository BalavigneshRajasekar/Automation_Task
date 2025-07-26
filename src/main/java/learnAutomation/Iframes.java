package learnAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Iframes {
	 
	WebDriver driver;
	
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
		WebElement iFrame=	driver.findElement(By.xpath("//iframe[@id=\"iframeResult\"]"));
		driver.switchTo().frame(iFrame);
		
	}
	
	public void checkIframe() {
		WebElement tryBTN = driver.findElement(By.xpath("//button[text()=\"Try it\"]"));
		tryBTN.click();
		
		try {
			Thread.sleep(2000);
			
		}catch(Exception io) {
			System.out.println("error");
		}
		
		driver.switchTo().alert().accept();
	
	}

	public static void main(String[] args) {
		Iframes obj = new Iframes();
		obj.setup();
		obj.checkIframe();
		
         }

}
