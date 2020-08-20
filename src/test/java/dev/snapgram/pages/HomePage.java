package dev.snapgram.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//placeholder id names
	
	@FindBy(id = "username_field")
	public WebElement usernameField;
	@FindBy(id = "logout_btn")
	public WebElement logoutBtn;
	@FindBy(id = "user-lookup")
	public WebElement lookupUser;
	@FindBy(id = "add-photo-button")
	public WebElement addPhotoBtn;
	@FindBy(id = "mat-expansion-panel-header-0")
	public WebElement headerBar;
	@FindBy(id = "homepage-username-label")
	public WebElement homepageUsernameLabel;
	@FindBy(id = "search_photo")
	public WebElement searchPhotoElement;
	@FindBy(className = "card-image")
	public WebElement firstPhotoCard;
	@FindBy(id = "addTag")
	public WebElement addTagField;
	@FindBy(id = "addTagButton")
	public WebElement addTagButton;
	@FindBy(id = "saveButton")
	public WebElement savePhotoButton;
	@FindBy(id = "tryDeleteButton")
	public WebElement deletePhotoButton;
	@FindBy(id = "yesDelete")
	public WebElement yesButton;
	@FindBy(className = "deleteTagBtn")
	public WebElement firstDeleteTagSpan;
	@FindBy(id = "photoName")
	public WebElement imageNameField;
	@FindBy(id = "photoDescription")
	public WebElement imageDescriptionField;
	@FindBy(id = "card-title")
	public WebElement firstImageTitle;
	@FindBy(id = "tagSpan")
	public WebElement firstTag;
	@FindBy(id = "photo_description")
	public WebElement firstImageDescription;
	
	
}
