package fiduicia_POM_Object_Repository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Inventorypage 

{
	 private WebDriver driver;

	@FindBy(xpath= "//span[.='Inventory']")
    private WebElement inventory;
	
	@FindBy(xpath= "//input[@type='search']")
    private WebElement productsearch;
	
	
	@FindBy(xpath= "//table[@id='dataTable']/tbody/tr/td[.='Nvidia']")
    private List<WebElement> nvidia;

	
	
	
	
	 public Inventorypage(WebDriver driver) 
	 {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	
	
	
	
	
	
	
	public List<WebElement> getproduct()
	{
		return nvidia;
	}
	
	
	
	public WebElement getInventory() {
		return inventory;
	}



	public WebElement getProductsearch() {
		return productsearch;
	}



	public List<WebElement> getNvidia() {
		return nvidia;
	}



	public void searchProductInventory(String product)
	{
		inventory.click();
		//productsearch.sendKeys(product);
		
		
		
		
	}



	public void productsearch(String productname) {
		productsearch.sendKeys(productname);
		
	}
	
	
	
	
	
	

}
