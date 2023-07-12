package greentrade.crm.pom;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.greentreand.genericutility.ExcelUtlity;
import com.greentreand.genericutility.FileUtlity;
import com.greentreand.genericutility.JavaUtlity;
import com.greentreand.genericutility.WebActionUtility;
import com.greentrend.objectrepository.AdministratorSettingsPage;
import com.greentrend.objectrepository.CampaignPage;
import com.greentrend.objectrepository.CreateNewCampaignPage;
import com.greentrend.objectrepository.CreateNewOpportunityPage;
import com.greentrend.objectrepository.CreateNewOrganizationPage;
import com.greentrend.objectrepository.CreateNewProductPage;
import com.greentrend.objectrepository.CreateNewVendorsPage;
import com.greentrend.objectrepository.HomePage;
import com.greentrend.objectrepository.LoginPage;
import com.greentrend.objectrepository.OpportunitiesPage;
import com.greentrend.objectrepository.OpportunityInformationPage;
import com.greentrend.objectrepository.OrganIzationsPage;
import com.greentrend.objectrepository.ProductsPage;
import com.greentrend.objectrepository.SearchOrganizationPage;
import com.greentrend.objectrepository.SearchProductPage;
import com.greentrend.objectrepository.SearchVendorPage;
import com.greentrend.objectrepository.VendorsPage;

public class CreateNewOpportunity {

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
		//Login
		LoginPage login=new LoginPage(driver);
		login.loginToApp(username, password);

		//TestScript data
		String vendorname=eLib.getDataFromExcelBasedTestId(Excel_File_Path, "vendor", "TC_35", "Vendor Name")+"_"+randomNum;
		String productName=eLib.getDataFromExcelBasedTestId(Excel_File_Path, "product", "TC_35", "Product Name")+"_"+randomNum;
		String campName=eLib.getDataFromExcelBasedTestId(Excel_File_Path, "campaign","TC_35","Campaign Name")+"_"+randomNum;
		String opportunityName=eLib.getDataFromExcelBasedTestId(Excel_File_Path, "opportunity","TC_33","Opportunity Name")+"_"+randomNum;
		String orgName=eLib.getDataFromExcelBasedTestId(Excel_File_Path, "org","TC_35","Organization Name")+"_"+randomNum;
		
		//Create Vendor
		HomePage homepage=new HomePage(driver);
		homepage.getMoreLink().click();
		homepage.getVendorsLink().click();
		//naviage to craete vendor page

		VendorsPage vpage=new VendorsPage(driver);
		vpage.getCreateVendorsPage();

		//Create Vendor
		CreateNewVendorsPage cnPage=new CreateNewVendorsPage(driver);
		cnPage.createVendor(vendorname);
		//create Organization
		homepage.getOrgLink().click();
		OrganIzationsPage orgPage=new OrganIzationsPage(driver);
		orgPage.getCreateOrganizatiomLookUpImage().click();
		CreateNewOrganizationPage CNOP=new CreateNewOrganizationPage(driver);
		CNOP.createOrg(orgName);
		//Create Product
		homepage=new HomePage(driver);
		Thread.sleep(2000);
		homepage.getProductLink().click();
		ProductsPage proPage=new ProductsPage(driver);
		proPage.getCreateProductLookUpImage().click();
		CreateNewProductPage cnp=new CreateNewProductPage(driver);
		cnp.createProduct(productName);		
		wLib.swithToWindow(driver, "Vendors");
		SearchVendorPage searchVpage=new SearchVendorPage(driver);
		searchVpage.getSearchEdt().sendKeys(vendorname);
		WebElement indropdown = searchVpage.getIndropDwn();
		wLib.selectBasedOnValue(indropdown, "vendorname");
		//wait
		//wLib.waitForTextToBePresent(driver, searchVpage.getSearchEdt(), vendorname);
		searchVpage.getSearchNowBtn().click();
		
		searchVpage.getRequiredVendorLink().click();	
		wLib.swithToWindow(driver, "Product");
		cnp.getSaveBtn().click();
		//Create Campaign
		homepage.getMoreLink().click();
		homepage.getCampaignLink().click();
		CampaignPage campPage=new CampaignPage(driver);
		campPage.getCreateCampaignLookUpImage().click();
		
		CreateNewCampaignPage CNCP=new CreateNewCampaignPage(driver);
		CNCP.getCampaignNameEdt().sendKeys(campName);
		WebElement campaigndropdown = CNCP.getCampTypeDropDown();		
		wLib.selectBasedOnValue(campaigndropdown, "Advertisement");
		CNCP.getProductSelectLookUpImage().click();	
		wLib.swithToWindow(driver, "Products");
		SearchProductPage srchProPage=new SearchProductPage(driver);
		srchProPage.getSearchEdt().sendKeys(productName);
		WebElement search = srchProPage.getIndropDwn();
		wLib.selectBasedOnValue(search, "productname");	
		//wait
		//wLib.waitForTextToBePresent(driver, srchProPage.getSearchEdt(), vendorname);
		srchProPage.getSearchNowBtn().click();
		srchProPage.getRequiredProductLink().click();
		wLib.swithToWindowBasedOnURL(driver, "module=Campaigns&action=EditView");
		CNCP.getSaveBtn().click();
		homepage.getOpportunityLink().click();
		OpportunitiesPage oPage=new OpportunitiesPage(driver);
		oPage.getCreateOpportunityLookUpImage().click();
		CreateNewOpportunityPage CNO=new CreateNewOpportunityPage(driver); 
		CNO.getOpportunityNameEdt().sendKeys(opportunityName);
		CNO.getSelectProductLookUpImg().click();
		wLib.swithToWindow(driver, "Organizations");
		SearchOrganizationPage srchPage1=new SearchOrganizationPage(driver);
		srchPage1.getSearchEdt().sendKeys(orgName);
		WebElement dropDown1 = srchPage1.getIndropDwn();
		wLib.selectBasedOnValue(dropDown1, "accountname");
		srchPage1.getSearchNowBtn().click();
		srchPage1.getRequiredOrgLink().click();
		wLib.swithToWindowBasedOnURL(driver, "module=Potentials&action=EditView");
		CNO.getSaveBtn().click();
		
		OpportunityInformationPage oinPage=new OpportunityInformationPage(driver);
		
		String actualtext =oinPage.getCreatedOpportunityName().getText();
		
		if(actualtext.contains(opportunityName))
		{
			System.out.println("Opportunity is created and Pass");
		}
		else {
			System.out.println("Opportunity is not created and fail");
		}	
		
		homepage.signOut(wLib, driver);
		
	}

}
