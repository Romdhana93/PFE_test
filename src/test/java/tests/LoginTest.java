package tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
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

public class LoginTest  {

	private WebDriver driver = null;
	private String baseUrl = null;
	
	 ExtentReports extent;
	 ExtentTest test1;
	 
	
	 
	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		
		
				
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		driver = new ChromeDriver();
		//driver = new FirefoxDriver();
		baseUrl = "https://www.google.com/";
		
	}
	
	
	
	
/*
	@Test
	public void loginTestCase() throws Exception {

		LoginPage loginPage = new LoginPage(driver);

		driver.get(
				"http://10.2.140.157/auth/realms/GENERALI/protocol/openid-connect/auth?response_type=code&client_id=public-client&state=YnozY2dFRnctamJybWNZQ25hNVhMQ2hnQUttdG8xUUR6Ry5PR1FTRXo3ZzdC&redirect_uri=http%3A%2F%2F10.1.144.54%2F&scope=group%20openid%20profile%20email%20offline_access&code_challenge=qns5yIxHbxKtpSBNbC3eM61W26dhowwXJccQaUcsxLk&code_challenge_method=S256&nonce=YnozY2dFRnctamJybWNZQ25hNVhMQ2hnQUttdG8xUUR6Ry5PR1FTRXo3ZzdC");

		loginPage.setUserName("b012cag");
		loginPage.SetPassword("generali");
		loginPage.clickLogin();

	}
*/
	
	@DataProvider(name = "testDataLogin")
	public Object[][] getData() throws Exception {

		String excelPath = "C:\\Users\\msromdhana\\Documents\\workspace-spring-tool-suite-4-4.13.1.RELEASE\\Generali_Test_Project\\testData\\Login_Test_Data.xlsx";

		Object data[][] = ExcelUtils.testData(excelPath, "Sheet1");
		return data;

	}

	@Test(dataProvider = "testDataLogin")
	public void loginTestCase_excel(String username, String password) throws Exception {
		
//		ExtentReports extent = new ExtentReports();
//		ExtentSparkReporter report = new ExtentSparkReporter("./Reports/report.html");
//		extent.attachReporter(report);

		LoginPage loginPage = new LoginPage(driver);

		driver.get(
				"http://10.2.140.157/auth/realms/GENERALI/protocol/openid-connect/auth?response_type=code&client_id=public-client&state=M1NYY2ZQU0hiLVIzZC1hQ3o4a3k4d3Rzby5ad3pEQmRLU09JeUIwbVBxMFNI&redirect_uri=http%3A%2F%2F10.2.140.176%2F&scope=group%20openid%20profile%20email%20offline_access&code_challenge=FFyFhKhFFpTqOA2VHMtoUGJmRQL7M8t1-vhV9sxTtNc&code_challenge_method=S256&nonce=M1NYY2ZQU0hiLVIzZC1hQ3o4a3k4d3Rzby5ad3pEQmRLU09JeUIwbVBxMFNI");

		loginPage.setUserName(username);
		loginPage.SetPassword(password);
		loginPage.clickLogin();
		
//		extent.createTest("Login Test")
//		  .log(Status.PASS, "This is a logging event for MyFirstTest, and it passed!");
//		extent.flush();

	}
	
	
	

}
