package com.qa.web.pageobject;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.base.WebBasePage;

public class HomePage extends WebBasePage {

	By menuName = By.xpath("//li[@id='menu-item-3932']//a[contains(text(),'Case Studies')]");
	
	public HomePage(WebDriver driver) {
		super(driver);
		
	}

	public void clickMenu(String menu) throws IOException {
		
		click(menuName);
	}
}
