 package vtiger.contactstest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import vtiger.GenericUtility.ExcelFileUtility;
import vtiger.GenericUtility.JavaUtility;
import vtiger.GenericUtility.PropertyFileUtility;
import vtiger.GenericUtility.WebDriverUtility;

public class CreateContactWithOrganization {

	public static void main(String[] args) throws Throwable
	{
		
	//create object for required utility
	  JavaUtility jutil=new JavaUtility();
	  PropertyFileUtility putil= new PropertyFileUtility();
	  ExcelFileUtility eutil=new ExcelFileUtility();
	  WebDriverUtility wutil=new WebDriverUtility();
	    WebDriver driver=null;
  
	    //step 1 read all necessary data
	  //by using generic utility we can write in dis way
	    String BROWSER = putil.getDataFromProperty("browser");
	    String USERNAME = putil.getDataFromProperty("username");
	   String PASSWORD = putil.getDataFromProperty("password");
	    String URL = putil.getDataFromProperty("url");
	    
	    //by using generic utility we can write dis way
	    String ORGNAME = eutil.getDataFromExcel("Contacts", 4, 2)+jutil.getRandomNumber();
	    String LASTNAME = eutil.getDataFromExcel("Contacts", 4, 2);
	    
	  //step 2 launch the browser
	      if(BROWSER.equalsIgnoreCase("chrome"))
	      {
	    	  driver=new ChromeDriver();
	    	  System.out.println(BROWSER+"----browser launched");
	    	  
	      }
	      else if(BROWSER.equalsIgnoreCase("edge"))
	      {
	    	  driver=new EdgeDriver();
	    	  System.out.println(BROWSER+"----browser launched");
	      }
	      else 
	      {
	    	  System.out.println("invalid browser");
	      }
	      
	      
	      
	      //by using webdriverutility we cwn write dis way
	        wutil.maximizeWindow(driver);
	        wutil.waitForElementsToLoad(driver);
	      
	      //step 3 load url
	      driver.get(URL);
	      
	      //step 4 login to the application
	      
	      driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();
			
			//step 5 click on organization link
	         driver.findElement(By.linkText("Organizations")).click();
			
			//step 6 click on add organization symbol
			driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
			
			//step 7 create organization
			driver.findElement(By.name("accountname")).sendKeys(ORGNAME) ;   
			
		      
		          //step 9 save
		    		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		    		
		    	     //step 10 verify
		    	String header = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		    		if(header.contains(ORGNAME))
		    		{
		    			System.out.println("passed");
		    			System.out.println(header);
		    		}
		    		else
		    		{
		    			System.out.println("failed");
		    		}
		    		
		    		/*create contact using organization*/
		    		driver.findElement(By.linkText("Contacts")).click();
		    		
		    		 //step 11 navigate to create contact clicking on image
		    		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		    	
		   //step 12 enter the last name
		    driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(LASTNAME);
		    
		    driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@title='Select']")).click();
		    
		    //step 13 switch to child window
		    wutil.switchToWindow(driver,"Accounts");
		    
		   //step 14 search for organozation
		    driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(ORGNAME);
		    driver.findElement(By.name("search")).click();
		    driver.findElement(By.xpath("//a[text()='"+ORGNAME+"']")).click();//dynamic xpath
		     
		    //step 15 switch back to parent weindow
		    wutil.switchToWindow(driver, "Contacts");
		    
		    //step 16 save
		    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		    
		    //verify the contact
		    String header1 = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
    		if(header.contains(LASTNAME))
    		{
    			System.out.println("passed");
    			System.out.println(header1);
    		}
    		else
    		{
    			System.out.println("failed");
    		}
		   
    		//signout
    		WebElement signout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
    		wutil.mouseHoverAction(driver, signout);
    		driver.findElement(By.linkText("Sign Out")).click();
    		System.out.println("signout successfully");
    		
	}
}
