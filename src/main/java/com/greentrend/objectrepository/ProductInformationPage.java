package com.greentrend.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInformationPage {
	
	//Declaration
		@FindBy(id="dtlview_Product Name")
		private WebElement createdProductName;
		
		//Initialization
		public ProductInformationPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		//utilization
		public WebElement getCreatedProductName() {
			return createdProductName;
		}
		//Business Libraries
		public String returnCreatedProductName()
		{
			return getCreatedProductName().getText();
		}
}
