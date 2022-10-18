package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {

	
	WebDriver driver;

    @FindBy(id="Email")
    @CacheLookup
    WebElement txtEmail;

    @FindBy(id="Password")
    @CacheLookup
    WebElement txtpassword;    

    @FindBy(className="barone")
    @CacheLookup
    WebElement titleText;

    @FindBy(xpath="//button[text()='Log in']")
    @CacheLookup
    WebElement login;
    
    
    @FindBy(xpath="//a[text()='Log out']")
    @CacheLookup
    WebElement logout;


    public Login_Page(WebDriver driver){

        this.driver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);

    }
    
    

    //Set user name in textbox

    public void setEmail(String Email) throws InterruptedException{
    	txtEmail.sendKeys(Email);
    	Thread.sleep(3000);
        txtEmail.clear();
        Thread.sleep(3000);
        txtEmail.sendKeys(Email);     
    }

    //Set password in password textbox

    public void setPassword(String Password) throws InterruptedException{
    	
    txtpassword.clear();
    Thread.sleep(3000);
    txtpassword.sendKeys(Password);

    }

    //Click on login button

    public void clickLogin(){

            login.click();

    }  
    
 

    //Get the title of Login Page

   /* public String  getLoginTitle(){

     return    driver.getTitle();

    }*/

    /**

     * This POM method will be exposed in test case to login in the application

     * @param strUserName

     * @param strPasword

     * @return

     */

    
	public void clickLogout() {
		// TODO Auto-generated method stub
		logout.click();
	}

}
