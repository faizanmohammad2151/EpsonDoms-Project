package Demo;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class DemoTest {

	@Test
	public void DemoTesting1() {
		
		// Create the SparkReport
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReports/report.html");

		// Configure the SparkReport Information
		spark.config().setDocumentTitle("Regression Testing for the RegisterPage");
		spark.config().setReportName("RegressionSuite");
		spark.config().setTheme(Theme.DARK);

		// Create the ExtentReport
		ExtentReports report = new ExtentReports();

		// Attach the spark Report and Extents
		report.attachReporter(spark);

		// Configure the system information in Extent Report
		report.setSystemInfo("DeviceName", "Faizan");
		report.setSystemInfo("Operating System", "WINDOWS 11");
		report.setSystemInfo("Browser:", "Chrome");
		report.setSystemInfo("BrowserVersion", "chrome-128.0.6613.85");

		// Create the Test Information
		ExtentTest test = report.createTest("Regressiontest");

		// Steps Information
		test.log(Status.INFO, "Step:1 Launching The Browser Successful");
		test.log(Status.INFO, "Step:2 Navigating To Application via URI Successful");
		test.log(Status.PASS, "Step:3 Verified the WebPage Successful");

		if ("Faizan".equals("Faizan")) {
			test.log(Status.PASS, "Step:4 Verified the Webelement is displayed");
		} else {
			test.log(Status.FAIL, "Step:4 Verified the WebElement is Not Displayed");
		}

		//test.log(Status.SKIP, "Step:5 Element is Hidden");

		// Flush the Report Information
		report.flush();
		
		System.out.println("Execution Done");

	}
	
	@Test
	public void DemoTesting2() {
		
	}
	
	@Test
	public void DemoTesting3() {
		
	}
	
	@Test
	public void DemoTesting4() {
		
	}
	
	@Test
	public void DemoTesting5() {
		
	}

}
