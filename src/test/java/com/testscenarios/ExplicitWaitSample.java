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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class ExplicitWaitSample extends Staticvariables {

	Locators obj = new Locators();
	CommonFunctions cfn = new CommonFunctions();

	@Test
	public void TC_001() throws Exception {

		FileInputStream path = new FileInputStream(".\\TestData\\testdata.properties");
		Properties prop = new Properties();
		prop.load(path);

		// BaseURL
//		driver.get("https://www.rediff.com/");
//		driver.findElement(By.linkText("Create Account")).click();
//		driver.findElement(By.xpath("//*[starts-with(@name,'name')]")).sendKeys("TEstName");

		driver.get("https://www.platformqedu.com/contact-us/");
		// Explicit wait
//		WebDriverWait explicitWait = new WebDriverWait(driver, 20);
//		explicitWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[contains(@id,'3523pi_796743_3523')]"))));

		if (driver.findElements(By.xpath("//input[contains(@id,'3523pi_796743_3523')]")).size() == 0) {
			System.out.println("the element is NOT presents on DOM(webpage)");
		} else if (driver.findElements(By.xpath("//input[contains(@id,'3523pi_796743_3523')]")).size() > 0) {
			System.out.println("the element is presents on DOM(webpage)");
		}

		driver.findElement(By.xpath("//input[contains(@id,'3523pi_796743_3523')]")).sendKeys("fasdhgfakdbf");

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

	@AfterClass
	public void afterClass() {
		driver.quit();
		System.out.println("************************************");
	}

	@AfterMethod
	public void takeScreenshot() throws Exception {
		cfn.takescreenshotWithTimeStamp();
	}

}
