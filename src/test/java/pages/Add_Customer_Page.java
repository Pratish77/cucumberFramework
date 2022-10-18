package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Add_Customer_Page {
	public WebDriver driver;

	 public Add_Customer_Page(WebDriver driver){

	        this.driver = driver;

	        //This initElements method will create all WebElements

	        PageFactory.initElements(driver, this);

	    }
	 
	 By Customer_menu=By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");
	 By Customer_menuitem=By.xpath("//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]");
	 By btnAddnew=By.xpath("//a[@class='btn btn-primary']");
	 By txtEmail=By.xpath("//input[@id='Email']");
	 By txtPassword=By.xpath("//input[@id='Password']");//a[normalize-space()='16']
	 By txtFirstName=By.xpath("//input[@id='FirstName']");
	 By txtLastName=By.xpath("//input[@id='LastName']");
	 By customerGender=By.xpath("//input[@id='Gender_Male']");
	 By femalecustomer=By.xpath("//input[@id='Gender_FeMale']");
	 By Customer_Dob=By.xpath("//span[@class='k-icon k-i-calendar']");
	 By Customer_Dob1=By.xpath("//a[normalize-space()='16']");
	 By Customer_cmpny=By.xpath("//input[@id='Company']");
	 By istcheckbox=By.xpath("//input[@id='IsTaxExempt']");
	 By Customer_Newsletter=By.xpath("//li[normalize-space()='Test store 2']");
	 By Customer_Roles=By.xpath("//*[@id=\"customer-info\"]/div[2]/div[10]/div[2]/div/div[1]/div/div");
	 
	 By Customer_Roles2=By.xpath("//li[contains(text(),'Vendors')]");
	 By Customer_ManagerOfVendor=By.xpath("//select[@id='VendorId']");
	 By Customer_Status=By.xpath("//input[@id='Active']");
	 By Customer_Addcomment=By.xpath("//textarea[@id='AdminComment']");
	 By SaveCustomer=By.xpath("//button[@name='save']");
	 By addedcustomerConfirmation=By.xpath("//html/body/div[3]/div[1]/div[1]");
	 By newsletterinteraction=By.xpath("//*[@id=\"customer-info\"]/div[2]/div[9]/div[2]/div/div[1]/div/div");
	
	 
	 
	 
	 //Actgions Methods
public String dashboardPageTitle() {
		 
		return driver.getTitle();
	 }
	 public void clickonCustomerMenu() {
		 
		 driver.findElement(Customer_menu).click();
	 }
 public void clickonCustomerMenuItem() {
		 
		 driver.findElement(Customer_menuitem).click();
	 }
 public void clickonAddNewButton() {
	 
	 driver.findElement(btnAddnew).click();
 }
 public void setEmail(String email) {
	 
	 driver.findElement(txtEmail).sendKeys(email);
 }
 public void setPassword(String pwd) {
	 
	 driver.findElement(txtPassword).sendKeys(pwd);
 }
 public void enterFirstName(String fname) {
	 
	 driver.findElement(txtFirstName).sendKeys(fname);
 }
 public void enterLastName(String lname) {
	 
	 driver.findElement(txtLastName).sendKeys(lname);
 }
 public void clickonGender(String gender) {
	 
	 if (gender.equals("Male")) {
	 
	 driver.findElement(customerGender).click();
     }else {
    	 driver.findElement(femalecustomer).click(); 
     }
 }
public void enterDob() {
	 
	 driver.findElement(Customer_Dob).click();
 }
 public void enterDob1() {
	 
	 driver.findElement(Customer_Dob1).click();
 }
 public void customerCompany(String cmpny) {
	 
	 driver.findElement(Customer_cmpny).sendKeys(cmpny);;
 }
 public void clickonTexCheckBox() {
	 
	 driver.findElement(istcheckbox).click();
 }
 public void chooseNewsletter() throws InterruptedException {
	 driver.findElement(newsletterinteraction).click();
	 
	 Thread.sleep(3000);
	 
	 driver.findElement(Customer_Newsletter).click();
 }
 public void selectCustomerRoles() throws InterruptedException {
	 
     driver.findElement(Customer_Roles).click();
	 
	 Thread.sleep(3000);
	 
	 driver.findElement(Customer_Roles2).click();
 }
public void selectManagerOfVender(String ven) {
	
	Select sel = new Select(driver.findElement(Customer_ManagerOfVendor));
	  sel.selectByVisibleText(ven);
 }
 /*public void clickStatus() {
	 
	 driver.findElement(Customer_Status).click();
 }*/
 public void enterComment(String comment) {
	 
	 driver.findElement(Customer_Addcomment).sendKeys(comment);;
 }
 public void clickonSaveButton() {
	 
	 driver.findElement(SaveCustomer).click();
 }
public String addedCustomerconfirmation() {
	
	
	
	String confirmatione="The new customer has been added successfully.";
	
	//String confirmation=driver.findElement(addedcustomerConfirmation).getText();
	 
	 return confirmatione;
}
 
 
 
	 
	 
	 
	 
	 
	    
}
