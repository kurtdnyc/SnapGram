package dev.snapgram.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dev.snapgram.runners.SnapGramRunner;
import junit.framework.Assert;

public class PhotoViewSteps {

	public static LoginPage loginPage = SnapGramRunner.loginPage;
	public static HomePage homePage = SnapGramRunner.homePage;
	public static AddPhotoPage addPhotoPage = SnapGramRunner.addPhotoPage;
	public static WebDriver driver = SnapGramRunner.driver;
	public static WebDriverWait wait = new WebDriverWait(driver, 4);
	
	@When("^user clicks on first photo$")
	public void user_clicks_on_first_photo() throws Throwable {
	    homePage.firstPhotoCard.click();
	}

	@When("^user types new tag into tag field$")
	public void user_types_new_tag_into_tag_field() throws Throwable {
	    homePage.addTagField.sendKeys("tagFromSelenium");
	}

	@When("^user clicks on the add tag button$")
	public void user_clicks_on_the_add_tag_button() throws Throwable {
	    homePage.addTagButton.click();
	}

	@When("^user clicks on the save photo button$")
	public void user_clicks_on_the_save_photo_button() throws Throwable {
	    homePage.savePhotoButton.click();
	}

	@When("^user clicks on the delete photo$")
	public void user_clicks_on_the_delete_photo() throws Throwable {
	    homePage.deletePhotoButton.click();
	}

	@When("^clicks the yes button$")
	public void clicks_the_yes_button() throws Throwable {
	    homePage.yesButton.click();
	}

	@When("^clicks on the x next to the first tag for that photo$")
	public void clicks_on_the_x_next_to_the_first_tag_for_that_photo() throws Throwable {
	    homePage.firstDeleteTagSpan.click();
	}

	@When("^user enters \"([^\"]*)\" in title field$")
	public void user_enters_in_title_field(String arg1) throws Throwable {
	    homePage.imageNameField.sendKeys(arg1);
	}

	@When("^user enters \"([^\"]*)\" in description field$")
	public void user_enters_in_description_field(String arg1) throws Throwable {
	    homePage.imageDescriptionField.sendKeys(arg1);
	}

	@Then("^first photo will have \"([^\"]*)\" as its title$")
	public void first_photo_will_have_as_its_title(String arg1) throws Throwable {
	    Thread.sleep(200);
	    Assert.assertEquals(arg1, homePage.firstImageTitle.getText());
	}

	@Then("^first photo will have \"([^\"]*)\" as its description$")
	public void first_photo_will_have_as_its_description(String arg1) throws Throwable {
		Thread.sleep(200);
	    Assert.assertEquals(arg1, homePage.firstImageDescription.getText());
	}
	
}
