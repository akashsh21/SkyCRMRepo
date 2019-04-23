package com.crmpro.qa.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crmpro.qa.base.CRMTestBase;
import com.crmpro.qa.pages.HomePage;
import com.crmpro.qa.pages.LoginPage;

public class Company_Test extends CRMTestBase {
	LoginPage loginpage = new LoginPage();
	HomePage homepage = new HomePage();
	
	@BeforeMethod
	public void start() {
		initialization();
		loginpage.loginCredential();
		}
	
	@Test
	public void Verify_company_field()
	{
		
	}
}
