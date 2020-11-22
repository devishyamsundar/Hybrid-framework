package com.testscenarios;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.objectrepository.Locators;
import com.utilities.CommonFunctions;
import com.utilities.Staticvariables;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FB_Login extends Staticvariables {
	// Create webdriver Object
//	WebDriver driver;

	// Crate Locators class object and use the same object to call the Locators
	// CLASSNAME objectName = new CLASSNAME();
	Locators obj = new Locators();
	CommonFunctions cfn = new CommonFunctions();

	@Test
	public void TC_001() throws Exception {
		// Create a property file variable to call/read the testdata from Property file
		FileInputStream path = new FileInputStream(".\\TestData\\testdata.properties");
		Properties prop = new Properties();
		prop.load(path);

		driver.get(prop.getProperty("baseURL"));
		cfn.implicitWait(20);
		
		cfn.sendKeysByAnyLocator(obj.USERNAME_EDITBOX, prop.getProperty("Username"));
		cfn.sendKeysByAnyLocator(obj.PASSWORD_EDITBOX, prop.getProperty("Password"));
		cfn.clickByAnyLocator(obj.LOGIN_BUTTON);
//		driver.findElement(obj.USERNAME_EDITBOX).sendKeys(prop.getProperty("Username"));		
//		driver.findElement(obj.PASSWORD_EDITBOX).sendKeys(prop.getProperty("Password"));		
//		driver.findElement(obj.LOGIN_BUTTON).click();
	}

	@Test
	public void TC_002() throws Exception {
		// Create a property file variable to call/read the testdata from Property file
		FileInputStream path = new FileInputStream(".\\TestData\\testdata.properties");
		Properties prop = new Properties();
		prop.load(path);

		driver.get("https://www.google.com/");
		cfn.sendKeysByAnyLocator(obj.SEARCH_EDITBOX, prop.getProperty("SerahText"));
//		driver.findElement(obj.SEARCH_EDITBOX).sendKeys(prop.getProperty("SerahText"));

	}

	// String browserName = "Opera";
	@Parameters("browserName")
	@BeforeClass // pre-condition
	public void beforeClass(@Optional("chrome") String browserName) {
		if (browserName.equalsIgnoreCase("Chrome")) {
			cfn.chromeBrowserLaunch();
		} else if (browserName.equalsIgnoreCase("IE")) {
			cfn.ieBrowserLaunch();
		} else if (browserName.equalsIgnoreCase("firefoX")) {
			cfn.firefoxBrowserLaunch();
		} else {
			System.out.println("PLease enter browser name within the CHROME, IE & FIREFOX");
		}
	}

	@AfterClass // post-condition
	public void afterClass() {
		driver.quit();
		System.out.println("************************************");
	}

	@AfterMethod
	public void takeScreenshot() throws Exception {
		cfn.takescreenshotWithTimeStamp();
	}

}
