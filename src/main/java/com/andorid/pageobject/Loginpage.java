package com.andorid.pageobject;

import java.io.IOException;

import org.openqa.selenium.By;

import com.qa.base.MobileBasePage;

public class Loginpage extends MobileBasePage {

	By loginIcon = By.id("com.divum.MoneyControl:id/header_user_icon_img");
	By emailTextBox = By.id("com.divum.MoneyControl:id/loginEmailET");
	By passwordTextBox = By.id("com.divum.MoneyControl:id/loginePassET");
	By loginButton = By.id("com.divum.MoneyControl:id/loginBtn");

	public void dologin() throws IOException, InterruptedException {

		click(loginIcon);
		Thread.sleep(3000);
		sendkeys(emailTextBox, "testing");
		hideKeyboard();
		Thread.sleep(3000);
		sendkeys(passwordTextBox, "testing");
		hideKeyboard();
		click(loginButton);
	}

}
