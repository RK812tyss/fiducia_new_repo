package Admin_fiducia_pom;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import fiduicia_POM_Object_Repository.HomePage;
import fiduicia_POM_Object_Repository.Product_page;


@Listeners(GenericUtility.ListnerImplementationClass.class)
public class Admin_Add_Product_test extends BaseClass
{
	
@Test(retryAnalyzer=GenericUtility.RetryImplement.class)

public void AdminAddProduct() throws Throwable

{
//	FileUtility futil=new FileUtility();
//    ExcelUtility eutil=new   ExcelUtility();
//    JavaUtility jutil=new  JavaUtility();
//    WebDriverUtility wutil=new WebDriverUtility();
//    
//  	
//	 String Browser=futil.readDataFromPropertyFile("browser");
//     String Url=futil.readDataFromPropertyFile("url");
//     String USERNAME=futil.readDataFromPropertyFile("username");
//     String PASSWORD=futil.readDataFromPropertyFile("password");
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
//	L.setLogin(USERNAME, PASSWORD);
	
	

	Thread.sleep(3000);
	wutil.acceptAlert(driver);
	Thread.sleep(3000);
	

	HomePage h=new HomePage(driver);
	Thread.sleep(2000);
	h.clickOnProduct();
	
		
	String win=driver.getWindowHandle();
	driver.switchTo().window(win);
	
	
	
	String productcode = eutil.ReadDataFromExcel("SystemTestcases",1,0);

	 	
	 	String productname = eutil.ReadDataFromExcel("SystemTestcases",1,1);

	
	String productdesc =  eutil.ReadDataFromExcel("SystemTestcases",1,2);

	
	String productquantity = eutil.ReadDataFromExcel("SystemTestcases",1,3);

	//Assert.fail();
	String productonhand=eutil.ReadDataFromExcel("SystemTestcases",1,4);

	
	String productprice= eutil.ReadDataFromExcel("SystemTestcases",1,5);

	String category=eutil.ReadDataFromExcel("SystemTestcases",1,6);
	String supplier=eutil.ReadDataFromExcel("SystemTestcases",1,7);

	String productdate= eutil.ReadDataFromExcel("SystemTestcases",1,8);
	
	Product_page p = new Product_page(driver);
		
	p.addProduct(productcode, productname, productdesc, productquantity , productonhand ,productprice,category,supplier, productdate);
	

	p.validateProduct();
		
	}
}

