package learnAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FormAutomation {
	 
	WebDriver driver;
	
	public void form() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		//form Data
		
		driver.get("https://demoqa.com/automation-practice-form");
		WebElement firstName = driver.findElement(By.id("firstName"));
		WebElement lastName = driver.findElement(By.id("lastName"));
		WebElement email = driver.findElement(By.id("userEmail"));
		WebElement male = driver.findElement(By.cssSelector("label[for='gender-radio-1']"));
		WebElement number = driver.findElement(By.id("userNumber"));
		WebElement DOB = driver.findElement(By.id("dateOfBirthInput"));
		
		
		firstName.sendKeys("balavignesh");
		lastName.sendKeys("rajasekar");
		email.sendKeys("vigneshvickybsc1999@gmail.com");
		male.click();
		number.sendKeys("8825559375");
		DOB.click();
		
		WebElement Month = driver.findElement(By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/select"));
		Select monthObj = new Select(Month);
		monthObj.selectByVisibleText("April");
		WebElement year = driver.findElement(By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/select"));
		Select yearObj = new Select(year);
		yearObj.selectByVisibleText("1999");
		WebElement date = driver.findElement(By.xpath("//div[text()=\"27\"]"));
		date.click();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         FormAutomation obj = new FormAutomation();
         obj.form();
         }

}
