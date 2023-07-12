package greentrade.crm.pom;

import java.time.Duration;
import java.util.Set;

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

import com.greentreand.genericutility.ExcelUtlity;
import com.greentreand.genericutility.FileUtlity;
import com.greentreand.genericutility.JavaUtlity;
import com.greentreand.genericutility.WebActionUtility;
import com.greentrend.objectrepository.ContactsPage;
import com.greentrend.objectrepository.CreateNewContactsPage;
import com.greentrend.objectrepository.CreateNewOpportunity;
import com.greentrend.objectrepository.CreateNewOpportunityPage;
import com.greentrend.objectrepository.CreateNewOrganizationPage;
import com.greentrend.objectrepository.CreateNewPriceBookPage;
import com.greentrend.objectrepository.CreateNewProductPage;
import com.greentrend.objectrepository.CreateNewQuotePage;
import com.greentrend.objectrepository.CreateNewVendorsPage;
import com.greentrend.objectrepository.HomePage;
import com.greentrend.objectrepository.LoginPage;
import com.greentrend.objectrepository.OpportunitiesPage;
import com.greentrend.objectrepository.OrganIzationsPage;
import com.greentrend.objectrepository.PriceBookPage;
import com.greentrend.objectrepository.ProductsPage;
import com.greentrend.objectrepository.QuotesPage;
import com.greentrend.objectrepository.SearchContactPage;
import com.greentrend.objectrepository.SearchOpportunityPage;
import com.greentrend.objectrepository.SearchOrganizationPage;
import com.greentrend.objectrepository.SearchVendorPage;
import com.greentrend.objectrepository.VendorsPage;

public class VerifyNewQuotationIsCreatedOrNot {

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
		String vendorname=eLib.getDataFromExcelBasedTestId(Excel_File_Path, "quotes", "TC_36", "Vendor Name")+"_"+randomNum;
		String productName=eLib.getDataFromExcelBasedTestId(Excel_File_Path, "quotes", "TC_36", "Product Name")+"_"+randomNum;
		String opportunityName=eLib.getDataFromExcelBasedTestId(Excel_File_Path, "quotes","TC_36","Opportunity Name")+"_"+randomNum;
		String firstName=eLib.getDataFromExcelBasedTestId(Excel_File_Path, "quotes","TC_36","First Name");
		String lastName=eLib.getDataFromExcelBasedTestId(Excel_File_Path, "quotes","TC_36","Last Name");
		String pbName=eLib.getDataFromExcelBasedTestId(Excel_File_Path,"quotes","TC_36","PriceBook Name");
		String orgName=eLib.getDataFromExcelBasedTestId(Excel_File_Path, "quotes","TC_36","Organization Name")+"_"+randomNum;
		
		
		String subject=eLib.getDataFromExcelBasedTestId(Excel_File_Path, "quotes", "TC_36","Subject" );
		String billAddress=eLib.getDataFromExcelBasedTestId(Excel_File_Path, "quotes", "TC_36","Billing Address" );
		String billPoBox=eLib.getDataFromExcelBasedTestId(Excel_File_Path, "quotes", "TC_36","Billing PO Box" );
		String billCity=eLib.getDataFromExcelBasedTestId(Excel_File_Path, "quotes", "TC_36","Billing City" );
		String billState=eLib.getDataFromExcelBasedTestId(Excel_File_Path, "quotes", "TC_36","Billing State" );
		String billPost=eLib.getDataFromExcelBasedTestId(Excel_File_Path, "quotes", "TC_36","Billing Post Code" );
		String billCountry=eLib.getDataFromExcelBasedTestId(Excel_File_Path, "quotes", "TC_36","Billing Country" );
		String qty=eLib.getDataFromExcelBasedTestId(Excel_File_Path, "quotes", "TC_36","Qty" );
		String listPrice=eLib.getDataFromExcelBasedTestId(Excel_File_Path, "quotes", "TC_36","List Price" );
		String validtill=eLib.getDataFromExcelBasedTestId(Excel_File_Path, "quotes", "TC_36", "valid till");
		System.out.println(orgName);
		System.out.println(pbName);
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
		//create Vendor
		HomePage homepage=new HomePage(driver);
		homepage.getMoreLink().click();
		homepage.getVendorsLink().click();
		//naviage to create vendor page

		VendorsPage vpage=new VendorsPage(driver);
		vpage.getCreateVendorsPage();

		//Create Vendor
		CreateNewVendorsPage cnPage=new CreateNewVendorsPage(driver);
		cnPage.createVendor(vendorname);
		//Create Product

		homepage.getProductLink().click();
		ProductsPage proPage=new ProductsPage(driver);
		proPage.getCreateProductLookUpImage().click();
		CreateNewProductPage cnp=new CreateNewProductPage(driver);
		cnp.createProduct(productName);		
		wLib.swithToWindow(driver, "Vendors");
		SearchVendorPage searchVpage=new SearchVendorPage(driver);
		searchVpage.getSearchEdt().sendKeys(vendorname);
		Thread.sleep(1000);
		WebElement indropdown = searchVpage.getIndropDwn();
		wLib.selectBasedOnValue(indropdown, "vendorname");
		
