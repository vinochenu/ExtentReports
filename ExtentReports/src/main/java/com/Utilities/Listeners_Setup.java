package com.Utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


public class Listeners_Setup extends BaseClass implements ITestListener{

	ExtentTest test;

	
protected static ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();

	ExtentReports reports=ExtentReports_Setup.setupExtentReports();

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

		test=reports.createTest(result.getMethod().getMethodName());
		extentTest.set(test);


	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().log(Status.PASS, result.getMethod().getMethodName()+" is passed");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		WebDriver driver=null;
		
		extentTest.get().log(Status.FAIL, result.getThrowable());
		
		Object instance=result.getInstance();
		Class clazz=result.getTestClass().getRealClass();
	
		
		try {
			driver=(WebDriver) clazz.getDeclaredField("driver").get(instance);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
		String Testcase=result.getMethod().getMethodName();
		try {
			extentTest.get().addScreenCaptureFromPath(getScreenshotPath(Testcase,driver), result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().log(Status.SKIP, result.getMethod().getMethodName()+" is skipped from execution");
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	
		reports.flush();
	}



}
