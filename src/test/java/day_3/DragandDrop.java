package day_3;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.ElementOption;

public class DragandDrop {
	public static void main(String[]args) throws MalformedURLException, InterruptedException {
	
	DesiredCapabilities dc = new DesiredCapabilities();
	dc.setCapability("platformName", "Android");
	dc.setCapability("deviceName", "Medium Phone API 32");
	dc.setCapability("skipServerInstallation", "true");
	dc.setCapability("noReset", "true");
	dc.setCapability("platformVersion", "12.0");
	dc.setCapability("app", "D:\\New folder\\com.mobeta.android.demodslv_2013-01-11.apk");
	URL url = new URL("http://127.0.0.1:4723/wd/hub");
	AndroidDriver driver=new AndroidDriver(url,dc);
	Thread.sleep(1000);
    driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.mobeta.android.demodslv:id/activity_desc\" and @text=\"Use the menu to adjust settings related to item removal and drag initiation. These options are provided by the DragSortController class.\"]")).click();
    Thread.sleep(1000);
    WebElement source = driver.findElements(By.id("com.mobeta.android.demodslv:id/drag_handle")).get(4);
    WebElement target = driver.findElements(By.id("com.mobeta.android.demodslv:id/drag_handle")).get(2);

    TouchAction action=new TouchAction(driver);
    action.longPress(ElementOption.element(source)).moveTo(ElementOption.element(target)).release().perform();

  }

}
