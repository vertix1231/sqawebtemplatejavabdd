package com.test.kerja.sqa.web.glue;


import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.test.kerja.sqa.web.config.AutomationFrameworkConfiguration;
import com.test.kerja.sqa.web.driver.DriverSingleton;
import com.test.kerja.sqa.web.scenariopage.LoginPage;
import com.test.kerja.sqa.web.scenariopage.RegisterPage;
import com.test.kerja.sqa.web.utils.ConfigurationProperties;
import com.test.kerja.sqa.web.utils.ConstantsDriver;
import com.test.kerja.sqa.web.utils.Log;
import com.test.kerja.sqa.web.utils.TestCase;
import com.test.kerja.sqa.web.utils.Utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = AutomationFrameworkConfiguration.class)
public class StepDefinition {
	private static WebDriver driver;
	private static RegisterPage registerPage;
	private static LoginPage loginPage;
	private ExtentTest extentTest;
	static ExtentReports extentReports = new ExtentReports();
	static ExtentSparkReporter htmlreporter = new ExtentSparkReporter(
			"src/main/resources/reporttest_testkerja.html");

	private final String url = "jdbc:h2:mem:testdb";
	private final String user = "sa";
	private final String password = "";
	public static String fname = null;

//start WEB JCODING---------------------------------------------------------------------------------------------------------------------

//MULAI TESTSTING ADMIN WEB JCODING-------------------------------------------------------------------------------------------------------------------
	@Autowired
	ConfigurationProperties configurationProperties;

