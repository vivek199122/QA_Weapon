package com.qa.mobile.coreclasses;

import org.openqa.selenium.support.PageFactory;

import com.qa.base.MobileBasePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MobilePageGenerator {

	public AppiumDriver<MobileElement> appiumDriver;

	// Constructor
	public MobilePageGenerator(AppiumDriver<MobileElement> appiumDriver) {
		this.appiumDriver = appiumDriver;
	}

	// JAVA Generics to Create and return a New Page
	public <TPage extends MobileBasePage> TPage GetInstance(Class<TPage> pageClass) {
		try {
			// Initialize the Page with its elements and return it.
			return PageFactory.initElements(appiumDriver, pageClass);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
