package com.ebay.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ebay.qa.base.TestBase;

public class CarsAndTrucksPage extends TestBase {
	
	//initialize pageObjects
	public CarsAndTrucksPage() {
		PageFactory.initElements(driver, this);
	}
	
	//WebElement vehicles = driver.findElement(By.xpath("//h2[@class='motors-finder__title']"));
	@FindBy(xpath="//h2[@class='motors-finder__title']")
	public WebElement vehicles;

}
