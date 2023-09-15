package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage
{
@FindBy(xpath = "//img[@alt='Create Contact...']")
private WebElement createContactLookUpImg;
 
public ContactPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public WebElement getCreateContactLookUpImg() {
	return createContactLookUpImg;
}

//business lib
public void createContact()
{
	createContactLookUpImg.click();
}
}
