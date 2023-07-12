package com.greentrend.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignInformationPage {
	
	//Declaration
	@FindBy(id="dtlview_Campaign Name")
	private WebElement createdCampaignName;
	
	//Initialization
	public CampaignInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getCreatedCampaignName() {
		return createdCampaignName;
	}
	
	//Business Libraries
	public String returnCreatedCampaignName()
	{
		return getCreatedCampaignName().getText();
	}

}
