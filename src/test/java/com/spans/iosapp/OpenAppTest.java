package com.spans.iosapp;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.ios.IOSDriver;

public class OpenAppTest {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("deviceName", "iPhone 12 Pro");
		cap.setCapability("platformName", "ios");
		cap.setCapability("platformVersion", "14.5");
		cap.setCapability("bundleId", "com.apple.Health");
		
		
		IOSDriver<WebElement> driver=new IOSDriver<WebElement>(new URL("http://localhost:4723/wd/hub"),cap);
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		driver.findElementByXPath("//*[@name='Browse']").click();
		Thread.sleep(3000);
		
		
		
		
		//scroll until presence of otherdata name
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		while(driver.findElementsByXPath("//*[@name='Other Data']").size()==0)
		{
			driver.executeScript("mobile: scroll", ImmutableMap.of("direction", "down"));

		}
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.findElementByXPath("//*[@name='Other Data']").click();
		
		driver.findElementByXPath("//*[contains(@name,'Handwash')]").click();
		
		driver.findElementByXPath("//*[@name='Other Data']").click();
		
		driver.findElementByXPath("//*[@name='Add Data']").click();
	}

}



