package com.ebay.qa.test;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ebay.qa.base.TestBase;
import com.ebay.qa.pages.CarsAndTrucksPage;
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
	
	@Test(priority=3)
	public void launchCarsAndMotors() {
		HomePage.selectCarsAndTrucks();
		CarsAndTrucksPage carsandtrucksPage = new CarsAndTrucksPage();
		Assert.assertEquals(carsandtrucksPage.vehicles.getText(),"Find a Vehicle");
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
