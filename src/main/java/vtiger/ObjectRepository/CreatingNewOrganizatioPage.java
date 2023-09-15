package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.WebDriverUtility;

public class CreatingNewOrganizatioPage extends WebDriverUtility
{
@FindBy(name = "accountname")
private WebElement organizationNameEdt;

@FindBy(name = "industry")
private WebElement industryDropDown;

@FindBy(xpath = "//input[@title='Save [Alt+S]']")
private WebElement saveBtn;

public CreatingNewOrganizatioPage(WebDriver driver) 
{
   PageFactory.initElements(driver, this);
}

//getters 
public WebElement getOrganizationNameEdt() {
	return organizationNameEdt;
}


public WebElement getIndustryDropDown() {
	return industryDropDown;
}

public WebElement getSaveBtn() {
	return saveBtn;
}

//business library
public void createOrganization(String ORGNAME)
{
	organizationNameEdt.sendKeys(ORGNAME);
	saveBtn.click();
}
 
public void createOrganization(String ORGNAME,String INDUSTRY)
{
	organizationNameEdt.sendKeys(ORGNAME);
	handleDropdown(INDUSTRY, industryDropDown);
	saveBtn.click();
}


	
}

