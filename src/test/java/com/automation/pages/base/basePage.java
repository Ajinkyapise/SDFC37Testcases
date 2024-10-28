package com.automation.pages.base;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.base.baseTest;
import com.automation.utility.Constants;
import com.automation.utility.ExtentReportsUtility;
import com.automation.utility.PropertiesUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class basePage extends baseTest {

	private final Logger log = LogManager.getLogger(basePage.class);
	protected ExtentReportsUtility extentReport = ExtentReportsUtility.getInstance();

	String usernameString = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "username");
	String passwordString = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "password");

	String urlString = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "url");

	public void launchBrowser(String browserName) throws InterruptedException {
		switch (browserName.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		case "safari":
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
			break;

		default:
			System.out.println("Browser not supported. Please provide a valid browser name.");
			break;
		}

	}

	public void enterText(WebElement element, String data, String objName) {
		try {
			element.clear();
			element.sendKeys(data);
			logTestInfo("Data entered in " + objName + ": " + data);
		} catch (Exception e) {
			logTestError("Error entering text in " + objName, e);
		}
	}

	public void checkText(WebElement element, String expectedText, String objName) {

		try {
			String actualText = element.getText();
			if (actualText.equals(expectedText)) {
				logTestInfo("Correct " + objName + " is present.");
			} else {
				log.warn(objName + " is not present.");
				extentReport.logTestFailed(objName + " is not present.");
			}
		} catch (Exception e) {
			logTestError("An error occurred while checking the text of " + objName + ": ", e);

		}
	}

	public void buttonClick(WebElement element, String objName) {
		try {
			element.click();
			logTestInfo(objName + " button clicked.");
		} catch (Exception e) {
			logTestError("Error clicking button " + objName, e);
		}
	}

	public void close(String testName) {
		try {
			logTestInfo("Closing browser for test: " + testName);
			driver.quit();
			logTestInfo(testName + " is completed and browser closed.");
		} catch (Exception e) {
			logTestError("An error occurred while closing the browser for test: " + testName, e);
		}
	}

//	public void checkTitle(String expectedTitle, String objName) {
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		try {
//
//			wait.until(ExpectedConditions.titleIs(expectedTitle));
//			String actualTitle = driver.getTitle();
//			log.debug("Found title: " + actualTitle);
//			if (actualTitle.equals(expectedTitle)) {
//				logTestInfo(objName + " was opened.");
//			} else {
//				log.warn(objName + " was not opened.");
//				extentReport.logTestFailed(objName + " was not opened.");
//			}
//		} catch (Exception e) {
//			logTestError("Error checking title for " + objName, e);
//		}
//	}

//Helper Methods

	private void logTestInfo(String message) {
		log.info(message);
		extentReport.logTestInfo(message);
	}

	private void logTestError(String message, Exception e) {
		log.error(message, e);
		extentReport.logTestFailedWithException(e);
	}

	public void pageloadCheckbyid(String id, String pageName) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement usname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
			logTestInfo(pageName + " has been loaded");
		} catch (Exception e) {
			logTestError("An error occurred while loading " + pageName + " by ID: " + id, e);
			close(pageName);
		}
	}

	public void pageloadCheckbyxpath(String xpath, String pageName) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement usname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			logTestInfo(pageName + " has been loaded");
		} catch (Exception e) {
			logTestError("An error occurred while loading " + pageName + " by XPath: " + xpath, e);
		}
	}

	public void pageloadCheckbytext(String text, String pageName) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement usname = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'" + text + "')]")));
			logTestInfo(pageName + " has been loaded");
		} catch (Exception e) {
			logTestError("An error occurred while loading " + pageName + " by text: " + text, e);
		}
	}

	public void LoginWpass(String browserName) {
		try {
			launchBrowser(browserName);

			driver.get(urlString);

			WebElement users = driver.findElement(By.id("username"));
			enterText(users, usernameString, "username");

			WebElement pass = driver.findElement(By.id("password"));
			enterText(pass, passwordString, "password");

			WebElement loginButton = driver.findElement(By.id("Login"));
			buttonClick(loginButton, "login");

			pageloadCheckbyid("userNavLabel", "Home Page");
		} catch (Exception e) {
			logTestError("An error occurred during login with browser: " + browserName, e);
		}
	}

	public void Logout() {
		try {
			Thread.sleep(2000);
			WebElement menuButton = driver.findElement(By.id("userNavLabel"));
			buttonClick(menuButton, "Menu");

			WebElement logoutButton = driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[5]"));
			buttonClick(logoutButton, "Logged Out");
			logTestInfo("User has been logged out successfully.");
		} catch (Exception e) {
			logTestError("An error occurred during logout.", e);
		}
	}

	public void usernameNPass() {
		try {

			WebElement users = driver.findElement(By.id("username"));
			enterText(users, usernameString, "username");

			WebElement pass = driver.findElement(By.id("password"));
			enterText(pass, passwordString, "password");

			WebElement loginButton = driver.findElement(By.id("Login"));
			buttonClick(loginButton, "login");

			pageloadCheckbyid("userNavLabel", "Home Page");
			logTestInfo("User has successfully logged in and Home Page is loaded.");
		} catch (Exception e) {
			logTestError("An error occurred during login process.", e);

		}
	}

	public void selectByValue(WebElement element, String value, String objName) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			Select select = new Select(element);
			select.selectByValue(value);
			logTestInfo(objName + " is selected.");
		} catch (Exception e) {
			logTestError("Error selecting value for " + objName, e);
		}
	}

	public void eleCheck(WebElement element, String expectedText, String objName) {

		try {

			String actualText = element.getText();
			if (actualText.equals(expectedText)) {
				logTestInfo("Correct element " + objName + " is present.");
			} else {
				log.warn(objName + " is not present in list.");
				extentReport.logTestFailed(objName + " is not present in list.");
			}
		} catch (Exception e) {
			logTestError("Error checking element " + objName, e);
		}
	}

	public void childCount(List<WebElement> bodyChildren, String tableName, int numToBeChecked) {
		int childCount = bodyChildren.size();
		if (childCount > numToBeChecked) {
			logTestInfo(tableName + " has more than " + numToBeChecked + " elements.");
		} else {
			log.warn(tableName + " has less than " + numToBeChecked + " elements.");
			close("Test as conditions did not meet");
		}
	}

	public void changeIframeToChild(WebElement iframeElement) {

		try {

			logTestInfo("Switched to child iframe.");
		} catch (Exception e) {
			logTestError("Error switching to child iframe.", e);
		}
	}

	public void changeIframeToParent(String parentOrDefaultFrames) {
		try {
			if (parentOrDefaultFrames.equals("parent")) {
				driver.switchTo().parentFrame();
				logTestInfo("Switched to parent frame.");
			} else if (parentOrDefaultFrames.equals("default")) {
				driver.switchTo().defaultContent();
				logTestInfo("Switched to default content.");
			}
		} catch (Exception e) {
			logTestError("Error switching iframe context.", e);
		}
	}

	public void testLeadsTabPresence() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement leadsTab = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"Lead_Tab\"]")));
			eleCheck(leadsTab, "Lead_Tab", "leadsTab");
			logTestInfo("Leads tab is present.");
		} catch (Exception e) {
			logTestError("Leads tab element not found on the page.", e);
		}
	}
