package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		String phoneNum="7418529630";
		//Login
		WebElement username=driver.findElement(By.xpath("//input[@type='text']"));
		username.sendKeys("DemoSalesManager");
		driver.findElement(By.xpath("//input[@name='PASSWORD']")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		//Go to phone number tab
		driver.findElement(By.xpath("(//em[@class='x-tab-left'])[2]")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phoneNum);
		//Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(4000);
		//Capture lead ID of First Resulting lead
		String leadId = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
		WebElement link = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
		link.click();
		//delete the lead id 
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadId);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(4000);
		//Verify message "No records to display" in the Lead List. This message confirms the successful deletion
        String alrtmsg = driver.findElement(By.xpath("//div[@class='x-panel-bbar']//div[text()='No records to display']")).getText();
		System.out.println(alrtmsg+ " message is verified");
		driver.close();
	}
}
