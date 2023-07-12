package com.greentrend.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactsPage {
	
	//Declartion
		@FindBy(name="lastname")
		private WebElement contactNameEdt;
		
		@FindBy(xpath="//input[@title='Save [Alt+S]']")
		private WebElement saveBtn;
		
		@FindBy(name="salutationtype")
		private WebElement salDropDown;
		
		@FindBy(name="firstname")
		private WebElement firstName;
		
		@FindBy(xpath="//img[@title='Select']")
		private WebElement selectLookUpImg;
		
		public WebElement getContactNameEdt() {
			return contactNameEdt;
		}

		public WebElement getSalDropDown() {
			return salDropDown;
		}

		public WebElement getFirstName() {
			return firstName;
		}

		public WebElement getSelectLookUpImg() {
			return selectLookUpImg;
		}

		//Initialization
		public CreateNewContactsPage(WebDriver driver) {
			PageFactory.initElements(driver, this);		
		}

		//Utilization
		public WebElement getcontactNameEdt() {
			return contactNameEdt;
		}

		public WebElement getSaveBtn() {
			return saveBtn;
		}
		
		public void createOrg(String lastName)
		{
			contactNameEdt.sendKeys(lastName);
			saveBtn.click();
		}

}
