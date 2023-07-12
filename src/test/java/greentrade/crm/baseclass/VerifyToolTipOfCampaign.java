package greentrade.crm.baseclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.greentreand.genericutility.BaseClass;
import com.greentreand.genericutility.ExcelUtlity;
import com.greentreand.genericutility.FileUtlity;
import com.greentreand.genericutility.JavaUtlity;
import com.greentreand.genericutility.WebActionUtility;
import com.greentrend.objectrepository.AdministratorSettingsPage;
import com.greentrend.objectrepository.CampaignPage;
import com.greentrend.objectrepository.CreateNewCampaignPage;
import com.greentrend.objectrepository.CreateNewProductPage;
import com.greentrend.objectrepository.CreateNewVendorsPage;
import com.greentrend.objectrepository.HomePage;
import com.greentrend.objectrepository.LoginPage;
import com.greentrend.objectrepository.ProductsPage;
import com.greentrend.objectrepository.SearchProductPage;
import com.greentrend.objectrepository.SearchVendorPage;
import com.greentrend.objectrepository.VendorsPage;

public class VerifyToolTipOfCampaign extends BaseClass{
	@Test(groups = {"regressionTest"})
	public  void toolTipVerification() throws Throwable {
		ExcelUtlity eLib=new ExcelUtlity();
		//get Random number
		int randomNum=jLib.getRandomNumber();		
		//to get the file paths
		String projectConfigDataFilePath=fLib.getFilePathFromPropertiesFile("projectConfigDataFilePath");
		String Excel_File_Path=fLib.getFilePathFromPropertiesFile("testScriptdatafilePath");
		
		//TestScript data
		String vendorname=eLib.getDataFromExcelBasedTestId(Excel_File_Path, "vendor", "TC_35", "Vendor Name")+"_"+randomNum;
		String productName=eLib.getDataFromExcelBasedTestId(Excel_File_Path, "product", "TC_35", "Product Name")+"_"+randomNum;
		String campName=eLib.getDataFromExcelBasedTestId(Excel_File_Path, "campaign","TC_35","Campaign Name")+"_"+randomNum;
		
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
		
		//Create Product
		homepage.getProductLink().click();
		ProductsPage proPage=new ProductsPage(driver);
		proPage.getCreateProductLookUpImage().click();
		CreateNewProductPage cnp=new CreateNewProductPage(driver);
		cnp.createProduct(productName);		
		wLib.swithToWindow(driver, "Vendors");
		SearchVendorPage searchVpage=new SearchVendorPage(driver);
		searchVpage.getSearchEdt().sendKeys(vendorname);
		wLib.waitForElement(driver);
		WebElement indropdown = searchVpage.getIndropDwn();
		wLib.selectBasedOnValue(indropdown, "vendorname");
		searchVpage.getSearchNowBtn().click();
		wLib.waitForElement(driver);		
		searchVpage.getRequiredVendorLink().click();	
		wLib.swithToWindow(driver, "Product");
		cnp.getSaveBtn().click();
		//Create new Campaign
		homepage.getMoreLink().click();
		homepage.getCampaignLink().click();
		CampaignPage campPage=new CampaignPage(driver);
		campPage.getCreateCampaignLookUpImage().click();
		
		CreateNewCampaignPage CNCP=new CreateNewCampaignPage(driver);
		CNCP.getCampaignNameEdt().sendKeys(campName);
		wLib.waitForElement(driver);
		WebElement campaigndropdown = CNCP.getCampTypeDropDown();		
		wLib.selectBasedOnValue(campaigndropdown, "Advertisement");
		CNCP.getProductSelectLookUpImage().click();	
		wLib.waitForElement(driver);
		wLib.swithToWindow(driver, "Products");
		SearchProductPage srchProPage=new SearchProductPage(driver);
		srchProPage.getSearchEdt().sendKeys(productName);
		wLib.waitForElement(driver);
		WebElement search = srchProPage.getIndropDwn();
		wLib.selectBasedOnValue(search, "productname");	
		
		srchProPage.getSearchNowBtn().click();
		wLib.waitForElement(driver);
		srchProPage.getRequiredProductLink().click();
		wLib.waitForElement(driver);
		wLib.swithToWindow(driver, "Creating New Campaign");
		CNCP.getSaveBtn().click();
		//tooltip selection
		campPage.getCampSettingLookUpImg().click();
		AdministratorSettingsPage admin=new AdministratorSettingsPage(driver);
		wLib.waitForElement(driver);
		admin.getToolTipMgmtLink().click();
		WebElement selectfield = admin.getSelectFieldDropDown();
		wLib.selectBasedOnValue(selectfield, "campaignname");
		admin.getProCheckBox().click();
		admin.getSaveBtn().click();
		homepage.getMoreLink().click();		
		homepage.getCampaignLink().click();
		campPage.getSearchEdt().sendKeys(campName);
		WebElement campaignDrpDwn = campPage.getCampDropDown();
		wLib.selectBasedOnValue(campaignDrpDwn, "campaignname");
		campPage.getSearchBtn().click();
		WebElement campaignName = campPage.getCampLink();
		wLib.mouseOverOnElement(driver, campaignName);
		wLib.waitForElement(driver, campPage.getToolTip());
		WebElement ttip=campPage.getToolTip();
		String actualText = ttip.getText();
		System.out.println(actualText);
		String productText=productName;
		System.out.println("actual text: "+actualText);
		System.out.println("Product text: "+productText);
		if(actualText.contains(productText)) {
			System.out.println("Tooltip text for campaign is verified PASS");
		}
		else {
			System.out.println("Tooltip text for campaign is not verified Fail");
		}
		
	}
}
