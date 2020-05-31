package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	// this class should contain OR and page actions. Refer POM image for
	// clarifications

	private WebDriver driver; // This is private so that once assigned no one can change it.

	// 1.
	// By locators -- OR (object repository)
	// This class is used to store all the page objects

	By username = By.id("username");
	By password = By.id("password");
	By loginBtn = By.id("loginBtn");
	By SignUp = By.linkText("Sign up");
	By PrivacyPolicy = By.linkText("Privacy Policy");

	// 2.
	// Creating constructor to pass driver into this class from where ever its
	// called from

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// Page actions

	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean verifySignUpLink() {
		return driver.findElement(SignUp).isDisplayed(); 
	}

	public HomePage doLogin(String username, String password) {
		driver.findElement(this.username).sendKeys(username);
		driver.findElement(this.password).sendKeys(password);
		driver.findElement(this.loginBtn).click();
		
		return new HomePage(driver); 
	}

}
