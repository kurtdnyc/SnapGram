package dev.snapgram.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dev.snapgram.pages.RegisterPage;
import dev.snapgram.runners.SnapGramRunner;
import junit.framework.Assert;

public class RegisterUserSteps {
	public static RegisterPage registerPage = SnapGramRunner.registerPage;
	public static WebDriver driver = SnapGramRunner.driver;
	public static WebDriverWait wait = new WebDriverWait(driver, 4);
	public static Actions actions = new Actions(driver);
	
	@Given("^user is on register user page$")
	public void user_is_on_register_user_page() throws Throwable {
	    driver.get("http://localhost:4200/register");
	    wait.until(ExpectedConditions.titleIs("SnapGram - Register User"));
	}

	@When("^user enters \"([^\"]*)\" into the new username field$")
	public void user_enters_into_the_new_username_field(String arg1) throws Throwable {
		registerPage.newUsername.click();
		registerPage.newUsername.sendKeys(arg1);
	}

	@When("^user enters new \"([^\"]*)\" into the new password field$")
	public void user_enters_new_into_the_new_password_field(String arg1) throws Throwable {
		registerPage.newPassword.click();
		registerPage.newPassword.sendKeys(arg1);
	}
	@When("^user enters new first name into the new first name field$")
	public void user_enters_new_first_name_into_the_new_first_name_field() throws Throwable {
		registerPage.newFirstName.click();
		registerPage.newFirstName.sendKeys("Mike");
	}

	@When("^user enters new last name into the new last name field$")
	public void user_enters_new_last_name_into_the_new_last_name_field() throws Throwable {
		registerPage.newLastName.click();
		registerPage.newLastName.sendKeys("Richardson");
	}

	@When("^clicks on the submit new user button$")
	public void clicks_on_the_submit_new_user_button() throws Throwable {
	    registerPage.submitNewUserBtn.click();
	}

	@Then("^user should be redirect to login page$")
	public void user_should_be_redirect_to_login_page() throws Throwable {
		wait.until(ExpectedConditions.titleIs("SnapGram - Login"));
	    Assert.assertEquals("SnapGram - Login", driver.getTitle());
	}

	@When("^user enters a username already registered into the new username field$")
	public void user_enters_a_username_already_registered_into_the_new_username_field() throws Throwable {
		registerPage.newUsername.click();
		registerPage.newUsername.sendKeys("ringbearer");
	}

	@When("^user enters new password already registered into the new password field$")
	public void user_enters_new_password_already_registered_into_the_new_password_field() throws Throwable {
		registerPage.newPassword.click();
		registerPage.newPassword.sendKeys("shire123");
	}

	@Then("^user should recieve an alert saying that user already exists$")
	public void user_should_recieve_an_alert_saying_that_user_already_exists() throws Throwable {
		wait.until(ExpectedConditions.alertIsPresent());
	    driver.switchTo().alert().accept();
	}
}
