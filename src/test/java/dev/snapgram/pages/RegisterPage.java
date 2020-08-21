package dev.snapgram.pages;

import javax.persistence.Id;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	WebDriver driver;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "new_username_input")
	public WebElement newUsername;
	@FindBy(id = "new_password_input")
	public WebElement newPassword;
	@FindBy(id = "new_fname_input")
	public WebElement newFirstName;
	@FindBy(id = "new_lname_input")
	public WebElement newLastName;
	@FindBy(id = "create_user_btn")
	public WebElement submitNewUserBtn;
	@FindBy(id = "sign_in_btn")
	public WebElement signInBtn;
	
}
