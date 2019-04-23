package com.crmpro.qa.utils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.crmpro.qa.base.CRMTestBase;
import com.google.common.io.Files;

public class TestUtils extends CRMTestBase {

	public void MouseHover(WebElement Element, WebElement Element2) {
		Actions action = new Actions(driver);
		action.moveToElement(Element).moveToElement(Element2).click().build().perform();
	}

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		Files.copy(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}

	public static void switchToFrames() {
		driver.switchTo().frame("mainpanel");
	}

	public static void mouseHover(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}

	public static void implicitWait(int x) {
		driver.manage().timeouts().implicitlyWait(x, TimeUnit.SECONDS);
	}

	public static void selectOptionByVisibleText(WebElement element, String value) {
		Select slt = new Select(element);
		slt.selectByVisibleText(value);
	}

	public static void selectOptionByvalue(WebElement element, String value) {
		Select slt = new Select(element);
		slt.selectByValue(value);
	}

}
