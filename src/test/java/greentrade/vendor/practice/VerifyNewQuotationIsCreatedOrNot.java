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

public class VerifyNewQuotationIsCreatedOrNot {

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
		//Create Campaign
		WebElement majortab1=driver.findElement(By.linkText("More"));
		a.moveToElement(majortab1).perform();
		driver.findElement(By.name("Campaigns")).click();
		driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		driver.findElement(By.name("campaignname")).sendKeys("RoadShow");
		WebElement campaigndropdown=driver.findElement(By.name("campaigntype"));
		Select s1=new Select(campaigndropdown);
		s1.selectByValue("Advertisement");
		driver.findElement(By.xpath("//img[@alt='Select']")).click();
		Set<String> allwindows2 = driver.getWindowHandles();
		for (String window : allwindows2) {
			driver.switchTo().window(window);
			String title = driver.getTitle();
			if(title.equalsIgnoreCase("Products"))
			{
				break;
			}
		}
		driver.findElement(By.name("search_text")).sendKeys("Laptop");
		WebElement search = driver.findElement(By.name("search_field"));
		Select s2=new Select(search);
		s2.selectByValue("productname");
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText("Laptop")).click();
		Set<String> allwindows3= driver.getWindowHandles();
		for (String window : allwindows3) {
			driver.switchTo().window(window);
			String title = driver.getTitle();
			if(title.equalsIgnoreCase("Creating New Campaign"))
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
		Select s3=new Select(prefixDropDown);
		s3.selectByValue("Mr.");
		driver.findElement(By.name("firstname")).sendKeys("Vivek");
		driver.findElement(By.name("lastname")).sendKeys("Nagarle");
		driver.findElement(By.xpath("//img[@title='Select']")).click();
		Set<String> allwindows4 = driver.getWindowHandles();
		for (String window : allwindows4) {
			driver.switchTo().window(window);
			String title = driver.getTitle();
			if(title.equalsIgnoreCase("Organizations"))
			{
				break;
			}
		}
		driver.findElement(By.id("search_txt")).sendKeys("PESCE");
		WebElement indropdown1 = driver.findElement(By.name("search_field"));
		Select s4=new Select(indropdown1);
		s4.selectByValue("accountname");
		driver.findElement(By.xpath("//input[@name='search']")).click();
		driver.findElement(By.linkText("PESCE")).click();	
		Set<String> allwindows5 = driver.getWindowHandles();
		for (String window : allwindows5) {
			driver.switchTo().window(window);
			String title = driver.getTitle();
			if(title.equalsIgnoreCase("Contact Information"))
			{
				break;
			}
		}
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//Create Opportunity
		driver.findElement(By.linkText("Opportunities")).click();
		driver.findElement(By.xpath("//img[@title='Create Opportunity...']")).click();
		driver.findElement(By.name("potentialname")).sendKeys("PESCE");
		driver.findElement(By.xpath("//img[@title='Select']")).click();
		Set<String> allwindows6= driver.getWindowHandles();
		for (String window : allwindows6) {
			driver.switchTo().window(window);
			String title = driver.getTitle();
			if(title.equalsIgnoreCase("Organizations"))
			{
				break;
			}
		}
		driver.findElement(By.name("search_text")).sendKeys("PESCE");
		WebElement search1 = driver.findElement(By.name("search_field"));
		Select s5=new Select(search1);
		s5.selectByValue("accountname");
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText("PESCE")).click();
		Set<String> allwindows7= driver.getWindowHandles();
		for (String window : allwindows7) {
			driver.switchTo().window(window);
			String title = driver.getTitle();
			if(title.equalsIgnoreCase("Creating New Opportunity"))
			{
				break;
			}
		}
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//Create Pricebook
		WebElement majortab2=driver.findElement(By.linkText("More"));
		a.moveToElement(majortab2).perform();
		driver.findElement(By.linkText("Price Books")).click();
		driver.findElement(By.xpath("//img[@title='Create Price Book...']")).click();
		driver.findElement(By.name("bookname")).sendKeys("HPLaptop15");
		driver.findElement(By.xpath("//td/input[contains(@name,'pricebook_no')]")).sendKeys("HP001");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//Create Quotes
		WebElement majortab3=driver.findElement(By.linkText("More"));
		a.moveToElement(majortab3).perform();
		driver.findElement(By.linkText("Quotes")).click();
		driver.findElement(By.xpath("//img[@title='Create Quote...']")).click();
		driver.findElement(By.name("subject")).sendKeys("Hp Pavilion 14");
		driver.findElement(By.name("validtill")).sendKeys("2023-07-15");
		driver.findElement(By.xpath("(//img[@title='Select'])[position()=1]")).click();
		Set<String> allwindows8 = driver.getWindowHandles();
		for (String window : allwindows8) {
			driver.switchTo().window(window);
			String title = driver.getTitle();
			if(title.equalsIgnoreCase("Opportunities"))
			{
				break;
			}
		}
		driver.findElement(By.id("search_txt")).sendKeys("PESCE");
		WebElement indropdown2 = driver.findElement(By.name("search_field"));
		Select s6=new Select(indropdown2);
		s6.selectByValue("potentialname");
		driver.findElement(By.xpath("//input[@name='search']")).click();
		driver.findElement(By.linkText("PESCE")).click();	
		Set<String> allwindows9 = driver.getWindowHandles();
		for (String window : allwindows9) {
			driver.switchTo().window(window);
			String title = driver.getTitle();
			if(title.equalsIgnoreCase("Creating New Quote"))
			{
				break;
			}
		}
		driver.findElement(By.xpath("(//img[@title='Select'])[position()=2]")).click();
		Set<String> allwindows10 = driver.getWindowHandles();
		for (String window : allwindows10) {
			driver.switchTo().window(window);
			String title = driver.getTitle();
			if(title.equalsIgnoreCase("Contacts"))
			{
				break;
			}
		}
		driver.findElement(By.id("search_txt")).sendKeys("Vivek Nagarle");
		WebElement indropdown3 = driver.findElement(By.name("search_field"));
		Select s7=new Select(indropdown3);
		s7.selectByValue("lastname");
		driver.findElement(By.xpath("//input[@name='search']")).click();
		driver.findElement(By.linkText("Vivek Nagarle")).click();
		wait.until(ExpectedConditions.alertIsPresent());
		Alert altPopUp1 = driver.switchTo().alert();
		altPopUp1.accept();
		Set<String> allwindows11 = driver.getWindowHandles();
		for (String window : allwindows11) {
			driver.switchTo().window(window);
			String title = driver.getTitle();
			if(title.equalsIgnoreCase("Creating New Quote"))
			{
				break;
			}
		}
		driver.findElement(By.xpath("(//img[@title='Select'])[position()=3]")).click();
		Set<String> allwindows12 = driver.getWindowHandles();
		for (String window : allwindows12) {
			driver.switchTo().window(window);
			String title = driver.getTitle();
			if(title.equalsIgnoreCase("Organizations"))
			{
				break;
			}
		}
		driver.findElement(By.id("search_txt")).sendKeys("PESCE");
		WebElement indropdown4 = driver.findElement(By.name("search_field"));
		Select s8=new Select(indropdown4);
		s8.selectByValue("accountname");
		driver.findElement(By.xpath("//input[@name='search']")).click();
		driver.findElement(By.linkText("PESCE")).click();
		wait.until(ExpectedConditions.alertIsPresent());
		Alert altPopUp2 = driver.switchTo().alert();
		altPopUp2.accept();
		Set<String> allwindows13 = driver.getWindowHandles();
		for (String window : allwindows13) {
			driver.switchTo().window(window);
			String title = driver.getTitle();
			if(title.equalsIgnoreCase("Creating New Quote"))
			{
				break;
			}
		}	
		driver.findElement(By.name("bill_street")).sendKeys("PESCE Bangalore-85");
		driver.findElement(By.name("bill_pobox")).sendKeys("Srinagara");
		driver.findElement(By.name("bill_city")).sendKeys("Bangalore");
		driver.findElement(By.name("bill_state")).sendKeys("Karnataka");
		driver.findElement(By.name("bill_code")).sendKeys("560085");
		driver.findElement(By.name("bill_country")).sendKeys("India");
		driver.findElement(By.xpath("(//input[@name='cpy'])[position()=2]")).click();		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();		
	}

}
