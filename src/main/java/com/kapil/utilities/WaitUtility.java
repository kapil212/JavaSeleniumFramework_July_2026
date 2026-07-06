package com.kapil.utilities;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.kapil.driver.DriverFactory;

public class WaitUtility {
	
	private static final int EXPLICIT_WAIT=Integer.parseInt(ConfigReader.getProperty("explicitWait"));
	
	public static void waitForVisibility(WebElement element) {
		
		WebDriverWait wait=new WebDriverWait(DriverFactory.getDriver(),Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	public static void waitForClickable(WebElement element) {
		WebDriverWait wait=new WebDriverWait(DriverFactory.getDriver(),Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}

}
