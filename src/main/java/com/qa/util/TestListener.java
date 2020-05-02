package com.qa.util;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestListener implements ITestListener{

	
	ExtentReports report;
	ExtentTest logger;
	
	public void onFinish(ITestContext context) {
		
		report.flush();
		report.endTest(logger);
		
		System.out.println(" All Tests Finished and Extent Reports Printed");
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
		report = new ExtentReports(System.getProperty("user.dir")+"\\src\\main\\resources\\com\\qa\\testoutput\\reports\\ExtentReports.html");
		logger = report.startTest("Rest Assured Api Testing");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		
		logger.log(LogStatus.FAIL, "The Test "+result.getMethod().getMethodName()+" Has Failed "+" The Error is : "+result.getThrowable());
	}

	public void onTestSkipped(ITestResult result) {
		
		logger.log(LogStatus.SKIP,"The Test "+result.getMethod().getMethodName()+" is Skipped "+result.getThrowable());
		
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		
		logger.log(LogStatus.PASS,"The Test "+result.getMethod().getMethodName()+" is Passed ");
		
	}

}
