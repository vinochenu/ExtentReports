package com.Extentreports;

import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Utilities.BaseClass;
import com.Utilities.ExtentReports_Setup;
import com.aventstack.extentreports.ExtentReports;

public class GoogleSearchTest extends BaseClass{

	public WebDriver driver;
	
	
	@Test
	public void openGoogle() {
		
		driver=BaseClass.driverSetup();
		
		driver.get("https://www.google.com/");
		String ActualTitle=driver.getTitle();
		try {
		Assert.assertEquals(ActualTitle, "XXX");
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	@Test
	public void w3Schools() {
		
		driver.get("https://www.w3schools.com/");
		String ActualTitle=driver.getTitle();
		try {
		Assert.assertEquals(ActualTitle, "YYY");
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.close();
	}
	
	
	

	
	

}
