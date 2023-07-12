package greentrade.vendor.practice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VerifyNewTroubleTicketCreatedOrNot {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("http://localhost:8888/");
		//login
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Actions a=new Actions(driver);
		//create Vendor
		WebElement majortab=driver.findElement(By.linkText("More"));
		a.moveToElement(majortab).perform();
		driver.findElement(By.xpath("//a[@name='Vendors']")).click();
		driver.findElement(By.xpath("//img[@title='Create Vendor...']")).click();
		driver.findElement(By.xpath("//input[@name='vendorname']")).sendKeys("HP");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//Create Product
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		driver.findElement(By.xpath("//input[@name='productname']")).sendKeys("Laptop");
		driver.findElement(By.xpath("//img[@title='Select']")).click();
		Set<String> allwindows = driver.getWindowHandles();
		for (String window : allwindows) {
			driver.switchTo().window(window);
			String title = driver.getTitle();
			if(title.equalsIgnoreCase("Vendors"))
			{
				break;
			}
		}
		driver.findElement(By.id("search_txt")).sendKeys("HP");
		WebElement indropdown = driver.findElement(By.name("search_field"));
		Select s=new Select(indropdown);
		s.selectByValue("vendorname");
		driver.findElement(By.xpath("//input[@name='search']")).click();
		driver.findElement(By.linkText("HP")).click();	
		Set<String> allwindows1 = driver.getWindowHandles();
		for (String window : allwindows1) {
			driver.switchTo().window(window);
			String title = driver.getTitle();
			if(title.equalsIgnoreCase("Creating New Product"))
			{
				break;
			}
		}
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//Create Organization
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("PESCE");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		wait.until(ExpectedConditions.alertIsPresent());
		Alert altPopUp = driver.switchTo().alert();
		altPopUp.accept();
		//create Contact
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		WebElement prefixDropDown = driver.findElement(By.name("salutationtype"));
		Select s1=new Select(prefixDropDown);
		s1.selectByValue("Mr.");
		driver.findElement(By.name("firstname")).sendKeys("Vivek");
		driver.findElement(By.name("lastname")).sendKeys("Nagarle");
		driver.findElement(By.xpath("//img[@title='Select']")).click();
		Set<String> allwindows2 = driver.getWindowHandles();
		for (String window : allwindows2) {
			driver.switchTo().window(window);
			String title = driver.getTitle();
			if(title.equalsIgnoreCase("Organizations"))
			{
				break;
			}
		}
		driver.findElement(By.id("search_txt")).sendKeys("PESCE");
		WebElement indropdown1 = driver.findElement(By.name("search_field"));
		Select s2=new Select(indropdown1);
		s2.selectByValue("accountname");
		driver.findElement(By.xpath("//input[@name='search']")).click();
		driver.findElement(By.linkText("PESCE")).click();	
		Set<String> allwindows3 = driver.getWindowHandles();
		for (String window : allwindows3) {
			driver.switchTo().window(window);
			String title = driver.getTitle();
			if(title.equalsIgnoreCase("Contact Information"))
			{
				break;
			}
		}
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		driver.findElement(By.linkText("Trouble Tickets")).click();
		driver.findElement(By.xpath("//img[@alt='Create Ticket...']")).click();
		driver.findElement(By.name("ticket_title")).sendKeys("Harddisktrouble");
		driver.findElement(By.xpath("//input[@value='T']")).click();
		WebElement groupDropDown = driver.findElement(By.name("assigned_group_id"));
		Select s3=new Select(groupDropDown);
		s3.selectByValue("4");
		driver.findElement(By.xpath("(//img[@title='Select'])[position()=1]")).click();
		Set<String> allwindows4 = driver.getWindowHandles();
		for (String window : allwindows4) {
			driver.switchTo().window(window);
			String title = driver.getTitle();
			if(title.equalsIgnoreCase("Contacts"))
			{
				break;
			}
		}
		driver.findElement(By.id("search_txt")).sendKeys("Vivek Nagarle");
		WebElement indropdown2 = driver.findElement(By.name("search_field"));
		Select s4=new Select(indropdown2);
		s4.selectByValue("lastname");
		driver.findElement(By.xpath("//input[@name='search']")).click();
		driver.findElement(By.linkText("Vivek Nagarle")).click();	
		Set<String> allwindows5 = driver.getWindowHandles();
		for (String window : allwindows5) {
			driver.switchTo().window(window);
			String title = driver.getTitle();
			if(title.equalsIgnoreCase("Trouble Tickets"))
			{
				break;
			}
		}
		driver.findElement(By.xpath("(//img[@title='Select'])[position()=2]")).click();
		Set<String> allwindows6 = driver.getWindowHandles();
		for (String window : allwindows6) {
			driver.switchTo().window(window);
			String title = driver.getTitle();
			if(title.equalsIgnoreCase("Products"))
			{
				break;
			}
		}
		driver.findElement(By.id("search_txt")).sendKeys("Laptop");
		WebElement indropdown3 = driver.findElement(By.name("search_field"));
		Select s5=new Select(indropdown3);
		s5.selectByValue("productname");
		driver.findElement(By.xpath("//input[@name='search']")).click();
		driver.findElement(By.linkText("Laptop")).click();	
		Set<String> allwindows7 = driver.getWindowHandles();
		for (String window : allwindows7) {
			driver.switchTo().window(window);
			String title = driver.getTitle();
			if(title.equalsIgnoreCase("Trouble Tickets"))
			{
				break;
			}
		}
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String text=driver.findElement(By.className("dvHeaderText")).getText();
		if(text.contains("Harddisktrouble"))
		{
			System.out.println("TroubleTicket creation is verified and Pass");
		}
		else {
			System.out.println("Trouble Ticket Creation is not verified and Fail");
		}
	}

}
