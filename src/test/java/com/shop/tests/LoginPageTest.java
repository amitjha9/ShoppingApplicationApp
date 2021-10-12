package com.shop.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.shop.base.TestBase;
import com.shop.pages.AccountCreationPage;
import com.shop.pages.HomePage;
import com.shop.pages.IndexPage;
import com.shop.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	AccountCreationPage accountCreationPage;
	
	@BeforeMethod
	public void setUP()
	{
		try {
			loadConfigFile();
			launchApplication();
			indexPage = new IndexPage();
			loginPage = new LoginPage();
			homePage = new HomePage();
		} catch (Exception e) {
			e.printStackTrace();
		}  	
	}
	
	@Test(priority=1)
	public void verifyLoginPageTitle()
	{
		loginPage=indexPage.clickOnSignIn();
		String loginPageTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(loginPageTitle, "Login - My Store");
	}
	
	@Test(priority=2)
	public void verifyAlreadyRegisteredText()
	{
		loginPage=indexPage.clickOnSignIn();
		String aleadyRegisteredText=loginPage.getAlreadyRegisteredText();
		Assert.assertEquals(aleadyRegisteredText, "ALREADY REGISTERED?");
	}
	
	@Test(priority=3)
	public void verifyLoginTest()
	{
		loginPage=indexPage.clickOnSignIn();
		homePage = loginPage.LoginTest(prop.getProperty("username"), prop.getProperty("password"));
		String loggedAdmin=homePage.getLoggedUserDetails();
		Assert.assertEquals(loggedAdmin, "Test Admin");
	}
	
	
	@Test(priority=4)
	public void verifyAccountCreationTest()
	{
		loginPage=indexPage.clickOnSignIn();
		accountCreationPage=loginPage.createAccount(prop.getProperty("newemail"));
		String getAccountText=accountCreationPage.getCreateAccountText();
		Assert.assertEquals(getAccountText, "CREATE AN ACCOUNT");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
