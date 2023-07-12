package com.greentrend.objectrepository;

import javax.security.auth.Subject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.greentreand.genericutility.WebActionUtility;

public class CreateNewQuotePage {
	
	//Declartion
		@FindBy(name="subject")
		private WebElement quoteNameEdt;
		
		@FindBy(xpath="//input[@title='Save [Alt+S]']")
		private WebElement saveBtn;
		
		@FindBy(name="bill_street")
		private WebElement billingAddressEdt;
		
		@FindBy(name="bill_pobox")
		private WebElement billPoBoxEdt;
		
		@FindBy(name="bill_city")
		private WebElement billcityEdt;
		
		@FindBy(name="bill_state")
		private WebElement billstateEdt;
		
		@FindBy(name="bill_code")
		private WebElement billcodeEdt;
		
		@FindBy(name="bill_country")
		private WebElement billcountryEdt;
		
		@FindBy(xpath="//img[@title='Products']")
		private WebElement productLookupImage;
		
		@FindBy(name="validtill")
		private WebElement validTillField;
		
		@FindBy(xpath="(//img[@title='Select'])[position()=1]")
		private WebElement opportunityLookUpImg;
		
		@FindBy(xpath="(//img[@title='Select'])[position()=2]")
		private WebElement contactLookUpImg;
		
		@FindBy(xpath="(//img[@title='Select'])[position()=3]")
		private WebElement orgLookUpImg;

		
		@FindBy(xpath="//input[@value='Add Product']")
		private WebElement addProdutBtn;
		
		@FindBy(id="qty1")
		private WebElement quantityEdt;
		
		@FindBy(id="listPrice1")
		private WebElement listpriceEdt;
		
		@FindBy(xpath="//input[@title='Save [Alt+S]']")
		private WebElement qsaveBtn;
		
		@FindBy(xpath="//input[@onclick='return copyAddressRight(EditView)']")
		private WebElement copyBillingAddressRBtn;

		public WebElement getCopyBillingAddressRBtn() {
			return copyBillingAddressRBtn;
		}

		public WebDriver getDriver() {
			return driver;
		}

		public SearchOpportunityPage getSrchpage() {
			return srchpage;
		}

		public WebActionUtility getwLib() {
			return wLib;
		}

		public SearchContactPage getScpage() {
			return scpage;
		}

		public SearchOrganizationPage getSopage() {
			return sopage;
		}
		private WebDriver driver;

		public WebElement getBillPoBoxEdt() {
			return billPoBoxEdt;
		}

		public WebElement getBillcityEdt() {
			return billcityEdt;
		}

		public WebElement getBillstateEdt() {
			return billstateEdt;
		}

		public WebElement getBillcodeEdt() {
			return billcodeEdt;
		}

		public WebElement getBillcountryEdt() {
			return billcountryEdt;
		}

		public WebElement getAddProdutBtn() {
			return addProdutBtn;
		}

		public WebElement getQuantityEdt() {
			return quantityEdt;
		}

		public WebElement getListpriceEdt() {
			return listpriceEdt;
		}

		public WebElement getQsaveBtn() {
			return qsaveBtn;
		}

		public WebElement getValidTillField() {
			return validTillField;
		}

		public WebElement getOpportunityLookUpImg() {
			return opportunityLookUpImg;
		}

		public WebElement getContactLookUpImg() {
			return contactLookUpImg;
		}

		public WebElement getOrgLookUpImg() {
			return orgLookUpImg;
		}

		//Initialization
		public CreateNewQuotePage(WebDriver driver) {
			PageFactory.initElements(driver, this);		
		}

		//Utilization
		public WebElement getQuoteNameEdt() {
			return quoteNameEdt;
		}

		public WebElement getSaveBtn() {
			return saveBtn;
		}
		
		public WebElement getBillingAddressEdt() {
			return billingAddressEdt;
		}
		public WebElement getProductLookupImage() {
			return productLookupImage;
		}
		SearchOpportunityPage srchpage=new SearchOpportunityPage(driver);		
		WebActionUtility wLib=new WebActionUtility();
		public void selectOpportunity(String opname, String url1,String url2)
		{
			opportunityLookUpImg.click();
			wLib.swithToWindowBasedOnURL(driver, "module=Potentials&action");
			srchpage.getSearchEdt().sendKeys(opname);
			WebElement inDropDown = srchpage.getIndropDwn();
			wLib.selectBasedOnValue(inDropDown, "module=Quotes&action=EditView");
			srchpage.getSearchNowBtn().click();
		}
		SearchContactPage scpage=new SearchContactPage(driver);
		public void selectContact(String cname, String value, String url)
		{
			contactLookUpImg.click();
			scpage.getSearchEdt().sendKeys(cname);
			WebElement inDropDown = scpage.getIndropDwn();
			wLib.selectBasedOnValue(inDropDown, value);
			scpage.getSearchNowBtn().click();
			scpage.getRequiredContactLink().click();
			wLib.swithToWindowBasedOnURL(driver, url);
		}
		
		SearchOrganizationPage sopage=new SearchOrganizationPage(driver);
		public void selectOrganization(String orgname, String value, String url)
		{
			orgLookUpImg.click();
			sopage.getSearchEdt().sendKeys(orgname);
			WebElement inDropDown = sopage.getIndropDwn();
			wLib.selectBasedOnValue(inDropDown, value);
			sopage.getSearchNowBtn().click();
			sopage.getRequiredOrgLink().click();
			wLib.swithToWindowBasedOnURL(driver, url);
		}
		public void createQuote(String address, String poName, String cityname, String stateName, String pincode, String country)
		{
			//quoteNameEdt.sendKeys(qName);
			billingAddressEdt.sendKeys(address);
			billPoBoxEdt.sendKeys(poName);
			billcityEdt.sendKeys(cityname);
			billstateEdt.sendKeys(stateName);
			billcodeEdt.sendKeys(pincode);
			billcountryEdt.sendKeys(country);
			copyBillingAddressRBtn.click();			
		}
		SearchQuoteProductPage sqp=new SearchQuoteProductPage(driver);
		
		public void itemDetails(String pname, String value)
		{
			productLookupImage.click();
			sqp.getSearchEdt().sendKeys(pname);
			WebElement inDropDown = sqp.getInDropDown();
			wLib.selectBasedOnValue(inDropDown, value);
			sqp.getSearchBtn().click();
			
		}

		
}
