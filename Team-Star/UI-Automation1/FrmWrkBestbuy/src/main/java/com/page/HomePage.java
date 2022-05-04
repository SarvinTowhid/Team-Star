package com.page;
import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Base.TestBase;

public class HomePage extends TestBase {
	

	//Page factory object repository
	
	@FindBy(xpath="//nav[@class='hamburger-menu']")
	WebElement menu;
	
	@FindBy(xpath="//a[text()='Best Buy Outlet']")
	WebElement outlet;
	
	@FindBy(className = "panel-content" )
	WebElement text1;
	
//	WebElement menu = driver.findElement(By.xpath("//nav[@class='hamburger-menu']"));
//	WebElement outlet = driver.findElement(By.xpath("//a[text()='Best Buy Outlet']"));	
//	WebElement text1 = driver.findElement(By.className("disclaimer"));
//	
	public HomePage() throws IOException {
		
		PageFactory.initElements(driver,this);
	}
	
//	public void pageTitle() {
//		String title = driver.getTitle();
//		System.out.println("Page Title is: "+ title);
//			
//	}	

	public String pageTitle() {
		String title = driver.getTitle();
		System.out.println("The Page Title is: "+ title);
		return title;
	}
	
	public void clickBestBuyOutlet() {
		menu.click();
		outlet.click();	
		pageTitle();
		String outText = text1.getText();
		System.out.println("Captaring the text: "+outText);	
		
		
	}
	
//	public void clickHamburgerMenu() {
//		menu.click();
//	}
//	public void getOutText() {
//		//menu.click();
//		//outlet.click();	
//		String outText = text1.getText();
//		System.out.println("Captaring the text: "+outText);	
//		
//	}	
}
