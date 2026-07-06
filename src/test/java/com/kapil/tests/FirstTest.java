package com.kapil.tests;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.kapil.base.BaseTest;
import com.kapil.driver.DriverFactory;
import com.kapil.pages.DashboardPage;
import com.kapil.pages.LoginPage;
import com.kapil.utilities.ConfigReader;
import com.kapil.utilities.LoggerUtility;
import com.kapil.utilities.TestData;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTest extends BaseTest {
	
	private static final Logger log=LoggerUtility.getLogger(FirstTest.class);
		
	@Test(dataProvider = "loginData",dataProviderClass = TestData.class)
	public void loginTest(String username,String password) {
		
	
		
		
		
		LoginPage loginPage=new LoginPage();
		log.info("orangehrm page");
		DashboardPage dashboardPage=loginPage.login(username,password);
		log.info("all details filled");
		
		Assert.assertTrue(dashboardPage.isDashboardDisplayed(),"Dashboard is not displayed after login");
		System.out.println(DriverFactory.getDriver().getTitle());
		System.out.println(DriverFactory.getDriver().getCurrentUrl());
		
		
	}
}
