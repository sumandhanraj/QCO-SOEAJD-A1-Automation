package vtiger.practice;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import vtiger.ObjectRepository.CreatingNewOrganizatioPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationPage;

public class CreateOrgTest
{
	@Test
	public void createOrgs() throws Throwable 
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
	    //trying to login using pom
		LoginPage lp=new LoginPage(driver);
		//lp.getUserNameEdt().sendKeys(USERNAME);
		//lp.getPasswordEdt().sendKeys(PASSWORD);//code is not optimized
	//	lp.getLoginBtn().click();
		lp.loginToApp(USERNAME, PASSWORD);
		
		HomePage hp=new HomePage(driver);
	    hp.clickOnOrganizationLink();
		
		OrganizationPage op=new OrganizationPage(driver);
		op.clickOnCreateOrgImg();
	 
		CreatingNewOrganizatioPage cnop=new CreatingNewOrganizatioPage(driver);
		cnop.createOrganization(ORGNAME, INDUSTRY);
		
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String OrgHrader = oip.getHeaderText();
		if(OrgHrader.contains(ORGNAME))
		{
			System.out.println("passed");
			System.out.println(OrgHrader);
		}
		else
		{
			System.out.println("failed");
		}
		hp.logoutOfApplication(driver);
		System.out.println("logout successfully");
	   }
}


