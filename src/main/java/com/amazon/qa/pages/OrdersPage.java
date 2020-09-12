package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class OrdersPage  extends TestBase  {

	@FindBy(xpath="//a[contains(text(),'Open Orders')]")
	WebElement ordersLabel;
	
	public OrdersPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyOrdersLabel() {
		return ordersLabel.isDisplayed();
	}
	
}

