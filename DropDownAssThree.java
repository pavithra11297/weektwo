package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownAssThree {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://leafground.com/select.xhtml");
		driver.manage().window().maximize();
		WebElement automationTool = driver.findElement(By.className("ui-selectonemenu"));
		Select tool=new Select(automationTool);
		tool.selectByVisibleText("Selenium");
		driver.findElement(By.xpath("//label[text()='Select Country']")).click();
		driver.findElement(By.xpath("//li[text()='India']")).click();
		driver.findElement(By.xpath("//button[@class='ui-autocomplete-dropdown ui-button ui-widget ui-state-default ui-corner-right ui-button-icon-only']")).click();
		driver.findElement(By.xpath("//li[text()='AWS']")).click();
	}
}
