package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {
	
public WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	By lnkCustomerMenu=By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");
	By lnkCustomerMenuItem=By.xpath("//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]");
	By btnAddNew=By.xpath("//a[@class='btn btn-primary']");
	By txtEmail=By.xpath("//input[@id='Email']");
	By txtPassword=By.xpath("//input[@id='Password']");
	By txtFirstName=By.xpath("//input[@id='FirstName']");
	By txtLastName=By.xpath("//input[@id='LastName']");
	By rdGenderFemale=By.xpath("//input[@id='Gender_Female']");
	By rdGenderMale=By.xpath("//input[@id='Gender_Male']");
	By txtDOB=By.xpath("//input[@id='DateOfBirth']");
	By txtCompanyName=By.xpath("//input[@id='Company']");
	By checkBoxIsTaxExempt=By.xpath("//input[@id='IsTaxExempt']");
	By drpNewsLetter=By.xpath("//select[@id='SelectedNewsletterSubscriptionStoreIds']");
	By drpCustomerRoles=By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']");
	By drpVendorId=By.xpath("//select[@id='VendorId']");
	By checkBocActive=By.xpath("//input[@id='Active']");
	By textAdminComment=By.xpath("//textarea[@id='AdminComment']");
	By btnSave=By.xpath("//button[@name='save']");
	
	public void clickOnCustomerMenu() {
		
		ldriver.findElement(lnkCustomerMenu).click();
	}
	public void clickOnCustomerMenuItem() throws InterruptedException {
		Thread.sleep(2000);
		ldriver.findElement(lnkCustomerMenuItem).click();
	}
	public void clickOnAddCustomer() {
		
		ldriver.findElement(btnAddNew).click();
	}
	public void setEmail(String email) {
		
		ldriver.findElement(txtEmail).sendKeys(email);
	}
	public void setPassword(String password) {
		
		ldriver.findElement(txtPassword).sendKeys(password);
	}
	public void setRoles(String Role) {
		
		ldriver.findElement(By.xpath("//div[@class='input-group-append input-group-required']/div/div/div/input")).sendKeys(Role);
		ldriver.findElement(By.xpath("//li[contains(text(),'"+ Role+ "']")).click();
		//ldriver.findElement(By.xpath("//div[@class='input-group-append input-group-required']/div/div/div/input")).sendKeys(Keys.ENTER);
	}	
	public void setMgrVendor(String value) {
		Select drp=new Select(ldriver.findElement(drpVendorId));
		drp.selectByVisibleText(value);
	}
	
	public void setGender(String gender) {
		if(gender.equals("Male")) {
			ldriver.findElement(rdGenderMale).click();
		}
		else {
			ldriver.findElement(rdGenderFemale).click();
		}
	}
	public void setFirstName(String name) {
		
		ldriver.findElement(txtFirstName).sendKeys(name);
	}
	public void setLastName(String lastName) {
		
		ldriver.findElement(txtLastName).sendKeys(lastName);
	}
	public void save() {
		
		ldriver.findElement(btnSave).click();
	}
	
	public String getPageTitle() {
		
		return ldriver.getTitle();
	}
}
