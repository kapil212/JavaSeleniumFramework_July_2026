package com.kapil.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.kapil.utilities.WaitUtility;

public class LoginPage extends BasePage {

	// Username
	// Password
	// Login

	@FindBy(name = "username")
	private WebElement userNameTextBox;

	@FindBy(name = "password")
	private WebElement passwordTextBox;

	@FindBy(css = "button[type='submit']")
	private WebElement loginBtn;

	public DashboardPage login(String username, String password) {

		WaitUtility.waitForVisibility(userNameTextBox);
		userNameTextBox.sendKeys(username);

		WaitUtility.waitForVisibility(passwordTextBox);
		passwordTextBox.sendKeys(password);

		WaitUtility.waitForClickable(loginBtn);
		loginBtn.click();
		
		return new DashboardPage();

	}

}
