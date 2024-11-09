package com.DomsEpson.GenericLibrary;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.DomsEpson.ExcelfileLibrary.ReadExcelFile;
import com.DomsEpson.PageRepository.PageManagement;
import com.DomsEpson.PropertyFileLibrary.ReadPropertyFile;
import com.DomsEpson.WebDriverlibrary.WebDriverUtility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This Class Is Used For Configuring All The PreCondition And Post Condition For TestScript
 * And Also Initializing All The Library-Utility Class
 * 
 * 
 * @author ymdta*/
public class BaseTest {

	public PageManagement pageManagementobj;
	public WebDriverUtility webDriverobj;
	public ReadExcelFile excelutilityobj;
	public ReadPropertyFile propertyfileobj;
	public String username;
	public ExtentSparkReporter spark;
	public ExtentReports report;
	public ExtentTest test;

	@BeforeSuite
	public void SuiteSetup() {
		// create the spark report
		spark = new ExtentSparkReporter("./AdvanceReports/report.html");
		
		// Configure the SparkReport Information
		spark.config().setDocumentTitle("Regression Testing for the learningselenium page");
		spark.config().setReportName("RegressionSuite||Verification of Welcome Page");
		spark.config().setTheme(Theme.STANDARD);

		// Create the ExtentReport
		report = new ExtentReports();

		// Attach the spark Report and Extents
		report.attachReporter(spark);

		// Configure the system information in Extent Report
		report.setSystemInfo("DeviceName", "Faizan");
		report.setSystemInfo("Operating System", "WINDOWS 11");
		report.setSystemInfo("Browser:", "Chrome");
		report.setSystemInfo("BrowserVersion", "chrome-128.0.6613.85");
	}

	@AfterSuite
	public void suiteTerminateSetup() {
		// Flush the Report Information
		report.flush();
	}

	@Parameters({ "browsername", "weburl" })
	@BeforeClass
	public void browserSetup(String browser, String url) {

		// Create Object for All the Repository/Utility
		createObjects();

		// fetch The Username
		username = excelutilityobj.readSingleData("RegisterData", 1, 1);

		// Launch the Browser-----> Chrome, Edge, safari
		webDriverobj.launchBrowser(browser);
		Reporter.log("Step1: Launch the Browser Success", true);

		// Maximize the Browser
		webDriverobj.maximizeTheBrowser();
		Reporter.log("Step1.1: Maximize The browser Success", true);

		// step: 2 Navigating to the application via URL
		webDriverobj.NavigateToApplication(url);
		Reporter.log("Step 2: Navigating the Application via URL Success", true);
	}

	// Browser Termination
	@AfterClass
	public void browserTermination() {

		webDriverobj.closeTheBrowser();
		Reporter.log("Step10: Close the Browser Success", true);
	}

	public void createObjects() {
		webDriverobj = new WebDriverUtility();
		excelutilityobj = new ReadExcelFile();
		propertyfileobj =new ReadPropertyFile();
	}
}