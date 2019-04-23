package com.crmpro.qa.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.crmpro.qa.base.CRMTestBase;

public class Utility extends CRMTestBase
{
	public void MouseHover(WebElement Element,WebElement Element2)
	{
		Actions action = new Actions(driver);
		action.moveToElement(Element).moveToElement(Element2).click().build().perform();

	}

}
