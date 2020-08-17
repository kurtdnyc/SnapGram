package dev.snapgram.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dev.snapgram.pages.LoginPage;
import dev.snapgram.runners.SnapGramRunner;
import junit.framework.Assert;

public class LoginPageSteps {
	public static LoginPage loginPage = SnapGramRunner.loginPage;
	public static WebDriver driver = SnapGramRunner.driver;
	public static WebDriverWait wait = new WebDriverWait(driver, 4);
	public static Actions actions = new Actions(driver);
	
	@Given("^user is on login page$")
	public void user_is_on_login_page() throws Throwable {
	    driver.get("http://localhost:4200/login");
	}

	@When("^user enters \"([^\"]*)\" into username field$")
	public void user_enters_into_username_field(String arg1) throws Throwable {
		loginPage.username.click();
		loginPage.username.sendKeys(arg1);
	}

	@When("^user enters \"([^\"]*)\" into password field$")
	public void user_enters_into_password_field(String arg1) throws Throwable {
		loginPage.password.click();
		loginPage.password.sendKeys(arg1);
	}

	@When("^user presses the login button$")
	public void user_presses_the_login_button() throws Throwable {
	    loginPage.loginBtn.click();
	}

	@Then("^user should be redirected to their home page$")
	public void user_should_be_redirected_to_their_home_page() throws Throwable {
		wait.until(ExpectedConditions.titleIs("SnapGram"));
	    Assert.assertEquals("SnapGram", driver.getTitle());
	}

	@Then("^user should see an alert appear$")
	public void user_should_see_an_alert_appear() throws Throwable {
		wait.until(ExpectedConditions.alertIsPresent());
	    driver.switchTo().alert().accept();
	}
	
	@When("^user clicks on the register user button$")
	public void user_clicks_on_the_register_user_button() throws Throwable {
	    loginPage.registerUserBtn.click();
	}

	@Then("^the user should be redirected to the reimbursement page$")
	public void the_user_should_be_redirected_to_the_reimbursement_page() throws Throwable {
		wait.until(ExpectedConditions.titleIs("SnapGram - Register User"));
	    Assert.assertEquals("SnapGram - Register User", driver.getTitle());
	}
	
}
