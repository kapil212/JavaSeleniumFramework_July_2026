package com.kapil.utilities;

import org.testng.annotations.DataProvider;

public class TestData {
	
	@DataProvider(name="loginData")
	public Object[][] loginData(){
		return new Object[][] {
			
			{"Admin","admin123"},
			{"adminqw","dsfs"},
			{"ffee","fwew"}
			
		};
	}

}
