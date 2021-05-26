package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class SearchCustomerPage {

public WebDriver ldriver;

WaitHelper waitHelper;

	public SearchCustomerPage(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		waitHelper=new WaitHelper(ldriver);
	}
	
	@FindBy(how=How.ID,using ="SearchEmail")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(how=How.ID,using ="SearchFirstName")
	@CacheLookup
	WebElement txtfirstName;
	
	@FindBy(how=How.ID,using ="SearchLastName")
	@CacheLookup
	WebElement txtLastName;
	
	@FindBy(how=How.ID,using ="search-customers")
	@CacheLookup
	WebElement btnSearch;
	
	@FindBy(how=How.XPATH,using ="//table[@role='grid']")
	@CacheLookup
	WebElement tblSearchResult;
	
	@FindBy(how=How.XPATH,using ="//table[@id='customers-grid']")
	@CacheLookup
	WebElement table;
	
	@FindBy(how=How.XPATH,using ="//table[@id='customers-grid']/tbody/tr")
	@CacheLookup
	List<WebElement> tableRows;
	
	@FindBy(how=How.XPATH,using ="//table[@id='customers-grid']/tbody/tr/td")
	@CacheLookup
	List<WebElement> tablecolumns;
	
	
	public void setEmail(String email) {
		waitHelper.waitForElement(txtEmail, 30);
		txtEmail.clear();
		txtEmail.sendKeys(email);
		
	}
	public void setFirstName(String fname) {
		waitHelper.waitForElement(txtfirstName, 30);
		txtfirstName.clear();
		txtfirstName.sendKeys(fname);
		
	}
	public void setLastName(String lname) {
		waitHelper.waitForElement(txtLastName, 30);
		txtLastName.clear();
		txtLastName.sendKeys(lname);
		
	}
	public void clickSearch() {
		btnSearch.click();
		
	}
	public int getRows() {
		return (tableRows.size());
	}
	public int getColumn() {
		return (tablecolumns.size());
	}
	
	
	public boolean searchCustomerByEmail(String email) {
		
		boolean flag=false;
		
		for(int i=1;i<=getRows();i++) {
			
			String emailId=table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[2]")).getText();
			System.out.println(emailId);
			if(emailId.equals(email)) {
				flag=true;
			}
		}
		return flag;
		
		
	}
}

