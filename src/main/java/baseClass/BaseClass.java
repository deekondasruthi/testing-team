package baseClass;



import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	//public static Properties prop;
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();


	public WebDriver getDriver() {

		return driver.get();		

	}
//	@BeforeSuite()
//
//	public void loadConfig() throws IOException {
//
//
//		prop = new Properties();
//		FileInputStream ip = new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\1\\Configuration\\config.properties");
//		prop.load(ip);
//	}
//

    public  void launchApp(String browserName) {

    	if (browserName.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
          //  options.addArguments("--headless"); // Enable headless mode
          //  options.addArguments("--disable-gpu"); // Optional: Disable GPU rendering for compatibility
        //    options.addArguments("--no-sandbox"); // Required for running in Jenkins
        //    options.addArguments("--disable-dev-shm-usage"); // Reduce resource usage
            driver.set(new ChromeDriver(options));
        } else if (browserName.equalsIgnoreCase("FireFox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless"); // Enable headless mode
            driver.set(new FirefoxDriver(options));
        } else if (browserName.equalsIgnoreCase("IE")) {
            WebDriverManager.iedriver().setup();
            driver.set(new InternetExplorerDriver()); // Note: IE does not support headless mode
        }
    
	
    getDriver().manage().window().maximize();
	//Delete all the cookies
	getDriver().manage().deleteAllCookies();
	//Implicit TimeOuts
	getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
	
	//PageLoad TimeOuts
	getDriver().manage().timeouts().pageLoadTimeout(Duration.ofMillis(20000));
	
	//Launching the URL
	getDriver().get("https:staging-mmsadmin.basispay.in/login");


}
}
