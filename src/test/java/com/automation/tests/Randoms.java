
package com.automation.tests;

import java.util.Set;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.automation.pages.base.basePage;
import com.automation.utility.Constants;
import com.automation.utility.PropertiesUtility;

public class Randoms extends basePage {
	String username = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "username");
	String passString = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "password");
	Logger mylog;

	@Test
	public void Test33() throws InterruptedException {

		LoginWpass("safari");

		WebElement home = driver.findElement(By.xpath("//*[@id=\"home_Tab\"]/a"));
		buttonClick(home, "Home");

		pageloadCheckbyxpath("//*[@id=\"ptBody\"]/div/div[2]/span[1]/h1/a", "Home Page");

		WebElement userName = driver.findElement(By.xpath("//*[@id=\"ptBody\"]/div/div[2]/span[1]/h1/a"));
		checkText(userName, "NewAjinkya Newpise", "Username");

		WebElement userNameButton = driver.findElement(By.xpath("//*[@id=\"ptBody\"]/div/div[2]/span[1]/h1/a"));
		buttonClick(userNameButton, "user Name Button");

		pageloadCheckbyxpath("//*[@id=\"publishersharebutton\"]", "UserName Page");

		Logout();
		close("Test33");
	}

	@Test
	public void Test34() throws InterruptedException {
		LoginWpass("safari");

		WebElement home = driver.findElement(By.xpath("//*[@id=\"home_Tab\"]/a"));
		buttonClick(home, "Home");

		pageloadCheckbyxpath("//*[@id=\"ptBody\"]/div/div[2]/span[1]/h1/a", "Home Page");

		WebElement userNameButton = driver.findElement(By.xpath("//*[@id=\"ptBody\"]/div/div[2]/span[1]/h1/a"));
		buttonClick(userNameButton, "user Name Button");
		pageloadCheckbyxpath("//*[@id=\"chatterTab\"]/div[2]/div[2]/div[1]/h3/div/div/a/img", "UserName Page");

		WebElement editContactButton = driver
				.findElement(By.xpath("//*[@id=\"chatterTab\"]/div[2]/div[2]/div[1]/h3/div/div/a/img"));
		buttonClick(editContactButton, "Edit Contact");

		WebElement iframeElement = driver.findElement(By.xpath("//*[@id=\"contactInfoContentId\"]"));
		changeIframeToChild(iframeElement);

		WebElement aboutButton = driver
				.findElement(By.xpath("//a[@role='tab' and @aria-controls='TabPanel:0:Body:1']"));
		buttonClick(aboutButton, "About Button");

		// pageloadCheckbyxpath("//*[@id=\"firstName\"]", "About Page");

		WebElement firstNameField = driver.findElement(By.xpath("//*[@id=\"firstName\"]"));
		enterText(firstNameField, "NewAjinkya", "First Name");

		WebElement lastName = driver.findElement(By.xpath("//*[@id=\"lastName\"]"));
		enterText(lastName, "Newpise", "Last Name");

		WebElement saveAllButton = driver.findElement(By.xpath("//*[@id=\"TabPanel\"]/div/div[2]/form/div/input[1]"));
		buttonClick(saveAllButton, "Save All Button");
		changeIframeToParent("default");

		WebElement userName = driver.findElement(By.xpath("//*[@id=\"tailBreadcrumbNode\"]"));
		checkText(userName, "NewAjinkya Newpise ", "Username");
		Thread.sleep(2000);
		Logout();
		close("Test34");
	}

	@Test
	public void Test35() throws InterruptedException {
		LoginWpass("safari");

		WebElement plusButton = driver.findElement(By.xpath("//*[@id=\"AllTab_Tab\"]/a"));
		buttonClick(plusButton, "Plus Button");
		pageloadCheckbyxpath("//*[@id=\"bodyCell\"]/div[1]/div[1]/div[1]/h1", "All Tabs Page");
		WebElement customizeMyTabs = driver
				.findElement(By.xpath("//*[@id=\"bodyCell\"]/div[3]/div[1]/table/tbody/tr/td[2]/input"));
		buttonClick(customizeMyTabs, "Customize My Tabs");
		pageloadCheckbyxpath("//*[@id=\"bodyCell\"]/div[1]/div[1]/div[1]/h1", "Customise My Tabs Page");
// Please put back lead in place to run this test case
		try {
			WebElement leads = driver.findElement(By.xpath("//*[@id=\"duel_select_1\"]"));
			selectByValue(leads, "Lead", "Leads");
		} catch (Exception e) {
			System.out.println("Please add back leads for this error to be removed \n" + e);
		}

		WebElement remove = driver.findElement(By.xpath("//*[@id=\"duel_select_0_left\"]/img"));
		buttonClick(remove, "Remove");

		WebElement save = driver.findElement(By.xpath("//*[@id=\"bottomButtonRow\"]/input[1]"));
		buttonClick(save, "Save");
		pageloadCheckbyxpath("\"//*[@id=\\\"ptBody\\\"]/div/div[2]/span[1]/h1/a\"", "Home Page");
		Logout();
		usernameNPass();
		testLeadsTabPresence();
		close("Test35");
	}

	@Test
	public void Test36() throws InterruptedException {
		LoginWpass("safari");

		WebElement home = driver.findElement(By.xpath("//*[@id=\"home_Tab\"]/a"));
		buttonClick(home, "Home");

		pageloadCheckbyxpath("//*[@id=\"ptBody\"]/div/div[2]/span[2]/a", "Home Page");

		WebElement currentdate = driver.findElement(By.xpath("//*[@id=\"ptBody\"]/div/div[2]/span[2]/a"));
		buttonClick(currentdate, "Current Date Link");

		pageloadCheckbyxpath("//*[@id=\"p:f:j_id25:j_id61:28:j_id64\"]/a", "Current Date Link Page");

		WebElement eightlink = driver.findElement(By.xpath("//*[@id=\"p:f:j_id25:j_id61:28:j_id64\"]/a"));
		buttonClick(eightlink, "Eight PM Link");

		pageloadCheckbyxpath("//*[@id=\"ep\"]/div[2]/div[4]/table/tbody/tr[2]/td[2]/div/a/img", "Eight PM Link Page");

		WebElement subjectCombo = driver
				.findElement(By.xpath("//*[@id=\"ep\"]/div[2]/div[4]/table/tbody/tr[2]/td[2]/div/a/img"));
		buttonClick(subjectCombo, "Subject Combo Link");

		String mainWindow = driver.getWindowHandle();
		// System.out.println("Main Window Handle: " + mainWindow);

		Set<String> allWindows = driver.getWindowHandles();

		for (String windowHandle : allWindows) {
			if (!windowHandle.equals(mainWindow)) {
				driver.switchTo().window(windowHandle);
				System.out.println("Switched to new window: " + windowHandle);
			}
		}
		pageloadCheckbyxpath("/html/body/div[2]/ul/li[5]/a", "Others Page");
		WebElement others = driver.findElement(By.xpath("/html/body/div[2]/ul/li[5]/a"));
		buttonClick(others, "Others Link");

		driver.switchTo().window(mainWindow);
		System.out.println("Switched back to the main window: " + mainWindow);

		WebElement end = driver.findElement(By.xpath("//*[@id=\"EndDateTime_time\"]"));
		enterText(end, "9:00 PM", "Time");

		WebElement save = driver.findElement(By.xpath("//*[@id=\"topButtonRow\"]/input[1]"));
		buttonClick(save, "Save Link");

		pageloadCheckbyid("userNavLabel", "Home Page");

		close("Test36");
	}

	@Test
	public void Test37() throws InterruptedException {
		LoginWpass("safari");

		WebElement home = driver.findElement(By.xpath("//*[@id=\"home_Tab\"]/a"));
		buttonClick(home, "Home");

		WebElement currentdate = driver.findElement(By.xpath("//*[@id=\"ptBody\"]/div/div[2]/span[2]/a"));
		buttonClick(currentdate, "Current Date Link");

		WebElement fourlink = driver.findElement(By.xpath("//*[@id=\"p:f:j_id25:j_id61:20:j_id64\"]/a"));
		buttonClick(fourlink, "Four PM Link");
		System.out.println(driver.getWindowHandles().size());
		WebElement subjectCombo = driver
				.findElement(By.xpath("//*[@id=\"ep\"]/div[2]/div[4]/table/tbody/tr[2]/td[2]/div/a/img"));
		buttonClick(subjectCombo, "Subject Combo Link");

		String mainWindow = driver.getWindowHandle();
		// System.out.println("Main Window Handle: " + mainWindow);

		Thread.sleep(5000);
		Set<String> allWindows = driver.getWindowHandles();

		for (String windowHandle : allWindows) {
			if (!windowHandle.equals(mainWindow)) {
				driver.switchTo().window(windowHandle);
				System.out.println("Switched to new window: " + windowHandle);
			}
		}
		Thread.sleep(5000);

		WebElement others = driver.findElement(By.xpath("/html/body/div[2]/ul/li[5]/a"));
		buttonClick(others, "Others Link");
		Thread.sleep(5000);

		driver.switchTo().window(mainWindow);
		System.out.println("Switched back to the main window: " + mainWindow);

		WebElement end = driver.findElement(By.xpath("//*[@id=\"EndDateTime_time\"]"));
		enterText(end, "7:00 PM", "Time");

		WebElement create = driver.findElement(By.xpath("//*[@id=\"IsRecurrence\"]"));
		buttonClick(create, "Create Recurring");
		WebElement weekly = driver.findElement(By.xpath("//*[@id=\"rectypeftw\"]"));
		buttonClick(weekly, "Weekly Link");

		WebElement enddate = driver.findElement(By.xpath("//*[@id=\"RecurrenceEndDateOnly\"]"));
		enterText(enddate, "10/10/2024", "EndDate");

		WebElement save = driver.findElement(By.xpath("//*[@id=\"topButtonRow\"]/input[1]"));
		buttonClick(save, "Save Link");
		close("Test37");
	}
}
