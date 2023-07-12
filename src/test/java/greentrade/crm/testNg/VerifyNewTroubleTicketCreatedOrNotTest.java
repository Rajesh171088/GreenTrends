package greentrade.crm.testNg;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.greentreand.genericutility.BaseClass;
import com.greentreand.genericutility.ExcelUtlity;
import com.greentrend.objectrepository.ContactsPage;
import com.greentrend.objectrepository.CreateNewContactsPage;
import com.greentrend.objectrepository.CreateNewProductPage;
import com.greentrend.objectrepository.CreateNewTicketPage;
import com.greentrend.objectrepository.CreateNewVendorsPage;
import com.greentrend.objectrepository.HomePage;
import com.greentrend.objectrepository.ProductsPage;
import com.greentrend.objectrepository.SearchContactPage;
import com.greentrend.objectrepository.SearchOrganizationPage;
import com.greentrend.objectrepository.SearchProductPage;
import com.greentrend.objectrepository.SearchVendorPage;
import com.greentrend.objectrepository.TicketInformationPage;
import com.greentrend.objectrepository.TroubleTicketPage;
import com.greentrend.objectrepository.VendorsPage;

public class VerifyNewTroubleTicketCreatedOrNotTest  extends BaseClass{

	@Test
	public  void troubleTicket() throws Throwable {

		//Create Object of Libraries
		
		ExcelUtlity eLib=new ExcelUtlity();
		
		//to get file paths
		String projectConfigDataFilePath=fLib.getFilePathFromPropertiesFile("projectConfigDataFilePath");
		String Excel_File_Path=fLib.getFilePathFromPropertiesFile("testScriptdatafilePath");

		int randomNum=jLib.getRandomNumber();

		//to read testScript data
		String vendorname=eLib.getDataFromExcelBasedTestId(Excel_File_Path, "vendor", "TC_35", "Vendor Name")+"_"+randomNum;
		String productName=eLib.getDataFromExcelBasedTestId(Excel_File_Path, "product", "TC_35", "Product Name")+"_"+randomNum;
		String opportunityName=eLib.getDataFromExcelBasedTestId(Excel_File_Path, "opportunity","TC_33","Opportunity Name")+"_"+randomNum;
		String firstName=eLib.getDataFromExcelBasedTestId(Excel_File_Path, "contact","TC_33","First Name");
		String lastName=eLib.getDataFromExcelBasedTestId(Excel_File_Path, "contact","TC_33","Last Name");
		String pbName=eLib.getDataFromExcelBasedTestId(Excel_File_Path,"PriceBook","TC_33","Price Book Name");
		String orgName=eLib.getDataFromExcelBasedTestId(Excel_File_Path, "org","TC_35","Organization Name")+"_"+randomNum;
		String subject=eLib.getDataFromExcelBasedTestId(Excel_File_Path, "Quotes", "TC_33","Subject" );
		String ticketTitle=eLib.getDataFromExcelBasedTestId(Excel_File_Path, "Trouble Ticket", "TC_34","title" );


		
		//create Vendor
		HomePage homepage=new HomePage(driver);
		homepage.getMoreLink().click();
		homepage.getVendorsLink().click();
		//naviage to craete vendor page

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
		WebElement indropdown = searchVpage.getIndropDwn();
		wLib.selectBasedOnValue(indropdown, "vendorname");
		//wait
		//wLib.waitForTextToBePresent(driver, searchVpage.getSearchEdt(), vendorname);
		searchVpage.getSearchNowBtn().click();

		searchVpage.getRequiredVendorLink().click();	
		wLib.swithToWindow(driver, "Product");
		cnp.getSaveBtn().click();
		wLib.waitForElement(driver);
		//create Contact
		homepage.getContactLink().click();
		ContactsPage cPage=new ContactsPage(driver);
		cPage.getCreateOrganizatiomLookUpImage().click();
		CreateNewContactsPage createContact=new CreateNewContactsPage(driver);
		WebElement selectDropDown = createContact.getSalDropDown();
		wLib.selectBasedOnValue(selectDropDown,	"Mr.");
		createContact.getFirstName().sendKeys(firstName);
		createContact.getContactNameEdt().sendKeys(lastName);
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
		
		//Create TroubleTicket
		homepage.getTtLink().click();
		TroubleTicketPage ttpage=new TroubleTicketPage(driver);
		ttpage.getCreateTicketLookUpImage().click();
		
		CreateNewTicketPage cntpage=new CreateNewTicketPage(driver);
		cntpage.getTicketNameEdt().sendKeys(ticketTitle);
		cntpage.getGroupRadioBtn().click();
		
		WebElement groupDropDown = cntpage.getGroupDropDown();
		wLib.selectBasedOnValue(groupDropDown, "4");
		
		cntpage.getContactLookUpImg().click();
		wLib.swithToWindow(driver, "Contacts");
		
		SearchContactPage srchcontact=new SearchContactPage(driver);
		srchcontact.getSearchEdt().sendKeys(firstName+" "+lastName);
		
		WebElement indropdown2 = srchcontact.getIndropDwn();
		wLib.selectBasedOnValue(indropdown2, "lastname");
		srchcontact.getSearchNowBtn().click();
		srchcontact.getRequiredContactLink().click();
		
		wLib.swithToWindow(driver, "Trouble Tickets");
		
		cntpage.getProductLookUpImg().click();
		wLib.swithToWindow(driver, "Products");
		
		SearchProductPage srchproduct=new SearchProductPage(driver);
		srchproduct.getSearchEdt().sendKeys(productName);
		
		WebElement indropdown3 = srchproduct.getIndropDwn();
		wLib.selectBasedOnValue(indropdown3, "productname");
		
		srchproduct.getSearchNowBtn().click();
		srchproduct.getRequiredProductLink().click();
		
		
		wLib.swithToWindow(driver, "Trouble Tickets");
		cntpage.getSaveBtn().click();
		
		TicketInformationPage tiPage=new TicketInformationPage(driver);
		
		String text=tiPage.getCreatedticketName().getText();;
		if(text.contains(ticketTitle))
		{
			System.out.println("TroubleTicket creation is verified and Pass");
		}
		else {
			System.out.println("Trouble Ticket Creation is not verified and Fail");
		}
		
	}

}
