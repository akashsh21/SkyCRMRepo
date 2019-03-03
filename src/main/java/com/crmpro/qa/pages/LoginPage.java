package com.crmpro.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crmpro.qa.base.CRMTestBase;
import com.crmpro.qa.utils.TestUtils;

public class LoginPage extends CRMTestBase {

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='username']")
	WebElement userNameField;

	@FindBy(xpath = "//input[@name='password']")
	WebElement pwdField;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginBtn;

	public String verfiyLoginPagetitle() {
		return driver.getTitle();
	}

	public HomePage getLogin(String username, String password) {
		userNameField.sendKeys(username);
		pwdField.sendKeys(password);
		TestUtils.implicitWait(10);
		loginBtn.click();
		return new HomePage();
	}

	public void login_with_valid_credentials(String username, String password) {
		getLogin(username, password);
	}
	public void login_with_Invalid_credentials(String username, String password) {
		getLogin(username, password);
	}

}
