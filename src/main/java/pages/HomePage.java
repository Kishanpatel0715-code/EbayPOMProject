package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class HomePage extends TestBase{

	//page objects OR
	@FindBy(linkText =" Brand Outlet")
	public WebElement  Brand_Outlet;
	
	@FindBy(linkText = "Fashion")
	WebElement Fashion;
	
	@FindBy(linkText = "Motors")
	WebElement Motors;
	
	@FindBy(linkText = "Home & Garden")
	WebElement Home_Garden;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyBrandOutletLink() {
		return Brand_Outlet.isDisplayed();
	}
	
	public FashionPage verifyFashionLink() {
		Fashion.click();
		return new FashionPage();
		
	}
	
	public MotorsPage verifyMotorsLink() {
		 Motors.click();
		 return new MotorsPage();
			
	}
	
	public GardenPage verify_Home_GardenLink() {
		Home_Garden.click();
		return new GardenPage();
	}
}
