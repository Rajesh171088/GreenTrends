package greentrade.crm.ddtpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchVendorPage {
	
	//Declaration
	@FindBy(id="search_txt")
	private WebElement searchEdt;
	
	@FindBy(name="search_field")
	private WebElement indropDown;
	
	@FindBy(xpath="//input[@name='search'")
	private WebElement seachBtn;
	
	public void readVendor(WebDriver driver,String text)
	{
		driver.findElement(By.linkText(text)).click();
	}
	
	

}
