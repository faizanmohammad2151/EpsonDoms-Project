package com.DomsEpson.PageRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	//initialization
	public RegisterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
