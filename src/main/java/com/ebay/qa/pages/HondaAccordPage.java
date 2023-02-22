package com.ebay.qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ebay.qa.base.TestBase;

public class HondaAccordPage extends TestBase {

	private static final String searchBoxPath = "//input[@type='text' and @placeholder='Search for anything' and @id='gh-ac']";

	// initialize pageObjects
	public HondaAccordPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = searchBoxPath)
	public WebElement resultText;

	public void waitForPage() {
		WebDriverWait wait = new WebDriverWait(TestBase.driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(searchBoxPath)));
	}

}
