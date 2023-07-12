package com.greentrend.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage {
	//Declaration
	@FindBy(xpath="//img[@alt='Create Campaign...']")
	private WebElement createCampaignLookUpImage;
	
	@FindBy(xpath="//img[@alt='Campaigns Settings']")
	private WebElement campSettingLookUpImg;
	
	@FindBy(name="search_text")
	private WebElement searchEdt;
	
	@FindBy(id="bas_searchfield")
	private WebElement campDropDown;
	
	@FindBy(name="submit")
	private WebElement searchBtn;
	
	@FindBy(xpath="//a[@title='Campaigns']")
	private WebElement campLink;
	
	@FindBy(xpath="//div[@class='tooltipClass']")
	private WebElement toolTip;
	
	public WebElement getToolTip() {
		return toolTip;
	}

	public WebElement getCampLink() {
		return campLink;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getCampDropDown() {
		return campDropDown;
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getCampSettingLookUpImg() {
		return campSettingLookUpImg;
	}

	//initialization
	public CampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getCreateCampaignLookUpImage() {
		return createCampaignLookUpImage;
	}
}
