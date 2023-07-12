package com.greentrend.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunitiesPage {
	
	//Declaration
			@FindBy(xpath="//img[@alt='Create Opportunity...']")
			private WebElement createOpportunityLookUpImage;
			
			
			//initialization
			public OpportunitiesPage(WebDriver driver) {
				PageFactory.initElements(driver, this);
			}

			//utilization
			public WebElement getCreateOpportunityLookUpImage() {
				return createOpportunityLookUpImage;
			}
}
