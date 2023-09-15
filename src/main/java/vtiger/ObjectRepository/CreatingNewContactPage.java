package vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.WebDriverUtility;

public class CreatingNewContactPage extends WebDriverUtility
{
@FindBy(name = "lastname")
private WebElement lastNameEdt;
 
@FindBy(xpath = "//input[@name='account_name']/following-sibling::img[@title='Select']")
private WebElement orgLookUpImg;

@FindBy(xpath = "//input[@title='Save [Alt+S]']")
private WebElement saveBtn;

@FindBy(name = "search_text")
private WebElement orgSeacrhEdt;
 
@FindBy(name = "search")
private WebElement orgSearchBtn;

public CreatingNewContactPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
	
}

public WebElement getLastNameEdt() {
	return lastNameEdt;
}

public WebElement getOrgLookUpImg() {
	return orgLookUpImg;
}

public WebElement getSaveBtn() {
	return saveBtn;
}

public WebElement getOrgSeacrhEdt() {
	return orgSeacrhEdt;
}

public WebElement getOrgSearchBtn() {
	return orgSearchBtn;
}

//business lib
public void createContact(String LASTNAME)
{
	lastNameEdt.sendKeys(LASTNAME);
}
public void createContact(WebDriver driver,String LASTNAME,String ORGNAME)
{
	lastNameEdt.sendKeys(LASTNAME);
	orgLookUpImg.click();
	switchToWindow(driver, "Accounts");
	orgSeacrhEdt.sendKeys(ORGNAME);
	orgSearchBtn.click();
	driver.findElement(By.xpath("//a[.='"+ORGNAME+"']")).click();
	switchToWindow(driver, "Contacts");
	saveBtn.click();
}

}
