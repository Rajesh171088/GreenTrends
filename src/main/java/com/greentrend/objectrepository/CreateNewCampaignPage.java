package com.greentrend.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewCampaignPage {
	
	//Declartion
		@FindBy(name="campaignname")
		private WebElement campaignNameEdt;
		
		@FindBy(xpath="//input[@title='Save [Alt+S]']")
		private WebElement saveBtn;
		
		@FindBy(name="campaigntype")
		private WebElement campTypeDropDown;
		
		@FindBy(xpath="//img[@alt='Select']")
		private WebElement productSelectLookUpImage;
		
		public WebElement getProductSelectLookUpImage() {
			return productSelectLookUpImage;
		}

		public WebElement getCampTypeDropDown() {
			return campTypeDropDown;
		}

		//Initialization
		public CreateNewCampaignPage(WebDriver driver) {
			PageFactory.initElements(driver, this);		
		}

		//Utilization
		public WebElement getCampaignNameEdt() {
			return campaignNameEdt;
		}

		public WebElement getSaveBtn() {
			return saveBtn;
		}
		
		public void createCampaign(String campName)
		{
			campaignNameEdt.sendKeys(campName);
			saveBtn.click();
		}
}
