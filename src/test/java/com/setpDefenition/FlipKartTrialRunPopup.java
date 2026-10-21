package com.setpDefenition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipKartTrialRunPopup {
public static void main(String [] args) {
	WebDriver driver = new ChromeDriver();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	driver.get("https://www.flipkart.com/");
	driver.manage().window().maximize();
	try {
		By locatorPop = By.xpath("//span[@role='button']");
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
}
