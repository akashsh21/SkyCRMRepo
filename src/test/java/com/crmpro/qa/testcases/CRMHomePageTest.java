package com.crmpro.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crmpro.qa.base.CRMTestBase;
import com.crmpro.qa.pages.HomePage;
import com.crmpro.qa.pages.LoginPage;
import com.crmpro.qa.testdata.TestdataProvider;
import com.crmpro.qa.utils.TestUtils;

public class CRMHomePageTest extends CRMTestBase {
	LoginPage loginpage;
	HomePage homepage;

	@BeforeMethod
	public void start() {
		initialization();
		loginpage = new LoginPage();
		homepage = new HomePage();
	}

	@Test(dataProvider = "dataP1", dataProviderClass = TestdataProvider.class, enabled = false)
	public void verify_logout_link(String username, String password) {
		loginpage.getLogin(username, password);
		TestUtils.switchToFrames();
		homepage.clickOnlogoutLink();
		Assert.assertEquals(driver.getTitle(), prop.getProperty("eLoginPage_title"));
	}

	@Test(dataProvider = "dataP1", dataProviderClass = TestdataProvider.class, enabled = false)
	public void verify_New_company_Link(String username, String password) {
		loginpage.getLogin(username, password);
		TestUtils.switchToFrames();
		homepage.clickOnNewCompany();
	}

	@Test()
	public void verify_New_company_option_test() {
		loginpage.loginCredential();
		TestUtils.switchToFrames();
		System.out.println(homepage.verifyNewCompanyOption());
		Assert.assertEquals(true, homepage.verifyNewCompanyOption());
	}

	@Test(enabled = false)
	public void test_credential_using_prop() {
		loginpage.loginCredential();
	}

	@Test()
	public void verify_New_combinedForm_option_test() {
		loginpage.loginCredential();
		TestUtils.switchToFrames();
		System.out.println(homepage.verifyNewCombinedFormOption());
		Assert.assertEquals(true, homepage.verifyNewCombinedFormOption());
	}

	@Test()
	public void verify_FullSearchForm_option_test() {
		loginpage.loginCredential();
		TestUtils.switchToFrames();
		System.out.println(homepage.verifyFullSearchFormOption());
		Assert.assertEquals(true, homepage.verifyFullSearchFormOption());

	}
	
	@Test()
	public void testMethod() {
		System.out.println("hello, I am Akash");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
// other two options in company with config file changes
//
