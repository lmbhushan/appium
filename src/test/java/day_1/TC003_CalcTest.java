package day_1;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class TC003_CalcTest {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		DesiredCapabilities dc=new DesiredCapabilities();
		//dc.setCapability("deviceName","Medium Phone API 32");
//		dc.setCapability("platformName", "Android");
//		dc.setCapability("deviceName", "Pixel_3a_API_34_extension_level_7_x86_64");
//		//dc.setCapability("platformName", false);
		URL url=new URL("http://127.0.0.1:4723/wd/hub");
		AndroidDriver driver=new AndroidDriver(url,dc);
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "12");
		dc.setCapability("deviceName", "Pixel 4 API 31");
		dc.setCapability("udid", "emulator-5554");
		dc.setCapability("appPackage", "com.google.android.calculator");
		dc.setCapability("appActivity", "com.android.calculator2.Calculator");
		Thread.sleep(2000);
		driver.findElement(By.id("com.google.android.calculator:id/digit_9")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("com.google.android.calculator:id/op_add")).click();
		Thread.sleep(2000);
driver.findElement(By.id("com.google.android.calculator:id/digit_1")).click();
Thread.sleep(2000);
	}

}
