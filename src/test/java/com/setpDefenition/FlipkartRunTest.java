package com.setpDefenition;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.setupBaseFile.BaseCode;

public class FlipkartRunTest extends BaseCode {
@BeforeMethod

public void FlipKartPopHandle() {
	PopHandle(By.xpath("//span[@role='button']"));
}
@Test
public void searchMobileTest() {
	WebElement searchBar = driver.findElement(By.xpath("//input[@name='q']"));
	searchBar.sendKeys("Mobile", Keys.ENTER);
	wait.until(ExpectedConditions.urlContains("Mobile"));
	String currentUrl = driver.getCurrentUrl().toLowerCase();
	System.out.println(currentUrl);
	Assert.assertTrue(currentUrl.contains("mobile"));
	System.out.println("Cookies size :"+driver.manage().getCookies().size());
	driver.manage().deleteAllCookies();
	System.out.println("Cookies size after deleting :"+driver.manage().getCookies().size());
	driver.navigate().refresh();
	System.out.println("Cookies size after refresh :"+driver.manage().getCookies().size());

	
}
}
