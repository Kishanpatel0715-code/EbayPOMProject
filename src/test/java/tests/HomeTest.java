package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.FashionPage;
import pages.GardenPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MotorsPage;

public class HomeTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	FashionPage fashionPage;
	MotorsPage motorsPage;
	GardenPage gardenPage;
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		loginPage = new LoginPage();
		homePage  = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.getHomePageTitle();
		Assert.assertEquals(homePageTitle, "Electronics, Cars, Fashion, Collectibles & More | eBay");
	}
	
	@Test(priority = 2)
	public void verifyBrand_OutletTest() {
		boolean b = homePage.verifyBrandOutletLink();
		Assert.assertTrue(b);
	}
	
	@Test(priority = 3)
	public void verifyFashionLinkTest() {
		fashionPage = homePage.verifyFashionLink();
	}
	
	@Test(priority = 4)
	public void verifyMotorsLink() {
		motorsPage = homePage.verifyMotorsLink();
	}
	
	@Test(priority = 5)
	public void verify_Home_GardenLink() {
		gardenPage = homePage.verify_Home_GardenLink();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
