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
	@FindBy(id = "edit_photo_btn")
	public WebElement editPhotoBtn;
	@FindBy(id = "delete_photo_btn")
	public WebElement deletePhotoBtn;
	@FindBy(id = "mat-expansion-panel-header-0")
	public WebElement headerBar;
	@FindBy(id = "homepage-username-label")
	public WebElement homepageUsernameLabel;
	@FindBy(id = "search_photo")
	public WebElement searchPhotoElement;
	
}
