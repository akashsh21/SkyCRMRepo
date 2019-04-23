package com.crmpro.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crmpro.qa.base.CRMTestBase;
import com.crmpro.qa.utils.TestUtils;

public class NewContactPage extends CRMTestBase {
	// initiate page factory
	public NewContactPage() {
		PageFactory.initElements(driver, this);
	}

	// Page object repository

	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactInfoLabel;

	@FindBy(name = "title")
	WebElement titleDropdown;

	@FindBy(xpath = "//select[@name='title']//following-sibling::input[1]")
	WebElement title_help;

	@FindBy(id = "first_name")
	WebElement firstNameField;

	@FindBy(id = "surname")
	WebElement LastNameField;

	@FindBy(xpath = "//select[@name='suffix']")
	WebElement suffixDropdown;

	@FindBy(xpath = "//input[@name='image_file']")
	WebElement chooseFileBtn;

	@FindBy(xpath = "//input[@name='client_lookup']")
	WebElement CompanyField;

	@FindBy(xpath = "//input[@name='client_lookup']//following-sibling::input[@class='button']")
	WebElement companyLookuptn;

	@FindBy(xpath = "//input[@name='contact_lookup_ref']")
	WebElement ReferredByField;

	@FindBy(xpath = "//input[@name='contact_lookup_ref']//following-sibling::input[@value='Lookup']")
	WebElement ReferredByLookup;

	@FindBy(id = "owner_user_id")
	WebElement Ownerfield;

	@FindBy(xpath = "//input[@id='email']")
	WebElement EmailField;

	@FindBy(xpath = "//input[@name='receive_email' and @value='Y']")
	WebElement ReceiveMail_Y_radiobtn;

	@FindBy(xpath = "//input[@name='receive_email' and @value='N']")
	WebElement ReceiveMail_N_radiobtn;

	//Methods for performing Actions
	public void selectTitle() {
		TestUtils.selectOptionByVisibleText(titleDropdown, "Miss");
	}
	
	
	
	
	
	
	
	
	
}
