package fiduicia_POM_Object_Repository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
   WebDriver driver;

    // Locators using @FindBy annotation
    @FindBy(xpath= "//input[@placeholder='Username']")
    private WebElement usernameField;

    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@name='btnlogin']")
    private WebElement loginButton;

    // Constructor to initialize the driver and elements using PageFactory
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

  
    public void setLogin(String username,String password) 
    {
    	usernameField.sendKeys(username);
    	passwordField.sendKeys(password);
    	
    	loginButton.click();
    	
    }
    
    public void userlogin(String username,String password) 
    {
    	usernameField.sendKeys(username);
    	passwordField.sendKeys(password);
    	
    	loginButton.click();
    	
    }
}
