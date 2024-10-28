package com.automation.tests;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.automation.pages.base.basePage;
import com.automation.utility.Constants;
import com.automation.utility.PropertiesUtility;

public class UserMenuDropdown extends basePage {
	String username = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "username");
	String passString = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "password");
	Logger mylog;

	@Test
	public void Test5() throws InterruptedException {

		LoginWpass("safari");

		WebElement menuButton = driver.findElement(By.id("userNavLabel"));
		buttonClick(menuButton, "Menu");

		WebElement ele1 = driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[1]"));
		checkText(ele1, "My Profile", "My Profile");

		WebElement ele2 = driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[2]"));
		checkText(ele2, "My Settings", "My Settings");

		WebElement ele3 = driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[3]"));
		checkText(ele3, "Developer Console", "Developer Console");

		WebElement ele4 = driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[4]"));
		checkText(ele4, "Switching to lightning Experience", "Switching to lightning Experience");

		WebElement ele5 = driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[5]"));
		checkText(ele5, "Logout", "Logout");

		close("Test5");
	}

	@Test
	public void Test7() throws InterruptedException {
		LoginWpass("safari");

		WebElement menuButton = driver.findElement(By.id("userNavLabel"));
		buttonClick(menuButton, "Menu");

		WebElement settingsButton = driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[2]"));
		buttonClick(settingsButton, "Settings");

		pageloadCheckbyxpath("//*[@id=\"bodyCell\"]/div[1]/div[1]/div[1]/h1", "Settings Page");

		WebElement personalButton = driver.findElement(By.xpath("//*[@id=\"PersonalInfo\"]/a"));
		buttonClick(personalButton, "Personal");

		WebElement loginHistory = driver.findElement(By.xpath("//*[@id=\"LoginHistory_font\"]"));
		buttonClick(loginHistory, "Login History");

		pageloadCheckbyxpath("//*[@id=\"RelatedUserLoginHistoryList_body\"]/div/a", "History Page");

		WebElement downloadButton = driver.findElement(By.xpath("//*[@id=\"RelatedUserLoginHistoryList_body\"]/div/a"));
		buttonClick(downloadButton, "Download button");

		WebElement menuButton2 = driver.findElement(By.id("userNavLabel"));
		buttonClick(menuButton2, "Menu");

		WebElement settingsButton2 = driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[2]"));
		buttonClick(settingsButton2, "Settings");

		pageloadCheckbyxpath(
				"/html[1]/body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[2]/div[1]/div[1]/div[2]/a[2]/span[1]",
				"Settings Page");

		WebElement customizeButton = driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[2]/div[1]/div[1]/div[2]/a[2]/span[1]"));
		buttonClick(customizeButton, "Customize button");
		pageloadCheckbyxpath("//*[@id=\"p4\"]", "Settings Page");
		WebElement content = driver.findElement(By.xpath("//*[@id=\"p4\"]"));
		selectByValue(content, "02uak000007MwZa", "Salesforce Chatter");

		WebElement content2 = driver.findElement(By.xpath("//*[@id=\"duel_select_0\"]"));
		selectByValue(content2, "report", "Report");

		WebElement AddButton = driver.findElement(By.xpath("//*[@id=\"duel\"]/table/tbody/tr/td[2]/div[2]"));
		buttonClick(AddButton, "Add");

		pageloadCheckbyxpath("//*[@id=\"bodyCell\"]/div[1]/div[1]/div[1]/h1", "Settings Page");
		WebElement EmailButton = driver.findElement(By.xpath("//*[@id=\"EmailSetup\"]/a"));
		buttonClick(EmailButton, "Email");

		WebElement MyEmailButton = driver.findElement(By.xpath("//*[@id=\"EmailSetup_child\"]/div[1]"));
		buttonClick(MyEmailButton, "My Email");

		pageloadCheckbyid("sender_name", "My Email Page");

		WebElement ele = driver.findElement(By.id("sender_name"));
		enterText(ele, "Ajinkya Pise", "Name");

		WebElement ele2 = driver.findElement(By.id("sender_email"));
		enterText(ele2, "ajinkyapise@gmail.com", "Email");

		WebElement YesButton = driver.findElement(By.xpath("//*[@id=\"auto_bcc1\"]"));
		buttonClick(YesButton, "Yes Clicked");

		WebElement SaveButton = driver.findElement(By.xpath("//*[@id=\"bottomButtonRow\"]/input[1]"));
		buttonClick(SaveButton, "Save Clicked");
		pageloadCheckbyxpath("//*[@id=\"meSaveCompleteMessage\"]/table/tbody/tr/td[2]/div", "After save Settings Page");

		WebElement CalButton = driver.findElement(By.xpath("//*[@id=\"CalendarAndReminders\"]/a"));
		buttonClick(CalButton, "Calenders & Reminders");

		WebElement ActButton = driver.findElement(By.xpath("//*[@id=\"CalendarAndReminders_child\"]/div[2]"));
		buttonClick(ActButton, "Activity Reminders");

		pageloadCheckbyxpath("//*[@id=\"testbtn\"]", "Activity Reminders Page");
		WebElement OptRButton = driver.findElement(By.xpath("//*[@id=\"testbtn\"]"));
		buttonClick(OptRButton, "Open Test Reminder");

		close("Test7");
	}

	@Test
	public void Test8() throws InterruptedException {
		LoginWpass("safari");

		WebElement menuButton = driver.findElement(By.id("userNavLabel"));
		buttonClick(menuButton, "Menu");

		WebElement devButton = driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[3]"));
		buttonClick(devButton, "Developers Console");

		String mainWindow = driver.getWindowHandle();

		for (String windowHandle : driver.getWindowHandles()) {
			if (!windowHandle.equals(mainWindow)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}

		driver.close();

		driver.switchTo().window(mainWindow);

		pageloadCheckbyid("userNavLabel", "Home Page");

		close("Test8");
	}

	@Test
	public void Test9() throws InterruptedException {

		LoginWpass("safari");

		WebElement menuButton = driver.findElement(By.id("userNavLabel"));
		buttonClick(menuButton, "Menu");

		WebElement proButton = driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[1]"));
		eleCheck(proButton, "My profile", "My Profile");

		WebElement settButton = driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[2]"));
		eleCheck(settButton, "My Settings", "My Settings");

		WebElement devButton = driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[3]"));
		eleCheck(devButton, "Developer Console", "Developer Console");

		WebElement LOButton = driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[5]"));
		eleCheck(LOButton, "Logout", "Logout");

		buttonClick(LOButton, "Logout");

		pageloadCheckbyid("username", "login Page");

		close("Test9");
	}

}
