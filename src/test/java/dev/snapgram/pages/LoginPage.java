package dev.snapgram.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username_input")
	public WebElement username;
	@FindBy(id = "password_input")
	public WebElement password;
	@FindBy(id = "login_btn")
	public WebElement loginBtn;
	@FindBy(id = "register_user_btn")
	public WebElement registerUserBtn;

}
