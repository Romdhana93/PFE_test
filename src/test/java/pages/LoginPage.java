package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	public WebDriver driver;

	By username = By.id("username");

	By password = By.id("password");

	By kclogin = By.id("kc-login");

	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}

	public void setUserName(String username) {

		driver.findElement(By.id("username")).click();
	    driver.findElement(By.id("username")).sendKeys(username);
		
	}

	public void SetPassword(String password) {

		driver.findElement(By.id("password")).click();
	    driver.findElement(By.id("password")).sendKeys(password);
	}

	public void clickLogin() {

	    driver.findElement(kclogin).click();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    driver.get("http://10.2.140.176/chrysalide-frontend/#/homepage/edit-0/(projet:projet/search-project)");

	}

}
