package page_objects;

import org.openqa.selenium.support.PageFactory;

import action_driver.Action_class;
import baseClass.BaseClass;

public class HolidayPage extends BaseClass {

	Action_class action= new Action_class();
	
	public HolidayPage() {

		PageFactory.initElements(getDriver(),this );

	}
	public String currenturl() {
		return action.getCurrentURL(getDriver());
	}
}
