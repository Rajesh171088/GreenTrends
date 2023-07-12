package greentrade.crm.testNg;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.greentreand.genericutility.BaseClass;
import com.greentreand.genericutility.ExcelUtlity;
import com.greentrend.objectrepository.CampaignPage;
import com.greentrend.objectrepository.CreateNewCampaignPage;
import com.greentrend.objectrepository.CreateNewOpportunityPage;
import com.greentrend.objectrepository.CreateNewOrganizationPage;
import com.greentrend.objectrepository.CreateNewProductPage;
import com.greentrend.objectrepository.CreateNewVendorsPage;
import com.greentrend.objectrepository.HomePage;
import com.greentrend.objectrepository.OpportunitiesPage;
import com.greentrend.objectrepository.OpportunityInformationPage;
import com.greentrend.objectrepository.OrganIzationsPage;
import com.greentrend.objectrepository.ProductsPage;
import com.greentrend.objectrepository.SearchOrganizationPage;
import com.greentrend.objectrepository.SearchProductPage;
import com.greentrend.objectrepository.SearchVendorPage;
import com.greentrend.objectrepository.VendorsPage;
@Listeners(com.greentreand.genericutility.LisImpClass.class)
public class CreateNewOpportunityTest extends BaseClass{
	@Test
	public  void verifyopportunityCreation() throws Throwable {
		ExcelUtlity eLib=new ExcelUtlity();
		//get Random number
		int randomNum=jLib.getRandomNumber();		
		//to get the file paths
		//String projectConfigDataFilePath=fLib.getFilePathFromPropertiesFile("projectConfigDataFilePath");
		String Excel_File_Path=fLib.getFilePathFromPropertiesFile("testScriptdatafilePath");
				
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
		Assert.fail();
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
		
		
		
	}

}
