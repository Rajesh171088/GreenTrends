package com.greentrend.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewPriceBookPage {
	
	//Declartion
		@FindBy(name="bookname")
		private WebElement bookNameEdt;
		
		@FindBy(xpath="//input[@title='Save [Alt+S]']")
		private WebElement saveBtn;
		
		//Initialization
		public CreateNewPriceBookPage(WebDriver driver) {
			PageFactory.initElements(driver, this);		
		}

		//Utilization
		public WebElement getBookNameEdt() {
			return bookNameEdt;
		}

		public WebElement getSaveBtn() {
			return saveBtn;
		}
		
		public void createTicket(String bookName)
		{
			bookNameEdt.sendKeys(bookName);
			saveBtn.click();
		}
}
