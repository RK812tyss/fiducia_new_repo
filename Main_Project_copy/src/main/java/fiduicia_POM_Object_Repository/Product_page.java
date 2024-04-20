package fiduicia_POM_Object_Repository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.WebDriverUtility;

public class Product_page 

{
	  private WebDriver driver;
		WebDriverUtility wutil =new WebDriverUtility();
		
	@FindBy(xpath= "//i[@class='fas fa-fw fa-plus']")
    private WebElement plusicon;
	
	@FindBy(xpath= "//input[@placeholder='Product Code']")
    private WebElement productcode ;
	
	@FindBy(xpath= "//input[@placeholder='Name']")
    private WebElement productname ;
	
	@FindBy(xpath= "//textarea[@placeholder='Description']")
    private WebElement productDescription;
	
	
	@FindBy(xpath= "//input[@placeholder='Quantity']")
    private WebElement quantity ;
	
	@FindBy(xpath= "//input[@placeholder='On Hand']")
    private WebElement onhand ;
	
	@FindBy(xpath= "//input[@placeholder='Price']")
    private WebElement price;
	
	@FindBy(xpath= "//select[@name='category']")
    private WebElement category;
	
	@FindBy(xpath= "//select[@name='supplier']")
    private WebElement supplier ;
	
	@FindBy(xpath= "//input[@name='datestock']")
    private WebElement datestock ;
	
	@FindBy(xpath= "//table[@id='dataTable']/tbody/tr/td[2]")
    private List<WebElement> expproduct;
	
	
	@FindBy(xpath= "//button[.='Save']/parent::form[@action='pro_transac.php?action=add']/child::button[@type='submit']")
    private WebElement savebtn ;

	
	

	 public Product_page (WebDriver driver) 
	 {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	
	
	 
	 
	
	public void selectCategory(String value) 
	{
			
		 wutil.dropDownHandling(category, value);
		 
	}
	public void selectSupplier(String value) 
	{
			
		 wutil.dropDownHandling(supplier, value);
		 
	}
	
	public void addProduct(String code,String name,String desc,String quant,String hand,String pr,String cat,String sup,String date  )
	{
		plusicon.click();
		productcode.sendKeys(code);
		productname.sendKeys(name);
		productDescription.sendKeys(desc);
		quantity.sendKeys(quant);
		onhand.sendKeys(hand);
		price.sendKeys(pr);
		selectCategory( cat);
		selectSupplier(sup);
		datestock.click();
		datestock.sendKeys(date);
		savebtn.click();
		
	}
	
	public void validateProduct()
	{
		
		for(WebElement w:expproduct)
		{
			String text=w.getText();
			if(text.contains(productname.getText()))
			{
				System.out.println("product created sucessfully");
				break;
			}
			else
			{
				System.out.println("product not created");
			}
		}
	}
	
	
}
