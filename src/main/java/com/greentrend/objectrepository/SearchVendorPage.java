package com.greentrend.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.greentreand.genericutility.WebActionUtility;

public class SearchVendorPage {
	
	@FindBy(id="search_txt")
	private WebElement searchEdt;

	@FindBy(name="search_field")
	private WebElement indropDwn;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement searchNowBtn;
	
	@FindBy(xpath="//a[@href='javascript:window.close();']")
	private WebElement requiredVendorLink;
	
	public WebElement getRequiredVendorLink() {
		return requiredVendorLink;
	}

	public SearchVendorPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getIndropDwn() {
		return indropDwn;
	}

	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}
	
	
}
