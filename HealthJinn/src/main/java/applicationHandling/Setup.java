package applicationHandling;

import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

/*import static GenericLab.ActionDrivers.waitForPresenceOfElelment;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;*/

public class Setup {

	//public static AndroidDriver driver;
	public static WebDriver driver;
	public static final String USERNAME = "abhishekchauhan5";
	public static final String AUTOMATE_KEY = "bb5f832e3ee56f952af3f8ae1983b4de9e4b0951";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

	@Parameters({"udid"})
	@BeforeTest
	public static void openApplication(String udid) throws MalformedURLException, InterruptedException {
		
		DesiredCapabilities caps = new DesiredCapabilities();
		/*
		 * DesiredCapabilities cap = new DesiredCapabilities();
		 * 
		 * cap.setCapability("platformName", "Android"); cap.setCapability("deviceName",
		 * "Moto E"); cap.setCapability("noReset", true);
		 * cap.setCapability(CapabilityType.VERSION,"7.1.2");
		 * cap.setCapability("automationName", "uiautomator2");
		 * cap.setCapability("appPackage", "com.amhi.healthjinn"); cap.setCapability
		 * ("appActivity","com.amhi.healthjinn.MainActivity"); driver = new
		 * AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
		 * System.out.println(driver);
		 * 
		 * driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 */
		 

		/*
		 * // Setup for Browserstack
		 * 
		 * DesiredCapabilities caps = new DesiredCapabilities();
		 * caps.setCapability("browserName", "android"); caps.setCapability("device",
		 * "Google Pixel"); caps.setCapability("realMobile", "true");
		 * caps.setCapability("os_version", "7.1");
		 * 
		 * caps.setCapability("appPackage", "com.amhi.healthjinn"); caps.setCapability
		 * ("appActivity","com.amhi.healthjinn.MainActivity"); driver = new
		 * RemoteWebDriver(new URL(URL), caps);
		 */
		
		caps.setCapability("reportDirectory", "reports");
        caps.setCapability("reportFormat", "xml");
        caps.setCapability("testName", "Untitled");
		caps.setCapability(MobileCapabilityType.UDID, "50444f5434573398");
	    caps.setCapability("accessKey","eyJ4cC51Ijo1NDE2NjkwLCJ4cC5wIjo1NDE2Njg5LCJ4cC5tIjoiTVRVMU16QTNNak14TnpFd09BIiwiYWxnIjoiSFMyNTYifQ.eyJleHAiOjE4Njg0MzIzMTgsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.SbZSzdp3nQnRcuY6F3Js93WyzPguBNuFlPBcgT88TJ4");

		caps.setCapability("appPackage", "com.amhi.healthjinn");
		caps.setCapability ("appActivity","com.amhi.healthjinn.MainActivity"); 
	    //driver = new RemoteWebDriver(new java.net.URL(URL), caps);
		driver = new AndroidDriver(new URL("https://cloud.seetest.io:443/wd/hub"), caps);
		
		int count=3;
	       By str1 = By.id("com.amhi.healthjinn:id/btnNext");
	       
	       if(str1 != null )
	           System.out.println("Proceed...");
	       else{
	           for(int i=0;i<count;i++) {
	               driver.findElement(By.id("com.amhi.healthjinn:id/btnNext")).click();
	           } }
	}

	@Test
	public void loginViaOTP() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.id("com.amhi.healthjinn:id/login_using_otp")).click();
		driver.findElement(By.xpath("//*[@text='Phone Number / Email Id']")).sendKeys("gm17@gmail.com");
		driver.findElement(By.xpath("//*[@text='SEND OTP']")).click();
		driver.findElement(By.id("com.amhi.healthjinn:id/text_1")).sendKeys("1");
		driver.findElement(By.id("com.amhi.healthjinn:id/text_2")).sendKeys("2");
		driver.findElement(By.id("com.amhi.healthjinn:id/text_3")).sendKeys("3");
		driver.findElement(By.id("com.amhi.healthjinn:id/text_4")).sendKeys("4");
		driver.findElement(By.id("com.amhi.healthjinn:id/btnRight")).click();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
	}

	@AfterTest
	public void End() {
		driver.quit();
	}
}
