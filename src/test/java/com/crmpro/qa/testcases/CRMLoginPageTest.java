package com.crmpro.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crmpro.qa.base.CRMTestBase;
import com.crmpro.qa.pages.LoginPage;
import com.crmpro.qa.testdata.TestdataProvider;
import com.crmpro.qa.utils.TestUtils;

public class CRMLoginPageTest extends CRMTestBase {

	LoginPage loginpage;

	@BeforeMethod
	public void start() {
		initialization();
		loginpage = new LoginPage();
	}

	@Test
	public void verifyLgnPageLogo() {
		TestUtils.implicitWait(10);
		//System.out.println(loginpage.verifyLogo());
		Assert.assertTrue(loginpage.verifyLogo());
	}

	@Test(enabled = false)
	public void verify_Page_Title() {
		String atitle = loginpage.getLoginPagetitle();
		String etitle = prop.getProperty("eLoginPage_title");
		Assert.assertEquals(atitle, etitle);
	}

	@Test(dataProvider = "dataP1", dataProviderClass = TestdataProvider.class, enabled = false)
	public void verify_Login_With_Valid_Credentials(String userName, String password) {
		loginpage.getLogin(userName, password);
		Assert.assertEquals(driver.getTitle(), prop.getProperty("eHomePage_title"));
	}

	@Test(dataProvider = "dataP2", dataProviderClass = TestdataProvider.class, enabled = false)
	public void verify_Login_With_Invalid_Credentials(String userName, String password) {
		loginpage.getLogin(userName, password);
		Assert.assertEquals(driver.getTitle(), prop.getProperty("eLoginPage_title"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}