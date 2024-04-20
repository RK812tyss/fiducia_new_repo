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
import org.openqa.selenium.Keys;
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
import fiduicia_POM_Object_Repository.Inventorypage;
import fiduicia_POM_Object_Repository.LoginPage;


public class Search_NVIDIA_By_Admin_test extends BaseClass
{
	@Test
public  void searchNvidia() throws Throwable
{
//	FileUtility futil=new FileUtility();
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
//	
//	if(Browser.equalsIgnoreCase("chrome"))
//	{
//		 driver = new ChromeDriver();
//			
//	}
//	
//	 wutil.maximizeWindow(driver);
//     wutil.waitForPageLoad(driver,5);
//	driver.get(Url);
//
//	
//	LoginPage L= new LoginPage(driver);
//	L.setLogin(USERNAME,PASSWORD);
//	

	Thread.sleep(3000);
	wutil.acceptAlert(driver);
	Thread.sleep(2000);
	
	
	
	HomePage h=new HomePage(driver);
	
	h.clickOnInventory();
	Thread.sleep(2000);
			
	String productname = eutil.ReadDataFromExcel("SystemTestcases",1,1);
		
	Inventorypage i=new Inventorypage(driver);
	i.productsearch(productname);
	
	
	for(WebElement w:i.getproduct())
		{
			String text=w.getText();
			if(text.contains(productname))
			{
				System.out.println("Nvidia product found in Inventory");
				break;
			}
			else
			{
				System.out.println("Nvidia product not found in Inventory");
			}
		}
	
		
	

}
}