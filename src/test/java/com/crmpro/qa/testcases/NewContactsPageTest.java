package com.crmpro.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crmpro.qa.base.CRMTestBase;
import com.crmpro.qa.pages.HomePage;
import com.crmpro.qa.pages.LoginPage;
import com.crmpro.qa.pages.NewContactPage;
import com.crmpro.qa.utils.TestUtils;

public class NewContactsPageTest extends CRMTestBase {
	LoginPage loginpage;
	HomePage homepage;
	NewContactPage new_contactpage;


	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		homepage = new HomePage();
	}
	
	@Test
	public void verifyNewContactsPage_TC001() {
		loginpage.getLogin();
		TestUtils.switchToFrames();
		homepage.mouseHoverOnContacts();
		homepage.clickOnNewContacts();
		TestUtils.switchToFrames();
		System.out.println(new_contactpage.veriyNewContactsPage());
		Assert.assertEquals(true, new_contactpage.veriyNewContactsPage());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