	@Before
	public void initializeObject() {
		DriverSingleton.getInstance(configurationProperties.getBrowser());

		registerPage = new RegisterPage();
		loginPage = new LoginPage();

		extentReports.attachReporter(htmlreporter);
		TestCase[] tests = TestCase.values();
		extentTest = extentReports.createTest(tests[Utils.testcount].getTestNama());
		Log.getLogData(Log.class.getName()); // log4j
		Log.startTest(tests[Utils.testcount].getTestNama()); // log4j
		Utils.testcount++;
	}

//1---------------------------------------------------------------------------------------------------------------------	
	@Given("^click contact sale")
	public void registerOne() {
//		registerPage.directtoContactSale();
		if (Status.PASS != null) {
			System.out.println(
					"scenario click contact sale fail");
			extentTest.log(Status.FAIL,
					"click contact sale");
			Log.info(
					"scenario click contact sale fail "); // log4j
//			try {
//				extentTest.fail("User masukkan email dan tekan subscribe",
//						MediaEntityBuilder.createScreenCaptureFromPath(captureScreen()).build());
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}

		} 

	}
	@And("^User going direct for the first website page to register account in the form for submitting the new account")
	public void registerTwo() {
		driver = DriverSingleton.getDriver();
		driver.get(ConstantsDriver.URL_BRICK);
		Log.info("INFO: Navigating to " + ConstantsDriver.URL_BRICK); // log4j
		extentTest.log(Status.PASS, "Navigation to : " + ConstantsDriver.URL_BRICK);
		if (Status.PASS != null) {
			System.out.println(
					"scenario User going direct for the first website page to register account in the form for submitting the new account passed");
			extentTest.log(Status.PASS,
					"User going direct for the first website page to register account in the form for submitting the new account");
			Log.info(
					"scenario User going direct for the first website page to register account in the form for submitting the new account passed "); // log4j

		} else {
			System.out.println(
					"scenario User going direct for the first website page to register account in the form for submitting the new account fail");
			extentTest.log(Status.FAIL,
					"User going direct for the first website page to register account in the form for submitting the new account");
			Log.info(
					"scenario User going direct for the first website page to register account in the form for submitting the new account fail ");
			try {
				extentTest.fail("User masukkan email dan tekan subscribe",
						MediaEntityBuilder.createScreenCaptureFromPath(captureScreen()).build());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	@And("^Register account in the form for submitting the new account")
	public void registerThree() {
		registerPage.registerSubmitForm();
		assertEquals(ConstantsDriver.SUCCES_REGIS, registerPage.succestextregister());
		if (registerPage.succesregister().isDisplayed()) {
			System.out.println("scenario Register account in the form for submitting the new account passed");
			extentTest.log(Status.PASS, "Register account in the form for submitting the new account");
			Log.info("scenario Register account in the form for submitting the new account passed ");

		} else {
			System.out.println("scenario Register account in the form for submitting the new account fail");
			extentTest.log(Status.FAIL, "Register account in the form for submitting the new account");
			Log.info("scenario Register account in the form for submitting the new account fail ");
			try {
				extentTest.fail("Register account in the form for submitting the new account",
						MediaEntityBuilder.createScreenCaptureFromPath(captureScreen()).build());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	@When("^Click login link to the login page")
	public void loginOne() {
		loginPage.scrooltologin();
		if (Status.PASS != null) {
			System.out.println("scenario Click login link to the login page passed");
			extentTest.log(Status.PASS, "Click login link to the login page");
			Log.info("scenario Click login link to the login page passed ");

		} else {
			System.out.println("scenario Click login link to the login page fail");
			extentTest.log(Status.FAIL, "Click login link to the login page");
			Log.info("scenario Click login link to the login page fail ");
			try {
				extentTest.fail("Click login link to the login page",
						MediaEntityBuilder.createScreenCaptureFromPath(captureScreen()).build());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	@And("^Input login data")
	public void loginTwo() {
		loginPage.inputlogin();
		if (Status.PASS != null) {
			System.out.println("scenario Input login data passed");
			extentTest.log(Status.PASS, "Input login data");
			Log.info("scenario Input login data passed ");

		} else {
			System.out.println("scenario Input login data fail");
			extentTest.log(Status.FAIL, "RInput login data");
			Log.info("scenario Input login data fail ");
			try {
				extentTest.fail("Input login data",
						MediaEntityBuilder.createScreenCaptureFromPath(captureScreen()).build());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	@Then("^Succes enter the account and logout again")
	public void loginThree() {
//		
		loginPage.inputlogout();
		if (Status.PASS != null) {
			System.out.println("scenario Succes enter the account and logout again passed");
			extentTest.log(Status.PASS, "Succes enter the account and logout again");
			Log.info("scenario Succes enter the account and logout again passed ");

		} else {
			System.out.println("scenario Succes enter the account and logout again fail");
			extentTest.log(Status.FAIL, "Succes enter the account and logout again");
			Log.info("scenario Succes enter the account and logout again fail ");

			try {
				extentTest.fail("Succes enter the account and logout again",
						MediaEntityBuilder.createScreenCaptureFromPath(captureScreen()).build());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
	@And("^click forgot password")
	public void loginFour() {
		
		loginPage.forgotPassword();
		if (Status.PASS != null) {
			System.out.println(
					"scenario click forgot password fail");
			extentTest.log(Status.FAIL,
					"click forgot password");
			Log.info(
					"scenario click forgot password fail "); // log4j
			try {
				extentTest.fail("click forgot password",
						MediaEntityBuilder.createScreenCaptureFromPath(captureScreen()).build());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} 
	}

	@When("^Checking database for the right input register/login form")
	public void databaseOne() {
//		StepDefinition app = new StepDefinition();
//		app.connect();
////		given().when().get("https://reqres.in/api/users/2").then().body("data.first_name", equalToIgnoringCase(fname));
//		System.out.println("Execution Successful");
		if (Status.PASS != null) {
			System.out.println("scenario Checking database for the right input register/login formn passed");
			extentTest.log(Status.PASS, "Checking database for the right input register/login form");
			Log.info("scenario Checking database for the right input register/login formn passed ");

		} else {
			System.out.println("scenario Checking database for the right input register/login form fail");
			extentTest.log(Status.FAIL, "Checking database for the right input register/login form");
			Log.info("scenario Checking database for the right input register/login formn fail ");
			try {
				extentTest.fail("Checking database for the right input register/login form",
						MediaEntityBuilder.createScreenCaptureFromPath(captureScreen()).build());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	@After
	public void closeObject() {
		extentReports.flush();
	}

//CAPTURE PHOTO TESTING

	public static String captureScreen() throws IOException {
		TakesScreenshot screen = (TakesScreenshot) driver;
		File src = screen.getScreenshotAs(OutputType.FILE);
		String dest = "D:\\ChromeDriver\\bricttestkerja\\" + getcurrentdateandtime() + ".png";
		File target = new File(dest);
		FileUtils.copyFile(src, target);
		return dest;
	}

	public static String getcurrentdateandtime() {
		String str = null;
		try {
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss:SSS");
			Date date = new Date();
			str = dateFormat.format(date);
			str = str.replace(" ", "-").replaceAll("/", "").replaceAll(":", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}

	// Method to initalize connection to the database and execute query

	public void connect() {

		try {
			Connection conn = DriverManager.getConnection(url, user, password);
			{
				if (conn != null) {

					PreparedStatement pst = conn
							.prepareStatement("select first_name from actor where last_name = 'Lollobrigida'");
					ResultSet rs = pst.executeQuery();
					{
						while (rs.next()) {

							fname = rs.getString("first_name");
							System.out.println("The value from the table is : " + fname);
						}
					}

				} else
					System.out.println("Failed to connect");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
