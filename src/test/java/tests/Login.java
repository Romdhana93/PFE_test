package tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import pages.LoginPage;
import utils.ExcelUtils;

public class Login {

	private WebDriver driver = null;
	private String baseUrl = null;

	static ExtentReports extent;
	ExtentSparkReporter spark;

	static ExtentTest test;
	static ExtentTest test1;
	static ExtentTest test2;
	static ExtentTest test3;

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		// System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		// driver = new FirefoxDriver();
		baseUrl = "https://www.google.com/";

		extent = new ExtentReports();
		spark = new ExtentSparkReporter(
				"C:\\Users\\msromdhana\\Front-End_PFE\\automatisation-Test-App\\src\\assets\\Report.html");
		extent.attachReporter(spark);

		test1 = extent.createTest("Login with wrong username");
		test2 = extent.createTest("Login with wrong password");
		test3 = extent.createTest("Login with wrong usernam and password");
		test = extent.createTest("Login  with valid username and password");

	}

	@Test
	public void loginTestCase1() throws Exception {
		driver = new ChromeDriver();

		LoginPage loginPage = new LoginPage(driver);

		driver.get(
				"http://10.2.140.157/auth/realms/GENERALI/protocol/openid-connect/auth?response_type=code&client_id=public-client&state=YnozY2dFRnctamJybWNZQ25hNVhMQ2hnQUttdG8xUUR6Ry5PR1FTRXo3ZzdC&redirect_uri=http%3A%2F%2F10.1.144.54%2F&scope=group%20openid%20profile%20email%20offline_access&code_challenge=qns5yIxHbxKtpSBNbC3eM61W26dhowwXJccQaUcsxLk&code_challenge_method=S256&nonce=YnozY2dFRnctamJybWNZQ25hNVhMQ2hnQUttdG8xUUR6Ry5PR1FTRXo3ZzdC");

		loginPage.setUserName("xxxxx");
		loginPage.SetPassword("vvvvvv");
		loginPage.clickLogin();
		driver.close();


	}

	@Test
	public void loginTestCase2() throws Exception {
		driver = new ChromeDriver();

		LoginPage loginPage = new LoginPage(driver);

		driver.get(
				"http://10.2.140.157/auth/realms/GENERALI/protocol/openid-connect/auth?response_type=code&client_id=public-client&state=YnozY2dFRnctamJybWNZQ25hNVhMQ2hnQUttdG8xUUR6Ry5PR1FTRXo3ZzdC&redirect_uri=http%3A%2F%2F10.1.144.54%2F&scope=group%20openid%20profile%20email%20offline_access&code_challenge=qns5yIxHbxKtpSBNbC3eM61W26dhowwXJccQaUcsxLk&code_challenge_method=S256&nonce=YnozY2dFRnctamJybWNZQ25hNVhMQ2hnQUttdG8xUUR6Ry5PR1FTRXo3ZzdC");

		loginPage.setUserName("aaaaa");
		loginPage.SetPassword("465456");
		loginPage.clickLogin();
		driver.close();


	}

	@Test
	public void loginTestCase3() throws Exception {
		driver = new ChromeDriver();

		LoginPage loginPage = new LoginPage(driver);

		driver.get(
				"http://10.2.140.157/auth/realms/GENERALI/protocol/openid-connect/auth?response_type=code&client_id=public-client&state=YnozY2dFRnctamJybWNZQ25hNVhMQ2hnQUttdG8xUUR6Ry5PR1FTRXo3ZzdC&redirect_uri=http%3A%2F%2F10.1.144.54%2F&scope=group%20openid%20profile%20email%20offline_access&code_challenge=qns5yIxHbxKtpSBNbC3eM61W26dhowwXJccQaUcsxLk&code_challenge_method=S256&nonce=YnozY2dFRnctamJybWNZQ25hNVhMQ2hnQUttdG8xUUR6Ry5PR1FTRXo3ZzdC");

		loginPage.setUserName("dqsdfd");
		loginPage.SetPassword("sdqsdq");
		loginPage.clickLogin();
		driver.close();


	}

	@Test
	public void loginTestCase() throws Exception {
		driver = new ChromeDriver();

		LoginPage loginPage = new LoginPage(driver);

		driver.get(
				"http://10.2.140.157/auth/realms/GENERALI/protocol/openid-connect/auth?response_type=code&client_id=public-client&state=YnozY2dFRnctamJybWNZQ25hNVhMQ2hnQUttdG8xUUR6Ry5PR1FTRXo3ZzdC&redirect_uri=http%3A%2F%2F10.1.144.54%2F&scope=group%20openid%20profile%20email%20offline_access&code_challenge=qns5yIxHbxKtpSBNbC3eM61W26dhowwXJccQaUcsxLk&code_challenge_method=S256&nonce=YnozY2dFRnctamJybWNZQ25hNVhMQ2hnQUttdG8xUUR6Ry5PR1FTRXo3ZzdC");

		loginPage.setUserName("b012cag");
		loginPage.SetPassword("generali");
		loginPage.clickLogin();
		driver.close();

	}

	@AfterMethod
    public void getResult(ITestResult result) {
        if(result.getStatus() == ITestResult.FAILURE) {
            test1.log(Status.FAIL,result.getThrowable());
            test2.log(Status.FAIL,result.getThrowable());
            test3.log(Status.FAIL,result.getThrowable());
            test.log(Status.FAIL,result.getThrowable());

        }
        else if(result.getStatus() == ITestResult.SUCCESS) {
            test1.log(Status.PASS, result.getTestName());
            test2.log(Status.PASS, result.getTestName());
            test3.log(Status.PASS, result.getTestName());
            test.log(Status.PASS, result.getTestName());

        }
        else {
            test1.log(Status.SKIP, result.getTestName());
            test2.log(Status.SKIP, result.getTestName());
            test3.log(Status.PASS, result.getTestName());
            test.log(Status.PASS, result.getTestName());

        }
    }
	@AfterClass(alwaysRun = true)
	public void endReport() {
		extent.flush();

	}

}
