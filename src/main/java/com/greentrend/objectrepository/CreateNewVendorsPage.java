package com.greentrend.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewVendorsPage {
	//Declaration
	@FindBy(xpath="//input[@name='vendorname']")
	private WebElement vendorNameEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//Initialization
	public CreateNewVendorsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getVendorNameEdt() {
		return vendorNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void createVendor(String name)
	{
		getVendorNameEdt().sendKeys(name);
		saveBtn.click();
	}
	
	
	
	

}
