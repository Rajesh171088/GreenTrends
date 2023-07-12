package com.greentrend.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunityInformationPage {
	//Declaration
			@FindBy(xpath="//span[@id='dtlview_Opportunity Name']")
			private WebElement createdOpportunityName;
			
			//Initialization
			public OpportunityInformationPage(WebDriver driver) {
				PageFactory.initElements(driver, this);
			}
			
			//utilization
			public WebElement getCreatedOpportunityName() {
				return createdOpportunityName;
			}
			
			//Business Libraries
			public String returnCreatedOpportunityName()
			{
				return getCreatedOpportunityName().getText();
			}

}
