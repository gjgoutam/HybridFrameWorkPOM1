package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.basePage.BasePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.util.Constants;

public class LoginPageTest {

	BasePage basePage;
	WebDriver driver;
	LoginPage loginpg;
	Properties prop;
	

	@BeforeTest
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.initProperties();
		driver = basePage.initDriver(prop);
		loginpg = new LoginPage(driver);
		
	}

	// Verify page title test
	@Test
	public void verifyLoginPageTitleTest() {
		String pgTitle = loginpg.getLoginPageTitle();
		Assert.assertEquals(pgTitle, Constants.LOGIN_PAGE_TITLE, "Login page title is different");

	}

	// Verify presence of Signup Link
	@Test(priority = 1)
	public void verifySignUpLinkTest() {
		Assert.assertTrue(loginpg.verifySignUpLink(), "SignUp Link is not displayed");
	}

	@Test
	public void loginTest() {
		loginpg.doLogin("gjgoutamjoshigj@gmail.com", "Welcome@123Aut");
	}

	@AfterTest
	public void tearDown() { 
		driver.quit();
	} 

}
