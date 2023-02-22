package com.ebay.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ebay.qa.base.TestBase;


public class HomePage extends TestBase {
	
	//Page factory- obj repo
	//WebElement searchField= driver.findElement(By.id("gh-ac"));
	
	@FindBy(id="gh-ac")
	WebElement searchField;
	
	//WebElement searchButton= driver.findElement(By.id("gh-btn"));
	@FindBy(id="gh-btn")
	WebElement searchButton;
	
	//WebElement logo= driver.findElement(By.id("gh-logo"));
	@FindBy(id="gh-logo")
	static WebElement logo;
	
	//initialize pageObjects
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions
	public static String validateTitle() {
		return driver.getTitle();
	}
	
	public static boolean validateLogo() {
		return logo.isDisplayed();
	}
	
	public void enterText() {
		searchField.sendKeys("phones");
		searchButton.click();
	}
	
		
}