package com.page;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Base.TestBase;


public class LoginPage extends TestBase {
	

	@FindBy(xpath="//span[text()='Account']")
	WebElement Login_Button ;
	
	@FindBy(xpath="//a[text()='Sign In']")
	WebElement SignIn_Button;
	
	@FindBy(id="fld-e")
	WebElement User_name ;
	
	@FindBy(id="fld-p1")
	WebElement User_Password ;
	
	@FindBy(xpath="//button[text()='Sign In']")
	WebElement Sign_In ;
	
	@FindBy(xpath="//span[@class='v-p-right-xxs line-clamp']")
	WebElement current_user_name ;
	
	//Initialized Page-Factory
	
	public LoginPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	public String pageTitle() {
		String title = driver.getTitle();
		System.out.println("The Page Title is: "+ title);
		return title;
	}
	public HomePage validateLogin(String Username, String Password) throws IOException {
		
		Login_Button.click();
		SignIn_Button.click();
		
		User_name.sendKeys(Username);
		User_Password.sendKeys(Password);
		
		Sign_In.click();
		return new HomePage();
		
	}
	
	public String validateCurrentUserName() {
		
		String cUserName = current_user_name.getText();
		System.out.println("Current user name is:"+ cUserName);
		return cUserName;
	}
	
	
	
}
