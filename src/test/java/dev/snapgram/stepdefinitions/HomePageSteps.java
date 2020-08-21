package dev.snapgram.stepdefinitions;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import com.google.common.hash.Hashing;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.junit.Assertions;
import dev.snapgram.entities.Photo;
import dev.snapgram.entities.User;
import dev.snapgram.pages.AddPhotoPage;
import dev.snapgram.pages.HomePage;
import dev.snapgram.pages.LoginPage;
import dev.snapgram.runners.SnapGramRunner;
import dev.snapgram.services.PhotoService;
import dev.snapgram.services.UserService;
import junit.framework.Assert;

@SpringBootTest(classes = dev.snapgram.app.SnapGramSpringApplication.class)
public class HomePageSteps {

	public static LoginPage loginPage = SnapGramRunner.loginPage;
	public static HomePage homePage = SnapGramRunner.homePage;
	public static AddPhotoPage addPhotoPage = SnapGramRunner.addPhotoPage;
	public static WebDriver driver = SnapGramRunner.driver;
	public static WebDriverWait wait = new WebDriverWait(driver, 4);
	
	@Autowired
	UserService uServ;
	
	@When("^user clicks on user lookup button$")
	public void user_clicks_on_user_lookup_button() throws Throwable {
//	    homePage.lookupUser.click();
		Thread.sleep(200);
		JavascriptExecutor jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("arguments[0].scrollIntoView()", homePage.lookupUser); 
		Actions actions = new Actions(driver);
		actions.moveToElement(homePage.lookupUser).click().build().perform();
	}

	@When("^types in a valid \"([^\"]*)\"$")
	public void types_in_a_valid(String arg1) throws Throwable {
	    homePage.lookupUser.sendKeys(arg1);
	    homePage.lookupUser.sendKeys(Keys.ENTER);
	}
//	@Then("^\"([^\"]*)\" photos should appear$")
//	public void photos_should_appear(String arg1) throws Throwable {
//		Thread.sleep(500);
//	    List<WebElement> cardTitles = driver.findElements(By.id("card-title"));
//	    Thread.sleep(500);
//	    User user = this.uServ.getUserByUsername(arg1);
//	    Thread.sleep(500);
//	    System.out.println(user);
//	    Set<Photo> photos = user.getPhotos();
//	    boolean photoInView = false;
//	    for(WebElement cardTitle : cardTitles) {
//	    	photoInView = false;
//	    	for(Photo photo : photos) {
//	    		if(photo.getPhotoName() == cardTitle.getText()) {
//	    			photoInView =true;
//	    		}
//	    	}
//	    	if(!photoInView) {
//	    		break;
//	    	}
//	    }
//	    Assert.assertEquals(true, photoInView);
//	}
	

	@Then("^the add photo button should not be present$")
	public void the_add_photo_button_should_not_be_present() throws Throwable {
		try {
			System.out.println(homePage.addPhotoBtn);
		}catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
	}

	@When("^clears the input$")
	public void clears_the_input() throws Throwable {
	    homePage.lookupUser.sendKeys("");
	    homePage.lookupUser.sendKeys(Keys.ENTER);
	}

	@Then("^the add photo button should be present$")
	public void the_add_photo_button_should_be_present() throws Throwable {
		Thread.sleep(300);
		try {
			assertEquals(1, homePage.addPhotoBtn.getSize());
		}catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@When("^user clicks on the search photo button$")
	public void user_clicks_on_the_search_photo_button() throws Throwable {
	    homePage.searchPhotoElement.click();
	}

	@When("^types in tag name$")
	public void types_in_tag_name() throws Throwable {
		homePage.searchPhotoElement.clear();
	    homePage.searchPhotoElement.sendKeys("animals");
	}

	@Then("^only photos with that tag name will appear$")
	public void only_photos_with_that_tag_name_will_appear() throws Throwable {
		Thread.sleep(200);
		assertEquals("#animals", homePage.firstTag.getText());
	}

	@When("^user types in image name$")
	public void user_types_in_image_name() throws Throwable {
		homePage.searchPhotoElement.sendKeys("Updated Title");
	}

	@Then("^only photos with that image name will appear$")
	public void only_photos_with_that_image_name_will_appear() throws Throwable {
		Thread.sleep(300);
		assertEquals("Updated Title", homePage.firstImageTitle.getText());
	}
	@When("^user clicks on first photo$")
	public void user_clicks_on_first_photo() throws Throwable {
	    homePage.firstPhotoCard.click();
	    Thread.sleep(600);
	}

	@When("^user types new tag into tag field$")
	public void user_types_new_tag_into_tag_field() throws Throwable {
	    homePage.addTagField.sendKeys("editedTag");
	}

	@When("^user clicks on the add tag button$")
	public void user_clicks_on_the_add_tag_button() throws Throwable {
		wait.until(ExpectedConditions.elementToBeClickable(homePage.addTagButton));
		homePage.addTagButton.click();
	}

	@When("^user clicks on the save photo button$")
	public void user_clicks_on_the_save_photo_button() throws Throwable {
		Thread.sleep(200);
		JavascriptExecutor jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("arguments[0].scrollIntoView()", homePage.savePhotoButton); 
		Actions actions = new Actions(driver);
		actions.click(homePage.savePhotoButton).build().perform();
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
		wait.until(ExpectedConditions.elementToBeClickable(homePage.firstDeleteTagSpan));
	    homePage.firstDeleteTagSpan.click();
	}

	@When("^user enters \"([^\"]*)\" in title field$")
	public void user_enters_in_title_field(String arg1) throws Throwable {
		homePage.imageNameField.clear();
	    homePage.imageNameField.sendKeys(arg1);
	}

	@When("^user enters \"([^\"]*)\" in description field$")
	public void user_enters_in_description_field(String arg1) throws Throwable {
		homePage.imageDescriptionField.clear();
	    homePage.imageDescriptionField.sendKeys(arg1);
	}

	@Then("^first photo will have \"([^\"]*)\" as its title$")
	public void first_photo_will_have_as_its_title(String arg1) throws Throwable {
	    wait.until(ExpectedConditions.textToBePresentInElement(homePage.firstImageTitle,arg1));
		Assert.assertEquals(arg1, homePage.firstImageTitle.getText());
	}

	@Then("^first photo will have \"([^\"]*)\" as its description$")
	public void first_photo_will_have_as_its_description(String arg1) throws Throwable {
		wait.until(ExpectedConditions.textToBePresentInElement(homePage.firstImageDescription,arg1));
		 Assert.assertEquals(arg1, homePage.firstImageDescription.getText());
	}
}
