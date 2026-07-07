package com.kapil.listners;

import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.kapil.utilities.LoggerUtility;
import com.kapil.utilities.ScreenshotUtility;

public class TestListner implements ITestListener {
	
	private static final Logger log=LoggerUtility.getLogger(TestListner.class);

	public void onTestStart(ITestResult result) {
		
		log.info("TEST START : {}",result.getName());
		//System.out.println("TEST START "+ result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		log.info("TEST SUCCESS : {}",result.getName());
		//System.out.println("TEST SUCCESS "+ result.getName());
	}

	public void onTestFailure(ITestResult result) {
		log.info("TEST FAIL : {}",result.getName());
		//System.out.println("TEST FAIL "+ result.getName());
		
		// Attach screenshot for fail
		
		ScreenshotUtility.captureScreenshot(result.getName());
	}

	public void onTestSkipped(ITestResult result) {
		log.info("TEST SKIPPED : {}",result.getName());
		//System.out.println("TEST SKIPPED "+ result.getName());
		
		// Attach screenshot for Skipped
		
				ScreenshotUtility.captureScreenshot(result.getName());
	}

}
