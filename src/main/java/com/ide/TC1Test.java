package com.ide;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;

public class TC1Test {
	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;

	@Before
	public void setUp() {
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void tC1() {
		driver.get("https://magento.com/");
		driver.manage().window().setSize(new Dimension(1280, 800));
		{
			WebElement element = driver.findElement(By.id("gnav_213"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).perform();
		}
		{
			WebElement element = driver.findElement(By.id("gnav_466"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).perform();
		}
		driver.findElement(By.cssSelector("#gnav_557 > .feds-navLink-contentWrapper")).click();
		driver.findElement(By.id("email")).click();
		driver.findElement(By.id("email")).sendKeys("balaji0017@gmail.com");
		driver.findElement(By.id("pass")).click();
		driver.findElement(By.id("pass")).sendKeys("balaji@12345");
		driver.findElement(By.id("pass")).sendKeys(Keys.ENTER);
		driver.findElement(By.cssSelector(".-content")).click();
		vars.put("id", driver.findElement(By.cssSelector(".content > span")).getText());
		driver.findElement(By.cssSelector(".columns")).click();
		
		
		assertEquals(driver.findElement(By.cssSelector(".columns")).getText(), is(
				"ID: MAG004563920\\\\nLog Out\\\\nMy Account\\\\nAccount Settings\\\\nContact Information\\\\nChange Password\\\\nTwo-factor Authentication\\\\nBilling and Payments\\\\nDownloads Access Token\\\\nBilling History\\\\nTraining and Certification\\\\nAPI Portal\\\\nShared Access\\\\nSecurity Scan\\\\nMagento Identity Manager\\\\nMy Account\\\\nYour password has expired.\\\\n\\\\nIn order to safeguard your account, Magento requires that you change your password at least once every 90 days. Please re-enter your current password and select a new password.\\\\n\\\\nYour new password must be at least 12 characters long and include characters from at least three of the following four categories: upper case letters, lower case letters, numbers, special characters.\\\\nChange Password\\\\n* All indicated fields are required\\\\nCurrent Password\\\\nNew Password\\\\nPassword Strength: No Password\\\\nConfirm New Password\\\\nSave"));
		assertEquals(driver.findElement(By.cssSelector(".dashboard-top-menu")).getText(),
				is("My Account\\\\nMagento Partner Portal Marketplace"));
		{
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Log Out")));
		}
		{
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Log Out")));
		}
		driver.findElement(By.cssSelector(".columns")).click();
		{
			WebElement element = driver.findElement(By.cssSelector(".-content"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).perform();
		}
		{
			WebElement element = driver.findElement(By.linkText("Partner Portal"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).perform();
		}
		driver.findElement(By.linkText("Log Out")).click();
		System.out.println(vars.get("id").toString());
		if ((Boolean) js.executeScript("return (arguments[0] == \'ID: MAG004563920\')", vars.get("id"))) {
			System.out.println("passed");
		}
		if ((Boolean) js.executeScript("return (arguments[0] <= \'MAG004563920\')", vars.get("id"))) {
			System.out.println("passed");
		}
	}
}
