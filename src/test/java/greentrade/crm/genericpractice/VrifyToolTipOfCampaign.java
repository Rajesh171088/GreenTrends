package greentrade.crm.genericpractice;

import java.io.FileInputStream;
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

import com.greentreand.genericutility.ExcelUtlity;
import com.greentreand.genericutility.FileUtlity;
import com.greentreand.genericutility.JavaUtlity;
import com.greentreand.genericutility.WebActionUtility;

public class VrifyToolTipOfCampaign {

	public static void main(String[] args) throws Throwable {
		//Create Object for Libraries
		JavaUtlity jLib=new JavaUtlity();
		WebActionUtility wLib=new WebActionUtility();
		ExcelUtlity eLib=new ExcelUtlity();
		FileUtlity fLib=new FileUtlity();
		
		//get Random number
		int randomNum=jLib.getRandomNumber();
		
		
		//to get the file paths
		String projectConfigDataFilePath=fLib.getFilePathFromPropertiesFile("projectConfigDataFilePath");
		String Excel_File_Path=fLib.getFilePathFromPropertiesFile("testScriptdatafilePath");
		
		//to read common data from property file
		
		String browser=fLib.getDataFromProperties(projectConfigDataFilePath, "browser");
		String url=fLib.getDataFromProperties(projectConfigDataFilePath, "url");
		String username=fLib.getDataFromProperties(projectConfigDataFilePath, "username");
		String password=fLib.getDataFromProperties(projectConfigDataFilePath, "password");
		
		//TestScript data
		String vendorname=eLib.getDataFromExcelBasedTestId(Excel_File_Path, "vendor", "TC_35", "Vendor Name");
		String productName=eLib.getDataFromExcelBasedTestId(Excel_File_Path, "product", "TC_35", "Product Name");
		String campName=eLib.getDataFromExcelBasedTestId(Excel_File_Path, "campaign","TC_35","Campaign Name");
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
		wLib.waitForElementInDOM(driver);
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		WebElement majortab=driver.findElement(By.linkText("More"));
		wLib.mouseOverOnElement(driver, majortab);
		driver.findElement(By.xpath("//a[@name='Vendors']")).click();
		driver.findElement(By.xpath("//img[@title='Create Vendor...']")).click();		
		
		driver.findElement(By.xpath("//input[@name='vendorname']")).sendKeys(vendorname);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//String vendorid=driver.findElement(By.xpath("//font[@color='purple']")).getText();
		//vendorid=vendorid.replaceAll("[^a-zA-Z0-9]", "");
		//Create Product
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		
		driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(productName);
		driver.findElement(By.xpath("//img[@title='Select']")).click();
		
		wLib.swithToWindow(driver, "Vendors");
		/*Set<String> allwindows = driver.getWindowHandles();
		for (String window : allwindows) {
			driver.switchTo().window(window);
			String title = driver.getTitle();
			if(title.equalsIgnoreCase("Vendors"))
			{
				break;
			}
		}*/
		driver.findElement(By.id("search_txt")).sendKeys(vendorname);
		WebElement indropdown = driver.findElement(By.name("search_field"));
		//Thread.sleep(3000);
		wLib.selectBasedOnValue(indropdown, "vendorname");
		
		/*Select s=new Select(indropdown);
		s.selectByValue("vendorname");*/
		driver.findElement(By.xpath("//input[@name='search']")).click();
		driver.findElement(By.linkText(vendorname)).click();	
		/*Set<String> allwindows1 = driver.getWindowHandles();
		for (String window : allwindows1) {
			driver.switchTo().window(window);
			String title = driver.getTitle();
			if(title.equalsIgnoreCase("Creating New Product"))
			{
				break;
			}
		}*/
		wLib.swithToWindow(driver, "Product");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//Create new Campaign
		WebElement majortab1=driver.findElement(By.linkText("More"));
		wLib.mouseOverOnElement(driver, majortab1);
		driver.findElement(By.name("Campaigns")).click();
		driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		
		driver.findElement(By.name("campaignname")).sendKeys(campName);
		WebElement campaigndropdown=driver.findElement(By.name("campaigntype"));
		wLib.selectBasedOnValue(campaigndropdown, "Advertisement");
		driver.findElement(By.xpath("//img[@alt='Select']")).click();
		/*Set<String> allwindows2 = driver.getWindowHandles();
		for (String window : allwindows2) {
			driver.switchTo().window(window);
			String title = driver.getTitle();
			if(title.equalsIgnoreCase("Products"))
			{
				break;
			}
		}*/
		wLib.swithToWindow(driver, "Products");
		driver.findElement(By.name("search_text")).sendKeys(productName);
		WebElement search = driver.findElement(By.name("search_field"));
		wLib.selectBasedOnValue(search, "productname");
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText(productName)).click();
		/*Set<String> allwindows3= driver.getWindowHandles();
		for (String window : allwindows3) {
			driver.switchTo().window(window);
			String title = driver.getTitle();
			if(title.equalsIgnoreCase("Creating New Campaign"))
			{
				break;
			}
		}*/
		wLib.swithToWindow(driver, "Creating New Campaign");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//tooltip selection
		driver.findElement(By.xpath("//img[@alt='Campaigns Settings']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Tooltip Management')]")).click();
		WebElement selectfield = driver.findElement(By.id("pick_field"));
		wLib.selectBasedOnValue(selectfield, "campaignname");
		driver.findElement(By.xpath("(//td[contains(text(),'Product')]/preceding-sibling::td/input)[position()=last()]")).click();
		driver.findElement(By.name("save")).click();
		WebElement majortab2=driver.findElement(By.linkText("More"));
		wLib.mouseOverOnElement(driver, majortab2);
		driver.findElement(By.name("Campaigns")).click();
		driver.findElement(By.className("txtBox")).sendKeys(campName);
		WebElement campaignDrpDwn = driver.findElement(By.id("bas_searchfield"));
		wLib.selectBasedOnValue(campaignDrpDwn, "campaignname");
		WebElement campaignName = driver.findElement(By.linkText(campName));
		wLib.mouseOverOnElement(driver, campaignName);
		wLib.waitForElement(driver, driver.findElement(By.xpath("//div[@class='tooltipClass']")));
		String actualText = driver.findElement(By.xpath("//div[@class='tooltipClass']")).getText();
		System.out.println(actualText);
		String productText=productName;
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
