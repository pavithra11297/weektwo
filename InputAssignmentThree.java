package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InputAssignmentThree {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://leafground.com/input.xhtml");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[@class='col-12']/input")).sendKeys("Pavithra");
		driver.findElement(By.xpath("//input[@value='Chennai']")).sendKeys(" INDIA");
		boolean enabled = driver.findElement(By.xpath("//form[@method='post']//input[@disabled='disabled']")).isEnabled();
		System.out.println("Text box is enabled : "+enabled);
		driver.findElement(By.xpath("//input[@disabled='disabled']/following::input")).clear();
		//Retrieve the typed text
		String Retrive = driver.findElement(By.xpath("//input[@name='j_idt88:j_idt97']")).getAttribute("value");
		System.out.println("Retrieved the typed text : " +Retrive);
		//Type email and Tab
		driver.findElement(By.xpath("//input[contains(@placeholder,'Your email')]")).sendKeys("pavi@gmail.com", Keys.TAB);
		//Just Press Enter and confirm error message*
		driver.findElement(By.xpath("//div[@class='col-12 mb-2 lg:col-8']/input")).sendKeys(Keys.ENTER);
		String ErrorAlertMsg = driver.findElement(By.className("ui-message-error-detail")).getText();
		boolean ErrorAlert = driver.findElement(By.className("ui-message-error-detail")).isDisplayed();
		if(ErrorAlert==true)
		{
			System.out.println(ErrorAlertMsg+ " error message is shown");

		}else
		{
			System.out.println(ErrorAlertMsg+ " error message is not shown");

		}
		//Click and Confirm Keyboard appears
		driver.findElement(By.xpath("//input[@class='ui-inputfield ui-keyboard-input ui-widget ui-state-default ui-corner-all is-keypad']")).click();
		boolean keyboard  = driver.findElement(By.xpath("//div[@class='ui-widget ui-widget-content ui-corner-all ui-shadow keypad-popup ui-input-overlay']")).isDisplayed();
		if(keyboard ==true)
		{
			System.out.println("Keyboard Appears");

		}else
		{
			System.out.println("Keyboard not appears");

		}


	}

}
