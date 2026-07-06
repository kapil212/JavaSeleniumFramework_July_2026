package com.kapil.base;

import java.util.logging.LogManager;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.kapil.driver.DriverFactory;
import com.kapil.utilities.ConfigReader;
import com.kapil.utilities.LoggerUtility;

public class BaseTest {
	
	private static final Logger log=LoggerUtility.getLogger(BaseTest.class);

	@BeforeMethod
	public void setup() {

		DriverFactory.initDriver();
		log.info("Launching google");
		DriverFactory.getDriver().get(ConfigReader.getProperty("url"));
	}

	@AfterMethod
	public void tearDown() {

		DriverFactory.quitDriver();
	}

}
