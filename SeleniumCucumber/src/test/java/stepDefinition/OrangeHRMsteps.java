package stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class OrangeHRMsteps {
	
	WebDriver driver;
	
	@Given("I launch chrome browser")
	public void i_launch_chrome_browser() {
		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
	}

	@When("I open hrm homepage")
	public void i_open_hrm_homepage() {
		driver.get("https://opensource-demo.orangehrmlive.com/");
	    
	}

	@Then("I verify the logo present on homepage")
	public void i_verify_the_logo_present_on_homepage() {
		
		boolean status=driver.findElement(By.xpath("//div[@id='divLogo']/img")).isDisplayed();
		Assert.assertEquals(true, status);
	}

//	@And("Close browser")
//	public void close_browser() {
//		driver.quit();
//	    
//	}
	
	
}
