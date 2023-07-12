package com.greentrend.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewTicketPage {
	
	//Declartion
	@FindBy(name="ticket_title")
	private WebElement ticketNameEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath="//input[@value='T']")
	private WebElement groupRadioBtn;
	
	@FindBy(name="assigned_group_id")
	private WebElement groupDropDown;
	
	@FindBy(xpath="(//img[@title='Select'])[position()=1]")
	private WebElement contactLookUpImg;
	
	@FindBy(xpath="(//img[@title='Select'])[position()=2]")
	private WebElement productLookUpImg;
	
	public WebElement getGroupRadioBtn() {
		return groupRadioBtn;
	}

	public WebElement getGroupDropDown() {
		return groupDropDown;
	}

	public WebElement getContactLookUpImg() {
		return contactLookUpImg;
	}

	public WebElement getProductLookUpImg() {
		return productLookUpImg;
	}

	//Initialization
	public CreateNewTicketPage(WebDriver driver) {
		PageFactory.initElements(driver, this);		
	}

	//Utilization
	public WebElement getTicketNameEdt() {
		return ticketNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void createTicket(String ticketName)
	{
		ticketNameEdt.sendKeys(ticketName);
		saveBtn.click();
	}
}
