package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.basePage.BasePage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.util.Constants;

public class HomePageTest {
	WebDriver driver;
	BasePage basePage;
	LoginPage loginPg;
	HomePage homePg;
	Properties prop;

	@BeforeTest
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.initProperties();
		driver = basePage.initDriver(prop);
		driver.manage().window().maximize();
		loginPg = new LoginPage(driver);
		homePg = loginPg.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	}

	@Test (priority = 3)
	public void verifyPageTileTest(){
		String PgTitle = homePg.getHomePageTitle();
		Assert.assertEquals(PgTitle,Constants.HOME_PAGE_TITLE,"Page tile incorrect .. ");
	}
	
	@Test (priority = 1)
	public void verifyHeaderTextTest(){
		String HText = homePg.getHeaderText();
		Assert.assertEquals(HText, Constants.HOME_PAGE_HEADER, "Header text is incorrect .. ");
	}
	
	@Test(priority = 2)
	public void verifyLoggedInUserNameTest() {
		String LoggedInUser = homePg.getAccountName();
		Assert.assertEquals(LoggedInUser,"Goutam Joshi", "Logged in user not matched");	
	}
	
	@AfterTest
	private void tearDown() {
		driver.close();
	}

}
