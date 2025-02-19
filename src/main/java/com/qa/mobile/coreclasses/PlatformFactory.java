package com.qa.mobile.coreclasses;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class PlatformFactory {

	public static AppiumDriver<MobileElement> appiumDriver;

	// private HashMap<String, URL> hosts;

	private static DesiredCapabilities getCaps(String platformName) {

		DesiredCapabilities capabilities = new DesiredCapabilities();

		if (platformName.equalsIgnoreCase("Android")) {

			capabilities.setCapability("appPackage", "com.divum.MoneyControl");
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("platformVersion", "9");
			capabilities.setCapability("deviceName", "Nexus_6P");
			// capabilities.setCapability("app","C:\\Users\\vparmar\\Downloads\\moneycontrol.apk");
			capabilities.setCapability("app", "/Users/vivek/Downloads/moneycontrol.apk");
			capabilities.setCapability("noReset", "true");
			capabilities.setCapability("ful	lReset", "false");
			capabilities.setCapability("appActivity", "com.moneycontrol.handheld.SplashActivity");

			return capabilities;

		} else {

			capabilities.setCapability("appPackage", "com.divum.MoneyControl");
			capabilities.setCapability("platformName", "iOS");
			capabilities.setCapability("platformVersion", "9");
			capabilities.setCapability("deviceName", "Nexus_6P");
			capabilities.setCapability("app", "C:\\Users\\vparmar\\Downloads\\moneycontrol.apk");
			capabilities.setCapability("noReset", "true");
			capabilities.setCapability("fullReset", "false");
			capabilities.setCapability("appActivity", "com.moneycontrol.handheld.SplashActivity");
			return capabilities;

		}

		// return capabilities;

	}

	public void createDriver(String platformName) throws MalformedURLException {

		if (platformName.equalsIgnoreCase("Android")) {

			appiumDriver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),
					getCaps(platformName));
		} else {
			appiumDriver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), getCaps(platformName));
		}

	}

	public void killDriver() {

		appiumDriver.close();
		appiumDriver.quit();
	}

}
