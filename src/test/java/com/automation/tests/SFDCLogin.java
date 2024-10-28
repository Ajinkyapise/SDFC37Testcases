package com.automation.tests;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.automation.pages.base.basePage;
import com.automation.utility.Constants;
import com.automation.utility.PropertiesUtility;

public class SFDCLogin extends basePage {
	String username = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "username");
	String passString = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "password");
	Logger mylog;

	@Test
	public void Test1() throws InterruptedException {
		launchBrowser("safari");
		driver.get("https://login.salesforce.com/");

		WebDriverWait wait = new WebDriverWait(driver, 10);

		WebElement users = driver.findElement(By.id("username"));
		enterText(users, "admin123@gmail.com", "username");

		WebElement passElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("password")));
		enterText(passElement, "", "password");

		WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("Login")));
		buttonClick(loginButton, "login");

		WebElement pass = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("error")));
		String actualText = "Please enter your password.";
		checkText(pass, actualText, "Password Error Message");

		close("Test1");
	}

	@Test
	public void Test2() throws InterruptedException {
		launchBrowser("safari");
		driver.get("https://login.salesforce.com/");

		WebElement users = driver.findElement(By.id("username"));
		enterText(users, "ajinkyapise@gmail.com", "username");

		WebElement pass = driver.findElement(By.id("password"));
		enterText(pass, "Ajinkya@3599", "password");

		WebElement loginButton = driver.findElement(By.id("Login"));
		buttonClick(loginButton, "login");

		pageloadCheckbyid("userNavLabel", "Home Page");

		close("Test2");
	}

	@Test
	public void Test3() throws InterruptedException {

		launchBrowser("safari");
		driver.get("https://login.salesforce.com/");

		String uname = "ajinkyapise@gmail.com";
		WebElement users = driver.findElement(By.id("username"));
		enterText(users, uname, "username");

		WebElement pass = driver.findElement(By.id("password"));
		enterText(pass, "Ajinkya@3599", "password");

		WebElement remeberMeButton = driver.findElement(By.id("rememberUn"));
		buttonClick(remeberMeButton, "Remember Me");

		WebElement loginButton = driver.findElement(By.id("Login"));
		buttonClick(loginButton, "login");

		pageloadCheckbyid("userNavLabel", "Home Page");

		WebElement usname2 = driver.findElement(By.id("userNavLabel"));
		checkText(usname2, "NewAjinkya Newpise", "Name");

		WebElement menuButton = driver.findElement(By.id("userNavLabel"));
		buttonClick(menuButton, "Remember Me");

		WebElement logoutButton = driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[5]"));
		buttonClick(logoutButton, "Logged Out");

		pageloadCheckbyid("Login", "Login Page");

		WebElement savedUserName = driver.findElement(By.id("idcard-identity"));
		checkText(savedUserName, uname, "Saved UserName");

		close("Test3");
	}

	@Test
	public void Test4a() throws InterruptedException {

		launchBrowser("safari");
		driver.get("https://login.salesforce.com/");

		WebElement forgotPass = driver.findElement(By.id("forgot_password_link"));
		buttonClick(forgotPass, "Forgot Password");
		pageloadCheckbyid("un", "Forgot Password Page");
		WebElement userName = driver.findElement(By.id("un"));
		enterText(userName, "ajinkyapise@gmail.com", "UserName");
		WebElement contnuElement = driver.findElement(By.id("continue"));
		buttonClick(contnuElement, "Continue");
		Thread.sleep(2000);
		pageloadCheckbyxpath("//*[@id=\"forgotPassForm\"]/a", "Check Your Email Page");

		WebElement text = driver.findElement(By.xpath("//*[@id=\"forgotPassForm\"]/div/p[1]"));
		checkText(text, "We’ve sent you an email with a link to finish resetting your password.",
				"Password Error Message");

		WebElement returnToLogin = driver.findElement(By.xpath("//*[@id=\"forgotPassForm\"]/a"));
		buttonClick(returnToLogin, "Return To Login");

		pageloadCheckbyid("Login", "Login Page");

		close("Test4A");
	}

	@Test
	public void Test4b() throws InterruptedException {

		launchBrowser("safari");
		driver.get("https://login.salesforce.com/");
		pageloadCheckbyid("Login", "Login Page");
		WebElement users = driver.findElement(By.id("username"));
		enterText(users, "123", "username");

		WebElement pass = driver.findElement(By.id("password"));
		enterText(pass, "22131", "password");

		WebElement loginButton = driver.findElement(By.id("Login"));
		buttonClick(loginButton, "login");
		Thread.sleep(2000);
		pageloadCheckbyid("Login", "Login Page");

		WebElement ele = driver.findElement(By.xpath("//*[@id=\"error\"]"));
		String actualText = "Your login attempt has failed. The username or password may be incorrect, or your location or login time may be restricted. Please contact the administrator at your company for help";
		String obj = "Error Message";
		checkText(ele, actualText, obj);

		close("Test4");
	}

}
