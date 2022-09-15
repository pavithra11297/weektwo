package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FaceBookSignUp {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//div[@class='_6ltg']/a")).click();
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Pavithra");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("G");
		driver.findElement(By.xpath("//form[@name='reg']//input[@name='reg_email__']")).sendKeys("8000000039");
		driver.findElement(By.xpath("//input[@id='password_step_input']")).sendKeys("abcABC@123");
		WebElement Bday=driver.findElement(By.xpath("//select[@name='birthday_day']"));
		Select ddDay=new Select(Bday);
		ddDay.selectByVisibleText("11");
		WebElement Bmonth=driver.findElement(By.xpath("//select[@name='birthday_month']"));
		Select ddMonth=new Select(Bmonth);
		ddMonth.selectByIndex(2);
		WebElement Byear=driver.findElement(By.xpath("//select[@name='birthday_year']"));
		Select ddyear=new Select(Byear);
		ddyear.selectByValue("1997");
		driver.findElement(By.xpath("//input[@value='1']")).click();
	}
}