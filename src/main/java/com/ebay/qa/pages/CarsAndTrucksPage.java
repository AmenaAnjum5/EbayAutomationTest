package com.ebay.qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ebay.qa.base.TestBase;

public class CarsAndTrucksPage extends TestBase {
	private static final String modelDropDownXpath = "//select[@name='Model']";

	@FindBy(xpath = "//select[@name='Make']")
	WebElement allmakesDropdwn;

	@FindBy(xpath = modelDropDownXpath)
	WebElement modelDropdwn;

	@FindBy(xpath = "//input[@name='_stpos']")
	WebElement zipCode;

	@FindBy(xpath = "//select[@name='LH_ItemCondition']")
	WebElement newandusedDropdwn;

	@FindBy(xpath = "//button[@class='btn btn--primary motors-finder__find-btn']")
	WebElement findvehicleButton;

	@FindBy(xpath = "//h2[@class='motors-finder__title']")
	public WebElement vehicles;

	// initialize pageObjects
	public CarsAndTrucksPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public void selectMake(String make) {
		Select allmakesdd = new Select(allmakesDropdwn);
		allmakesdd.selectByVisibleText(make);
	}

	public void selectModel(String model) {
		// wait till model select is enabled
		WebDriverWait wait = new WebDriverWait(TestBase.driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(modelDropDownXpath))).isEnabled();
		// now select model
		Select allmodelsdd = new Select(modelDropdwn);
		allmodelsdd.selectByVisibleText(model);
	}

	public void enterZipcode(String code) {
		zipCode.clear();
		zipCode.sendKeys(code);
	}

	public void selectNewandUsed() {
		Select newanduseddd = new Select(newandusedDropdwn);
		newanduseddd.selectByVisibleText("New & Used");
	}

	public void clickFindVehicle() {
		findvehicleButton.click();
		// wait for search page to load and input to be visible
		WebDriverWait wait = new WebDriverWait(TestBase.driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@name='Model']"))).isEnabled();
	}

}