//
//	public void checkTextError(WebElement element, String expectedText, String objName) {
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		try {
//			wait.until(ExpectedConditions.visibilityOf(element));
//			String actualText = element.getText();
//			if (expectedText.equals(actualText)) {
//				logTestInfo("Correct error message displayed for " + objName);
//			} else {
//				log.warn("Wrong error message displayed for " + objName);
//				extentReport.logTestFailed("Wrong error message displayed for " + objName);
//			}
//		} catch (Exception e) {
//			logTestError("Error checking text in " + objName, e);
//		}
//	}

//	public void checkTextContains(WebElement element, String expectedText, String objName) {
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		try {
//			wait.until(ExpectedConditions.visibilityOf(element));
//			String actualText = element.getText();
//			if (actualText.contains(expectedText)) {
//				logTestInfo(objName + " contains the expected text.");
//			} else {
//				log.warn("The expected string was NOT found in " + objName);
//				extentReport.logTestFailed("The expected string was NOT found in " + objName);
//			}
//		} catch (Exception e) {
//			logTestError("Error checking if " + objName + " contains " + expectedText, e);
//		}
//	}
//

	public void takeScreenshot(String filepath) {
		TakesScreenshot screenCapture = (TakesScreenshot) driver;
		File src = screenCapture.getScreenshotAs(OutputType.FILE);
		File destFile = new File(filepath);

		try {
			Files.copy(src.toPath(), destFile.toPath());
			logTestInfo("Screenshot captured successfully and saved at " + filepath);
		} catch (IOException e) {
			logTestError("Problem occurred during screenshot capture.", e);
		}
	}

	public void addingLeads() throws InterruptedException {
		try {
			LoginWpass("safari");
			Thread.sleep(2000);

			WebElement menuButton = driver.findElement(By.id("userNavButton"));
			buttonClick(menuButton, "Menu");

			WebElement settButton = driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[2]"));
			buttonClick(settButton, "Settings");

			pageloadCheckbyxpath("//div[@class='zen contentWrapper']//div[2]//a[2]//span[1]//img[1]", "Settings Page");

			WebElement customiseButton = driver
					.findElement(By.xpath("//div[@class='zen contentWrapper']//div[2]//a[2]//span[1]//img[1]"));
			buttonClick(customiseButton, "Customise Button");

			pageloadCheckbyxpath("//*[@id=\"duel_select_0\"]", "Settings Page");

			WebElement leads = driver.findElement(By.xpath("//*[@id=\"duel_select_0\"]"));
			selectByValue(leads, "Lead", "Leads");

			WebElement addButton = driver.findElement(By.xpath("//*[@id=\"duel_select_0_right\"]/img"));
			buttonClick(addButton, "Add Button");

			WebElement saveButton = driver.findElement(By.xpath("//*[@id=\"bottomButtonRow\"]/input[1]"));
			buttonClick(saveButton, "Save Button");

			close("Leads Added");
		} catch (Exception e) {

			logTestError("An error occurred while adding leads: ", e);
		}
	}
}
