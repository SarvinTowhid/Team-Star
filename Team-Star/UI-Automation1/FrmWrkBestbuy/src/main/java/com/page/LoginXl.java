package com.page;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginXl {
	
	public WebDriver d;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFCell cell;
	

	@Test
	public void testfullPage() throws IOException {
		FileInputStream file = new FileInputStream("C://E//BootcampLogin.xlsx");
		
		workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheetAt(0);
		
		for(int i=1; i<= sheet.getLastRowNum(); i++) {
			
			cell = sheet.getRow(i).getCell(0);
			DataFormatter formatter = new DataFormatter();
			
			String username = formatter.formatCellValue(cell);
			cell= sheet.getRow(i).getCell(1);
			
			String password = formatter.formatCellValue(cell);
			
			d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			//d.findElement(By.xpath("//span[text()='Account']")).click();
			
			d.findElement(By.xpath("//span[@class='v-p-right-xxs line-clamp']")).click();
			d.findElement(By.xpath("//a[text()='Sign In']")).click();
			
			d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			 d.findElement(By.id("fld-e")).sendKeys(username);
			 d.findElement(By.id("fld-p1")).sendKeys(password);
			 
			 //d.findElement(By.xpath("//button[text()='Sign In']")).click();
			 d.findElement(By.xpath("//button[@type='submit']")).click();
			 
			String Text = d.findElement(By.xpath("//span[@class='v-p-right-xxs line-clamp']")).getText();
			System.out.println("The name on the account is: "+ Text);

			
		}
		
	}
	@BeforeTest
	public void beforeTest(){
		System.setProperty("webdriver.chrome.driver", "C:/Work/chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver", "C:/Users/ktowh/eclipse-workspace/FrmWrkBestbuy/Drivers/chromedriver.exe");
		d= new ChromeDriver();
		d.get("https://www.bestbuy.com/");
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}
	

	@AfterTest
	public void aftertest() {
		d.close();
	}
	
	
	
	
	
	
	
}
