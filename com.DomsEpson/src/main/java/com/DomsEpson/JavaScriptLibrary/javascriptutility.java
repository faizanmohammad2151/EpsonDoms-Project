package com.DomsEpson.JavaScriptLibrary;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import com.DomsEpson.WebDriverlibrary.WebDriverUtility;

/**
 * This Class Provides The Reusable Method To Pass The Data With The Help Of JavascriptExecutor
 * @author ymdta*/
public class javascriptutility {
	
	public JavascriptExecutor javascriptobj;
	
	public void enterData_DisabledElement(WebElement element, String data)
	{
		javascriptobj=(JavascriptExecutor)WebDriverUtility.driver_static;
		javascriptobj.executeScript("arguments[0].value=" +data + "",  element);
	}
	public void click_DisabledElement()
	{
		javascriptobj=(JavascriptExecutor)WebDriverUtility.driver_static;
		//javascriptobj.executeScript("arguments[0].click()", element);
	}
	public void defaultVerticalscrollBy()
	{
		javascriptobj=(JavascriptExecutor)WebDriverUtility.driver_static;
		javascriptobj.executeScript("window.scrollBy(1000,1000)");
		
	}
	public void defaultHorihoriiscrollTo()
	{
		javascriptobj=(JavascriptExecutor)WebDriverUtility.driver_static;
		javascriptobj.executeScript("window.scrollTo(1000,1000)");
	}
	public void scrollUsingView(WebElement element, boolean value)
	{
		javascriptobj=(JavascriptExecutor)WebDriverUtility.driver_static;
		javascriptobj.executeScript("arguments[0].scrollIntoView("+value+");,",element);
	}
	
		
	

}
