package tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {

	static AppiumDriver<MobileElement> driver;

	@BeforeTest
	public void setUp() {

		try {

			DesiredCapabilities caps = new DesiredCapabilities();

			caps.setCapability(MobileCapabilityType.DEVICE_NAME, "");
			caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");

			//caps.setCapability("platformName", "ANDROID");
			//caps.setCapability(CapabilityType.PLATFORM_NAME, "ANDROID");
			caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");

			//caps.setCapability(CapabilityType.VERSION, "9");
			caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");

			caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 2000);

			//APK path
			//caps.setCapability(MobileCapabilityType.APP, "");

			//appium --allow-insecure chromedriver_autodownload
			caps.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");

			URL url = new URL("http:/127.0.0.1:4723/wd/hub");

			driver = new AppiumDriver<MobileElement>(url, caps);
			//driver = new AndroidDriver<MobileElement>(url, caps);
			//driver = new IOSDriver<MobileElement>(url, caps);		

		} catch (MalformedURLException e) {
			System.out.println("The Cause is: " + e.getCause());
			System.out.println("Message is: " + e.getMessage());
			e.printStackTrace();

		}

	} 

	@AfterSuite
	public void tearDown() {
		driver.close();
		driver.quit();

	} 

}
