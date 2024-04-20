package GenericUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtility
{

	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	
	public void waitForPageLoad(WebDriver driver,int sec)
	{
		
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(sec));
	}
	
	
	public void waitUntilElementToBeVisible(WebDriver driver,int sec,WebElement element)
	{
				
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(sec));
		 wait.until(ExpectedConditions.visibilityOf(element));
		
		
	}
	
	public void waitUntilElementToBeClickable(WebDriver driver,int sec,WebElement element)
	{
				
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(sec));
		 wait.until(ExpectedConditions.elementToBeClickable(element));
		
		
	}
	
	public void waitUntilToGetTitle(WebDriver driver,int sec,String title)
	{
				
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(sec));
		 wait.until(ExpectedConditions.titleContains(title));
		
		
	}
	
	
	
	
	
	public Actions performActions(WebDriver driver)
	{
		Actions act=new Actions(driver);
		return act;
	}
	
	
	public void mouseHover(WebDriver driver,WebElement element)
	{
		 performActions(driver).click(element).perform();
		
	}
	
	
	public void dragAnddrop(WebDriver driver,WebElement src,WebElement dst)
	{
		
		performActions(driver).dragAndDrop(src, dst).perform();
	}
	
	 public void rightClickOnElement(WebDriver driver,WebElement element)
	 {
		 performActions(driver).contextClick(element).perform();
	   }
	
		 
	public void dropDownHandling(WebElement element,String text)
	{
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}
	
	public void enterkeys(WebDriver driver)
	{
		 performActions(driver).sendKeys(Keys.ENTER).perform();
	}
	
	
	public void switchToWindow(WebDriver driver,String expwind)
	{
		Set<String> window = driver.getWindowHandles();
		Iterator<String> it = window.iterator();
		while(it.hasNext())
		{
			String win=it.next();
			String currentTitle=driver.switchTo().window(win).getTitle();
			
			if(currentTitle.contains(expwind)) 
			{
				break;
			}
		}
	}
	
	public Robot robotObj() throws AWTException
	{
		Robot rb = new Robot();
		return rb;
	}
	
	public void enterKeyPress(WebDriver driver) throws Throwable 
	{
		robotObj().keyPress(KeyEvent.
				VK_ENTER);
	}
	
	
	public void enterKeyRelease(WebDriver driver) throws Throwable 
	{
		robotObj().keyRelease(KeyEvent.VK_ENTER);
	}
	
	
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	
	public static  String getscreenShot(WebDriver driver,String screenshotName) throws Throwable
	{
		
		JavaUtility jutils=new JavaUtility();
	   TakesScreenshot ts = (TakesScreenshot)driver;
		
		File src=ts.getScreenshotAs(OutputType.FILE);
		String path=".//Screenshot//"+screenshotName+jutils.getsystemDateInformat()+".png";
		File dest=new File(path);
		String scrpath=dest.getAbsolutePath();
	    FileUtils.copyFile(src, dest);
	    return scrpath;
	}
	
	public void JsscrollBarAction(WebDriver driver)
	{
		JavascriptExecutor jse=(JavascriptExecutor)driver;
	
	jse.executeScript("window.scrollBy(0,800)", "");
	
	}
	
	public void JsscrollAction(WebDriver driver,WebElement element)
	{
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		int y=element.getLocation().getY();
	
	jse.executeScript("window.scrollBy(0,"+y+")",element);
	
	}
	
	public void JsclickOnElement(WebDriver driver,WebElement element)
	{
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		
	
	jse.executeScript("arguments[0].click()",element);
	
	}
	
	public void JsSendKeys(WebDriver driver,WebElement element,String key)
	{
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		
	
	jse.executeScript("arguments[0].value=arguments[1]",element,key);
	
	}
	
	public void JsScrollTillElement(WebDriver driver,WebElement element)
	{
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		
	
	jse.executeScript("arguments[0].scrollIntoView()",element);
	
	}
	public void JsLaunchBrowser(WebDriver driver,String url)
	{
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		
	
	jse.executeScript("window.location=arguments[0])",url);
	
	}
	
	
	public void JsScrollDownTillbottomOfPage(WebDriver driver)
	{
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		
	
	jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	
	}
	
	
	
	
	
	
	
	
}
