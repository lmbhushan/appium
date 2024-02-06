package day_2;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.appium.java_client.android.AndroidDriver;

public class Assignment_Main {
	AndroidDriver driver;
  @Test (dataProvider = "Test")
  public void Test(String name) throws InterruptedException, IOException {
	  long timestamp=new Date().getTime();
	  System.out.println("Time is :"+timestamp);
	  Assignment_POM obj =new Assignment_POM(driver);
	  
 // obj.radiobutton101();
  obj.radiobutton2nd();
  obj.enterfirstname(name);
  obj.clickonbutton();
  Thread.sleep(2000); 
  String title= driver.getTitle();
	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter spark=new ExtentSparkReporter(timestamp+"Appium.html"); 
	extent.attachReporter(spark);
	ExtentTest test=extent.createTest("Verify the Title of Bitbar");
	if(obj.isDisplayed())
	{
		test.pass("bitbar title is displyed");
	}
	else
	{
		Thread.sleep(3000);
		File sfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dfile=new File("C:\\Users\\bhushan.joshi\\eclipse-workspace\\Feb2024_Appium\\test-output\\Appiumphoto.png");
		FileUtils.copyFile(sfile, dfile);
		String path=dfile.getAbsolutePath();
		test.fail("bitbar is not displayed",
				MediaEntityBuilder
				.createScreenCaptureFromPath(path)
				.build());
	//	test.addScreenCaptureFromPath(path);
	}

  extent.flush();
  
  }
  
  
  @BeforeMethod
  public void beforeMethod() throws MalformedURLException {
	  DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("platformName", "Android");
		dc.setCapability("appium:deviceName", "Medium Phone API 32");
		dc.setCapability("appium:skipServerInstallation","true");
		dc.setCapability("appium:noReset", "true");
		dc.setCapability("appium:platformVersion","12.0");
		dc.setCapability("appium:app","D:\\Assignment\\bitbar-sample-app.apk");	
		
		
		URL url=new URL("http://127.0.0.1:4723/wd/hub");  // you have to go on appium server;
	 driver= new AndroidDriver(url, dc);	
		
  }

  @AfterMethod
  public void afterMethod() {
  }


  @DataProvider
  public Object[][] Test() {
    return new Object[][] {
      new Object[] {"Bhushan"},
      
    };
  }
}