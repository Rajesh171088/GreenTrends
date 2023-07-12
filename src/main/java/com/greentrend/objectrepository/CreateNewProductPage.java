package com.greentrend.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewProductPage {
	
	//Declartion
			@FindBy(name="productname")
			private WebElement productNameEdt;
			
			@FindBy(xpath="//input[@title='Save [Alt+S]']")
			private WebElement saveBtn;
			
			@FindBy(xpath="//img[@title='Select']")
			private WebElement selectVendorLookUpImage;
			
			//Initialization
			public CreateNewProductPage(WebDriver driver) {
				PageFactory.initElements(driver, this);		
			}

			//Utilization
			public WebElement getProductNameEdt() {
				return productNameEdt;
			}

			public WebElement getSaveBtn() {
				return saveBtn;
			}
			
			public void createProduct(String productName)
			{
				productNameEdt.sendKeys(productName);
				selectVendorLookUpImage.click();
			}

}
