package com.test.kerja.sqa.web.scenariopage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.kerja.sqa.web.driver.DriverSingleton;
import com.test.kerja.sqa.web.utils.ConstantsDriver;

public class LoginPage {
	private WebDriver driver;

	public LoginPage() {

		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "/html/body/div/div/form/div[7]/p/a")
	private WebElement registoLogin;
	// login form
	@FindBy(css = "#your_email")
	private WebElement emailusername_login;
	@FindBy(css = "#password")
	private WebElement password_login;
	@FindBy(css = "#myform > div.form-row-last > input")
	private WebElement btnlogin;
	@FindBy(css = "body > div.swal2-container.swal2-center.swal2-backdrop-show > div > div.swal2-actions > button.swal2-confirm.swal2-styled")
	private WebElement btnsucceslogin;
	@FindBy(css = "body > div.centered > a")
	private WebElement btnlogout;
	@FindBy(css = "#myform > div.form-row-last > p:nth-child(2) > a")
	private WebElement forgotpassword;

	public void scrooltologin() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//		js.executeScript("arguments[0].scrollIntoView();", registoLogin);
//		js.executeScript("window.scrollBy(0,1000)");
		registoLogin.click();

	}

	public void inputlogin() {
		emailusername_login.sendKeys(ConstantsDriver.EMAIL_USER);
		password_login.sendKeys(ConstantsDriver.PASSWORD_USER);
		btnlogin.click();
		btnsucceslogin.click();

	}

	public void inputlogout() {
		btnlogout.click();

	}

	public void forgotPassword() {
		forgotpassword.click();
	}

}
