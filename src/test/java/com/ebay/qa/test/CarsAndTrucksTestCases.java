package com.ebay.qa.test;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ebay.qa.base.TestBase;
import com.ebay.qa.pages.CarsAndTrucksPage;
import com.ebay.qa.pages.HomePage;
import com.ebay.qa.pages.HondaAccordPage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CarsAndTrucksTestCases extends TestBase {
	public CarsAndTrucksPage carsandtrucksPage;

	private HomePage homepage;

	public CarsAndTrucksTestCases() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		homepage = new HomePage();
	}

	@Test(priority = 1)
	public void launchCarsAndMotors() {
		homepage.selectCarsAndTrucks();
		carsandtrucksPage = new CarsAndTrucksPage();
		Assert.assertEquals(carsandtrucksPage.vehicles.getText(), "Find a Vehicle");
	}

	@Test(priority = 2)
	public void searchVehicle() {
		homepage.selectCarsAndTrucks();
		carsandtrucksPage = new CarsAndTrucksPage();
		carsandtrucksPage.selectMake("Honda");
		carsandtrucksPage.selectModel("Accord");
		carsandtrucksPage.enterZipcode("43026");
		carsandtrucksPage.selectNewandUsed();
		carsandtrucksPage.clickFindVehicle();
		HondaAccordPage hondaaccordpage = new HondaAccordPage();
		hondaaccordpage.waitForPage();
		Assert.assertEquals(hondaaccordpage.resultText.getAttribute("value"), "Honda Accord");
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
