package com.qa.web.tests;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;
import com.web.pageobject.HomePage;

public class WebFirstTest extends BaseTest{

	private static final Logger logger = LoggerFactory.getLogger(WebFirstTest.class);
	
	HomePage homepage;
	
	@Test
	public void smampletest() throws IOException, InterruptedException {

		System.out.println("WebTest");
		
		
		logger.debug("Your message");
		logger.error("Your error");
		logger.info("This is info");
		
		homepage = webpage.GetInstance(HomePage.class);
		Thread.sleep(5000);
		homepage.clickMenu("test");
		
		// 50 steps
	}

}
