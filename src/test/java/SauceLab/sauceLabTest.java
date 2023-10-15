package SauceLab;

import java.awt.List;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class sauceLabTest {
	
	public static AppiumDriver<MobileElement> driver;
	public  static EventFiringWebDriver e_driver;
	public static Properties prop;
	public static DesiredCapabilities capabilities;
	
	public static void  scrollTo(String text)
	{
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\""+text+"\"))"));
	}
	
	@BeforeClass()
	public void setUp() throws MalformedURLException
	{
		capabilities = new DesiredCapabilities();
		capabilities.setCapability("appium-version", "1.22.0");
		capabilities.setCapability("platformName", "Android");
		//  capabilities.setCapability("newCommandTimeout", "6000");
		capabilities.setCapability("newCommandTimeout", 60 * 100);
		capabilities.setCapability("platformVersion", "11");
		capabilities.setCapability("deviceName", "Galaxy Note 10 Lite");
		capabilities.setCapability("udid", "353491090612551");
		capabilities.setCapability("appPackage", "com.swaglabsmobileapp");
		capabilities.setCapability("appActivity", "com.swaglabsmobileapp.SplashActivity");
		driver = new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@Test()
	public void sauceLabTask() throws InterruptedException
	{
		driver.findElementByAccessibilityId("test-Username").sendKeys("standard_user");
		driver.findElementByAccessibilityId("test-Password").sendKeys("secret_sauce");
		driver.findElementByAccessibilityId("test-LOGIN").click();
		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-Toggle\"]/android.widget.ImageView")).click();
		scrollTo("Test.allTheThings() T-Shirt (Red)");
		driver.findElement(By.xpath("(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[3]/android.widget.TextView")).click();
		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView")).click();
		boolean value1 =driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-Description\"]/android.widget.TextView[1]")).getText().contains("Test.allTheThings() T-Shirt (Red)");
		driver.findElementByAccessibilityId("test-CONTINUE SHOPPING").click();
		Thread.sleep(1000);
		boolean value2;
		try
		{
			 value2 = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.TextView")).getText().contains("1");
			
		}
		catch(Exception e)
		{
		 value2 = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.TextView")).getText().contains("1");
		}
		//boolean value2 = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.TextView")).getText().contains("1");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(value1);
		softAssert.assertTrue(value2);
		softAssert.assertAll();
		
		
		
		

		
		
		
		
	}

}
