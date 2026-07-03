package com.kapil.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.kapil.base.BaseTest;
import com.kapil.driver.DriverFactory;
import com.kapil.utilities.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTest extends BaseTest {
		
	@Test
	public void launchBrowser() {
		
		DriverFactory.getDriver().get(ConfigReader.getProperty("url"));
		System.out.println(DriverFactory.getDriver().getTitle());
		System.out.println(DriverFactory.getDriver().getCurrentUrl());
	}
}
