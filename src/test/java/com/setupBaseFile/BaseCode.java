package com.setupBaseFile;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BaseCode {
protected WebDriver driver;
protected WebDriverWait wait;
String url;
@Parameters({"browser", "url"})
@BeforeMethod
public void launchUrl(@Optional ("chrome")String browser, @Optional("https://www.flipkart.com/")String url) {
	switch(browser.toLowerCase()) {
	case "chrome":
		driver = new ChromeDriver();
		break;
	case "edge":
		driver = new EdgeDriver();
		break;
	case "firefox":
		driver = new FirefoxDriver();
		break;
	default :
		throw new IllegalArgumentException("Browser not supported: " + browser);

	}
	wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	driver.get(url);
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
}

protected void PopHandle(By locatorPop) {
	try {
		WebElement pop = wait.until(ExpectedConditions.visibilityOfElementLocated(locatorPop));
		pop.click();
		
	}
	catch(TimeoutException e){
		String exceptionname = e.getClass().getSimpleName();
		System.out.println(exceptionname);
		System.out.println(e.getMessage());
		System.out.println("No pop up this time");
	}
	finally {
		System.out.println("Pop up handled");
	}
}
@AfterMethod(alwaysRun = true)
public void CloseUrl() {
	if(driver!=null) {
	driver.quit();
	}
}
}
