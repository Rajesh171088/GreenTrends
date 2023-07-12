package com.greentrend.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QuotesPage {
	
	//Declaration
			@FindBy(xpath="//img[@alt='Create Quote...']")
			private WebElement createQuoteLookUpImage;
			
			
			//initialization
			public QuotesPage(WebDriver driver) {
				PageFactory.initElements(driver, this);
			}

			//utilization
			public WebElement getCreateQuoteLookUpImage() {
				return createQuoteLookUpImage;
			}
}
