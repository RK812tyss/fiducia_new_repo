package fiduicia_POM_Object_Repository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Transaction_page
{
	 private WebDriver driver;
		
	 @FindBy(xpath= "//input[@type='search']")
	    private WebElement search;
	 
	 @FindBy(xpath= "//table[@id='dataTable']")
	    private WebElement table;
	 
	 @FindBy(xpath= "//tr")
	    private List<WebElement> heading;
	 
	 @FindBy(xpath= "//tr")
	    private List<WebElement> heading2;
	 
	 @FindBy(xpath= "//a[.='Next']")
	    private WebElement nextbtn;
	 
	 public Transaction_page(WebDriver driver) 
	 {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	
	 public List<WebElement> getheading()
	 {
		 return heading;
	 }
	 
	 public List<WebElement> getheading2()
	 {
		 return heading2;
	 }
	 
	 public void tranSearch(String customername) 
	 {
		 search.sendKeys(customername);
		 
		 
	 }
	 
	 public void next() 
	 {
		
		 nextbtn.click();
		 
	 }
	 
	 
}
