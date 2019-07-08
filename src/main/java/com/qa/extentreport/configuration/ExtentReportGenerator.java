package com.qa.extentreport.configuration;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportGenerator {

	// builds a new report using the html template
	ExtentHtmlReporter htmlReporter;

	ExtentReports extent;

	// helps to generate the logs in test report.
	ExtentTest test;

	public void startExtentReport() {

		htmlReporter = new ExtentHtmlReporter(System.getProperty("./test-output/ExtentReport.html"));
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		extent.setSystemInfo("Host Name", "SoftwareTestingMaterial");
		extent.setSystemInfo("Environment", "Automation Testing");
		extent.setSystemInfo("User Name", "Vivek P.");

		htmlReporter.config().setDocumentTitle("Title of the Report Comes here");
		htmlReporter.config().setReportName("Name of the Report Comes here");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);
	}

	public void endExtentReport() {

		extent.flush();

	}

}
