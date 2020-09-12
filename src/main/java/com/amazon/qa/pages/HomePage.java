package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//a[@id='nav-greeting-name']//b[contains(text(),'trusha')]")
	//Cachelookup annotations is for improving script performance. 
	@CacheLookup
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[@id='nav-orders']")
	WebElement orderLink;
	
	@FindBy(xpath="//a[contains(text(),\"Today's Deals\")]")
	WebElement dealsLink;
	
	//Initializing the Page Objects
	public HomePage() {
	PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public OrdersPage clickOnOrdersLink() {
		orderLink.click();
		return new OrdersPage();
	}
	
	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}
	
	

}