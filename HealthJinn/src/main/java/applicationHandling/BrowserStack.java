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

public class BrowserStack {
	
	public static WebDriver driver;

	/*
	 * public static final String USERNAME = "abhishekchauhan5"; public static final
	 * String AUTOMATE_KEY = "W8rh7pEypuzvDm2yb4Pw"; public static final String URL
	 * = "https://" + USERNAME + ":" + AUTOMATE_KEY +
	 * "@hub-cloud.browserstack.com/wd/hub";
	 */
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities caps = new DesiredCapabilities();
		/*
		 * caps.setCapability("browserName", "android"); caps.setCapability("device",
		 * "Google Pixel"); caps.setCapability("realMobile", "true");
		 * caps.setCapability("os_version", "7.1");
		 * caps.setCapability("browserstack.local", "false");
		 * caps.setCapability("browserstack.debug", "true");
		 */
		caps.setCapability("reportDirectory", "reports");
        caps.setCapability("reportFormat", "xml");
        caps.setCapability("testName", "Untitled");
		caps.setCapability(MobileCapabilityType.UDID, "9886674e5258475a46");
	    caps.setCapability("accessKey","eyJ4cC51Ijo1NjU0MDg2LCJ4cC5wIjo1NjU0MDg1LCJ4cC5tIjoiTVRVMU16YzJOemd5TXpreE5nIiwiYWxnIjoiSFMyNTYifQ.eyJleHAiOjE4NjkxMjc4MjUsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.7NjoXLOGJnRarZN0zreiXAXLX33NH_EI5sJJsT7CTgY");

		caps.setCapability("appPackage", "com.amhi.healthjinn");
		caps.setCapability ("appActivity","com.amhi.healthjinn.MainActivity"); 
	    //driver = new RemoteWebDriver(new java.net.URL(URL), caps);
		driver = new AndroidDriver(new URL("https://cloud.seetest.io:443/wd/hub"), caps);
	    
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
		
		driver.quit();


	}

}
