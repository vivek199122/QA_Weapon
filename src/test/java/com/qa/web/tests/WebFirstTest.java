package com.qa.web.tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;
import com.qa.base.WebBasePage;

public class WebFirstTest extends BaseTest{

	private static final Logger logger = LoggerFactory.getLogger(WebFirstTest.class);
	
	@Test
	public void smampletest() {

		System.out.println("WebTest");
		
		
		logger.debug("Your message");
		logger.error("Your error");
		logger.info("This is info");
		
		
		// 50 steps
	}

}
