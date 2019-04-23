package com.crmpro.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crmpro.qa.base.CRMTestBase;
import com.crmpro.qa.pages.HomePage;
import com.crmpro.qa.pages.LoginPage;
import com.crmpro.qa.utils.TestUtils;

public class NewContactsPageTest extends CRMTestBase {
	LoginPage loginpage;
	HomePage homepage;

	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		homepage = new HomePage();
	}
	
	@Test
	public void test1() {
		loginpage.getLogin();
		TestUtils.switchToFrames();
		
		homepage.click_on_New_contacts_option();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
