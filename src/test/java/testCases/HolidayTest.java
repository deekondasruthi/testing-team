package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import page_objects.HolidayPage;
import page_objects.HomePage;
import page_objects.LoginPage;
import page_objects.mainMasterPage;
import utilities.Log;

public class HolidayTest extends BaseClass{
	
	LoginPage loginPage;

	HomePage homePage;

	mainMasterPage masterPage;

	HolidayPage holidayPage;

	@BeforeMethod()
	
	public void setup() throws InterruptedException {
		
		launchApp("chrome");
		loginPage = new LoginPage();
		loginPage.Email("majeeth.h@babujiventures.in");
		loginPage.Pass("Test@123");
		homePage = loginPage.SubBtn();

		// Wait for HomePage to load
		Thread.sleep(3000);

		// Navigate to Main Master Page
		masterPage = homePage.mainMaster();
		holidayPage=masterPage.validateHoliBtn();
		holidayPage=new HolidayPage();
		
		Thread.sleep(3000);



	}
	
	@Test
	public void HolidayCreationTest() {
		Log.startTestCase(" Test for create Holiday");
		holidayPage.CreateFunc();
		boolean result=holidayPage.foundIsDisplayed();
		Assert.assertFalse(result);
		Log.endTestCase(" Test for create Holiday");

	}
	
	
	@AfterMethod()
	
	public void tearDown() {
		getDriver().quit();
	}
	
	
	
}
