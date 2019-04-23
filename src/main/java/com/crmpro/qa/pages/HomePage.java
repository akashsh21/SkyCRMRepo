package com.crmpro.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crmpro.qa.base.CRMTestBase;
import com.crmpro.qa.utils.TestUtils;

public class HomePage extends CRMTestBase {
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//i[@class='fa fa-sign-out icon-2x']")
	WebElement logoutLink1;

	@FindBy(xpath = "//a[contains(text(),'Full Search Form')]")
	WebElement Full_Search_Form;

	@FindBy(xpath = "//td[contains(text(), 'akash shastrakar')]")
	WebElement usernameLabel;

	@FindBy(xpath = "//a[contains(text(),'Companies')]")
	static WebElement companies;

	@FindBy(xpath = "//a[contains(text(),'New Company')]")
	WebElement New_company;

	@FindBy(xpath = "//a[contains(text(),'Combined Form')]")
	WebElement Combined_form;

	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement New_contact;

	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	static WebElement Contacts;

	public String verfiyHomePagetitle() {
		return driver.getTitle();
	}

	public LoginPage clickOnlogoutLink() {
		logoutLink1.click();
		return new LoginPage();
	}

	public void mouseHoverOnCompany() {
		TestUtils.mouseHover(companies);
	}

	public void mouseHoverOnContacts() {
		TestUtils.mouseHover(Contacts);
	}

	public boolean verifyNewCompanyOption() {
		mouseHoverOnCompany();
		return New_company.isDisplayed();
	}

	public boolean verifyNewCombinedFormOption() {
		mouseHoverOnCompany();
		return Combined_form.isDisplayed();
	}

	public boolean verifyFullSearchFormOption() {
		mouseHoverOnCompany();
		return Full_Search_Form.isDisplayed();
	}

	public void clickOnNewCompany() {
		mouseHoverOnCompany();
		New_company.click();
	}

	public void clickOnNewContacts() {
		New_contact.click();

	}

}
