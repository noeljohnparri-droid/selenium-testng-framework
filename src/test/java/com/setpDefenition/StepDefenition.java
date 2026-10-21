package com.setpDefenition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefenition {
	WebDriver driver;
	@Given("user launches the website page")
	public void user_launches_the_website_page() {
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();;
	}

	@When("user give valid credentials")
	public void user_give_valid_credentials() {
		WebElement username = driver.findElement(By.xpath("//input[@id='user-name']"));
		username.sendKeys("standard_user");
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		password.sendKeys("secret_sauce");
		
	}

	@When("user click on login button")
	public void user_click_on_login_button() {
	    WebElement loginbutton = driver.findElement(By.xpath("//input[@id='login-button']"));
		loginbutton.click();
	}

	@Then("user should enter the account page")
	public void user_should_enter_the_account_page_and_see_dashboard() {
	    String currenturl = driver.getCurrentUrl();
	    Assert.assertTrue(currenturl.contains("inventory"));
	    System.out.println("Login test successful");
	    driver.quit();
	}
	@When("user enter invalid credentials")
	public void user_enter_invalid_credentials() {
		WebElement username = driver.findElement(By.xpath("//input[@id='user-name']"));
		username.sendKeys("standard_u");
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		password.sendKeys("secret_sa");
	}

	@Then("user should see an error message")
	public void user_should_see_an_error_message() {
		String errormsg = driver.findElement(By.tagName("h3")).getText();
		Assert.assertTrue(errormsg.contains("Epic sadface: Username and password do not match any user in this service"));
		System.out.println("Invalid Login Test Passed");
		driver.quit();
	}
	@When("user enters valid username {string}")
	public void user_enters_valid_username(String username) {
		WebElement Username = driver.findElement(By.xpath("//input[@id='user-name']"));
		Username.sendKeys(username);
		
	}

	@When("user enter valid password {string}")
	public void user_enter_valid_password(String password) {
		WebElement Password = driver.findElement(By.xpath("//input[@id='password']"));
		Password.sendKeys(password);
	}
	@Then("login should be {string}")
	public void login_should_be(String result) {
	    String currenturl = driver.getCurrentUrl();
	    	
	    }
	}


