package com.qa.base;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.qa.configuration.RestConfiguration;
import com.qa.extentreport.configuration.ExtentReportGenerator;
import com.rest.coreclasses.RestClient;

public class BaseTest {

	BaseTest basetest;
	public static RestClient restClient;
	public static String requestURL;
	ExtentReportGenerator extentreportgenerator;

	public BaseTest() {

		extentreportgenerator = new ExtentReportGenerator();
		restClient = new RestClient();

	}

	@BeforeSuite
	public void beforeSuite() {

		extentreportgenerator.startExtentReport();

	}

	@BeforeTest
	public void beforeTest() {

	}

	@BeforeMethod
	public void beforeMethod(Method method) {

		requestURL = RestConfiguration.getBaseURL() + RestConfiguration.getApiURL();
		extentreportgenerator.createExtentReport(method);
	}

	@AfterMethod
	public void afterMethod(ITestResult result) {

		extentreportgenerator.captureTestResult(result);
	}

	@AfterTest
	public void afterTest() {

	}

	@AfterSuite
	public void afterSuite() {

		extentreportgenerator.endExtentReport();
	}
}
