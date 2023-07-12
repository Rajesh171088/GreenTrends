package com.greentrend.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchQuoteProductPage {
	
	@FindBy(id="search_txt")
	private WebElement searchEdt;
	
	@FindBy(name="search_field")
	private WebElement inDropDown;
	
	@FindBy(name="search")
	private WebElement searchBtn;
	
	public SearchQuoteProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getInDropDown() {
		return inDropDown;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	

}
