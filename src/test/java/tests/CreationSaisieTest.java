package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import pages.ControlerSaisiePage;
import pages.CreationSaisiePage;
import pages.LoginPage;

public class CreationSaisieTest {

	private WebDriver driver;
	private String baseUrl;
	private JavascriptExecutor js;
	
	static ExtentReports extent;
	ExtentSparkReporter spark;

	static ExtentTest test1;
	static ExtentTest test2;

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\msromdhana\\Documents\\workspace-spring-tool-suite-4-4.13.1.RELEASE\\Generali_Test_Project\\drivers/chromedriver.exe");
		// System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		// driver = new FirefoxDriver();
		baseUrl = "https://www.google.com/";
		js = (JavascriptExecutor) driver;

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

		extent = new ExtentReports();
		spark = new ExtentSparkReporter(
				"C:\\Users\\msromdhana\\Front-End_PFE\\automatisation-Test-App\\src\\assets\\Report.html");
		extent.attachReporter(spark);

		test1 = extent.createTest("Creation Saisie Sante");
		test2 = extent.createTest("Creation Saisie Prevoyance");

	}

	@Test(priority = 1)
	public void creationSaisieSante() throws Exception {
		LoginPage loginPage = new LoginPage(driver);
		CreationSaisiePage crs = new CreationSaisiePage(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

		driver.get(
				"http://10.2.140.157/auth/realms/GENERALI/protocol/openid-connect/auth?response_type=code&client_id=public-client&state=YnozY2dFRnctamJybWNZQ25hNVhMQ2hnQUttdG8xUUR6Ry5PR1FTRXo3ZzdC&redirect_uri=http%3A%2F%2F10.1.144.54%2F&scope=group%20openid%20profile%20email%20offline_access&code_challenge=qns5yIxHbxKtpSBNbC3eM61W26dhowwXJccQaUcsxLk&code_challenge_method=S256&nonce=YnozY2dFRnctamJybWNZQ25hNVhMQ2hnQUttdG8xUUR6Ry5PR1FTRXo3ZzdC");

		loginPage.setUserName("b012cag");
		loginPage.SetPassword("generali");
		loginPage.clickLogin();
		driver.get("http://10.2.140.176/chrysalide-frontend/#/homepage/edit-0/(projet:projet/search-project)");
		driver.findElement(By.linkText("Saisies")).click();
		// driver.get("http://10.2.140.176/chrysalide-frontend/#/saisie-broker/(broker:broker/broker-search)");

		driver.findElement(crs.nomSaisie).sendKeys("Test Sauvegarde Saisie use case 2");

//onglet Société de référence et établissements
		crs.ongletSocietDeRefference();

//onglet apporteur
		crs.ongletApporteur();

// Descriptif du projet
		crs.descreptifProjet();

//Controler saisie

		crs.syntheseSaisie();
		
//validation saise
		
		crs.validationSaisie();
		
		driver.findElement(crs.creerProj).click();
		Wait<WebDriver> fluentwait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofMinutes(2))
				.pollingEvery(Duration.ofSeconds(30)).ignoring(org.openqa.selenium.NoSuchElementException.class);

		fluentwait.until(ExpectedConditions.visibilityOfElementLocated((crs.popUpControlerSaisie)));

		 String sucess = driver.findElement(crs.popUpControlerSaisie).getText();
		
		System.out.println(sucess+"helloooooooo cration saisie");
		
	}
	@Test(priority = 2)
	public void creationSaisiePrev() throws Exception {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		LoginPage loginPage = new LoginPage(driver);
		CreationSaisiePage crs = new CreationSaisiePage(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

		driver.get(
				"http://10.2.140.157/auth/realms/GENERALI/protocol/openid-connect/auth?response_type=code&client_id=public-client&state=YnozY2dFRnctamJybWNZQ25hNVhMQ2hnQUttdG8xUUR6Ry5PR1FTRXo3ZzdC&redirect_uri=http%3A%2F%2F10.1.144.54%2F&scope=group%20openid%20profile%20email%20offline_access&code_challenge=qns5yIxHbxKtpSBNbC3eM61W26dhowwXJccQaUcsxLk&code_challenge_method=S256&nonce=YnozY2dFRnctamJybWNZQ25hNVhMQ2hnQUttdG8xUUR6Ry5PR1FTRXo3ZzdC");

		loginPage.setUserName("b012cag");
		loginPage.SetPassword("generali");
		loginPage.clickLogin();
		driver.get("http://10.2.140.176/chrysalide-frontend/#/homepage/edit-0/(projet:projet/search-project)");
		driver.findElement(By.linkText("Saisies")).click();
		// driver.get("http://10.2.140.176/chrysalide-frontend/#/saisie-broker/(broker:broker/broker-search)");

		driver.findElement(crs.nomSaisie).sendKeys("Test Sauvegarde Saisie use case 2");

//onglet Société de référence et établissements
		crs.ongletSocietDeRefference();

//onglet apporteur
		crs.ongletApporteur();

// Descriptif du projet
		crs.descreptifProjet();

//Controler saisie

		crs.syntheseSaisie();
		
//validation saise
		
		crs.validationSaisie();
		
		driver.findElement(crs.creerProj).click();
		Wait<WebDriver> fluentwait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofMinutes(2))
				.pollingEvery(Duration.ofSeconds(30)).ignoring(org.openqa.selenium.NoSuchElementException.class);

		fluentwait.until(ExpectedConditions.visibilityOfElementLocated((crs.popUpControlerSaisie)));

		 String sucess = driver.findElement(crs.popUpControlerSaisie).getText();
		
		System.out.println(sucess+"helloooooooo cration saisie");
		
	}
	
	@AfterMethod
    public void getResult(ITestResult result) {
        if(result.getStatus() == ITestResult.FAILURE) {
            test1.log(Status.FAIL,result.getThrowable());
            test2.log(Status.FAIL,result.getThrowable());

        }
        else if(result.getStatus() == ITestResult.SUCCESS) {
            test1.log(Status.PASS, result.getTestName());
            test2.log(Status.PASS, result.getTestName());

        }
        else {
            test1.log(Status.SKIP, result.getTestName());
            test2.log(Status.SKIP, result.getTestName());

        }
    }

	@AfterSuite
	public void report() {
		extent.flush();

	}
	
}
