package com.greentrend.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOpportunityPage {
	
	//Declartion
	@FindBy(name="potentialname")
	private WebElement opportunityNameEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath="//img[@title='Select']")
	private WebElement selectProductLookUpImg;
	
	public WebElement getSelectProductLookUpImg() {
		return selectProductLookUpImg;
	}

	//Initialization
	public CreateNewOpportunityPage(WebDriver driver) {
		PageFactory.initElements(driver, this);		
	}

	//Utilization
	public WebElement getOpportunityNameEdt() {
		return opportunityNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void createOrg(String oppName)
	{
		opportunityNameEdt.sendKeys(oppName);
		saveBtn.click();
	}
}
