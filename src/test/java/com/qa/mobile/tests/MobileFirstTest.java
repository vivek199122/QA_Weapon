package com.qa.mobile.tests;

import org.testng.annotations.Test;

import com.andorid.pageobject.Loginpage;
import com.qa.base.BaseTest;

public class MobileFirstTest extends BaseTest {

	@Test
	public void loginTest() throws Exception {

		Loginpage loginpage = new Loginpage();

		Thread.sleep(11000);

		loginpage.dologin();
		
		


//
//		Thread.sleep(2000);
////	   driver.toggleWifi();
////	   driver.toggleData();
//
//		WebElement userName = android_driver.findElement(By.id("com.divum.MoneyControl:id/loginEmailET"));
//		userName.sendKeys("testing");
//		Thread.sleep(2000);
//
//		android_driver.hideKeyboard();
//
//		WebElement password = android_driver.findElement(By.id("com.divum.MoneyControl:id/loginePassET"));
//		password.sendKeys("testing");
//		Thread.sleep(2000);
//
//		android_driver.hideKeyboard();
//
//		WebElement logInButton = android_driver.findElement(By.id("com.divum.MoneyControl:id/loginBtn"));
//		logInButton.click();
//
//		Activity activity = new Activity("com.android.settings", "com.android.settings.Settings");
//		// activity.setWaitAppPackage("app wait package goes here");
//		// activity.setWaitAppActivity("app wait activity goes here");
//		android_driver.startActivity(activity);
//
//		Thread.sleep(2000);
//		// Switch OFF WIFI
//		android_driver.findElement(By.id("com.android.settings:id/switchWidget")).click();
	}

}
