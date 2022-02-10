package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	public LoginTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		
	}
	
	@Test(priority = 1)
	public void verifyLoginTitleTest() {
		String loginTitle = loginPage.verifyLoginPageTitle();
		Assert.assertEquals(loginTitle, "Sign in or Register | eBay");
	}
	
	@Test(priority = 2)
	public void verifyWelcomeLogoTest() {
		boolean welcome_logo = loginPage.verifyaccountLogo();
		Assert.assertTrue(welcome_logo);
	}
	
	
	@Test(priority = 3)
	public void doLoginTest() throws InterruptedException {
		homePage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
