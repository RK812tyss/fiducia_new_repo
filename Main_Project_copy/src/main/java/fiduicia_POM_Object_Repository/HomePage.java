package fiduicia_POM_Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	 private WebDriver driver;
	 @FindBy(xpath= "")
	    private WebElement lgbtnimg;
	 
	 @FindBy(xpath= "")
	    private WebElement logoutbtn;
	 @FindBy(xpath= "")
	    private WebElement customerlink;
	 
	 @FindBy(xpath= "//span[.='Transaction']")
	    private WebElement Transactionlink;
	 
	 @FindBy(xpath= "//span[.='Inventory']")
	    private WebElement Inventorylink;
	 
	 @FindBy(xpath= "")
	    private WebElement Supplierlink;
	 
	 @FindBy(xpath= "")
	    private WebElement Employeelink;

	 @FindBy(xpath= "//span[.='POS']")
	    private WebElement poslink;
	 
	 @FindBy(xpath="//span[.='Product']")
	 private WebElement productlink;
	
	
	 public HomePage(WebDriver driver) 
	 {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	 
	 
	
	 public void clickOnCustomer()
		{
		 customerlink.click();
		}
		
	 public void clickOnInventory()
		{
		 Inventorylink.click();
		}
	 public void clickOnProduct()
		{
		 productlink.click();
		}
	
	 public void pos()
		{
		 poslink.click();
		}
	
	 public void transaction()
		{
		 Transactionlink.click();
		}
	
}
