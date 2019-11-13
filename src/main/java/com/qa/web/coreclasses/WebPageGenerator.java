package com.qa.web.coreclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.WebBasePage;

public class WebPageGenerator {
	public WebDriver driver;

	// Constructor
	public WebPageGenerator(WebDriver driver) {
		this.driver = driver;
	}

	// JAVA Generics to Create and return a New Page
	public <TPage extends WebBasePage> TPage GetInstance(Class<TPage> pageClass) {

		try {
			// Initialize the Page with its elements and return it.
			return PageFactory.initElements(driver, pageClass);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
