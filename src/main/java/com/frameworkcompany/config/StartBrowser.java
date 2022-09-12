package com.frameworkcompany.config;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StartBrowser {
  public static WebDriver driver;
  //setUp Report
  public ExtentReports extent;
  public static ExtentTest parentTest;
  public static ExtentTest childTest;
  //ExtentSparkReporter sparkReporter;
  public ExtentHtmlReporter htmlReport;
  
  @BeforeTest
  public void generateReport() {
	//  sparkReporter = new ExtentSparkReporter("Reports/AutomationReport.html");
	 //extent = new ExtentReports();
	 // extent.attachReporter(sparkReporter);
	  
	  htmlReport = new ExtentHtmlReporter("Reports/ReportHtml.html");
	  extent = new ExtentReports();
		extent.attachReporter(htmlReport);
  }
  @BeforeMethod
  public void methodName(Method method) {
	  parentTest = extent.createTest(method.getName());
  }
  
  @BeforeClass
  public void beforeClass() {
	  
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  
	  //WebDriverManager.firefoxdriver().setup();
	  //driver = new FirefoxDriver();
	  //WebDriverManager.edgedriver().setup();
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
	  extent.flush();
  }

}
