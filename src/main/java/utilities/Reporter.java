package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reporter {

	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static void StartReport() {
		ExtentSparkReporter reporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/"+"MyReport.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		test = extent.createTest("Merchant Panel");
		test.assignAuthor("Majeeth");
		test.assignCategory("End to End ");
		extent.setSystemInfo("Host"," BVpl");
		extent.setSystemInfo("OS", "Win10");
		extent.setSystemInfo("Browser", "Chrome");
	}
	public static void flushReport() {
		
		extent.flush();
	}
}
