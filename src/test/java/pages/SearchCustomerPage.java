package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utils.WaitHelper_Class;

public class SearchCustomerPage {

	public WebDriver driver;
	WaitHelper_Class waithelper;

	 public SearchCustomerPage(WebDriver driver){

	        this.driver = driver;

	        //This initElements method will create all WebElements

	        PageFactory.initElements(driver, this);
            waithelper=new WaitHelper_Class(driver);
            
	    }
	 @FindBy(how=How.ID,using="SearchEmail")
	 @CacheLookup
	 WebElement txtEmail;
	 
	 @FindBy(how=How.ID,using="SearchFirstName")
	 @CacheLookup
	 WebElement txtFirstName;
	 
	 @FindBy(how=How.XPATH,using="//button[@id='search-customers']//i[@class='fas fa-search']")
	 @CacheLookup
	 WebElement btnSearch;
	 
	 @FindBy(how=How.XPATH,using="//table[@id='grid']")
	 @CacheLookup
	 WebElement tableSearchResults;
	
	 @FindBy(how=How.XPATH,using="//table[@id='customers-grid']")
	 @CacheLookup
	 WebElement table;
	 
	 @FindBy(how=How.XPATH,using="//table[@id='customers-grid']//tbody/tr")
	 @CacheLookup
	 List<WebElement> tableRows;
	
	 @FindBy(how=How.XPATH,using="//table[@id='customers-grid']//tbody/tr/td")
	 @CacheLookup
	 List<WebElement> tableColumns;
	 
	 
	 
	
	 public void setEmail(String email) {
		 waithelper.waitForElement(txtEmail,5);
		 txtEmail.clear();
		 txtEmail.sendKeys(email);
	 }
	 public void setFirstName(String fname) {
		 waithelper.waitForElement(txtEmail,5);
		 txtEmail.clear();
		 txtFirstName.sendKeys(fname);
	 }
	 public void clickonSearch() {
		 btnSearch.click();
		 waithelper.waitForElement(txtEmail,5);
		 
	 }
	 
	 public int tableRows() {
		 
		return tableRows.size();
	 }
	 public int getgettableColumns() {
		 
		return tableColumns.size();
	 }
	 public boolean searchCustomerByEmail(String email)
	 {
		 boolean flag=false;
		 
		 for(int i=1;i<=tableRows();i++) {
			 
			 String emailid=table.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+i+"]/td[2]")).getText();
			 System.out.println(emailid);
			 if(emailid.equals(email))
			 {
				 flag=true;
			 }
		 }
		 return flag;
}
	 
	 
	 
	 
	 
}
