package com.greentrend.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PriceBookInformationPage {
	
	//Declaration
	@FindBy(xpath="//td/span[@id='dtlview_Price Book Name']")
	private WebElement createdBookName;
	
	//Initialization
	public PriceBookInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getCreatedBookName() {
		return createdBookName;
	}
	//Business Libraries
	public String returnCreatedBookName()
	{
		return getCreatedBookName().getText();
	}

}
