package com.Utilities;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.w3c.dom.UserDataHandler;

public class BaseClass {

	static WebDriver driver;

	public static WebDriver driverSetup() {

		System.setProperty("webdriver.chrome.driver", "C:\\vinoth\\Tools\\Drivers\\Chrome\\V87\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		return driver;
	}

	
	public String getScreenshotPath(String Testcase,WebDriver driver) throws IOException {
		
		
		TakesScreenshot screenshot=(TakesScreenshot) driver;
		File source=screenshot.getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")+"\\Reports\\"+Testcase+".png";
		System.out.println(path);
		File destination=new File(path);
		FileHandler.copy(source, destination);
		return path;
	}
	
	
}
