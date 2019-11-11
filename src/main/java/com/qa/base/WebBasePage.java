package com.qa.base;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import com.web.coreclasses.DriverFactory;

public class WebBasePage {

	private static final Logger logger = LoggerFactory.getLogger(WebBasePage.class);

	public WebDriver driver;
	DriverFactory driverfactory;

	static ThreadLocal<WebDriver> driverinstance = new ThreadLocal<>();

	public WebBasePage(WebDriver driver) {
		this.driver = driver;
		driverfactory = new DriverFactory();
		driver = DriverFactory.driver;
	}

	public void click(By by) throws IOException {

		try {
			timeinterval(2);
			driver.findElement(by).click();
			timeinterval(5);
		} catch (NoSuchElementException e) {
			driver.findElement(by).click();
		} catch (Exception e) {
			logger.error("Fail to click on link : " + by + " on page : " + e.getMessage());
			Assert.assertTrue(false, "Fail to click on link : " + by + " on page : " + e.getMessage());
		}
	}

	public void timeinterval(int i) throws InterruptedException {
		Thread.sleep(1000 * i);
	}

	public void sendkeys(By by, String keys) {
		// getHighlightElement(driver.findElement(by));
		driver.findElement(by).sendKeys(keys);
	}

}
