package com.spans.iosapp;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.ios.IOSDriver;

public class OpenAppTest2 {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("deviceName", "iPhone 11");
		cap.setCapability("platformName", "ios");
		cap.setCapability("platformVersion", "14.5");
		cap.setCapability("bundleId", "com.apple.Health");
		
		
		IOSDriver<WebElement> driver=new IOSDriver<WebElement>(new URL("http://localhost:4723/wd/hub"),cap);
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		
	
		
		driver.findElementByIosNsPredicate("name=='Browse'").click();
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
		
		//driver.findElementByXPath("//*[@name='Other Data']").click();
		
		driver.findElementByXPath("//*[@name='Add Data']").click();
		
		
		HashMap<String, String> map=new HashMap<String, String>();
		map.put("bundleId", "com.apple.Health");
	    boolean result=(Boolean) driver.executeScript("mobile: terminateApp", map);
		System.out.println(result);
		
		result=(Boolean) driver.executeScript("mobile: isAppInstalled", map);
		System.out.println(result);
	
		
		
//		tap by coordinates
		HashMap<String, String> map1=new HashMap<String, String>();
		map1.put("x", "800");
		map1.put("y", "800");
		driver.executeScript("mobile: tap", map1);
		
		
		//tap by element 
		RemoteWebElement ele=(RemoteWebElement) driver.findElementByXPath("//*[@name='Add Data']");
		
		
		
		Point p= ele.getLocation();
		
		HashMap<String, Object> map2=new HashMap<String, Object>();	
		map2.put("elementId", ele.getId());
		map2.put("x", p.x);
		map2.put("y", p.y);
		driver.executeScript("mobile: tap", map2);
		
		
		HashMap<String, Object> map3=new HashMap<String, Object>();
		map3.put("x", p.x);
		map3.put("y", p.y);
		driver.executeScript("mobile: tap", map1);
		
	}

}






