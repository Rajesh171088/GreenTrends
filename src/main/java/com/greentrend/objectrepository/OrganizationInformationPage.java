package com.greentrend.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage {
	
	//Declaration
	@FindBy(id="dtlview_Organization Name")
	private WebElement createdOrgName;
	
	//Initialization
	public OrganizationInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getCreatedOrgName() {
		return createdOrgName;
	}
	
	//Business Libraries
	public String returnCreatedOrgName()
	{
		return getCreatedOrgName().getText();
	}
	
}
