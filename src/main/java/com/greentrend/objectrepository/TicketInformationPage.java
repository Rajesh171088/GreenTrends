package com.greentrend.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TicketInformationPage {
	
	//Declaration
			@FindBy(xpath="//td/span[@id='dtlview_Title']")
			private WebElement createdticketName;
			
			//Initialization
			public TicketInformationPage(WebDriver driver) {
				PageFactory.initElements(driver, this);
			}
			
			//utilization
			public WebElement getCreatedticketName() {
				return createdticketName;
			}
			//Business Libraries
			public String returnCreatedticketName()
			{
				return getCreatedticketName().getText();
			}
}
