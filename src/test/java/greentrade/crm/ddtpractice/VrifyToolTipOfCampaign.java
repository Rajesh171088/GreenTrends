package greentrade.crm.ddtpractice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class VrifyToolTipOfCampaign {

	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("./config/projectEnvConfig.properties");
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
		//WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get(url);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Actions a=new Actions(driver);
		WebElement majortab=driver.findElement(By.linkText("More"));
		a.moveToElement(majortab).perform();
		driver.findElement(By.xpath("//a[@name='Vendors']")).click();
		driver.findElement(By.xpath("//img[@title='Create Vendor...']")).click();
		FileInputStream fis1=new FileInputStream("./Testscriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		String vendor=wb.getSheet("Vendor").getRow(1).getCell(2).getStringCellValue();
		driver.findElement(By.xpath("//input[@name='vendorname']")).sendKeys(vendor);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//String vendorid=driver.findElement(By.xpath("//font[@color='purple']")).getText();
		//vendorid=vendorid.replaceAll("[^a-zA-Z0-9]", "");
		//Create Product
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		String product=wb.getSheet("Product").getRow(1).getCell(2).getStringCellValue();
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
		driver.findElement(By.id("search_txt")).sendKeys(vendor);
		WebElement indropdown = driver.findElement(By.name("search_field"));
		Select s=new Select(indropdown);
		s.selectByValue("vendorname");
		driver.findElement(By.xpath("//input[@name='search']")).click();
		driver.findElement(By.linkText(vendor)).click();	
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
		//Create new Campaign
		WebElement majortab1=driver.findElement(By.linkText("More"));
		a.moveToElement(majortab1).perform();
		driver.findElement(By.name("Campaigns")).click();
		driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		String camp=wb.getSheet("Campaign").getRow(1).getCell(2).getStringCellValue();
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
		driver.findElement(By.name("search_text")).sendKeys(product);
		WebElement search = driver.findElement(By.name("search_field"));
		Select s2=new Select(search);
		s2.selectByValue("productname");
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText(product)).click();
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
		//tooltip selection
		driver.findElement(By.xpath("//img[@alt='Campaigns Settings']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Tooltip Management')]")).click();
		WebElement selectfield = driver.findElement(By.id("pick_field"));
		Select s3=new Select(selectfield);
		s3.selectByValue("campaignname");
		driver.findElement(By.xpath("(//td[contains(text(),'Product')]/preceding-sibling::td/input)[position()=last()]")).click();
		driver.findElement(By.name("save")).click();
		WebElement majortab2=driver.findElement(By.linkText("More"));
		a.moveToElement(majortab2).perform();
		driver.findElement(By.name("Campaigns")).click();
		driver.findElement(By.className("txtBox")).sendKeys(camp);
		WebElement campaignDrpDwn = driver.findElement(By.id("bas_searchfield"));
		Select s4=new Select(campaignDrpDwn);
		s4.selectByValue("campaignname");
		WebElement campaignName = driver.findElement(By.linkText(camp));
		a.moveToElement(campaignName).perform();
		a.pause(Duration.ofSeconds(3));
		String actualText = driver.findElement(By.xpath("//div[@class='tooltipClass']")).getText();
		System.out.println(actualText);
		String productText=product;
		if(actualText.contains(productText)) {
			System.out.println("Tooltip text for campaign is verified PASS");
		}
		else {
			System.out.println("Tooltip text for campaign is not verified Fail");
		}
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.manage().window().minimize();
		driver.quit();
	}
}
