package com.crmpro.qa.pages;

import org.openqa.selenium.support.PageFactory;

import com.crmpro.qa.base.CRMTestBase;

public class HomePage extends CRMTestBase{
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verfiyHomePagetitle() {
		return driver.getTitle();
	}
	
}
