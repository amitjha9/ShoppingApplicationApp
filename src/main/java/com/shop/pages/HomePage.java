package com.shop.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.shop.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath = "//a[@class='account']")
	WebElement checkAccountLoggedIn;


	//Page factory Object initialization
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}

	//User Action Method
	public String getLoggedUserDetails()
	{
		String loggedInAdmin=checkAccountLoggedIn.getText();
		System.out.println("Logged Admin Name is:" +loggedInAdmin);
		return loggedInAdmin;
	}

}
