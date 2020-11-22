package com.testscenarios;

import org.testng.annotations.Test;

import com.objectrepository.Locators;
import com.utilities.CommonFunctions;
import com.utilities.Staticvariables;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class ShearCircle_ScrollDown extends Staticvariables {

	Locators obj = new Locators();
	CommonFunctions cfn = new CommonFunctions();

	@Test
	public void TC_001() throws Exception {

		FileInputStream path = new FileInputStream(".\\TestData\\testdata.properties");
		Properties prop = new Properties();
		prop.load(path);

		// BaseURL
		driver.get(prop.getProperty("shearcircleURL"));
		WebElement element = driver.findElement(obj.SHEARCIRCLE_RIGISTER_BUSINESSNAME_EDITBOX);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
		((JavascriptExecutor) driver).executeScript("arguments[0].style.border='6px groove green'", element);
		cfn.sendKeysByAnyLocator(obj.SHEARCIRCLE_RIGISTER_BUSINESSNAME_EDITBOX, prop.getProperty("BusinessName"));

	}

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

	// @AfterClass
	public void afterClass() {
		driver.quit();
		System.out.println("************************************");
	}

	@AfterMethod
	public void takeScreenshot() throws Exception {
		cfn.takescreenshotWithTimeStamp();
	}

}
