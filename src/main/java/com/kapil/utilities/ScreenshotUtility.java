package com.kapil.utilities;

import java.io.File;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.nio.file.Files;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.kapil.driver.DriverFactory;

public class ScreenshotUtility {
	
	public static String captureScreenshot(String testName) {
		
		
		TakesScreenshot ts=(TakesScreenshot)DriverFactory.getDriver();
		
		File source=ts.getScreenshotAs(OutputType.FILE);
		
		String timestamp=new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		
		String destination=System.getProperty("user.dir")+"/screenshots/"+testName+"_"+timestamp+".png";
		
		try {
			Files.copy(source.toPath(), new File(destination).toPath(),StandardCopyOption.REPLACE_EXISTING);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return destination;
	}

}
