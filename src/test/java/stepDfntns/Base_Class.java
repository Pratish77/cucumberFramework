package stepDfntns;


import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import pages.Add_Customer_Page;
import pages.Login_Page;
import pages.SearchCustomerPage;
import org.apache.log4j.Logger;
public class Base_Class {

    public WebDriver driver;
	public Login_Page lp;
	public Add_Customer_Page addcusr;
	public SearchCustomerPage searchcustmr;
	public static Logger logger;
	//public FileInputStream fisproperties;
	
	public Properties configProp;
	
	
	
	
	//created for generating random string for unique email id
	public static String randomString() {
		
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return(generatedString);
		
		
	}
	
}
