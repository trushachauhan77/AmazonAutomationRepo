package com.amazon.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.LoginPage;
import com.amazon.qa.pages.OrdersPage;


public class HomePageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	OrdersPage ordersPage;
	
	public HomePageTest() {
		super();
	}
	
	//For each test case , launch new browser each time and quit it.
	
	@BeforeMethod
	public void setUp() {
	initialization();	
	
	loginPage = new LoginPage();
	ordersPage  = new OrdersPage();
	homePage = loginPage.login(prop.getProperty("email") , prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Amazon Sign In");
	}
	
	@Test(priority=2)
	public void verifyOrdersLinkTest() {
		ordersPage = homePage.clickOnOrdersLink();
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
	

}
