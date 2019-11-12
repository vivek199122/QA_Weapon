package com.qa.base;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

import com.mobile.coreclasses.MobilePageGenerator;
import com.mobile.coreclasses.PlatformFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MobileBasePage extends MobilePageGenerator {

	public AppiumDriver<MobileElement> appiumDriver;

	PlatformFactory platformfactory;

	public MobileBasePage(AppiumDriver<MobileElement> appiumDriver) {
		super(appiumDriver);
	}

	public void click(By by) throws IOException {

		try {
			timeinterval(2);
			appiumDriver.findElement(by).click();
			timeinterval(5);
		} catch (NoSuchElementException e) {
			appiumDriver.findElement(by).click();
		} catch (Exception e) {
			Assert.assertTrue(false, "Fail to click on link : " + by + " on page : " + e.getMessage());
		}
	}

	public void timeinterval(int i) throws InterruptedException {

		Thread.sleep(1000 * i);

	}

	public void sendkeys(By by, String keys) {
		// getHighlightElement(driver.findElement(by));
		appiumDriver.findElement(by).sendKeys(keys);
	}

	public void hideKeyboard() {

		appiumDriver.hideKeyboard();
	}

}
