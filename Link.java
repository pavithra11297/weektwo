package week2.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Link {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://leafground.com/link.xhtml");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("(//a[text()='Go to Dashboard'])[1]")).click();
		System.out.println("Page Title is: " +driver.getTitle());
		driver.navigate().back();
		String url = driver.findElement(By.xpath("//a[text()='Find the URL without clicking me.']")).getAttribute("href");
		System.out.println("Destination is[URL]: " +url);
		driver.findElement(By.xpath("//a[text()='How many links in this page?']")).click();
		List<WebElement> count=driver.findElements(By.tagName("a"));
		System.out.println("Total links are "+count.size());

	}
}


