package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		//Login
		WebElement username=driver.findElement(By.xpath("//input[@type='text']"));
		username.sendKeys("DemoSalesManager");
		driver.findElement(By.xpath("//input[@name='PASSWORD']")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		//Go to Find Lead page
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		//search first name
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Pavithra");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);
		//Click on first resulting lead
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		//Verify title of the page
		System.out.println("The Page Title is :" +driver.getTitle());
		String oldcmpname = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		System.out.println("Old Company name " +oldcmpname);
		//Click Edit
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		//Change the company name
		WebElement cmpName=driver.findElement(By.id("updateLeadForm_companyName"));
		cmpName.clear();
		cmpName.sendKeys("Vaanam Pvt Ltd");
		driver.findElement(By.name("submitButton")).click();
		String newCmpName = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		System.out.println("New Company name " +newCmpName);
		//Confirm the changed name appears
		if(oldcmpname.equals(newCmpName))
		{
			System.out.println("Company name not updated");
		}
		else
		{
			System.out.println("Company name updated");
		}
		driver.close();
	}
}




