package com.greentrend.objectrepository;


	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindAll;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.FindBys;
	import org.openqa.selenium.support.PageFactory;

	public class LoginPage{
		//Declaration		
		@FindBy(name = "user_name")
		private WebElement usernameEdtTxt;
		
		@FindBys(@FindBy(name = "user_password"))
		private WebElement passwordEdtTxt;
		
		@FindAll({@FindBy(id = "submitButton"),@FindBy(xpath = "//input[@value='Login']")})
		private WebElement LoginBtnClk;
		
		//Initialization
		public LoginPage(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
		}
		
		//Utilization
		public WebElement getusernameEdtTxt()
		{
			return usernameEdtTxt;
		}

		public WebElement getPasswordEdtTxt() 
		{
			return passwordEdtTxt;
		}

		public WebElement getLoginBtnClk() 
		{
			return LoginBtnClk;
		}		
		//Business libraries
		
		public void loginToApp(String username,String password)
		{
			usernameEdtTxt.sendKeys(username);
			passwordEdtTxt.sendKeys(password);
			LoginBtnClk.click();
		}
	}

