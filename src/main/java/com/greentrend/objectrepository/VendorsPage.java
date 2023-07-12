package com.greentrend.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorsPage {
	
	@FindBy(xpath="//img[@alt='Create Vendor...']")
	private WebElement createVendorsLookUpImage;
	
	
	//initialization
	public VendorsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//utilization
	public void getCreateVendorsPage() {
		createVendorsLookUpImage.click();
	}
}
