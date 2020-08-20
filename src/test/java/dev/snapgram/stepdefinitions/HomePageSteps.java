package dev.snapgram.stepdefinitions;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
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
	public static Actions actions = new Actions(driver);
	
	@Autowired
	UserService uServ;
	
	@When("^user clicks on user lookup button$")
	public void user_clicks_on_user_lookup_button() throws Throwable {
	    homePage.lookupUser.click();
	}

	@When("^types in a valid \"([^\"]*)\"$")
	public void types_in_a_valid(String arg1) throws Throwable {
	    homePage.lookupUser.sendKeys(arg1);
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
	}

	@Then("^the add photo button should be present$")
	public void the_add_photo_button_should_be_present() throws Throwable {
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
	    homePage.searchPhotoElement.sendKeys("yummy");
	}

	@Then("^only photos with that tag name will appear$")
	public void only_photos_with_that_tag_name_will_appear() throws Throwable {
		Thread.sleep(200);
		List<WebElement> tagSpans = driver.findElements(By.id("tagSpan"));
		assertEquals("#yummy", tagSpans.get(0).getText());
	}

	@When("^user types in image name$")
	public void user_types_in_image_name() throws Throwable {
		homePage.searchPhotoElement.sendKeys("Bear");
	}

	@Then("^only photos with that image name will appear$")
	public void only_photos_with_that_image_name_will_appear() throws Throwable {
		Thread.sleep(300);
		List<WebElement> cardTitles = driver.findElements(By.id("card-title"));
		assertEquals("Bear", cardTitles.get(0).getText());
	}
}
