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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.ExcelUtility;
import GenericUtility.FileUtility;
import GenericUtility.JavaUtility;
import GenericUtility.WebDriverUtility;
import fiduicia_POM_Object_Repository.HomePage;
import fiduicia_POM_Object_Repository.LoginPage;
import fiduicia_POM_Object_Repository.SalesAndInventoryPage;


public class Transaction_By_Admin_test3 extends BaseClass
{
	@Test
	public  void transactionByAdmin() throws Throwable
	{
//		FileUtility futil=new FileUtility();
//    ExcelUtility eutil=new   ExcelUtility();
//    JavaUtility jutil=new  JavaUtility();
//    WebDriverUtility wutil=new WebDriverUtility();
//
//    String Browser=futil.readDataFromPropertyFile("browser");
//    String Url=futil.readDataFromPropertyFile("url");
//    String USERNAME=futil.readDataFromPropertyFile("username");
//    String PASSWORD=futil.readDataFromPropertyFile("password");
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
//		
//		LoginPage L= new LoginPage(driver);
//		L.setLogin(USERNAME, PASSWORD);
//		
		Thread.sleep(3000);
		wutil.acceptAlert(driver);
		Thread.sleep(2000);
		
		HomePage h =new HomePage(driver); 
		h.pos();
		
		SalesAndInventoryPage sop=new SalesAndInventoryPage(driver);
		Thread.sleep(2000);
		sop.clickon();
		
		String name=eutil.ReadDataFromExcel("SystemTestcases",1,9);
		sop.selectCustomerandClick(name);
		String cash=eutil.ReadDataFromExcel("SystemTestcases",1,5);
		sop.enterCashClick(cash);
		
		Thread.sleep(2000);
		
			
		String text = driver.switchTo().alert().getText();
		
		Thread.sleep(2000);
		if(text.contains("Success."))
		{
		System.out.println(text);
		System.out.println("transaction successful");
		}
		else
		{
			System.out.println("transaction not successful");
		}
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		
		
}
}