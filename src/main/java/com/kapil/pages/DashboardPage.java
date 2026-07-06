package com.kapil.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.kapil.utilities.WaitUtility;

public class DashboardPage extends BasePage{
	
	@FindBy(xpath="//h6[text()='Dashboard']")
	WebElement dashboardTitle;
	
	public boolean isDashboardDisplayed() {
		
		WaitUtility.waitForVisibility(dashboardTitle);
		
		return dashboardTitle.isDisplayed();
		
		
	}

}
