package com.Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Base.TestBase;
import com.page.HomePage;
import com.page.LoginPage;

public class LoginPageTest extends TestBase {
	
	HomePage homePage;
	LoginPage loginpage;
	
	
	public LoginPageTest() throws IOException {
		super();
		
	}
	@BeforeMethod
	public void setUp() throws IOException
	{
		initilization();
		homePage = new HomePage();
		loginpage = new LoginPage();
			
	}
	@Test(priority=1)
	public void PageTitleTest() {
		String title = loginpage.pageTitle();
		//System.out.println("The Title of this page is: "+title);
		Assert.assertEquals(title, "Best Buy | Official Online Store | Shop Now & Save", "Opps!! page didnt found");;
	}
	@Test(priority=2)
	public void loginTest() throws IOException {
		loginpage.validateLogin(prop.getProperty("Username"), prop.getProperty("Password"));
		loginpage.validateCurrentUserName();
		loginpage.pageTitle();
	}
//	@Test
//	public void currentUserNameTest() throws IOException {
//		loginTest();
//		loginpage.validateCurrentUserName();
	//}
	@AfterMethod
	public void tearDown(){
		driver.close();
	}
}
