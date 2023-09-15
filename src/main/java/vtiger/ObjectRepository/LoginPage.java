package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage //rule 1 class name should be pagewise name
{
	//rule 2 identify the locators
@FindBy(name = "user_name")
private WebElement userNameEdt;

@FindBy(name = "user_password")
private WebElement passwordEdt;

@FindBy(id = "submitButton")
private WebElement loginBtn;




//ruke 3create a constructor
public LoginPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

//rule 4 provide getters
public WebElement getUserNameEdt() {
	return userNameEdt;
}

public WebElement getPasswordEdt() {
	return passwordEdt;
}

public WebElement getLoginBtn() {
	return loginBtn;
}

//business method
public void loginToApp(String USERNAME,String PASSWORD  )
{
	userNameEdt.sendKeys(USERNAME);
	passwordEdt.sendKeys(PASSWORD);
	loginBtn.click();
}
}
