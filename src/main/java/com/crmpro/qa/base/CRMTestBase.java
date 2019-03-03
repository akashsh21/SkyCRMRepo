package com.crmpro.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CRMTestBase {
	public static WebDriver driver;
	public static Properties prop;
	// public static EventFiringWebDriver e_driver;
	// public static WebEventListener eventListener;

	public CRMTestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/com/crmpro/qa/config/CRMconfig.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "J:/Seleniumnew/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "J:/Seleniumnew/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		/*
		 * e_driver = new EventFiringWebDriver(od); // Now create object of
		 * EventListerHandler to register it with EventFiringWebDriver eventListener =
		 * new WebEventListener(); e_driver.register(eventListener); od = e_driver;
		 */

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(prop.getProperty("URL"));
	}

}
