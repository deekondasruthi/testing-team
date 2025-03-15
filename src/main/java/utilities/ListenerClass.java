package utilities;




import java.io.File;
import org.testng.ITestListener;
import org.testng.ITestResult;

import action_driver.Action_class;
import baseClass.BaseClass;

public class ListenerClass  implements ITestListener {
	
	Action_class action =new Action_class();
	@Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test passed: " + result.getName());
    }

   
    	@Override
    	public void onTestFailure(ITestResult result) {
    	    if (result.getStatus() == ITestResult.FAILURE) {
    	        try {
    	            // Ensure WebDriver is valid
    	            if (BaseClass.getDriver() != null) {
    	                // Capture screenshot
    	                File imgPath = action.screenShot(BaseClass.getDriver(), result.getName());
    	                System.out.println("Screenshot captured for failed test: " + imgPath.getAbsolutePath());
    	            } else {
    	                System.err.println("WebDriver instance is null. Unable to capture screenshot.");
    	            }
    	        } catch (Exception e) {
    	            System.err.println("Error while capturing screenshot: " + e.getMessage());
    	        }
    	    }
    	}

    

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test skipped: " + result.getName());
    }
}
