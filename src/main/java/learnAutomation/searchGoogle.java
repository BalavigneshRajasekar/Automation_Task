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
		driver.get("https://www.facebook.com");
		WebElement email = driver.findElement(By.xpath("//input[@id=\"email\"]"));
		WebElement password = driver.findElement(By.xpath("//input[@id=\"pass\"]"));
		WebElement eyeIcon = driver.findElement(By.xpath("//div[@class=\"_9lsa\"]"));
		WebElement	logInButton = driver.findElement(By.xpath("//button[@name=\"login\"]"));
		
		
		email.sendKeys("kingbala62@gmail.com");
		password.sendKeys("fb.com");
	    
		try {
			Thread.sleep(2000);
		}catch(Exception e) {}
		
       eyeIcon.click();
       logInButton.click();
	}

}
