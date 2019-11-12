package com.qa.base;

import java.lang.reflect.Method;
import java.net.MalformedURLException;

import org.apache.log4j.PropertyConfigurator;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.mobile.coreclasses.MobilePageGenerator;
import com.mobile.coreclasses.PlatformFactory;
import com.qa.configuration.MobileConfiguration;
import com.qa.configuration.RestConfiguration;
import com.qa.configuration.WebConfiguration;
import com.qa.extentreport.configuration.ExtentReportGenerator;
import com.rest.coreclasses.RestClient;
import com.web.coreclasses.DriverFactory;
import com.web.coreclasses.WebPageGenerator;

public class BaseTest {

	public static RestClient restClient;
	public static String requestURL;
	ExtentReportGenerator extentreportgenerator;
	PlatformFactory platformfactory;
	DriverFactory driverfactory;
	public WebPageGenerator webpage;
	public MobilePageGenerator mobilepage;

	public BaseTest() {

		extentreportgenerator = new ExtentReportGenerator();
		restClient = new RestClient();
		platformfactory = new PlatformFactory();

	}

	@BeforeSuite
	public void beforeSuite() {

		extentreportgenerator.startExtentReport();
		PropertyConfigurator.configure("log4j.properties");

	}

	@BeforeTest
	public void beforeTest() throws MalformedURLException {

		if (System.getProperty("profileId").equalsIgnoreCase("mobile")) {

			platformfactory.createDriver(MobileConfiguration.getPlatform());
			mobilepage = new MobilePageGenerator(PlatformFactory.appiumDriver);
			
		} else if (System.getProperty("profileId").equalsIgnoreCase("web")) {

			DriverFactory.build(WebConfiguration.getDriverEnvironment(),
					DriverFactory.setup(WebConfiguration.getDriverEnvironment()));
			webpage = new WebPageGenerator(DriverFactory.driver);
			DriverFactory.driver.get(WebConfiguration.getRemoteURL());
		}

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
		DriverFactory.DestroyDriver();
	}
}
