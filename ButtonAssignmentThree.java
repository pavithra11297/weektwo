package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ButtonAssignmentThree {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://leafground.com/button.xhtml");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[@class='card']/button")).click();
		System.out.println("Page Title is: " +driver.getTitle());
		driver.navigate().back();
		boolean butnDisable = driver.findElement(By.xpath("(//div[@class='card']/button)[2]")).isEnabled();
		if (butnDisable==true)
		{
			System.out.println("button is not disabled");
		}
		else
		{
			System.out.println("Button is Disabled");
		}
		Point location = driver.findElement(By.xpath("(//span[text()='Submit'])[1]")).getLocation();
		System.out.println("Button Position");
		System.out.println(location.getX());
		System.out.println(location.getY());
		String color = driver.findElement(By.xpath("(//span[text()='Submit'])[1]/parent::button")).getCssValue("background");
		System.out.println("Button color is: "+color);
		Dimension size = driver.findElement(By.xpath("(//span[text()='Submit'])[2]")).getSize();
		System.out.println("Button Height: " +size.getHeight());
		System.out.println("Button Width: "+size.getWidth());


	}
}
