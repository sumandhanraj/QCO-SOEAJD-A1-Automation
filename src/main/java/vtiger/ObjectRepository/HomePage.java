package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.WebDriverUtility;

public class HomePage extends WebDriverUtility//rule 1 classname should b pagewise
{
	//rule 2 identify the locators
@FindBy(linkText = "Organizations")
private WebElement organizationLnk;

@FindBy(xpath = "//a[.='Contacts']")
private WebElement contactLnk;

@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
private WebElement adminstratorTag;

@FindBy(linkText = "Sign Out")
private WebElement signOutLink;


//rule 3 create a constructor
public HomePage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public WebElement getOrganizationLnk() {
	return organizationLnk;
}


public WebElement getContactLnk() {
	return contactLnk;
}

public void setContactLnk(WebElement contactLnk) {
	this.contactLnk = contactLnk;
}

public WebElement getAdminstratorTag() {
	return adminstratorTag;
}

public WebElement getSignOutLink() {
	return signOutLink;
}

//business library
/**
 * this method click on organization link
 */
public void clickOnOrganizationLink()
{
	organizationLnk.click();
	
}


public void clickOnContactsLink()
{
	contactLnk.click();
}
/**
 * this method will logout the application
 * @param driver
 * @throws Throwable
 */
public void logoutOfApplication(WebDriver driver) throws Throwable
{
	mouseHoverAction(driver, adminstratorTag);
	Thread.sleep(1000);
	signOutLink.click();
}
}
