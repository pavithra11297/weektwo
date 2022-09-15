package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBox {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://leafground.com/checkbox.xhtml");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//label[text()='Java']")).click();
		driver.findElement(By.xpath("//label[text()='Python']")).click();
		boolean checkboxDisabled = driver.findElement(By.xpath("(//div[@class='ui-selectbooleancheckbox ui-chkbox ui-widget'])[3]")).isEnabled();
		if(checkboxDisabled==true)
		{
			System.out.println("check box is disabled");
		}
		else
		{
			System.out.println("check box is not disabled");
		}
	}
}