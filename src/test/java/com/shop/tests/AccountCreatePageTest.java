package com.shop.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.shop.base.TestBase;
import com.shop.pages.IndexPage;
import com.shop.pages.LoginPage;

public class AccountCreatePageTest extends TestBase{

	IndexPage indexPage;
	LoginPage loginPage;

	@BeforeMethod
	public void setUP()
	{
		try {
			loadConfigFile();
			launchApplication();
			indexPage = new IndexPage();
			loginPage = new LoginPage();
		} catch (Exception e) {
			e.printStackTrace();
		}  	
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
