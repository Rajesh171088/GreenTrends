package com.greentrend.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorsInformationPage {
	
	//Declaration
		@FindBy(id="dtlview_Vendor Name")
		private WebElement createdVendorsName;
		
		//Initialization
		public VendorsInformationPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		//utilization
		public WebElement getCreatedVendorsName() {
			return createdVendorsName;
		}
		
		//Business Libraries
		public String returnCreatedVendorsName()
		{
			return getCreatedVendorsName().getText();
		}
		

}
