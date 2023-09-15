package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage 
{
@FindBy(xpath ="//img[@alt='Create Organization...']")
private WebElement CreateOrgImg;
 
public OrganizationPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public WebElement getCreateOrgImg() {
	return CreateOrgImg;
}
//business library
public void clickOnCreateOrgImg()
{
	CreateOrgImg.click();
}
}
