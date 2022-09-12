package com.frameworkcompany.webdrivercmds;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.frameworkcompany.config.StartBrowser;


public class ActionDriver {
	public WebDriver driver;
	
	public ActionDriver()
	{
		driver = StartBrowser.driver;
	}
	/**
	 * USed to navigate to any application
	 * @param url -- URL of Application
	 */
	
	public void navigateToApplication(String url)
	{
		try {
			driver.get(url);
			StartBrowser.childTest.pass("Successfully Navigate to : "+url);
		} catch (Exception e) {
			StartBrowser.childTest.fail("Unable to Navigate to : "+url);
		}
	}
	
	/**
	 * Used to Performe click on link, button, radio buttons and checkboxes
	 * @param locator -- Get it from object repository
	 * @param eleName -- Name of the element
	 * @throws Exception
	 */
	public void click(By locator, String eleName) throws Exception
	{
		try {
			driver.findElement(locator).click();
			StartBrowser.childTest.pass("Performed click action on : "+eleName,MediaEntityBuilder.createScreenCaptureFromPath(screenShot()).build());

			//StartBrowser.childTest.pass("Performed click action on : "+eleName,MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
		} catch (Exception e) {
			StartBrowser.childTest.fail("Unable to perform click action on :"+eleName, 
					MediaEntityBuilder.createScreenCaptureFromPath(screenShot()).build());
			
			//StartBrowser.childTest.fail("Unable to perform click action on :"+eleName,MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
			StartBrowser.childTest.info(e);
			throw e;
		}
	}
	
	/**
	 * Used to preform action in textbox or test area
	 * @param locator -- Get it from OR
	 * @param testData -- Get it from external files
	 * @param eleName -- Name of the element
	 * @throws Exception
	 */
	public void type(By locator, String testData, String eleName) throws Exception
	{
		try {
			driver.findElement(locator).sendKeys(testData);
			//StartBrowser.childTest.pass("Successfully Performed type action on : "+eleName + "with test data: " +testData,MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
			StartBrowser.childTest.pass("Successfully Performed type action on : "+eleName + "with test data: " +testData,MediaEntityBuilder.createScreenCaptureFromPath(screenShot()).build());

		} catch (Exception e) {
			//StartBrowser.childTest.fail("Unable to perform type action on :"+eleName+ "with test data: " +testData, MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
			StartBrowser.childTest.fail("Unable to perform type action on :"+eleName+ "with test data: " +testData, MediaEntityBuilder.createScreenCaptureFromPath(screenShot()).build());

			StartBrowser.childTest.info(e);
			throw e;
		}
	}
	
	public void mouseHover(By locator, String eleName) throws Exception 
	{
		try {
			WebElement we = driver.findElement(locator);
			Actions act = new Actions(driver);
			act.moveToElement(we).build().perform();
			//StartBrowser.childTest.pass("Successfully Performed MouseHover action on : "+eleName ,MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());

			StartBrowser.childTest.pass("Successfully Performed MouseHover action on : "+eleName ,MediaEntityBuilder.createScreenCaptureFromPath(screenShot()).build());
		} catch (Exception e) {
			
			//StartBrowser.childTest.fail("Unable to perform MouseHover action on :"+eleName, MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());

			StartBrowser.childTest.fail("Unable to perform MouseHover action on :"+eleName, MediaEntityBuilder.createScreenCaptureFromPath(screenShot()).build());
			StartBrowser.childTest.info(e);
			throw e;
		}
	}
	
	
	/**
	 * Select value from DD using Visible Text
	 * @param locator -- OR
	 * @param visibleText --DropDown Value
	 * @param eleName -- Name Of The DropDown
	 * @throws Exception
	 */
	public void selectByVisibleText(By locator, String visibleText, String eleName) throws Exception
	{
		try {
			WebElement we = driver.findElement(locator);
			Select s = new Select(we);
			s.selectByVisibleText(visibleText);
			//StartBrowser.childTest.pass("Successfully Selected Value : "+eleName ,MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());

			StartBrowser.childTest.pass("Successfully Selected Value : "+eleName ,MediaEntityBuilder.createScreenCaptureFromPath(screenShot()).build());
		} catch (Exception e) {
			//StartBrowser.childTest.fail("Unable to Select Value :"+eleName, MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
			StartBrowser.childTest.fail("Unable to Select Value :"+eleName, MediaEntityBuilder.createScreenCaptureFromPath(screenShot()).build());
			StartBrowser.childTest.info(e);
			throw e;
		}
	}
	
	public String screenShot() throws Exception {
		//return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		String screenshot = null;
		String dateName = new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir")+"/FailedTestScreenShot/"+screenshot+ dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
}
