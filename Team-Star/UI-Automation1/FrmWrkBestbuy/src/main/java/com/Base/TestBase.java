package com.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.Utility.TestUtil;

public class TestBase {
	TestUtil util;
	
	public static WebDriver driver;
	public static Properties prop;
	public String propFile = "C:/Users/ktowh/eclipse-workspace/FrmWrkBestbuy/src/main/java/com/Envrmnt_Config/config.properties";
	
	
	//Constractor
	public TestBase() throws IOException {
		prop = new Properties();
		try {
			FileInputStream file = new FileInputStream (propFile);
			prop.load(file);
			
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		}
		
	}
	//--Initialization--
	
	public static void initilization() {
		String browserName = prop.getProperty("Browser");
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:/Users/ktowh/eclipse-workspace/FrmWrkBestbuy/Drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		else {
			driver = new SafariDriver();
		}
		

		driver.manage().window().maximize();
		
		//driver.manage().timeouts().pageLoadTimeout(TestUtil.page_load_Wait_Time, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(TestUtil.implicit_Wait_Time, TimeUnit.SECONDS);
	
		driver.get(prop.getProperty("Url"));
	}

}
