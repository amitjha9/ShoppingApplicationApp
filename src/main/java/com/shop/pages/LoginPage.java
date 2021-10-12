package com.shop.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.shop.base.TestBase;

public class LoginPage extends TestBase{

	@FindBy(id = "email")
	WebElement emailid;

	@FindBy(xpath = "//input[@id='passwd']")
	WebElement password;

	@FindBy(xpath = "//button[@id='SubmitLogin']")
	WebElement signInButton;

	@FindBy(xpath = "//h3[contains(text(),'Already registered?')]")
	WebElement checkAlreadyRegistered;

	@FindBy(name="email_create")
	WebElement createEmail;

	@FindBy(id="SubmitCreate")
	WebElement createAccount;

	@FindBy(xpath = "//div[@id='create_account_error']")
	WebElement retryCreateAccount;

	//Page factory Object initialization
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}

	public HomePage LoginTest(String userName, String Password)
	{
		emailid.sendKeys(userName);
		password.sendKeys(Password);
		signInButton.click();
		return new HomePage();
	}

	public String getLoginPageTitle()
	{
		String loginPageTitle=driver.getTitle();
		System.out.println("Login Page Title is:" +loginPageTitle);
		return loginPageTitle;
	}

	public String getAlreadyRegisteredText()
	{
		String validateText = checkAlreadyRegistered.getText();
		System.out.println("Registered Text is:" +validateText);
		return validateText;
	}

	public AccountCreationPage createAccount(String email)
	{
		createEmail.sendKeys(email);
		createAccount.click();
		String errorGot=retryCreateAccount.getText();
		if(errorGot!=null)
		{
			driver.navigate().refresh();
			email=prop.getProperty("updatedEmail");
			createEmail.sendKeys(email);
			createAccount.click();
		}
		return new AccountCreationPage();
	}

}
