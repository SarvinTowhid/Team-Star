package com.Test;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Base.TestBase;
import com.Utility.TestUtil;
import com.page.HomePage;






public class HomePageTest extends TestBase  {

	HomePage homePage;
	TestUtil testutil;
	
	Logger log = Logger.getLogger(HomePageTest.class);
	
	public HomePageTest() throws IOException {
		super();
	}
	@BeforeMethod
	public void setUp() throws IOException {
	
		initilization();
		
		homePage = new HomePage();
		testutil= new TestUtil();
		
		log.info("launching chrome browser");
		log.info("Entering application URL");
		log.fatal("just fatal error");
		
	}
	@Test(priority=1)
	public void pageTitleTest() throws IOException {
		homePage.pageTitle();
		log.info("loging page title");
		testutil.screenshoot();
		
	}
//	@Test
//	public void clickHamburgerMenu() {
//		homePage.clickHamburgerMenu();
//	}
	@Test(priority=2)
	public void clickBestBuyOutlet() {
		homePage.clickBestBuyOutlet();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	
	
	
}
