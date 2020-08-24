package dev.snapgram.stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dev.snapgram.pages.HomePage;
import dev.snapgram.pages.LoginPage;
import dev.snapgram.runners.SnapGramRunner;
import junit.framework.Assert;

public class LoginPageSteps {
	public static LoginPage loginPage = SnapGramRunner.loginPage;
	public static HomePage homePage = SnapGramRunner.homePage;
	public static WebDriver driver = SnapGramRunner.driver;
	public static WebDriverWait wait = new WebDriverWait(driver, 4);
	public static Actions actions = new Actions(driver);
	public static int numberOfTags;
	public static int numberOfPhotos;
	
	@Given("^user is on login page$")
	public void user_is_on_login_page() throws Throwable {
	    driver.get("http://localhost:4200/login");
	}
	@When("^user clicks on sign up button$")
	public void user_clicks_on_sign_up_button() throws Throwable {
	    loginPage.registerUserBtn.click();
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
	    numberOfTags = driver.findElements(By.id("tagSpan")).size();
		numberOfPhotos = driver.findElements(By.className("card-tile")).size();
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

	@When("^user clicks on the header bar$")
	public void user_clicks_on_the_header_bar() throws Throwable {
	    homePage.headerBar.click();
	}

	@When("^user clicks the sign out button$")
	public void user_clicks_the_sign_out_button() throws Throwable {
	    homePage.logoutBtn.click();
	}

	@Then("^the user should be redirected back to the login page$")
	public void the_user_should_be_redirected_back_to_the_login_page() throws Throwable {
		wait.until(ExpectedConditions.titleIs("SnapGram - Login"));
	    Assert.assertEquals("SnapGram - Login", driver.getTitle());
	}
	@Then("^there will be one less photo$")
	public void there_will_be_one_less_photo() throws Throwable {
	    Thread.sleep(200);
	    Assert.assertNotSame(numberOfPhotos, driver.findElements(By.className("card-tile")).size());
	}
	@Then("^there should be one more tag$")
	public void the_newest_photo_should_have_a_tag() throws Throwable {
		Thread.sleep(400);
		Assert.assertNotSame(numberOfTags, driver.findElements(By.id("tagSpan")).size());
	}

	
}
