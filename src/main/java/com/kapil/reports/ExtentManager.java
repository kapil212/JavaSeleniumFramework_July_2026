package com.kapil.reports;

import org.apache.logging.log4j.Logger;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.kapil.utilities.LoggerUtility;

public class ExtentManager {

	private static final Logger log = LoggerUtility.getLogger(ExtentManager.class);

	private static ExtentReports extentReports;

	public static ExtentReports getExtentReports() {

		if (extentReports == null) {

			extentReports = new ExtentReports();
			String timestamp = new java.text.SimpleDateFormat("yyyyMMdd_HHmmss").format(new java.util.Date());

			String reportPath = System.getProperty("user.dir") + "/reports/ExtentReport_" + timestamp + ".html";

			System.out.println(reportPath);

			ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);

			spark.config().setReportName("Java Selenium Framework July 2026");
			spark.config().setDocumentTitle("Automation Execution Report");

			extentReports.attachReporter(spark);
			extentReports.setSystemInfo("Tester", "kapil");
			extentReports.setSystemInfo("Framework", "Java Selenium");
			extentReports.setSystemInfo("Build Tool", "Maven");
			log.info("Extent Report Initialised Successfully");
			System.out.println("Extent Report Initialised Successfully");
		}

		return extentReports;

	}

}
