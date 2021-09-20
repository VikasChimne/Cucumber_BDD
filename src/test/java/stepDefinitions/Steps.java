package stepDefinitions;

import org.junit.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import pageObjects.LoginPage;

public class Steps {
	 public WebDriver driver;
	public LoginPage lp;
	
	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\eclipse-workspace\\Cucumber_BDD\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		lp=new LoginPage(driver);
	}
    @When("User opens URL {string}")
	public void user_opens_url(String url) {
	   driver.get(url);
	   driver.manage().window().maximize();
	   driver.manage().deleteAllCookies();
	}
	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_Password_as(String email,String password){
    lp.setUserName(email);
    lp.setPassword(password);
	}
	@When("Click on Login")
	public void click_on_login() throws InterruptedException {
	    lp.clickLogin();
	    Thread.sleep(3000);
	}
    @Then("Page Title should be {string}")
	public void page_title_should_be(String Title) throws InterruptedException {
		if (driver.getPageSource().contains("Login was unsuccessful.")) {
			driver.close();
			Assert.assertTrue(false);
		}
		else {
			Assert.assertEquals(Title,driver.getTitle());
		}
		Thread.sleep(3000);
	}
	@When("User click on Log out link")
	public void user_click_on_log_out_link() throws InterruptedException {
	   lp.clickLogout();
	   Thread.sleep(3000);
	}
	@Then("close browser")
	public void close_browser() {
		driver.quit();
	    	}



	
}
