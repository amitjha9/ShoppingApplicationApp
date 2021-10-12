package com.shop.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.shop.base.TestBase;

public class AccountCreationPage extends TestBase{
	
	@FindBy(xpath = "//h1[contains(text(),'Create an account')]")
	WebElement validateAccountText;
	
	//Initialize object
	public AccountCreationPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//User Action method
	public String getCreateAccountText()
	{
		String creatAccountText=validateAccountText.getText();
		System.out.println("Create Account Text is:"+creatAccountText);
		return creatAccountText;
	}
}
