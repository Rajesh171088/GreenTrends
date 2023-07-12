package com.greentrend.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PriceBookPage {
	
	//Declaration
			@FindBy(xpath="//img[@alt='Create Price Book...']")
			private WebElement createPriceBookLookUpImage;
			
			
			//initialization
			public PriceBookPage(WebDriver driver) {
				PageFactory.initElements(driver, this);
			}

			//utilization
			public WebElement getCreatePriceBookLookUpImage() {
				return createPriceBookLookUpImage;
			}
}
