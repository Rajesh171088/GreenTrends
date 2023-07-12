package com.greentrend.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganIzationsPage {
	//Declaration
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createOrganizationLookUpImage;
	
	
	//initialization
	public OrganIzationsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getCreateOrganizatiomLookUpImage() {
		return createOrganizationLookUpImage;
	}
}
