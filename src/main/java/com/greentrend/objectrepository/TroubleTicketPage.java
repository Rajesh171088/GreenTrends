package com.greentrend.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TroubleTicketPage {
	
	//Declaration
			@FindBy(xpath="//img[@alt='Create Ticket...']")
			private WebElement createTicketLookUpImage;
			
			
			//initialization
			public TroubleTicketPage(WebDriver driver) {
				PageFactory.initElements(driver, this);
			}

			//utilization
			public WebElement getCreateTicketLookUpImage() {
				return createTicketLookUpImage;
			}

}
