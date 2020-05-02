package com.qa.util;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{

	
	int count=0;
	int retryNumber = 1;
	
	public boolean retry(ITestResult result) {
		

		
		if(count<=retryNumber) 
		{
			count++;
			return true;
		}
		else {
		return false;
	}
	}
}
