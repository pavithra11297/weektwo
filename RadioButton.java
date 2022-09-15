package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioButton {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://leafground.com/radio.xhtml");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("(//label[text()='Chrome'])[1]")).click();
		driver.findElement(By.xpath("(//label[text()='Edge'])[1]")).click();
		driver.findElement(By.xpath("(//label[text()='Bengaluru'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[text()='Bengaluru'])[1]")).click();
	}

}
