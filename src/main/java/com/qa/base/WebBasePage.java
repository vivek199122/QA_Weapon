package com.qa.base;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import com.web.coreclasses.WebPageGenerator;

public class WebBasePage extends WebPageGenerator {

	private static final Logger logger = LoggerFactory.getLogger(WebBasePage.class);

	public static int Seconds = 15;
	WebPageGenerator page;

	static ThreadLocal<WebDriver> driverinstance = new ThreadLocal<>();

	public WebBasePage(WebDriver driver) {
		super(driver);
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

	public void getHighlightElement(final WebElement element) {
		try {
			Wait<WebDriver> wait = new WebDriverWait(driver, Seconds);
			// Wait for search to complete
			wait.until(new ExpectedCondition<Boolean>() {
				@Override
				public Boolean apply(WebDriver webDriver) {
					return element != null;
				}
			});
			((JavascriptExecutor) driver).executeScript("arguments[0].style.border='2px solid red'", element);
		} catch (Exception e) {
			logger.info("Fail to highlight the Element");
		}
	}

//	@SuppressWarnings("unchecked")
//	public WebBasePage<T> detectPage() throws IOException {
//
//		String url = driver.getCurrentUrl();
//		
//
//		String testUrl = WebConfiguration.getRemoteURL();
//
//		if (url.startsWith(testUrl + "services/xerox-case-study/")) {
//
//			return PageFactory.initElements(driver, CaseStudyPage.class);
//
//		} else if (url.startsWith(testUrl + "careers/")) {
//
//			return PageFactory.initElements(driver, CareersPage.class);
//
//		} else {
//			logger.info("URL : " + url);
//			logger.info("No Page Detected");
//			return null;
//		}
//
//	}

}
