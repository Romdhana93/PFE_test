package tests;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.SauvegardeSaisiePage;
import pages.SauvegardeSaisie_01_Page;

public class CreateProjetTest {

	private WebDriver driver;
	private String baseUrl;
	private JavascriptExecutor js;


	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		// System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		// driver = new FirefoxDriver();
		baseUrl = "https://www.google.com/";
		js = (JavascriptExecutor) driver;

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

	}

	@Test
	public void CreateProjet() throws Exception {
		LoginPage loginPage = new LoginPage(driver);
		SauvegardeSaisie_01_Page svs = new SauvegardeSaisie_01_Page(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

		driver.get(
				"http://10.2.140.157/auth/realms/GENERALI/protocol/openid-connect/auth?response_type=code&client_id=public-client&state=YnozY2dFRnctamJybWNZQ25hNVhMQ2hnQUttdG8xUUR6Ry5PR1FTRXo3ZzdC&redirect_uri=http%3A%2F%2F10.1.144.54%2F&scope=group%20openid%20profile%20email%20offline_access&code_challenge=qns5yIxHbxKtpSBNbC3eM61W26dhowwXJccQaUcsxLk&code_challenge_method=S256&nonce=YnozY2dFRnctamJybWNZQ25hNVhMQ2hnQUttdG8xUUR6Ry5PR1FTRXo3ZzdC");

		loginPage.setUserName("b012cag");
		loginPage.SetPassword("generali");
		loginPage.clickLogin();
		driver.get("http://10.2.140.176/chrysalide-frontend/#/homepage/edit-0/(projet:projet/search-project)");
		driver.findElement(By.linkText("Saisies")).click();
		// driver.get("http://10.2.140.176/chrysalide-frontend/#/saisie-broker/(broker:broker/broker-search)");

		driver.findElement(svs.nomSaisie).sendKeys("Test Sauvegarde Saisie use case 2");

//onglet Société de référence et établissements
		svs.ongletSocietDeRefference();

//onglet apporteur
		svs.ongletApporteur();
		
// Descriptif du projet
		svs.descreptifProjet();

		driver.findElement(svs.sauvegardeSaisie).click();// Sauvegarder Saisie

		Wait<WebDriver> fluentwait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofMinutes(2))
				.pollingEvery(Duration.ofSeconds(30)).ignoring(org.openqa.selenium.NoSuchElementException.class);

		fluentwait.until(ExpectedConditions.visibilityOfElementLocated((svs.popUpSauvegSucess)));

		String sucess = driver.findElement(svs.popUpSauvegSucess).getText();

		System.out.println("123**********" + sucess);

		assertEquals(sucess, "Votre saisie a été sauvegardée avec succès");


		
	}
	
	@Test
	public void CreateProjetPrev() throws Exception {
		LoginPage loginPage = new LoginPage(driver);
		SauvegardeSaisie_01_Page svs = new SauvegardeSaisie_01_Page(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

		driver.get(
				"http://10.2.140.157/auth/realms/GENERALI/protocol/openid-connect/auth?response_type=code&client_id=public-client&state=YnozY2dFRnctamJybWNZQ25hNVhMQ2hnQUttdG8xUUR6Ry5PR1FTRXo3ZzdC&redirect_uri=http%3A%2F%2F10.1.144.54%2F&scope=group%20openid%20profile%20email%20offline_access&code_challenge=qns5yIxHbxKtpSBNbC3eM61W26dhowwXJccQaUcsxLk&code_challenge_method=S256&nonce=YnozY2dFRnctamJybWNZQ25hNVhMQ2hnQUttdG8xUUR6Ry5PR1FTRXo3ZzdC");

		loginPage.setUserName("b012cag");
		loginPage.SetPassword("generali");
		loginPage.clickLogin();
		driver.get("http://10.2.140.176/chrysalide-frontend/#/homepage/edit-0/(projet:projet/search-project)");
		driver.findElement(By.linkText("Saisies")).click();
		// driver.get("http://10.2.140.176/chrysalide-frontend/#/saisie-broker/(broker:broker/broker-search)");

		driver.findElement(svs.nomSaisie).sendKeys("Test Sauvegarde Saisie use case 2");

//onglet Société de référence et établissements
		svs.ongletSocietDeRefference();

//onglet apporteur
		svs.ongletApporteur();
		
// Descriptif du projet
		svs.descreptifProjet();

		driver.findElement(svs.sauvegardeSaisie).click();// Sauvegarder Saisie

		Wait<WebDriver> fluentwait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofMinutes(2))
				.pollingEvery(Duration.ofSeconds(30)).ignoring(org.openqa.selenium.NoSuchElementException.class);

		fluentwait.until(ExpectedConditions.visibilityOfElementLocated((svs.popUpSauvegSucess)));

		String sucess = driver.findElement(svs.popUpSauvegSucess).getText();

		System.out.println("123**********" + sucess);

		assertEquals(sucess, "Votre saisie a été sauvegardée avec succès");


		
	}
}
