package fiduicia_POM_Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.WebDriverUtility;

public class SalesAndInventoryPage
{
	 private WebDriver driver;
	WebDriverUtility wutil =new WebDriverUtility();
	
	
	 
	 @FindBy(xpath= "//a[.='Others']")
	    private WebElement otherproduct;
	
	
	 @FindBy(xpath="//h6[.='Nvidia']/parent::div//descendant::input[@class='btn btn-info']")
	 private WebElement Nvidia;
	
	@FindBy(xpath="//button[.='SUBMIT']") private WebElement save;
	
	
	
	@FindBy(xpath="//select[@name='customer']") private WebElement selectCustomer;
	 
	@FindBy(xpath="//input[@name='cash']") private WebElement entercash;
	
	@FindBy(xpath="//button[.='PROCEED TO PAYMENT']") private WebElement proceedpaymentbtn ;
	
	@FindBy(xpath="//a[contains(@href,'delete')]") private WebElement deletebtn ;
	
	 public SalesAndInventoryPage(WebDriver driver)
	 {
	       // this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	
	
	
	public WebElement getSelectCustomer()
	{
		return selectCustomer;
	}
	
	
//	 
//	 public void clickOnOtherProduct()
//		{
//		 otherproduct.click();
//		}
//		
//	
//	 public void clickOnNvidia()
//		{
//		 Nvidia.click();
//		}
		
	
	
	public void selectCustomerandClick(String name) 
	{
			
		 wutil.dropDownHandling(selectCustomer, name);
		 save.click();
	}
	
	
	public void clickon()
	{
		otherproduct.click();
		
		 Nvidia.click();
	}
	
	
		public void enterCashClick(String cash)
		{
			
			
		 
		entercash.sendKeys(cash);
		
		proceedpaymentbtn.click();
	}
	
		
		public void deleteTranBtn()
		{
			deletebtn.click();
		}
}
	
	
	
	
	
	
	
	
	


