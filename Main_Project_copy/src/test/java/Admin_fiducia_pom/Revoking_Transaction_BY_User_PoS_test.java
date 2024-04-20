package Admin_fiducia_pom;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.ExcelUtility;
import GenericUtility.FileUtility;
import GenericUtility.JavaUtility;
import GenericUtility.WebDriverUtility;
import fiduicia_POM_Object_Repository.HomePage;
import fiduicia_POM_Object_Repository.LoginPage;
import fiduicia_POM_Object_Repository.SalesAndInventoryPage;


public class Revoking_Transaction_BY_User_PoS_test extends BaseClass
{
	@Test
	public void revokingTransaction() throws Throwable
	{
//		FileUtility futil=new FileUtility();
//	    ExcelUtility eutil=new   ExcelUtility();
//	    JavaUtility jutil=new  JavaUtility();
//	    WebDriverUtility wutil=new WebDriverUtility();
//
//	    String Browser=futil.readDataFromPropertyFile("browser");
//	    String Url=futil.readDataFromPropertyFile("url");
//	    String USERNAME=futil.readDataFromPropertyFile("username");
//	    String PASSWORD=futil.readDataFromPropertyFile("password");
//		
//		
//		if(Browser.equalsIgnoreCase("chrome"))
//		{
//			 driver = new ChromeDriver();
//				
//		}
//		
//		 wutil.maximizeWindow(driver);
//	     wutil.waitForPageLoad(driver,5);
//		driver.get(Url);
//	
//		LoginPage L= new LoginPage(driver);
//		L.userlogin(USERNAME,PASSWORD);
//			
	
		Thread.sleep(3000);
		wutil.acceptAlert(driver);
		Thread.sleep(3000);

		HomePage h =new HomePage(driver); 
		h.pos();
		
		
		SalesAndInventoryPage pos=new SalesAndInventoryPage(driver);
		pos.clickon();
	
		
		String url = driver.getCurrentUrl();
		if(url.contains("add"))
		{
			System.out.println("proceeding for transaction");
		}
		System.out.println("customer want to revoke transaction");
			
		
	pos.deleteTranBtn();
		
		
		String url2 = driver.getCurrentUrl();
		           if(url2.contains("delete"))
		        		 {
					      System.out.println("transaction revoked");
						}
				
				 	   
	}
}
				
		