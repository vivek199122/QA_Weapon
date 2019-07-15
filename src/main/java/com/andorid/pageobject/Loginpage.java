package com.andorid.pageobject;

import java.io.IOException;

import org.openqa.selenium.By;

import com.qa.base.BasePage;

public class Loginpage extends BasePage {

	By loginIcon = By.id("com.divum.MoneyControl:id/header_user_icon_img");
	By emailTextBox = By.id("com.divum.MoneyControl:id/loginEmailET");
	By passwordTextBox = By.id("com.divum.MoneyControl:id/loginePassET");

	public void dologin() throws IOException {

		click(loginIcon);
		sendkeys(emailTextBox, "testing");
		sendkeys(passwordTextBox, "testing");

	}

}
