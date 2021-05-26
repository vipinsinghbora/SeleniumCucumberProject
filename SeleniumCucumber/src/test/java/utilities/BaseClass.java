package utilities;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class BaseClass {

	public WebDriver driver;
	public LoginPage lp;
	public AddCustomerPage addCust;
	public SearchCustomerPage searchCust;
	
	
	//Generated Random String
	public static String randomString() {
		
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return (generatedString);
	}
	
}
