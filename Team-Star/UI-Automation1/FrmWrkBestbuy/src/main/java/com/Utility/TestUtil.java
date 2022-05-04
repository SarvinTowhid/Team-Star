package com.Utility;


import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.Base.TestBase;
import com.google.common.io.Files;


public class TestUtil extends TestBase { //TestBase class of every classes
	
	public static final long implicit_Wait_Time = 15;
	public static final long page_load_Wait_Time = 15;
	
	public TestUtil() throws IOException {
		super();
		
	}
	 public void screenshoot() throws IOException {
		 File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType. FILE);
		 Files.copy(screenShot, new File("C:\\Users\\ktowh\\eclipse-workspace\\FrmWrkBestbuy\\SnapShoot\\Photos"+System.currentTimeMillis()+
				 ".png"));
	 }

}
