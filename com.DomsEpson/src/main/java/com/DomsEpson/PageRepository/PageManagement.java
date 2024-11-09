package com.DomsEpson.PageRepository;

import org.openqa.selenium.WebDriver;


public class PageManagement {
	
	public WebDriver driver= null;
	public LoginPage loginpageobj;
	public RegisterPage registerpageobj;
	public WelcomePage welcomepageobj;
	
	
	// initialization
	public PageManagement(WebDriver driver) {
		this.driver= driver;
	}
	
	public LoginPage initloginpage() {
		loginpageobj = new LoginPage(driver);
		return loginpageobj;
		
	}
	
	public WelcomePage initWelcomePage() {
		welcomepageobj = new WelcomePage(driver);
		return welcomepageobj;
	}
	
	public RegisterPage initRegisterPage() {
		registerpageobj = new RegisterPage(driver);
		return registerpageobj;
	}
}
