package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import page_objects.HomePage;
import page_objects.LoginPage;

public class LoginTest extends BaseClass {
	
	
	
	LoginPage loginPage;
	 HomePage homePage;
	
	@BeforeMethod()
	public void setup() {
	launchApp("chrome");
	
	}
	@Test
	public void loginTest()   throws Throwable{
		loginPage=new LoginPage();
		loginPage.Email("majeeth.h@babujiventures.in");
		loginPage.Pass("Test@123");
		homePage =loginPage.SubBtn();
	    Thread.sleep(3000);
		String expectedUrl ="https://staging-mmsadmin.basispay.in/sidenav/dashboard";
		String actualUrl=loginPage.CurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl,"Login failed: URLs do not match.");
		}

	
	@AfterMethod()
	public void tearDown() {
		getDriver().quit();
	}
	
}
