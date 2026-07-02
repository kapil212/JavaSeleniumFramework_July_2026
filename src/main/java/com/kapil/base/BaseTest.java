package com.kapil.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.kapil.driver.DriverFactory;

public class BaseTest {
	
	protected WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		
		driver=DriverFactory.initDriver();
	}
	
	@AfterMethod
	public void tearDown() {
		
		if(driver!=null) {
		driver.quit();
		}
	}

}
