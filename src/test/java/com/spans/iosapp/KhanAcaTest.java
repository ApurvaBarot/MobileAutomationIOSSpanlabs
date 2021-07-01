package com.spans.iosapp;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class KhanAcaTest {

	public static void main(String[] args) throws MalformedURLException {
		
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "iPad");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "ios");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "14.6");
		cap.setCapability(MobileCapabilityType.UDID, "417da800b3114ff6776f5c37c65974d071364376");
		cap.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "org.khanacademy.Khan-Academy");
		
		IOSDriver<WebElement> driver=new IOSDriver<WebElement>(new URL("http://localhost:4723/wd/hub"),cap);
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		driver.findElementByName("Search").click();
		
		driver.findElementByXPath("//XCUIElementTypeButton[@name='Math']").click();
		
//		name=='Math' and type=='XCUIElementTypeButton'
		System.out.println(driver.findElementsByXPath("//XCUIElementTypeButton[@name='Get ready for Precalculus']").size());
		System.out.println(driver.findElementByXPath("//XCUIElementTypeButton[@name='Get ready for Precalculus']").isDisplayed());
		
		
	   List<WebElement>	elements=	driver.findElementsByXPath("//XCUIElementTypeButton");
	   
	   
	   for( WebElement ele : elements)
	   {
		   System.out.println(ele.getAttribute("name"));
	   }
		
		
		while(!driver.findElementByXPath("//XCUIElementTypeButton[@name='Get ready for Precalculus']").isDisplayed())
		{
			driver.executeScript("mobile: scroll", ImmutableMap.of("direction", "down"));
		}
		
		driver.findElementByXPath("//XCUIElementTypeButton[@name='Get ready for Precalculus']").click();
		
	}

}




