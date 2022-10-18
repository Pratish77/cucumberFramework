package stepDfntns;


import static org.junit.Assert.assertEquals;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;
import org.mortbay.log.Log;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pages.Add_Customer_Page;
import pages.Login_Page;
import pages.SearchCustomerPage;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Step_Definitions extends Base_Class {
	
	
	
	@Before
	public void setup() throws IOException {
		
		//Reading properties
		configProp=new Properties();
		FileInputStream fisproperties=new FileInputStream("config.properties");
		configProp.load(fisproperties);
		
		logger=Logger.getLogger("nopCommerce");//Added logger
		PropertyConfigurator.configure("log4j.properties");//Added logger
		
		String browser=configProp.getProperty("browser");
		if (browser.equals("chrome")){
		 
		System.setProperty("webdriver.chrome.driver",configProp.getProperty("chromepath"));  
		driver=new ChromeDriver();
		
		}else if(browser.equals("firefox")){
			
		System.setProperty("webdriver.gecko.driver",configProp.getProperty("firefoxpath"));  
		driver=new FirefoxDriver();
        }
		
	    logger.info("****Launching browser*****");
		
	}
	
	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {
		lp= new Login_Page(driver);
	}


	@When("User open URL {string}")
	public void user_open_url(String url) {
	  logger.info("*********Opening url***********");
		driver.get(url);
	   driver.manage().window().maximize();
	}
	@When("User enters Email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		
		logger.info("****Providing login details****");
		Thread.sleep(3000);
		lp.setEmail(email);
	    lp.setPassword(password);
		
	   
	}




	/*@When("User opens URL 'String'")
	public void user_opens_url(String url) {
	    driver.get(url);
	}

	@When("User enters Email as 'String' and Password as 'String'")
	public void user_enters_email_as_and_password_as(String email, String password) {
	    lp.setEmail(email);
	    lp.setPassword(password);
	}*/

	@When("Click on login")
	public void click_on_login() {
		
		Log.info("*****Started login*****");
		
		lp.clickLogin();
	    
	} 

	@Then("Page Title should be {string}")
	public void page_title_should_be(String logintitle) {
		//String expected=((LoginPage) lp).getLoginTitle();
		
		if(driver.getPageSource().contains("Login was unsuccessful.")) {
		driver.close();
		logger.info("*****Login Passed*******");
	   Assert.assertTrue(false);
	}else {
		logger.info("*****Login failed*******");
		logger.info(logintitle);
		logger.info(driver.getTitle());
		Assert.assertEquals(logintitle,driver.getTitle());
	}
	}
	@When("user click on log out link")
	public void user_click_on_log_out_link() throws InterruptedException {
		
		logger.info("*****click on logout*******");Thread.sleep(3000);
		lp.clickLogout();
		Thread.sleep(5000);
	}

	@Then("close browser")
	public void close_browser() {
		logger.info("*****closing browser*******");
	 driver.close();    
}
	//Customer feature step definitions
	
	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
	      addcusr=new Add_Customer_Page(driver); 
	      Assert.assertEquals("Dashboard / nopCommerce administration",addcusr.dashboardPageTitle());
	}
	@When("User click on customers Menu")
	public void user_click_on_customers_menu() throws InterruptedException {
	    Thread.sleep(3000);
	    addcusr.clickonCustomerMenu();  
	
	}
	@When("click on customers Menu Item")
	public void click_on_customers_menu_item() {
	   addcusr.clickonCustomerMenuItem();
	}
	@When("click on Add new button")
	public void click_on_add_new_button() {
	    addcusr.clickonAddNewButton();
	}
	@Then("User can view add new customer page")
	public void user_can_view_add_new_customer_page() { 
	      Assert.assertEquals("Add a new customer / nopCommerce administration",addcusr.dashboardPageTitle());
	    }
	@When("User enter customer info")
	public void user_enter_customer_info() throws InterruptedException {
		logger.info("*****Adding new customer*******");
		logger.info("*****Providing customer details*******");
		
	     String email=randomString()+"@gmail.com";
	     Thread.sleep(3000);
	     addcusr.setEmail(email);
	     Thread.sleep(3000);
	     addcusr.setPassword("test123");
	     Thread.sleep(3000);
	     addcusr.enterFirstName("1234p");
	     Thread.sleep(3000);
	     addcusr.enterLastName("lastname");
	     Thread.sleep(3000);
	     addcusr.clickonGender("Male");
	     Thread.sleep(3000);
	     addcusr.enterDob();
	     Thread.sleep(3000);
	     addcusr.enterDob1();
	     Thread.sleep(3000);
	     addcusr.customerCompany("IT");
	     Thread.sleep(3000);
	     addcusr.clickonTexCheckBox();
	     Thread.sleep(3000);
	     addcusr.chooseNewsletter();
	     Thread.sleep(3000);
	     addcusr.selectCustomerRoles();
	     Thread.sleep(3000);
	     addcusr.selectManagerOfVender("Vendor 2");
	     Thread.sleep(3000);
	     addcusr.enterComment("Work Hard");
	     
	}
	@When("click on Save button")
	public void click_on_save_button() throws InterruptedException {
		logger.info("*****Saving customer data*******");
		Thread.sleep(3000);
	     addcusr.clickonSaveButton();
	}
	@Then("User can view confirmation message {string};")
	public void user_can_view_confirmation_message(String confrmtxt) throws InterruptedException {
		Thread.sleep(3000);
		//String confrmtxt1="×\r\n"
			//	+ "The new customer has been added successfully.";
		String expected=addcusr.addedCustomerconfirmation();
		assertEquals(confrmtxt, expected);
	}
	//steps for searching a customer using Email ID....
	
	@When("Enter customer Email")
	public void enter_customer_email() {
		logger.info("*****Searching customer by email ID*******");
	   searchcustmr=new SearchCustomerPage(driver);
	   searchcustmr.setEmail("admin@yourstore.com");
	}
	@When("Click on search button")
	public void click_on_search_button() throws InterruptedException {
		searchcustmr.clickonSearch();
		Thread.sleep(3000);
	    }
	
	@Then("User should found Email in the Search table")
	public void user_should_found_email_in_the_search_table() {
	boolean status=  searchcustmr.searchCustomerByEmail("admin@yourStore.com");  
	  Assert.assertEquals(true,status);
	}






	
	
	
}
 