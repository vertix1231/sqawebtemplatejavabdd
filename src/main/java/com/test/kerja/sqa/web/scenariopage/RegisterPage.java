package com.test.kerja.sqa.web.scenariopage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.kerja.sqa.web.driver.DriverSingleton;
import com.test.kerja.sqa.web.utils.ConstantsDriver;


public class RegisterPage {

	private WebDriver driver;
	
	public RegisterPage() {
		
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="body > div > div > div.form-left > div > a")
	private WebElement contact_sales;
	@FindBy(css="#firstName")
	private WebElement txtfirstname;
	@FindBy(css="#lastName")
	private WebElement txtlastname;
	@FindBy(css="#email")
	private WebElement txtemail;
	@FindBy(css="#phoneNumber")
	private WebElement txtphonenumber;
	@FindBy(xpath="/html/body/div/div/form/div[3]/div/div")
	private WebElement scrollcountrynumber;
	@FindBy(css="#address")
	private WebElement txtaddress;
	@FindBy(css="#password")
	private WebElement txtpassword;
	@FindBy(css="#confirm_password")
	private WebElement txtconfirm_password;
	@FindBy(css ="#myform > div.form-row-last > input")
	private WebElement btnRegister;
	@FindBy(css="#swal2-title")
	private WebElement txtregistersucces;
//	/html/body/div[2]/div/div[1]/h2
	@FindBy(css="body > div.swal2-container.swal2-center.swal2-backdrop-show > div > div.swal2-actions > button.swal2-confirm.swal2-styled")
	private WebElement btnsuccesregis;
	@FindBy(xpath="/html/body/div/div/form/div[3]/div/div/div")
	private WebElement listcountry;
	
	public String succestextregister() {
		return txtregistersucces.getText();
	}
	public WebElement succesregister() {
		return txtregistersucces;
	}
	public void directtoContactSale() {
		contact_sales.click();
	}
	public void registerSubmitForm() {
		WebDriverWait wait = new WebDriverWait(driver, 300);
		
		wait.until(ExpectedConditions.elementToBeClickable(txtfirstname));
		txtfirstname.sendKeys(ConstantsDriver.FIRST_NAME);
		wait.until(ExpectedConditions.elementToBeClickable(txtlastname));
		txtlastname.sendKeys(ConstantsDriver.LAST_NAME);
		wait.until(ExpectedConditions.elementToBeClickable(txtemail));
		txtemail.sendKeys(ConstantsDriver.EMAIL_USER);
		lscountry(18);
		wait.until(ExpectedConditions.elementToBeClickable(txtphonenumber));
		txtphonenumber.sendKeys(ConstantsDriver.PHONE_USER);
		wait.until(ExpectedConditions.elementToBeClickable(txtaddress));
		txtaddress.sendKeys(ConstantsDriver.ADDRES_USER);
		wait.until(ExpectedConditions.elementToBeClickable(txtpassword));
		txtpassword.sendKeys(ConstantsDriver.PASSWORD_USER);
		wait.until(ExpectedConditions.elementToBeClickable(txtconfirm_password));
//		txtconfirm_password.sendKeys(ConstantsDriver.PASSWORD_USER);
		txtconfirm_password.sendKeys(ConstantsDriver.PASSWORD_USER);
		wait.until(ExpectedConditions.elementToBeClickable(btnRegister));
		btnRegister.click();
		wait.until(ExpectedConditions.elementToBeClickable(btnsuccesregis));
		btnsuccesregis.click();
	}
	private void lscountry(int selection) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");

		WebDriverWait wait = new WebDriverWait(driver, 300);
		wait.until(ExpectedConditions.elementToBeClickable(listcountry));

		listcountry.click();

		this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		List<Keys> lstSequence = new ArrayList<Keys>();
		for (int i = 0; i < selection; i++) {
			lstSequence.add(Keys.DOWN);
		}
		lstSequence.add(Keys.ENTER);
		CharSequence[] cs = lstSequence.toArray(new CharSequence[lstSequence.size()]);
		Actions keyDown = new Actions(driver);
		keyDown.sendKeys(Keys.chord(cs)).perform();

	}
	
	
}
