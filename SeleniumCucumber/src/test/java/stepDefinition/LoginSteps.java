package stepDefinition;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;
import utilities.BaseClass;

public class LoginSteps extends BaseClass {
	
	@Before
	public void setup() throws IOException {
		configProp=new Properties();
		FileInputStream configfile=new FileInputStream("configure.properties");
		configProp.load(configfile);
		
		// Added logger
		logger = Logger.getLogger("SeleniumCucumber");
		PropertyConfigurator.configure("log4j.properties");
		
		String browser=configProp.getProperty("browser");
		
		if(browser.equals("chrome")) {
			//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers//chromedriver.exe");
			System.setProperty("webdriver.chrome.driver",configProp.getProperty("chromepath"));
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",configProp.getProperty("firefoxpath"));
			driver = new FirefoxDriver();
		}
		else {
			System.setProperty("webdriver.ie.driver",configProp.getProperty("iepath"));
			driver = new InternetExplorerDriver();
			
		}
		logger.info("*******  Launching Browser**********");
				
		
	}
	
	
	@Given("User launch chrome browser")
	public void user_launch_chrome_browser() {
		
		
		lp=new LoginPage(driver);
	}

	@When("User open url {string}")
	public void user_open_url(String url) {
		logger.info("*******  Opening URL **********");
	    driver.get(url);
	    driver.manage().window().maximize();
	}

	@When("User enter email as {string} and password as {string}")
	public void user_enter_email_as_and_password_as(String email, String password) {
		logger.info("*******  Providing login details**********");
		lp.setUsername(email);
	    lp.setPassword(password);
	   
	}

	@When("Click on login")
	public void click_on_login() {
		logger.info("*******  Started Login **********");
	   lp.clickLogin();
	    
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String title) {
	    
		if(driver.getPageSource().contains("Login was unsuccessful")) {
			logger.info("*******  Login Failed **********");
			driver.close();
			Assert.assertTrue(false);
		}
		else {
			logger.info("*******  Login Passed **********");
			Assert.assertEquals(title, driver.getTitle());
		}
	    
	}

	@When("User click on logout link")
	public void user_click_on_logout_link() throws InterruptedException {
		logger.info("*******  Click on logout **********");
		lp.clickLogout();
	    Thread.sleep(3000);
	   
	}
	
	@And("Close browser")
	public void Close_browser() {
		logger.info("*******  Closing browser **********");
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
	public void click_on_customer_menu_item() throws InterruptedException {
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
		logger.info("*******  Adding new Customer Info **********");
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
		logger.info("*******  Saving customer data **********");
		addCust.save();
		Thread.sleep(2000);
	    
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String msg) {
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
				.contains("The new customer has been added successfully."));
	   
	}
	
	//Steps for search customer
	
	@Then("User can view customer page")
	public void user_can_view_customer_page() {
		Assert.assertEquals("Customers / nopCommerce administration", addCust.getPageTitle());
	   
	}


	@When("User enter email address")
	public void user_enter_email_address() {
		searchCust=new SearchCustomerPage(driver);
		searchCust.setEmail("admin@yourStore.com");
	    
	    
	}
	@When("Click on Search button")
	public void click_on_search_button() throws InterruptedException {
		searchCust.clickSearch();
		Thread.sleep(3000);
	    
	}
	@Then("Customer record should be visible")
	public void customer_record_should_be_visible() {
		boolean status=searchCust.searchCustomerByEmail("admin@yourStore.com");
		Assert.assertEquals(status, true);
	    
	}

}
