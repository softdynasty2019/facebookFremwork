package resources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class landingPage {

	public WebDriver driver;

	By email = By.id("email");
	By pass = By.id("pass");
	By login = By.cssSelector("input#u_0_b");

	public landingPage(WebDriver driver) {

		// We need to create always this contractor to connect with resources

		this.driver = driver;

	}

	public WebElement getemail() {

		return driver.findElement(email);

	}

	public WebElement getepass() {

		return driver.findElement(pass);

	}

	public WebElement Login() {

		return driver.findElement(login);

	}

}
