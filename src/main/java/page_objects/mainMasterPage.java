package page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import action_driver.Action_class;
import baseClass.BaseClass;

public class mainMasterPage extends BaseClass{

	Action_class action=new Action_class();
	
	@FindBy(xpath = "//span[text()='Create']")
	private WebElement crtHoli;
	
	public mainMasterPage() {
		
		PageFactory.initElements(getDriver(),this);
	}
	
	
	
public void CreateHoli() {
		action.mouseHoverByJavaScript(getDriver(), crtHoli);
		action.click(getDriver(), crtHoli);
	}

}
