package day_2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Assignment_POM {

	
	WebDriver driver;
	By radiobutton1 = By.id("com.bitbar.testdroid:id/radio0");
	By radiobutton2 = By.id("com.bitbar.testdroid:id/radio1");
	By Entername = By.id("com.bitbar.testdroid:id/editText1");
	By button = By.id("com.bitbar.testdroid:id/button1");
	By dashboard= By.id("com.bitbar.testdroid:id/textView2");

	public Assignment_POM(WebDriver driver2) {
		this.driver=driver2;
	}
//1
//	public void radiobutton101() {
//		driver.findElement(radiobutton1).click();
//	}
//2
	public void radiobutton2nd() {
		//driver.findElement(radiobutton2).click();
		WebElement rush =	driver.findElement(radiobutton2);
		rush.click();
		boolean isenable = rush.isEnabled();
		if(isenable)
		{
			System.out.println("It is Enabled properly");
		}else
		{
			System.out.println("It is not Enabled ");
		}
	}
	
	
	public void enterfirstname(String firstname) {
		driver.findElement(Entername).sendKeys(firstname);
	}
	

	public void clickonbutton() {
		driver.findElement(button).click();
	}
	
	public boolean isDisplayed() {
        boolean isdisplayed = driver.findElement(dashboard).isDisplayed();
        return isdisplayed;
            }
	
	
}
