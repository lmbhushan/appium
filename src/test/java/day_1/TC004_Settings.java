package day_1;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class TC004_Settings {
	final DesiredCapabilities capabilities=new DesiredCapabilities()
	capabilities.setcapability("deviceName","Android Emulator")
	capabilities.setcapability("appPackage","com.android.settings")
	capabilities.setCapability("appActivity","settings");
	URL url1=new URL("http://127.0.0.1:4723/wd/hub");
	AndroidDriver driver=new AndroidDriver(url1,capabilities);
}


