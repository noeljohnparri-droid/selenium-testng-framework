package com.setpDefenition;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AmazonProductSearch {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	String urlBefore; 
	@Given("user launches Amazon website")
	public void user_launches_amazon_website() {
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		js = (JavascriptExecutor) driver; 
		driver.manage().window().maximize();

	}

	@When("user finds searchbar, gives input as laptop and enters")
	public void user_finds_searchbar_gives_input_as_laptop_and_enters()throws Throwable {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='twotabsearchtextbox']")));
		WebElement searchbar = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		searchbar.sendKeys("Laptop", Keys.ENTER);
		
	}

	@When("user takes screenshot of the page and clicks on price filter")
	public void user_takes_screenshot_of_the_page_and_clicks_on_price_filter() throws Throwable {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-component-type='s-search-result']")));
		js.executeScript("window.scrollBy(0,500)");                       
		js.executeScript("window.scrollBy(0,500)");
	    TakesScreenshot screenshot = (TakesScreenshot) driver;                          // NEW
	    File source = screenshot.getScreenshotAs(OutputType.FILE);                      // NEW
	    File destination = new File("C:\\Users\\noelp\\OneDrive\\Documents\\Testing\\ProjectClass\\Cucumber\\Day 1\\Cucumber Task\\amazonLaptop.png");     
	    FileUtils.copyFile(source, destination);
		By firstPriceBucketLocator = By.xpath(                                    
		        "//span[text()='Price']/following::span[starts-with(normalize-space(text()),'Up to')][1]");
		WebElement firstPriceBucket = wait.until(ExpectedConditions.elementToBeClickable(firstPriceBucketLocator));
		    System.out.println("Clicking: " + firstPriceBucket.getText());
		    urlBefore = driver.getCurrentUrl(); 
		    try {
		        firstPriceBucket.click();
		    } catch (StaleElementReferenceException e) {
		        wait.until(ExpectedConditions.elementToBeClickable(firstPriceBucketLocator)).click();
		    }
			wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(urlBefore)));

		    wait.until(ExpectedConditions.visibilityOfElementLocated(                         
		            By.xpath("//div[@data-component-type='s-search-result']")));
	}

	@When("user takes screenshot of the page after clicking price filter")
	public void user_takes_screenshot_of_the_page_after_clicking_price_filter() throws Throwable {
		wait.until(ExpectedConditions.visibilityOfElementLocated(                          
	            By.xpath("//div[@data-component-type='s-search-result']")));
	    js.executeScript("window.scrollBy(0,500)");
	    TakesScreenshot screenshot = (TakesScreenshot) driver;                          

	    File source1 = screenshot.getScreenshotAs(OutputType.FILE);
	    File destination1 = new File("C:\\Users\\noelp\\OneDrive\\Documents\\Testing\\ProjectClass\\Cucumber\\Day 1\\Cucumber Task\\amazonLaptopFilter.png");     
	    FileUtils.copyFile(source1, destination1);
	}

	@Then("prices on the laptop should show difference")
	public void prices_on_the_laptop_should_show_difference() {
	    Assert.assertNotEquals(driver.getCurrentUrl(), urlBefore, "Price filter not applied");
	    driver.quit();                                                                         

	}

}
