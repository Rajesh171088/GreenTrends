package greentrade.crm.genericpractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VerifyNewTroubleTicketCreation {

	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("./crmcommondata.properties");
		Properties p=new Properties();
		p.load(fis);
		String browser=p.getProperty("browser");
		String url=p.getProperty("url");
		String username=p.getProperty("username");
		String password=p.getProperty("password");
		//Login
		WebDriver driver=null;
		if(browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();			
		}
		else {
			driver=new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get(url);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Actions a=new Actions(driver);
		WebElement majortab=driver.findElement(By.linkText("More"));
		a.moveToElement(majortab).perform();
		driver.findElement(By.xpath("//a[@name='Vendors']")).click();
		driver.findElement(By.xpath("//img[@title='Create Vendor...']")).click();
		FileInputStream fis1=new FileInputStream("./crmtestscript.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		String vendor=wb.getSheet("Vendor").getRow(0).getCell(1).getStringCellValue();
		driver.findElement(By.xpath("//input[@name='vendorname']")).sendKeys(vendor);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//Create Product
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		String product=wb.getSheet("Product").getRow(0).getCell(1).getStringCellValue();
		driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(product);
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
		String org=wb.getSheet("Organization").getRow(0).getCell(1).getStringCellValue();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(org);
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
		String fn=wb.getSheet("Contacts").getRow(0).getCell(1).getStringCellValue();
		String ln=wb.getSheet("Contacts").getRow(1).getCell(1).getStringCellValue();
		driver.findElement(By.name("firstname")).sendKeys(fn);
		driver.findElement(By.name("lastname")).sendKeys(ln);
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
		String title=wb.getSheet("TroubleTicket").getRow(0).getCell(1).getStringCellValue();
		driver.findElement(By.name("ticket_title")).sendKeys(title);
		driver.findElement(By.xpath("//input[@value='T']")).click();
		WebElement groupDropDown = driver.findElement(By.name("assigned_group_id"));
		Select s3=new Select(groupDropDown);
		s3.selectByValue("4");
		driver.findElement(By.xpath("(//img[@title='Select'])[position()=1]")).click();
		Set<String> allwindows4 = driver.getWindowHandles();
		for (String window : allwindows4) {
			driver.switchTo().window(window);
			String title1 = driver.getTitle();
			if(title1.equalsIgnoreCase("Contacts"))
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
			String title1 = driver.getTitle();
			if(title1.equalsIgnoreCase("Trouble Tickets"))
			{
				break;
			}
		}
		driver.findElement(By.xpath("(//img[@title='Select'])[position()=2]")).click();
		Set<String> allwindows6 = driver.getWindowHandles();
		for (String window : allwindows6) {
			driver.switchTo().window(window);
			String title1 = driver.getTitle();
			if(title1.equalsIgnoreCase("Products"))
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
			String title1 = driver.getTitle();
			if(title1.equalsIgnoreCase("Trouble Tickets"))
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
