package com.DomsEpson.WelcomeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.DomsEpson.GenericLibrary.BaseTest;
import com.DomsEpson.JavaLibrary.JavaUtility;
import com.DomsEpson.PageRepository.PageManagement;
import com.aventstack.extentreports.Status;


public class VerifyWelcomePageTest extends BaseTest {

	@Test(priority = 1)
	public void verifyWelcomePageWithValidInput() {

		// Create the Test Information
		test = report.createTest("verifyWelcomePageWithValidInput");

		// Steps Information
		test.log(Status.INFO, "Step:1 Launching The Browser Successful");

		test.log(Status.INFO, "<<--Execution Started Successfully--->>");

		// Execute the Preconditon-1.Launch the Browser, 2. Navigate to URL
		test.log(Status.INFO, "Step:1 Launching the browser Susccessfully");

		// implicit Wait
		webDriverobj.waitImplicitly(20);

		// Verify the Welcome Page Using Title
		String exptitle = "Learning Selenium";

		// verify the welcome page using title
		Assert.assertEquals("Learning Selenium", webDriverobj.driver.getTitle());
		test.log(Status.PASS, "Title Verified");

		// Create an Object for PageManager
		pageManagementobj = new PageManagement(webDriverobj.driver);

		// verify the Name TextField
		boolean result = pageManagementobj.initWelcomePage().getName().isDisplayed();

		Assert.assertTrue(result);
		test.log(Status.PASS, "Element Verified: Name Textfield is Displayed");

		// Step 3: Perform action---Clear
		pageManagementobj.initWelcomePage().getName().clear();
		test.log(Status.PASS, "step3:clear Action Done Successfully -name Textfield");

		// Step 4: Perform actions----sendKeys
		pageManagementobj.initWelcomePage().getName().sendKeys(username);
		test.log(Status.PASS, "step 4:sendKeys Action Done Successfully -name Textfield");

		// See the Execution
		JavaUtility.pause(3000);

		// Soft Assert Statement
		SoftAssert softassertobj = new SoftAssert();

		// step 5: Verify the contact us Hyperlink
		softassertobj.assertEquals("Contact Us", pageManagementobj.initWelcomePage().getContact().getText());
		test.log(Status.PASS, "step 4: Verified Text Successfully-Contact Us Hyperlink");
		// Execute the postcondition-->1.Terminate the Browser

		// Execution Log or Status
		test.log(Status.INFO, "Execution completed successsfully");

	}

	@Test(priority = 2, invocationCount = 2, dependsOnMethods = "verifyWelcomePageWithValidInput")
	public void verifyWelcomePageWithInvalidInput() {
		// Create the Test Information
		test = report.createTest("verifyWelcomePageWithInValidInput");

		// Steps Information
		test.log(Status.INFO, "<<--Execution started successfully--Test2-->>");

		// Execute the preconditon----->1. Launch the browser, 2. Navigate to url

		// implicit Wait
		webDriverobj.waitImplicitly(20);

		// Verify the Welcome Page using Titles
		String exptitle = "Learning Selenium";
		String acttitle = webDriverobj.driver.getTitle();

		Assert.assertEquals(acttitle, exptitle);
		test.log(Status.PASS, "Title Verified: " + acttitle);

		// create an Object For PageManager
		pageManagementobj = new PageManagement(webDriverobj.driver);

		// verify the Name TextField
		boolean result = pageManagementobj.initWelcomePage().getName().isDisplayed();

		Assert.assertTrue(result);
		test.log(Status.PASS, "Element Verified: Name TextField is Displayed");

		// Step 3: Perform Action---Clear
		pageManagementobj.initWelcomePage().getName().clear();
		test.log(Status.PASS, "step3:clear Action Done Successfully -Name Textfield");

		// Step 4: Perform actions----sendKeys
		pageManagementobj.initWelcomePage().getName().sendKeys("adfdfkjdklfj");
		test.log(Status.PASS, "step 4:sendKeys Action Done Successfully -name Textfield");

		// See the Execution
		JavaUtility.pause(3000);

		// To make The Explicit TestScript Fail
		// Assert.fail();

		// Execute the PostCondition--->1.Terminate the browser
		// Execution Log or Status
		test.log(Status.INFO, "<----Execute Completed Successfully---->");
	}

}