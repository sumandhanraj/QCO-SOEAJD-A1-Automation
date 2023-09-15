package vtiger.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import vtiger.ObjectRepository.LoginPage;

public class CreateOrgWithIndustryWithDDt 
{
   public static void main(String[] args) throws Throwable 
   {
	  WebDriver driver=null;
	  Random rd=new Random();
	 int random = rd.nextInt(1000);
	 
	 //step 1 read all necessary data
	 //read data from the property file-->common data
	 FileInputStream fisp=new FileInputStream(".\\src\\test\\resources\\common.properties");
	 Properties pro=new Properties();
	 pro.load(fisp);
	 String BROWSER = pro.getProperty("browser");
	String USERNAME = pro.getProperty("username");
	String PASSWORD = pro.getProperty("password");
	String URL = pro.getProperty("url");
	
	//read data from excel sheet---> test data
	FileInputStream fise=new FileInputStream(".\\src\\test\\resources\\exceladvsel.xlsx");
	Workbook wb = WorkbookFactory.create(fise);
	Sheet sh = wb.getSheet("Organizations");
	  String ORGNAME = sh.getRow(4).getCell(2).getStringCellValue()+random;
      String INDUSTRY = sh.getRow(4).getCell(3).getStringCellValue();
   
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
      
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      
      //step 3 load url
      driver.get(URL);
      
      //step 4 login to the application
      
   //   driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	//	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	//	driver.findElement(By.id("submitButton")).click();
      
    //trying to login using pom
    		LoginPage lp=new LoginPage(driver);
    		//lp.getUserNameEdt().sendKeys(USERNAME);
    		//lp.getPasswordEdt().sendKeys(PASSWORD);//code is not optimized
    	//	lp.getLoginBtn().click();
    		lp.loginToApp(USERNAME, PASSWORD);
		
		//step 5 click on organization link
         driver.findElement(By.linkText("Organizations")).click();
		
		//step 6 click on add organization symbol
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//step 7 create organization
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("Wipro"+random);
       
		//step 8 select the chemecial from industry dropdown
	WebElement industrydrop = driver.findElement(By.xpath("//select[@name='industry']"));
      Select sel=new Select(industrydrop);
      sel.selectByValue(INDUSTRY);
      
          //step 9 save
    		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
    		
    	     //step 10 verify
    	String header = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
    		if(header.contains("Wiproz"))
    		{
    			System.out.println("passed");
    			System.out.println(header);
    		}
    		else
    		{
    			System.out.println("failed");
    		}
    		
    		//step 11  signout
    		WebElement signout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
    		Actions act=new Actions(driver);
    		act.moveToElement(signout).perform();
    		
    		driver.findElement(By.linkText("Sign Out")).click();
    		System.out.println("signout successfully");
   
   
   }
}
