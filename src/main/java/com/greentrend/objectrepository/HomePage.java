package com.greentrend.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.greentreand.genericutility.*;

public class HomePage {
	
	@FindBy(linkText="Calendar")
	private WebElement calenderLink;
	
	@FindBy(linkText="Leads")
	private WebElement leadsLink;
	
	@FindBy(linkText="Organizations")
	private WebElement orgLink;
	
	@FindBy(linkText="Contacts")
	private WebElement contactLink;
	
	@FindBy(linkText="Opportunities")
	private WebElement opportunityLink;
	
	@FindBy(xpath="//td[@class='tabUnSelected']//a[contains(.,'Products')]")
	private WebElement productLink;
	
	@FindBy(linkText="Documents")
	private WebElement documentsLink;
	
	@FindBy(linkText="Trouble Tickets")
	private WebElement ttLink;
	
	@FindBy(linkText="More")
	private WebElement moreLink;
	
	@FindBy(linkText="Campaigns")
	private WebElement campaignLink;
	
	@FindBy(linkText="Price Books")
	private WebElement PBLink;
	
	@FindBy(linkText="Quotes")
	private WebElement quoteLink;
	
	@FindBy(linkText="Vendors")
	private WebElement vendorsLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administrator;
	
	@FindBy(xpath="//a[.='Sign Out']")
	private WebElement signoutLink;
	//Initialization
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getCalenderLink() {
		return calenderLink;
	}

	public WebElement getLeadsLink() {
		return leadsLink;
	}

	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getContactLink() {
		return contactLink;
	}

	public WebElement getProductLink() {
		return productLink;
	}

	public WebElement getDocumentsLink() {
		return documentsLink;
	}

	public WebElement getTtLink() {
		return ttLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getCampaignLink() {
		return campaignLink;
	}

	public WebElement getPBLink() {
		return PBLink;
	}

	public WebElement getQuoteLink() {
		return quoteLink;
	}

	public WebElement getVendorsLink() {
		return vendorsLink;
	}	
	//Business Library
	
	public void setElement(WebElement element)
	{
		element.click();
	}
	
	public WebElement getOpportunityLink() {
		return opportunityLink;
	}

	public WebElement getAdministrator() {
		return administrator;
	}

	public WebElement getSignoutLink() {
		return signoutLink;
	}

	public void signOut(WebActionUtility wLib,WebDriver driver)
	{
		wLib.mouseOverOnElement(driver, administrator);
		signoutLink.click();		
	}
}
