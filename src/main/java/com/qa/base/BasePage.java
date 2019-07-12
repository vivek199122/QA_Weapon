package com.qa.base;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.mobile.coreclasses.PlatformFactory;
import com.qa.configuration.MobileConfiguration;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class BasePage {

	public WebDriver driver;
	public IOSDriver iosdriver;
	PlatformFactory platformfactory;

	public BasePage() {
		platformfactory = new PlatformFactory();
		driver = PlatformFactory.androiddriver;
	}

	public void click(By by) throws IOException {

		try {
			timeinterval(2);
			driver.findElement(by).click();
			timeinterval(5);
		} catch (NoSuchElementException e) {
			driver.findElement(by).click();
		} catch (Exception e) {
			Assert.assertTrue(false, "Fail to click on link : " + by + " on page : " + e.getMessage());
			// rootLogger.warn("Fail to click on link : " + by + " on page : " +
			// selenium.getWrappedandroiddriver().getCurrentUrl());
		}
	}

	public void timeinterval(int i) throws InterruptedException {

		Thread.sleep(1000 * i);

	}

	public void sendkeys(By by, String keys) {
		//getHighlightElement(driver.findElement(by));
		driver.findElement(by).sendKeys(keys);
	}

}
