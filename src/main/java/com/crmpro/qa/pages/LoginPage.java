package com.crmpro.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
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

	@FindBy(xpath = "//input[@name='password']//following::input[1]")
	WebElement loginBtn;

	@FindBy(xpath = "/html/body/div[2]/div/div[1]/a/img")
	WebElement lgnPageLogo;

	public String getLoginPagetitle() {
		return driver.getTitle();
	}

	public HomePage getLogin(String username, String password) {
		userNameField.sendKeys(username);
		pwdField.sendKeys(password);
		TestUtils.implicitWait(10);
		loginBtn.click();
		return new HomePage();
	}

	public void loginCredential() {
		userNameField.sendKeys((prop.getProperty("username")));
		pwdField.sendKeys((prop.getProperty("password")));
		TestUtils.implicitWait(10);
		loginBtn.click();
	}
	

	public boolean verifyLogo() {
		boolean ImagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				lgnPageLogo);
		return ImagePresent;
	}
}
