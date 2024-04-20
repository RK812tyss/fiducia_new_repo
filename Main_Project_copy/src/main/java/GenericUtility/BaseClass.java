package GenericUtility;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import fiduicia_POM_Object_Repository.HomePage;
import fiduicia_POM_Object_Repository.LoginPage;

public class BaseClass
{
	
	public FileUtility futil=new FileUtility();
	public  ExcelUtility eutil=new   ExcelUtility();
	public JavaUtility jutil=new  JavaUtility();
	public  WebDriverUtility wutil=new WebDriverUtility();
	public DatabaseUtility dbutil=new DatabaseUtility(); 
	public  WebDriver driver;
	public static WebDriver sdriver;
	@BeforeSuite(alwaysRun=true)
	public void connectToDb() throws SQLException
	{
	dbutil.connectionToDB();
	Reporter.log("--DB connected--",true);
	
	}
	
	//@Parameters("browser")
	@BeforeClass(alwaysRun=true)
	public void launchBrowser(/* String Browser */) throws IOException
	{
		//String Browser = System.getProperty("browser");
		 String Browser=futil.readDataFromPropertyFile("browser");
		
	    
	     
	     if(Browser.equalsIgnoreCase("chrome"))
	 	{
	 		 driver = new ChromeDriver();
	 			
	 	}
	     else if(Browser.equalsIgnoreCase("edge"))
	     {
	    	 driver=new EdgeDriver();
	     }
	     else {
	    	 Reporter.log("Invalid Browser",true);
	     }
	    
	     sdriver= driver;
	     wutil.maximizeWindow(driver);
	     wutil.waitForPageLoad(driver,20);
	    
	    
	}
	
	 @BeforeMethod(alwaysRun=true)
	 public void loginToApp() throws IOException
	 {
		 String Url=futil.readDataFromPropertyFile("url");
	     String USERNAME=futil.readDataFromPropertyFile("username");
	     String PASSWORD=futil.readDataFromPropertyFile("password");
	     driver.get(Url);
	    
	     LoginPage L= new LoginPage(driver);
	 	L.setLogin(USERNAME, PASSWORD);
	 	Reporter.log("...Logged in to Application...",true);
	 	
	 }
	 @AfterMethod(alwaysRun=true)
	public void logoutFromApp()
	{
		 HomePage h=new HomePage(driver);
		 
		 Reporter.log("...Logged out from Application...",true);
	}
		
	 @AfterClass(alwaysRun=true)
	 public void closeBrowser()
	 {
		 driver.quit();
		 Reporter.log("...close the browser...",true);
	 }
	 
	 @AfterSuite(alwaysRun=true)
	 public void closeDB() throws SQLException
	 {
		 dbutil.closeDataBase();
		 Reporter.log("...close database...",true);
	 }
}
