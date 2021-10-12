package com.shop.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.shop.base.TestBase;
import com.shop.pages.IndexPage;
import com.shop.pages.LoginPage;

public class IndexPageTest extends TestBase{

	IndexPage indexPage;
	LoginPage loginPage;
	@BeforeMethod
	public void setUP()
	{
		try {
			loadConfigFile();
			launchApplication();
		} catch (Exception e) {
			e.printStackTrace();
		}  	
	}

	//TestCase Validation
	@Test(priority=1)
	public void verifyPageTitle()
	{
		indexPage = new IndexPage();
		String pageTitle = indexPage.getIndexPageTitle();
		Assert.assertEquals(pageTitle, "My Store");
	}
	
	@Test(priority=2)
	public void verifyPageCurrentURL()
	{
		indexPage = new IndexPage();
		String URL = indexPage.getCurrentURL();
		Assert.assertEquals(URL, "http://automationpractice.com/index.php");
	}
	
	@Test(priority=3)
	public void verifyImageLogo()
	{
		indexPage = new IndexPage();
		boolean result = indexPage.validateLogoImage();
		System.out.println("Logo Validated");
		Assert.assertTrue(result);
	}
	
	@Test(priority=4)
	public void verifyClickOnSignIn()
	{
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		System.out.println("Sign in button clicked");
		//Assert.assertTrue(loginPage);
	}
	
	@Test(priority=5)
	public void verifyClickContactUS()
	{
		indexPage = new IndexPage();
		boolean result = indexPage.clickOnContactUS();
		System.out.println("Contact US button clicked");
		Assert.assertTrue(result);
	}

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
