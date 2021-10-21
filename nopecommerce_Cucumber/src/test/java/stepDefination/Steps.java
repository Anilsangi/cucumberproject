package stepDefination;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;

public class Steps {
	
	public WebDriver driver;
	public LoginPage lp;

	
	@Given("User Launch Chrome Browser")
	public void user_launch_chrome_browser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Public\\chromedriver.exe");
		driver = new ChromeDriver();
		lp=new LoginPage(driver);
	    
	}

	@When("User open Url {string}")
	public void user_open_url(String url) {
		driver.get(url);
	   
	}

	@When("user enter email as {string} and password as {string}")
	public void user_enter_email_as_and_password_as(String email, String password) {
	   lp.setUserName(email);
	   lp.setPassword(password);
	}

	@When("Click on Login")
	public void click_on_login() {
	   lp.clickLogin();
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String title) {
		if(driver.getPageSource().contains("Login was Unsuccessful"))
		{
			driver.close();
			Assert.assertTrue(false);
		}
		else {
			Assert.assertEquals(title, driver.getTitle());
			
		}
	    
	}

	@When("user click on logout")
	public void user_click_on_logout() throws InterruptedException {
	   lp.clickLogout();
	   Thread.sleep(3000);
	}

	@Then("close browser")
	public void close_browser() {
	 driver.quit(); 
	}

	
}
