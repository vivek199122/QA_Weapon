package com.qa.base;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
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
	public void beforeTest() throws ClientProtocolException, IOException {
		
		requestURL = RestConfiguration.getBaseURL() + RestConfiguration.getApiURL();
	}

	@BeforeMethod
	public void beforeMethod() {

	}

	@AfterMethod
	public void afterMethod() {

	}

	@AfterSuite
	public void afterSuite() {

		extentreportgenerator.endExtentReport();

	}
}
