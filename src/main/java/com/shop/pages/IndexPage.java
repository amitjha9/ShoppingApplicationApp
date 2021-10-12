package com.shop.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.shop.base.TestBase;

public class IndexPage extends TestBase{

	//List of web elements presents on Index Page
	@FindBy(xpath = "//a[@title='Log in to your customer account']")
	WebElement signInButton;

	@FindBy(xpath = "//a[@title='Contact Us']")
	WebElement contactUs;

	@FindBy(xpath = "//img[@class='logo img-responsive']")
	WebElement logoImage;

	@FindBy(xpath = "//input[@class='search_query form-control ac_input']")
	WebElement searchBox;

	@FindBy(xpath = "//button[@name='submit_search']")
	WebElement submitSearchButton;

	//Constructor of this page to initialize all the web elements using page factory init Elements method
	public IndexPage()
	{
		PageFactory.initElements(driver, this);
	}

	//User Action method
	public String getIndexPageTitle()
	{
		String title=driver.getTitle();
		System.out.println("Title is:" +title);
		return title;
	}

	public String getCurrentURL()
	{
		String currentURL = driver.getCurrentUrl();
		System.out.println("Current URL is:" +currentURL);
		return currentURL;
	}

	public LoginPage clickOnSignIn()
	{
		signInButton.click();
		return new LoginPage();
	}

	public boolean clickOnContactUS()
	{
		boolean flag = false;
		contactUs.click();
		flag=true;
		return flag;
	}

	public boolean validateLogoImage()
	{
		boolean flag = logoImage.isDisplayed();
		return flag;
	}
}
