package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import utilities.BaseClass;

public class LoginSteps extends BaseClass {
	
	
	@Given("User launch chrome browser")
	public void user_launch_chrome_browser() {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		driver=new ChromeDriver();
		lp=new LoginPage(driver);
	}

	@When("User open url {string}")
	public void user_open_url(String url) {
	    
	    driver.get(url);
	    driver.manage().window().maximize();
	}

	@When("User enter email as {string} and password as {string}")
	public void user_enter_email_as_and_password_as(String email, String password) {
	    lp.setUsername(email);
	    lp.setPassword(password);
	   
	}

	@When("Click on login")
	public void click_on_login() {
	   lp.clickLogin();
	    
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String title) {
	    
		if(driver.getPageSource().contains("Login was unsuccessful")) {
			driver.close();
			Assert.assertTrue(false);
		}
		else {
			Assert.assertEquals(title, driver.getTitle());
		}
	    
	}

	@When("User click on logout link")
	public void user_click_on_logout_link() throws InterruptedException {
	    lp.clickLogout();
	    Thread.sleep(3000);
	   
	}
	
	@And("Close browser")
	public void Close_browser() {
	    driver.close();
	   
	}
	
	// Customer feature 

	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
		addCust=new AddCustomerPage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", addCust.getPageTitle());
	    
	}

	@When("User click on Customer Menu")
	public void user_click_on_customer_menu() {
		addCust.clickOnCustomerMenu();
	    
	}

	@And("click on customer menu Item")
	public void click_on_customer_menu_item() {
		addCust.clickOnCustomerMenuItem();
	    
	}

	@When("click on Add new button")
	public void click_on_add_new_button() {
		addCust.clickOnAddCustomer();
	    
	}

	@Then("User can view add new customer page")
	public void user_can_view_add_new_customer_page() {
		Assert.assertEquals("Add a new customer / nopCommerce administration", addCust.getPageTitle());
	   
	}

	@When("User enter customer info")
	public void user_enter_customer_info() throws InterruptedException {
		String email=randomString()+"@gmail.com";
		addCust.setEmail(email);
		addCust.setPassword("Test123");
		addCust.setFirstName("Rajat");
		addCust.setLastName("Sharma");
		addCust.setGender("Male");
		//addCust.setRoles("Guests");
		Thread.sleep(5000);
		addCust.setMgrVendor("Vendor 2");
		
	}

	@When("click on save button")
	public void click_on_save_button() throws InterruptedException {
		addCust.save();
		Thread.sleep(2000);
	    
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String msg) {
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
				.contains("The new customer has been added successfully."));
	   
	}

}
