package com.test.kerja.sqa.web.scenariopage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.test.kerja.sqa.web.driver.DriverSingleton;

public class DatabaseCheckManagePage {
	private WebDriver driver;

	public DatabaseCheckManagePage() {

		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
}
