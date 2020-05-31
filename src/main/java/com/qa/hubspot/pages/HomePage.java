package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.basePage.BasePage;

public class HomePage extends BasePage {

	private WebDriver driver;

	// 1. OR
	By header = By.cssSelector("h1.dashboard-selector__title");
	By accMenuBtn = By.id("account-menu");
	By usrName = By.className("user-info-name");

	// Constructor for driver
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	// Page actions 
	// Home page title
	public String getHomePageTitle() {
		return driver.getTitle();
	}

	// returning header text
	public String getHeaderText() {
		return driver.findElement(header).getText();
	}

	// return logged in user
	public String getAccountName() {
	// id account-menu
	// class user-info-name
	driver.findElement(accMenuBtn).click();
	return driver.findElement(usrName).getText();
	}
}
