package dev.snapgram.stepdefinitions;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dev.snapgram.pages.AddPhotoPage;
import dev.snapgram.pages.HomePage;
import dev.snapgram.pages.LoginPage;
import dev.snapgram.runners.SnapGramRunner;
import junit.framework.Assert;

public class UploadPhotoSteps {
	
	public static LoginPage loginPage = SnapGramRunner.loginPage;
	public static HomePage homePage = SnapGramRunner.homePage;
	public static AddPhotoPage addPhotoPage = SnapGramRunner.addPhotoPage;
	public static WebDriver driver = SnapGramRunner.driver;
	public static WebDriverWait wait = new WebDriverWait(driver, 4);
	public static Actions actions = new Actions(driver);
	
	@When("^user enters valid username into username field$")
	public void user_enters_valid_username_into_username_field() throws Throwable {
		loginPage.username.click();
		loginPage.username.sendKeys("samwiseTheBrave");
	}

	@When("^user enters valid password into password field$")
	public void user_enters_valid_password_into_password_field() throws Throwable {
		loginPage.password.click();
		loginPage.password.sendKeys("mrFrodo");
	}

	@When("^user clicks on upload photo button$")
	public void user_clicks_on_upload_photo_button() throws Throwable {
	    homePage.addPhotoBtn.click();
	}

	@Then("^user should be redirected to upload photo page$")
	public void user_should_be_redirected_to_upload_photo_page() throws Throwable {
	    wait.until(ExpectedConditions.titleIs("SnapGram - Upload Photo"));
	    Assert.assertEquals("SnapGram - Upload Photo", driver.getTitle());
	}
	@When("^\"([^\"]*)\" is selected from computer$")
	public void is_selected_from_computer(String arg1) throws Throwable {
	    addPhotoPage.uploadPhotoBtn.sendKeys(arg1);
	}
	@When("^enters \"([^\"]*)\" of photo into name field$")
	public void enters_of_photo_into_name_field(String arg1) throws Throwable {
	    addPhotoPage.photoNameField.sendKeys(arg1);
	}

	@When("^enters \"([^\"]*)\" of photo into the description field$")
	public void enters_of_photo_into_the_description_field(String arg1) throws Throwable {
	    addPhotoPage.captionField.sendKeys(arg1);
	}

	@When("^clicks on the upload photo button$")
	public void clicks_on_the_upload_photo_button() throws Throwable {
		actions.moveToElement(addPhotoPage.savePhotoBtn).click(addPhotoPage.savePhotoBtn).build().perform();
	}
	
	@When("^enters \"([^\"]*)\" to photo$")
	public void enters_to_photo(String arg1) throws Throwable {
	    addPhotoPage.tagsField.sendKeys(arg1);
	}

	@When("^clicks add tag button$")
	public void clicks_add_tag_button() throws Throwable {
	    addPhotoPage.addTagBtn.click();
	}
	
	@Then("^image with \"([^\"]*)\" should have \"([^\"]*)\"$")
	public void image_with_should_have(String arg1, String arg2) throws Throwable {
		Thread.sleep(300);
	    List<WebElement> cardTitles = driver.findElements(By.id("card-title"));
	    List<WebElement> tagSpans = driver.findElements(By.id("tagSpan"));
	    assertEquals(arg1, cardTitles.get(0).getText());
	    assertEquals("#"+arg2, tagSpans.get(0).getText());
	    
	}
	
}
