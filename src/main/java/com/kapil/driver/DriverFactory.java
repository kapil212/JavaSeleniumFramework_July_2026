package com.kapil.driver;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.kapil.utilities.LoggerUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	private static final Logger log=LoggerUtility.getLogger(DriverFactory.class);
	
	private static	ThreadLocal<WebDriver> driver=new ThreadLocal<>();
	
	public static void  initDriver() {
		
		WebDriverManager.chromedriver().setup();
		driver.set(new ChromeDriver());
		getDriver().manage().window().maximize();
		log.info("Launching Chrome Browser");
		
	}
	
	public static WebDriver getDriver() {
		return driver.get();
	}
	
	public static void quitDriver() {
		if(driver.get()!=null) {
			driver.get().quit();
			driver.remove();
			log.info("Closing Browser");
		}
	}

}
