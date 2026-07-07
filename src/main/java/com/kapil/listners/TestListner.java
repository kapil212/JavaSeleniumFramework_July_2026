package com.kapil.listners;

import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.kapil.reports.ExtentManager;
import com.kapil.utilities.LoggerUtility;
import com.kapil.utilities.ScreenshotUtility;

public class TestListner implements ITestListener {
	
	private static final Logger log=LoggerUtility.getLogger(TestListner.class);
	
	private static ExtentReports reports=ExtentManager.getExtentReports();
	
	private static ThreadLocal<ExtentTest> test=new ThreadLocal<>();

	public void onTestStart(ITestResult result) {
		
		ExtentTest extentTest=reports.createTest(result.getName());
		test.set(extentTest);
		test.get().info("TEST STARTED");
		
		//log.info("TEST START : {}",result.getName());
		//System.out.println("TEST START "+ result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		
		test.get().pass("TEST SUCCESS");
		log.info("TEST SUCCESS : {}",result.getName());
		//System.out.println("TEST SUCCESS "+ result.getName());
	}

	public void onTestFailure(ITestResult result) {
		
		test.get().fail(result.getThrowable());
		log.info("TEST FAIL : {}",result.getName());
		//System.out.println("TEST FAIL "+ result.getName());
		
		// Attach screenshot for fail
		
		String ss=ScreenshotUtility.captureScreenshot(result.getName());
		
		test.get().addScreenCaptureFromPath(ss);
	}

	public void onTestSkipped(ITestResult result) {
		log.info("TEST SKIPPED : {}",result.getName());
		//System.out.println("TEST SKIPPED "+ result.getName());
		
		// Attach screenshot for Skipped
		
				ScreenshotUtility.captureScreenshot(result.getName());
	}
	
	public void onFinish(ITestContext context) {
		
		System.out.println("Inside onFinish*******************************");
	    
		reports.flush();
	  }

}
