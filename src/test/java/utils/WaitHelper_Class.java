package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class WaitHelper_Class {

	public WebDriver driver;
	
	 public WaitHelper_Class(WebDriver driver){

	        this.driver = driver;

	        //This initElements method will create all WebElements
 }
public void waitForElement(WebElement element,long timeoutInSeconds) {
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeoutInSeconds));
	wait.until(ExpectedConditions.visibilityOf(element));
}
	 
	 
	
}
