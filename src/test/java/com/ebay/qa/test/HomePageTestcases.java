package com.ebay.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ebay.qa.base.TestBase;
import com.ebay.qa.pages.HomePage;

public class HomePageTestcases extends TestBase {

	HomePage homepage;
	
	public HomePageTestcases() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		homepage= new HomePage();
	}
	
	@Test(priority=1)
	public void homepageTitleTest() {
		String title= HomePage.validateTitle();
		Assert.assertEquals(title, "Electronics, Cars, Fashion, Collectibles & More | eBay");
	}
	
	@Test(priority=2)
	public void homepageLogoTest() {
		boolean flag= HomePage.validateLogo();
		Assert.assertTrue(flag);
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
