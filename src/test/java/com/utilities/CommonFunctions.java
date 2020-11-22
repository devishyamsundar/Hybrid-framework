package com.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonFunctions extends Staticvariables {

	// Constructor: By default constructor will run first method in a class.
	public CommonFunctions() {
		File screenshotPath = new File(".\\Screenshots");
		if (screenshotPath.exists()) {
			System.out.println("screenshot folder is exits***************");
		} else {
			screenshotPath.mkdir();
			System.out.println("screenshot folder is NOT available, system has created a Folder ***************");
		}

	}

	/*******************
	 * SendKeys by any locator
	 * 
	 * @throws Exception
	 ****************/
	public void sendKeysByAnyLocator(By locator, String inputData) throws Exception {
		WebElement element = driver.findElement(locator);
		// Element IsDisplayed()
		if (element.isDisplayed()) {
			// Element IsEnabled()
			if (element.isEnabled()) {
				highlightElement(element);
				// Clear
				element.clear();
				element.sendKeys(inputData);
			} else {
				System.out.println("The element is disable state, please check the locator***********");
			}
		} else {
			System.out.println("The element is NOT displayed, please check the locator***********");
		}
	}

	/*******************
	 * CLick by any locator
	 * 
	 * @throws Exception
	 ****************/
	public void clickByAnyLocator(By locator) throws Exception {
		WebElement element = driver.findElement(locator);
		// Element IsDisplayed()
		if (element.isDisplayed()) {
			// Element IsEnabled()
			if (element.isEnabled()) {
				highlightElement(element);
				element.click();
			} else {
				System.out.println("The element is disable state, please check the locator***********");
			}
		} else {
			System.out.println("The element is NOT displayed, please check the locator***********");
		}
	}

	/**************** timestamp **************************/
	public String timeStamp() {
		// Date and time in a customized format
		Date sd = new Date();
		SimpleDateFormat cdf = new SimpleDateFormat("MMddyyyy_HHmmss");
		String timestamp = cdf.format(sd);
		return timestamp;
	}

	/*********************
	 * takescreenshotWithTimeStamp
	 * 
	 * @throws Exception
	 **********************/
	public void takescreenshotWithTimeStamp() throws Exception {
		// Date and time in a customized format
		Date sd = new Date();
		SimpleDateFormat cdf = new SimpleDateFormat("MMddyyyy_HHmmss");
		String timestamp = cdf.format(sd);
		// Take screenshot of the page
		File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(srcfile, new File(".\\Screenshots\\" + timeStamp() + ".PNG"));
		System.out.println("The screenshot taken successfully*********");
	}

	/*************** Browser drivers *******************/
	public void chromeBrowserLaunch() {
		// Launch chrome Browser
		// system will download the latest Chromedriver version
		WebDriverManager.chromedriver().setup();
//		WebDriverManager.chromedriver().browserVersion("86").setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	public void firefoxBrowserLaunch() {
		// Launch Firefox Browser
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}

	public void ieBrowserLaunch() {
		// Launch IE Browser
		WebDriverManager.iedriver().setup();
		driver = new InternetExplorerDriver();
	}

	public void operaBrowserLaunch() {
		// Launch Firefox Browser
		WebDriverManager.operadriver().setup();
		driver = new OperaDriver();
		driver.manage().window().maximize();
	}

	/********************* Scroll down/up *******************/
	public void scrollToElement(WebElement element) {
		System.out.println("***ScrollToElement: ***");
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
		((JavascriptExecutor) driver).executeScript("arguments[0].style.border='6px groove green'", element);
	}

	public void scrollToElementBottom(WebElement element) {
		System.out.println("***ScrollToElementBottom:  ***");
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", element);
		System.out.println("***ScrollToElementBottom executed; going to hilight el  ***");
		((JavascriptExecutor) driver).executeScript("arguments[0].style.border='6px groove green'", element);
		System.out.println("***ScrollToElementBottom executed; hilight el  executed***");
	}

	public void highlightElement(WebElement element) throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("arguments[0].style.border='6px groove green'", element);
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("arguments[0].style.border=''", element);
	}
	
	/**************** Waits in Webdriver *******************/
	public void implicitWait(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	public void explicitWait() {
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
