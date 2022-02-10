package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class LoginPage extends TestBase{

	//page objects or object repository //page elements
	@FindBy(linkText ="create an account")
	WebElement account_Logo;
	
	@FindBy(id = "userid")
	WebElement email; 
	
	@FindBy(id = "signin-continue-btn")
	WebElement FirstClick;
	
	@FindBy(id = "pass")
	WebElement password;
	
	@FindBy(id = "sgnBt")
	WebElement loginBtn;
	
	//initialize the page factory
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//define the methods
	public String verifyLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyaccountLogo() {
		return account_Logo.isDisplayed();
	}
	
	public HomePage doLogin(String em,String pwd) throws InterruptedException {
		email.sendKeys(em);
		FirstClick.click();
		Thread.sleep(2000);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
	}
	
}
