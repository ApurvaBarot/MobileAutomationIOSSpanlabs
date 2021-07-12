package com.spans.iosapp;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.ios.IOSDriver;

public class WebAppTest {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("deviceName", "iPhone 12 Pro");
		cap.setCapability("platformName", "ios");
		cap.setCapability("platformVersion", "14.5");
		cap.setCapability("browserName", "safari");
		
		
		IOSDriver<WebElement> driver=new IOSDriver<WebElement>(new URL("http://localhost:4723/wd/hub"),cap);
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		driver.get("https://magento.com/");
		driver.findElementByXPath("//*[text()='Sign in']").click();
		
		driver.findElementByXPath("//*[@id='email']").sendKeys("hello");
	}

}
