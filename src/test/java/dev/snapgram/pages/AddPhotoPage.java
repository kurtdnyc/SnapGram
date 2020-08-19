package dev.snapgram.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddPhotoPage {

	WebDriver driver;

	public AddPhotoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Placeholder element ids below
	
	@FindBy(id = "photo_link_input")
	public WebElement photoLinkField;
	@FindBy(id = "photoName")
	public WebElement photoNameField;
	@FindBy(id = "photoDescription")
	public WebElement captionField;
	@FindBy(id = "tag_input")
	public WebElement tagsField;
	@FindBy(id = "photoUploadImage")
	public WebElement uploadPhotoBtn;
	@FindBy(id = "savePhotoButton")
	public WebElement savePhotoBtn;
}
