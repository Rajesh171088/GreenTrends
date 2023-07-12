package greentrade.crm.ddtpractice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;
import org.apache.poi.EncryptedDocumentException;
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
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateNewOpportunity {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
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
		//create Organization
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		String org=wb.getSheet("Organization").getRow(0).getCell(1).getStringCellValue();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(org);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		wait.until(ExpectedConditions.alertIsPresent());
		Alert altPopUp = driver.switchTo().alert();
		altPopUp.accept();
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
		WebElement majortab1=driver.findElement(By.linkText("More"));
		a.moveToElement(majortab1).perform();
		driver.findElement(By.name("Campaigns")).click();
		driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		String camp=wb.getSheet("Campaign").getRow(0).getCell(1).getStringCellValue();
		driver.findElement(By.name("campaignname")).sendKeys(camp);
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
		driver.findElement(By.linkText("Opportunities")).click();
		driver.findElement(By.xpath("//img[@title='Create Opportunity...']")).click();
		String opp=wb.getSheet("Opportunity").getRow(0).getCell(1).getStringCellValue();
		driver.findElement(By.name("potentialname")).sendKeys(opp);
		driver.findElement(By.xpath("//img[@title='Select']")).click();
		Set<String> allwindows4= driver.getWindowHandles();
		for (String window : allwindows4) {
			driver.switchTo().window(window);
			String title = driver.getTitle();
			if(title.equalsIgnoreCase("Organizations"))
			{
				break;
			}
		}
		driver.findElement(By.name("search_text")).sendKeys("PESCE");
		WebElement search1 = driver.findElement(By.name("search_field"));
		Select s3=new Select(search1);
		s3.selectByValue("accountname");
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText("PESCE")).click();
		Set<String> allwindows5= driver.getWindowHandles();
		for (String window : allwindows5) {
			driver.switchTo().window(window);
			String title = driver.getTitle();
			if(title.equalsIgnoreCase("Creating New Opportunity"))
			{
				break;
			}
		}
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String actualtext = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		String Opportunity="PESCE";
		if(actualtext.contains(Opportunity))
		{
			System.out.println("Opportunity is created and Pass");
		}
		else {
			System.out.println("Opportunity is not created and fail");
		}		
	}

}
