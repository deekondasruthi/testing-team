package page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import action_driver.Action_class;
import baseClass.BaseClass;

public class HomePage extends BaseClass{
	
	@FindBy(xpath = ("//span[ text()='Main Master']"))
    private WebElement mster;
	
	@FindBy(xpath = "//li[text()='Government Holiday ']")
	private WebElement holi; 
	
	
	Action_class action= new Action_class();

	public HomePage() {
		
		PageFactory.initElements(getDriver(),this );
		
		}
	
	public mainMasterPage mainMaster() {
		
		
		action.click(getDriver(), mster);
		
		return new mainMasterPage();
		
		
	}
	public HolidayPage toValidateHolibtn() {
		action.click(getDriver(), holi);
		action.implicitWait(getDriver(), 5);
		return new HolidayPage();
		
	}
	
	
	
	
	
	
	
	
}
