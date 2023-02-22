package com.ebay.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ebay.qa.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	static Properties prop;//prop global variable
	
	public TestBase() { //create constructor and read properties
		
		try{
			prop= new Properties();//intializing prop variable
			FileInputStream ip= new FileInputStream("C:\\Users\\sajjad\\Desktop\\SeleniumTraining\\EbayAutomationTest\\src\\main\\java\\com\\ebay\\qa\\config\\config.properties");
			prop.load(ip);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	//@SuppressWarnings("deprecation")
	public static void initialization() {
		String browsername = prop.getProperty("browser");
		if(browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\sajjad\\Desktop\\SeleniumDriver\\Chrome_driver\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}
		
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS );
	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));
	
	
}
	
}
