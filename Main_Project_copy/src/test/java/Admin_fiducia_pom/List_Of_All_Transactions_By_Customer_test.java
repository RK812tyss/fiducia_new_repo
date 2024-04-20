package Admin_fiducia_pom;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.ExcelUtility;
import GenericUtility.FileUtility;
import GenericUtility.JavaUtility;
import GenericUtility.WebDriverUtility;
import fiduicia_POM_Object_Repository.HomePage;
import fiduicia_POM_Object_Repository.LoginPage;
import fiduicia_POM_Object_Repository.Transaction_page;


public class List_Of_All_Transactions_By_Customer_test extends BaseClass
{
	
	@Test(groups ="Smoke")
	public void allTransactions() throws Throwable

	
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
//
//		LoginPage L= new LoginPage(driver);
//		L.setLogin( USERNAME,PASSWORD);
//		
		
		Thread.sleep(3000);
		wutil.acceptAlert(driver);
		Thread.sleep(3000);
	
		HomePage h=new HomePage(driver);
		Thread.sleep(2000);
		h.transaction();
		
		Transaction_page t =new Transaction_page(driver);
	
		String customername= eutil.ReadDataFromExcel("SystemTestcases",1,9);

		
		t.tranSearch(customername);
		
	for(WebElement w:t.getheading()) 
	{
		System.out.println(w.getText());
	}
	 t.next();

	
	for(WebElement w:t.getheading2()) 
	{
		System.out.println(w.getText());
	}
		
}
}