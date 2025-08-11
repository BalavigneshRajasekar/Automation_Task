package learnAutomation;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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

		List<WebElement> tableRow = driver
				.findElements(By.xpath("/html/body/main/div/div/div[2]/form/div[2]/table/tbody/tr"));

		List<WebElement> tableCol = driver
				.findElements(By.xpath("/html/body/main/div/div/div[2]/form/div[2]/table/tbody/tr[1]/td"));

		System.out.println(tableRow.size());
		for (int i = 1; i <= tableRow.size(); i++) {

			for (int j = 1; j <= tableCol.size(); j++) {

				System.out.print(driver
						.findElement(By.xpath(
								"/html/body/main/div/div/div[2]/form/div[2]/table/tbody/tr[" + i + "]/td[" + j + "]"))
						.getText() + " ");
			}
			System.out.println();

		}

	}

	public void javascriptExecutor() {

		JavascriptExecutor jsEx = (JavascriptExecutor) driver;
		WebElement delete = driver
				.findElement(By.xpath("/html/body/main/div/div/div[2]/form/div[2]/table/tbody/tr[1]/td[7]/a[2]"));

		WebElement text = driver
				.findElement(By.xpath("/html/body/main/div/div/div[2]/form/div[2]/table/tbody/tr[2]/td[1]"));
		jsEx.executeScript("arguments[0].click();", delete);
		jsEx.executeScript("arguments[0].style.backgroundColor='red';", text);

	}

	public void screenshot() {
		String s_sName = new Date().toString().replace(" ", "_").replace(":", "-");
		System.out.println(s_sName);
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshotFile, new File(".//screenshots/" + s_sName + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("error" + e);
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		WebTables tables = new WebTables();
		tables.setup();
//		tables.dynamicTable();
//		tables.javascriptExecutor();
		tables.screenshot();

	}

}