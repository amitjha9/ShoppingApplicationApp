package com.shop.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeSuite;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static Properties prop;
	public static WebDriver driver;

	@BeforeSuite
	public void loadConfigFile()
	{
		try {
			prop = new Properties();
			System.out.println("Super constructor invoked");
			String file = System.getProperty("user.dir") + "/src/main/java/com/shop/config/Config.properties";
			FileInputStream fip = new FileInputStream(file);
			prop.load(fip);
			System.out.println("Driver:" +driver);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void launchApplication()
	{
		try {
			WebDriverManager.chromedriver().setup();
			String browserName=prop.getProperty("browser");
			if(browserName.contains("Chrome"))
			{
				driver = new ChromeDriver();
			}
			else if (browserName.contains("FireFox")) {
				driver = new FirefoxDriver();
			}
			else if (browserName.contains("IE")) {
				driver = new InternetExplorerDriver();
			}

			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
