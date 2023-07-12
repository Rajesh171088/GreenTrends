package com.greentreand.genericutility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class LisImpClass extends BaseClass implements ITestListener{

	@Override
	public void onTestFailure(ITestResult result) {
		
		String testName=result.getMethod().getMethodName();
		System.out.println(testName+"=======execute and im listening========");
		TakesScreenshot img=(TakesScreenshot)driver;
		File src=img.getScreenshotAs(OutputType.FILE);
		File dest=new File("./screenshots/"+testName+".png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (Exception e ) {
			
		}
		
	}

}
