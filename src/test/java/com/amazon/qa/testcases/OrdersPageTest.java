package com.amazon.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.LoginPage;
import com.amazon.qa.pages.OrdersPage;
import com.amazon.qa.util.TestUtil;

public class OrdersPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	OrdersPage ordersPage;
	String sheetName="contacts";
	
	public OrdersPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
	initialization();	
	
	ordersPage = new OrdersPage();
	loginPage  = new LoginPage();
	homePage  = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
	homePage.clickOnOrdersLink();
	}

	//Below code is for pulling data from Excel. this code would not work in this project as this is not implemented for amazon. reference code only
	/*@DataProvider
	public Object[][] getAmazonTestData() {
		Object data [][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=2 , dataProvider="getAmazonTestData")
	public void validateCreateNewContact(String title , String firstName , String lastName , String company) {
		homePage.clickOnOrdersLink();
		contactsPage.createNewContact(title,firstName ,lastName , company);
	}*/
		
	@Test(priority=1)
	public void verifyOrdersPageLabel() {
		Assert.assertTrue(ordersPage.verifyOrdersLabel(),"Orders label is missing");
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
