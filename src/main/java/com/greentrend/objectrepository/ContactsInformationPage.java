package com.greentrend.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInformationPage {
	
	//Declaration
		@FindBy(id="dtlview_Contacts Name")
		private WebElement createdContactName;
		
		//Initialization
		public ContactsInformationPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		//utilization
		public WebElement getCreatedContactName() {
			return createdContactName;
		}
		
		//Business Libraries
		public String returnCreatedContactName()
		{
			return getCreatedContactName().getText();
		}
}
