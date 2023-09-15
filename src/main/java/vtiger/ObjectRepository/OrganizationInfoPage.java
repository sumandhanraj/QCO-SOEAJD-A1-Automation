package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage 
{
@FindBy(className = "dvHeaderText")
private WebElement orgHeaderText;

public OrganizationInfoPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public WebElement getOrgHeaderText() {
	return orgHeaderText;
}

//business library
public String getHeaderText()
{
	return orgHeaderText.getText();
}
}
