package page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import action_driver.Action_class;
import baseClass.BaseClass;

public class mainMasterPage extends BaseClass{

	Action_class action=new Action_class();
	
	@FindBy(xpath = "//span[text()='Create']")
	private WebElement clkHoli;
	@FindBy(xpath = "//li[text()='Government Holiday ']")
	private WebElement holi; 
<<<<<<< HEAD
	@FindBy(xpath = "//li[text()='Emails Configuration ']")
	private WebElement emailconf; 
=======
>>>>>>> dcb77796aad0418ada15a011dabf871566aaef84
	
	
	public mainMasterPage() {
		
		PageFactory.initElements(getDriver(),this);
	}
	
	public HolidayPage  validateHoliBtn() {
		action.explicitWait(getDriver(), holi, 3);
		action.click(getDriver(), holi);
		return new HolidayPage();
		
	}
	
<<<<<<< HEAD
	public EmailConfiguartionPage valiEmailconfBtn() {
		action.explicitWait(getDriver(), emailconf, 3);
		action.click(getDriver(), emailconf);
		
		return new EmailConfiguartionPage();
		
	}
	
=======
>>>>>>> dcb77796aad0418ada15a011dabf871566aaef84

	
}

