package com.Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReports_Setup {

	static ExtentReports reports;

	public static ExtentReports setupExtentReports() {

		String reportPath=System.getProperty("user.dir")+"\\Reports\\TestReports.html";
		ExtentSparkReporter extentSparkReporter=new ExtentSparkReporter(reportPath);
		extentSparkReporter.config().setReportName("WebAutomationReport Details");
		extentSparkReporter.config().setDocumentTitle("Web-ExtentReport");

		reports=new ExtentReports();
		reports.setSystemInfo("Tester", "VinothKumar Palanisamy");
		reports.attachReporter(extentSparkReporter);


		return reports;

	}

}
