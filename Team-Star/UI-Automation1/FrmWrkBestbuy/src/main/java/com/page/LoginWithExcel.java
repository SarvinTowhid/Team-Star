package com.page;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;

public class LoginWithExcel {
	public static void main(String[] args) throws IOException {
		
		//Excel--> work books--> sheets--> rows--> cells
		// FileInputStream--> XSSFWorkbook--> XSSFSheet --> XSSFRow-->XSSFCell
		// creating the excel sheet
		
		//FileInputStream file = new FileInputStream("C://E//BootcampLogin.xlsx");
		
		FileInputStream file = new FileInputStream("C:\\Users\\ktowh\\eclipse-workspace\\FrmWrkBestbuy\\excel\\TestCase Writing-BestBuy-Automation-Bootcamp-Zaman.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		
		XSSFSheet sheet = workbook.getSheet("Login Test"); //Providing sheet name which is Data
		
		int rowcount= sheet.getLastRowNum(); //return row count
		int colcount = sheet.getRow(29).getLastCellNum(); // return column or cell count
		
		for(int i=17; i<rowcount;i++)
		{
			XSSFRow currentrow=sheet.getRow(i); //focus on the current row
			
			for(int j=0; j<colcount; j++) {
			String value =currentrow.getCell(j).toString();
			System.out.print("     "+value);
			}
			System.out.println();
		}
		
	}
	
	

}
