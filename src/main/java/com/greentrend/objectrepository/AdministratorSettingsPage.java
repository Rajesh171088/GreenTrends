package com.greentrend.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdministratorSettingsPage {

	@FindBy(partialLinkText="Tooltip Management")
	private WebElement toolTipMgmtLink;
	
	@FindBy(id="pick_field")
	private WebElement selectFieldDropDown;
	
	@FindBy(xpath="(//td[contains(text(),'Product')]/preceding-sibling::td/input)[position()=last()]")
	private WebElement proCheckBox;
	
	@FindBy(name="save")
	private WebElement saveBtn;
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getProCheckBox() {
		return proCheckBox;
	}

	public AdministratorSettingsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getSelectFieldDropDown() {
		return selectFieldDropDown;
	}

	public WebElement getToolTipMgmtLink() {
		return toolTipMgmtLink;
	}
}
