package com.crmpro.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crmpro.qa.base.CRMTestBase;
import com.crmpro.qa.pages.LoginPage;
import com.crmpro.qa.testdata.TestdataProvider;

public class CRMLoginPageTest extends CRMTestBase {

	LoginPage loginpage;

	@BeforeMethod
	public void start() {
		initialization();
		loginpage = new LoginPage();
	}

	@Test(dataProvider = "dataP1", dataProviderClass = TestdataProvider.class)
	public void verify_Login_With_Valid_Credentials(String userName, String password) {
		loginpage.login_with_valid_credentials(userName, password);
		Assert.assertEquals(driver.getTitle(), "CRMPRO");
	}

	@Test(dataProvider = "dataP2", dataProviderClass = TestdataProvider.class)
	public void verify_Login_With_Invalid_Credentials(String userName, String password) {
		loginpage.login_with_Invalid_credentials(userName, password);
		Assert.assertEquals(driver.getTitle(),
				"CRMPRO - CRM software for customer relationship management, sales, and support.");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}