		searchVpage.getSearchNowBtn().click();

		searchVpage.getRequiredVendorLink().click();	
		wLib.swithToWindow(driver, "Product");
		cnp.getSaveBtn().click();
		//Create Organization
		homepage.getOrgLink().click();
		OrganIzationsPage orgPage=new OrganIzationsPage(driver);
		orgPage.getCreateOrganizatiomLookUpImage().click();

		CreateNewOrganizationPage CNOP=new CreateNewOrganizationPage(driver);
		CNOP.createOrg(orgName);	
		
		//create Contact
		//HomePage hmPage=new HomePage(driver);
		homepage.getContactLink().click();
		ContactsPage cPage=new ContactsPage(driver);
		cPage.getCreateOrganizatiomLookUpImage().click();
		CreateNewContactsPage createContact=new CreateNewContactsPage(driver);
		WebElement selectDropDown = createContact.getSalDropDown();
		wLib.selectBasedOnValue(selectDropDown,	"Mr.");
		createContact.getFirstName().sendKeys(firstName);
		createContact.getFirstName().sendKeys(lastName);
		createContact.getSelectLookUpImg().click();
		wLib.swithToWindow(driver, "Organizations");		
		SearchOrganizationPage srchPage=new SearchOrganizationPage(driver);
		srchPage.getSearchEdt().sendKeys(orgName);
		WebElement dropDown = srchPage.getIndropDwn();
		wLib.selectBasedOnValue(dropDown, "accountname");
		srchPage.getSearchNowBtn().click();
		srchPage.getRequiredOrgLink().click();
		wLib.swithToWindow(driver, "Contact Information");
		createContact.getSaveBtn().click();		
		//Create Opportunity

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
		wLib.swithToWindow(driver, "Creating New Opportunity");
		CNO.getSaveBtn().click();

		//Create Pricebook
		homepage.getMoreLink().click();
		homepage.getPBLink().click();
		PriceBookPage pbPage=new PriceBookPage(driver);
		pbPage.getCreatePriceBookLookUpImage().click();
		CreateNewPriceBookPage cnpbPage=new CreateNewPriceBookPage(driver);
		cnpbPage.getBookNameEdt().sendKeys(pbName);
		cnpbPage.getSaveBtn().click();

		//Create Quotes
		homepage.getMoreLink().click();
		homepage.getQuoteLink().click();
		QuotesPage qPage=new QuotesPage(driver);
		qPage.getCreateQuoteLookUpImage().click();
		CreateNewQuotePage cnqPage=new CreateNewQuotePage(driver);
		cnqPage.getQuoteNameEdt().sendKeys(subject);
		cnqPage.getValidTillField().sendKeys(validtill);
		cnqPage.getOpportunityLookUpImg().click();
		wLib.swithToWindow(driver, "Opportunities");

		SearchOpportunityPage soPage=new SearchOpportunityPage(driver);
		soPage.getSearchEdt().sendKeys(opportunityName);
		WebElement dropDown2 = soPage.getIndropDwn();
		wLib.selectBasedOnValue(dropDown2, "potentialname");
		soPage.getSearchNowBtn().click();
		soPage.getRequiredOpportunityLink().click();
		wLib.swithToWindow(driver, "Creating New Quote");
		cnqPage.getSaveBtn().click();	

		cnqPage.getContactLookUpImg().click();
		wLib.swithToWindow(driver, "Contacts");
		SearchContactPage scPage=new SearchContactPage(driver);
		scPage.getSearchEdt().sendKeys(firstName+" "+lastName);

		WebElement indropdown3 = scPage.getIndropDwn();
		wLib.selectBasedOnValue(indropdown3, "lastname");
		scPage.getSearchNowBtn().click();
		scPage.getRequiredContactLink().click();
		wLib.swithToAlertWindowAndAccpect(driver);
		wLib.swithToWindow(driver, "Creating New Quote");

		cnqPage.getOrgLookUpImg().click();
		wLib.swithToWindow(driver, "Organizations");
		SearchOrganizationPage srchPage2=new SearchOrganizationPage(driver);
		srchPage2.getSearchEdt().sendKeys(orgName);
		WebElement dropDown12 = srchPage.getIndropDwn();
		wLib.selectBasedOnValue(dropDown2, "accountname");
		srchPage2.getSearchNowBtn().click();
		srchPage2.getRequiredOrgLink().click();
		wLib.swithToAlertWindowAndAccpect(driver);
		wLib.swithToWindow(driver, "Creating New Quote");
		cnqPage.createQuote(billAddress, billPoBox, billCity, billState, billPost, billCountry);
		

		
		driver.findElement(By.xpath("(//input[@name='cpy'])[position()=2]")).click();		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		CNO.getSaveBtn().click();

		homepage.signOut(wLib, driver);
		
	}

}
