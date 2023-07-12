package com.greentrend.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QuotesInformationPage {
	
	//Declaration
	@FindBy(xpath="//td/span[@id='dtlview_Title']")
	private WebElement createdQuoteName;
	
	//Initialization
	public QuotesInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getCreatedQuoteName() {
		return createdQuoteName;
	}
	//Business Libraries
	public String returnCreatedQuoteName()
	{
		return getCreatedQuoteName().getText();
	}
}
