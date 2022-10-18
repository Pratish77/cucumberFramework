package helPers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;



public class Help {

	public static FileInputStream fisproperties;
	public static Properties configProp;
	public static void main(String[]args) throws IOException {
	
	  configProp=new Properties();
	 fisproperties=new FileInputStream("config.properties");
	 configProp.load(fisproperties);
	 
	String br = configProp.getProperty("browser");
	String br1= configProp.getProperty("chromepath");
	System.out.println(br);
	System.out.println(br1);

	 
}

}
/*configProp=new Properties();
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

logger.info("****Launching browser*****");*/
