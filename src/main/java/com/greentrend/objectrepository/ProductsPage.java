package com.greentrend.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
	//Declaration
		@FindBy(xpath="//img[@alt='Create Product...']")
		private WebElement createProductLookUpImage;
		
		
		//initialization
		public ProductsPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}

		//utilization
		public WebElement getCreateProductLookUpImage() {
			return createProductLookUpImage;
		}
}
