package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class LoginPage extends TestBase {

	//PageFactory or OR ( Object Repository)
	
	@FindBy(name="email")
	WebElement useremail;
	
	@FindBy(name="password")
	WebElement pass;
		
	@FindBy(xpath="//input[@type='submit']")
	WebElement continueBtn;
	
	@FindBy(id="createAccountSubmit")
	WebElement createAccountBtn;
	
	@FindBy(xpath="//input[@id='signInSubmit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//i[@class='a-icon a-icon-logo']")
	WebElement amazonLogo;
	
	//Initializing the Page Objects
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateLoginPageTitle() {
		
		return driver.getTitle();
	}
	
	public Boolean validateAmazonImg() {
		
		return amazonLogo.isDisplayed();
	}
	
	public HomePage login(String email, String password) {
		
		useremail.sendKeys(email);
		continueBtn.click();
		pass.sendKeys(password);
		loginBtn.click();
		return new HomePage();
			
	}
	
}