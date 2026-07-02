package com.kapil.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.kapil.base.BaseTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTest extends BaseTest {
		
	@Test
	public void launchBrowser() {
		
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
	}
}
