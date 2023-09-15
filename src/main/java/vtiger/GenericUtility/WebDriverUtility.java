package vtiger.GenericUtility;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriverBuilder;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class contains all the methods of webdriver
 * @author ASUS
 *
 */
public class WebDriverUtility
{
	/**
	 * the method will maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
   /**
    * this method will minimize the window
    * @param driver
    */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
   /**
    * this method will wait for all findelement and findElements 
    * operation to be performed
    * @param driver
    */
     public void waitForElementsToLoad(WebDriver driver)
     {
    	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     }
   /**
    * the method will wait untill specified element is visible
    * @param driver
    * @param element
    */
    public void waitForElementsToBeVisible(WebDriver driver,WebElement element)
    {
    	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.visibilityOf(element));
    	
    }
    /**
     * select class will handle if the dropdown starts with select tag
     * this method will handle dropdown with index
     * @param element
     * @param index
     */
    public void handleDropDown(WebElement element,int index)
    {
    	Select sel=new Select(element);
    	sel.selectByIndex(index);
    }
    
    /**
     * here we done method overloading becoz parametrs are diff
     * this method will handle dropdown with help of value
     * @param element
     * @param value
     */
    public void handleDropDown(WebElement element,String value)
    {
    	Select sel=new Select(element);
    	sel.selectByValue(value);
    	
    }
     
    /**
     * here also we did method overloading becoz parameters are same but
     *  position of parameters is changed
     * the method will handle dropdown by visibe text
     * @param text
     * @param element
     */
    public void handleDropdown(String text,WebElement element)
    {
    	Select sel=new Select(element);
    	sel.selectByVisibleText(text);
    }
    
    /**
     * the method will mouse hover to particular element
     * @param driver
     * @param element
     */
    public void mouseHoverAction(WebDriver driver,WebElement element)
    {
    	Actions act=new Actions(driver);
    	act.moveToElement(element).perform();;
    }
    
    /**
     * the method will double click whereever u point the curser
     * @param driver
     */
    public void doubleClickAction(WebDriver driver)
    {
    	Actions act=new Actions(driver);
    	act.doubleClick().perform();
    }
    
    /**
     * this method will double click to a particular element
     * @param driver
     * @param element
     */
    public void doubleClickAction(WebDriver driver,WebElement element)
    {
    	Actions act=new Actions(driver);
    	act.doubleClick(element).perform();
    }
    
    /**
     * the method will right click whereever we point curser
     * @param driver
     */
    public void rightClickAction(WebDriver driver)
    {
    	Actions act=new Actions(driver);
    	act.contextClick().perform();
    }
    
    /**
     * this method will right click to a particular element
     * @param driver
     * @param element
     */
    public void rightClickAction(WebDriver driver,WebElement element)
    {
    	Actions act=new Actions(driver);
    	act.contextClick(element).perform();
    }
    
    /**
     * this method will perform drag and drop
     * @param driver
     * @param srcelement
     * @param destelement
     */
    public void dragAndDropAction(WebDriver driver,WebElement srcelement,WebElement destelement)
    {
    	Actions act=new Actions(driver);
    	act.dragAndDrop(srcelement, destelement).perform();
    }
    
    /**
     * this method will move the curser anywhere on the webpage based 
     * on offSet values
     * @param driver
     * @param xoffSet
     * @param yoffSet
     */
    public void moveAccrosWebPage(WebDriver driver,int xoffSet,int yoffSet)
    {
    	Actions act=new Actions(driver);
    	act.moveByOffset(xoffSet, yoffSet).perform();
    }
    
    /**
     * this method will scroll vertically for 500 pixcels
     * @param driver
     */
    public void scrollAction(WebDriver driver)
    {
     JavascriptExecutor js=(JavascriptExecutor) driver;
     js.executeScript("window.ScrollBy(0,500);", "");
    }
    
    /**
     * this method scroll vertically untill element reference
     * @param driver
     * @param element
     */
    public void scrollAction(WebDriver driver,WebElement element)
    {
    	JavascriptExecutor js=(JavascriptExecutor) driver;
    	js.executeScript("arguments[0].scrollIntoView()", element);
    }
    
    /**
     * this method will accept the alert popup
     * @param driver
     */
    public void acceptAlert(WebDriver driver)
    {
    	driver.switchTo().alert().accept();
    }
    
    /**
     * this method will dismiss the alert popup
     * @param driver
     */
    public void dismissAlert(WebDriver driver)
    {
    	driver.switchTo().alert().dismiss();
    }
    
    /**
     * this method will enter the text in prompt alert
     * @param driver
     * @param text
     */
    public void sentTextToAlert(WebDriver driver,String text)
    {
    	driver.switchTo().alert().sendKeys(text);
    }
    
    /**
     * this method will capture the alert message and return it to caller
     * @param driver
     */
    public void getAlertText(WebDriver driver)
    {
    	driver.switchTo().alert().getText();
    }
    
    /**
     * this method will handle frame based on index
     * @param driver
     * @param index
     */
    public void handleFrame(WebDriver driver,int index)
    {
    	driver.switchTo().frame(index);
    }
   
    /**
     * this method will handle frame only with name and id attributes
     * @param driver
     * @param nameOrId
     */
    public void handleFrame(WebDriver driver,String nameOrId)
    {
    	driver.switchTo().frame(nameOrId);
    }
    
    /**
     * this method will handle frame to the particular element
     * @param driver
     * @param element
     */
    public void handleFrame(WebDriver driver,WebElement element)
    {
    	driver.switchTo().frame(element);
    }
    
    /**
     * this method will switch the control to the immediate parent
     * @param driver
     */
  public void switchToParentFrame(WebDriver driver) 
    {
	  driver.switchTo().parentFrame();
    }
  
  
  /**
   * this method will switch the selenium control from parent to child
   * or child to parent based on the partail window title
   * @param driver
   * @param partialtitle
   */
  
  public void switchToWindow(WebDriver driver,String partialtitle)
  {
	  //step 1 get all window ids
	  Set<String> allWinId = driver.getWindowHandles();
	  
	  //step 2 itreatre to individual ids
	  for(String winid:allWinId)
	  {
		  //step 3 switch to each id and capture the title
		 String currentTitle = driver.switchTo().window(winid).getTitle();
	
	  //step 4 compare the title with req reference
		 if(currentTitle.contains(partialtitle))
		 {
			 break;
		 }
	  }
  }
  
  /**
   * 
   * @param driver
   * @param screenshot
   * @throws IOException
   */
  public void takeScreenShot(WebDriver driver,String screenshot) throws IOException
  {
	  TakesScreenshot ts=(TakesScreenshot) driver;
	 File src = ts.getScreenshotAs(OutputType.FILE);
	 File dest=new File(".\\ScreenShot\\"+screenshot+".png");
	 FileUtils.copyFile(src, dest);
	 
	  
  }
}


