package com.DomsEpson.WebDriverlibrary;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This Class is Used to Provide the Reusable Method to Perform All Browser Related Actions
 * 
 * 
 * @author ymdta*/


public class WebDriverUtility {
	
	public static WebDriver driver_static;
	public WebDriver driver;
	public static Select selectobj;
	public static Actions actionsobj;
	public static Robot robotobj;
	public WebDriverWait wait;
	
	
	/**
	 * This Method used to Launch the browser With Specific Browser
	 * @param String browser name
	 * @return void*/
	public void launchBrowser(String browser)
	{

		//step:1 Launch the Browser-----> Chrome, Edge, safari
		switch(browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver_static=driver;
			break;
		
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver_static=driver;
			break;
		
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver_static=driver;
			break;
		
		default:
			Reporter.log("Entered incorrect browser name");
			break;
		}
		Reporter.log("Step1: Successully launched");
	}
	
	/**
	 * This Method used to Navigate To The URL
	 * @param String browser URL
	 * @return void*/
	public void NavigateToApplication(String url)
	{
		driver.get(url);
	}
	
	/**
	 * This Method Used To Maximize The Browser
	 * @return void*/
	
	public void maximizeTheBrowser()
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This Method Used To Close The Specific Browser
	 * @return void*/
	public void closeTheBrowser()
	{
		driver.close();
	}
	
	/**
	 * This Method Is Used To Close All The Browser
	 * @return void*/
	
	public void closeAllBrowser()
	{
		driver.quit();
	}
	
	/**
	 * This Method Used To WaitImplicitly For Given Time
	 * @return void*/
	
	public  void waitImplicitly(long duration)
	{
		driver.manage().timeouts().implicitlyWait(duration, TimeUnit.SECONDS);
	}
	
	/**
	 * This Method used To WaitExplicitly For Given Time
	 * @return void*/
	
	public  void waitExplicitily(long duration, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, duration);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This Method Is Used To Select The Option In DropDown By Using Index Value
	 * @return void*/
	public void selectOptionInDropdown(WebElement element, int index)
	{
		selectobj.selectByIndex(index);
	}
	
	/**
	 * This Method Used To Select The Option In DropDown By Using VisibleText
	 * @return void*/
	public void selectOptionInDropdown(WebElement element, String visibletext) {
		selectobj.selectByVisibleText(visibletext);
	}
	
	/**
	 * This Method Used To Select The Option In DropDown By Using WebElement
	 * @return void*/
	public void selectOptionInDropdown(String value, WebElement element) {
		selectobj.selectByVisibleText(value);
	}
	
	/**
	 * This Method Used To Perform Mouse Related Actions  
	 * @return void*/
	public void mouseHovering(WebElement element)
	{
		actionsobj.moveToElement(element).perform();
	}
	
	/**
	 * This Method Used To Perform KeyBoard Related Actions By Using Robot Class And Using KeyPressMethod
	 * @return void*/
	public void pressTheKey_pageDown()
	{
		robotobj.keyPress(KeyEvent.VK_PAGE_DOWN);
	}
	
	/**
	 * This Method Used To Perform KeyBoard Related Actions By Using Robot Class And KeyReleaseMthod
	 * @return void*/
	public void ReleaseTheKey()
	{
		robotobj.keyRelease(KeyEvent.VK_PAGE_DOWN);
	}
	
	/**
	 * This Method Is Used To Handle PopUps By Using The Accept Method
	 * @return void*/
	public void alertPopupAccept() {
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This Method Is Used For Not Handled PopUps By Using The Dismiss Method 
	 * @return void*/
	public void alertPopupDismiss()
	{
		driver.switchTo().alert().dismiss();
	}

	/**
	 * This Method Is Used To Switch The Control From One Window To Another Window   
	 * @return void*/
	public void switchControlToFrame(int index)
	{
		driver.switchTo().frame(0);
	}
	public void switchControlToFrame(WebElement element)
	{
		driver.switchTo().frame(element);
	}
	public void switchBackControlToMain()
	{
		driver.switchTo().defaultContent();
	}
	public void switchControlToWindow(String windowaddress)
	{
		
		driver.switchTo().window(windowaddress);
	}

}

