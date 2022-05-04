package StepDeff;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
      WebDriver driver;
	
	@Given("user is on login page")
	public void user_is_on_login_page() throws Throwable {

		System.setProperty("webdriver.chrome.driver", "C:/Work/chromedriver.exe");
		 driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();  
		Thread.sleep(3000);
	}

	@When("user enter usrename")
	public void user_enter_usrename() {

		 driver.findElement(By.id("email")).sendKeys("netsav@hotmail.com");
		 System.out.println(driver.findElement(By.name("email")).getText());	
	}
	@And("user enter password")
	public void user_enter_password() {
		driver.findElement(By.id("pass")).sendKeys("Oriental68");
		System.out.println(driver.findElement(By.xpath("//button[contains(@name,'login')]")));
	}

	@Then("clicks on login button")
	public void clicks_on_login_button() throws Throwable {
		driver.findElement(By.name("login")).click();
		Thread.sleep(3000);
	}


	@And("I capture page title")
	public void i_capture_page_title() {
		String title = driver.getTitle();
		System.out.println("The title is: "+title);
	    
	}

	@Then("I close the browser")
	public void i_close_the_browser() throws Throwable {
	    Thread.sleep(3000);
		 driver.close();
	}

}
