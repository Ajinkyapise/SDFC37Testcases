
package com.automation.tests;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.automation.pages.base.basePage;
import com.automation.utility.Constants;
import com.automation.utility.PropertiesUtility;

public class Leads extends basePage {
	String username = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "username");
	String passString = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "password");
	Logger mylog;

	// Before running this class please add Leads to the page

	@Test
	public void Test20() throws InterruptedException {
//Use below when using 35th testcase
		// addingLeads();
		LoginWpass("safari");

		WebElement leadsButton = driver.findElement(By.xpath("//*[@id=\"Lead_Tab\"]/a"));
		buttonClick(leadsButton, "Leads");

		pageloadCheckbyxpath("//*[@id=\"fcf\"]/option[1]", "Login Page");

		Logout();
		close("Test20");
	}

	@Test
	public void Test21() throws InterruptedException {
		LoginWpass("safari");

		WebElement leadsButton = driver.findElement(By.xpath("//*[@id=\"Lead_Tab\"]/a"));
		buttonClick(leadsButton, "Leads");

		pageloadCheckbyxpath("//*[@id=\"fcf\"]/option[1]", "Leads Page");

		WebElement allOpenLeads = driver.findElement(By.xpath("//*[@id=\"fcf\"]/option[1]"));
		checkText(allOpenLeads, "All Open Leads", "All Open Leads");

		WebElement myUnreadLeads = driver.findElement(By.xpath("//*[@id=\"fcf\"]/option[2]"));
		checkText(myUnreadLeads, "My Unread Leads", "My Unread Leads");

		WebElement recentlyViewedLeads = driver.findElement(By.xpath("//*[@id=\"fcf\"]/option[3]"));
		checkText(recentlyViewedLeads, "Recently Viewed Leads", "Recently Viewed Leads");

		WebElement todaysLeads = driver.findElement(By.xpath("//*[@id=\"fcf\"]/option[4]"));
		checkText(todaysLeads, "Today's Leads", "Today's Leads");

		Logout();
		close("Test21");
	}

	@Test
	public void Test22() throws InterruptedException {
		LoginWpass("safari");

		WebElement leadsButton = driver.findElement(By.xpath("//*[@id=\"Lead_Tab\"]/a"));
		buttonClick(leadsButton, "Leads");

		pageloadCheckbyxpath("//*[@id=\"fcf\"]/option[1]", "Leads Page");

		WebElement todaysLeads = driver.findElement(By.xpath("//*[@id=\"fcf\"]"));
		selectByValue(todaysLeads, "00Bak00000HJmYA", "Todays Leads");

		Logout();
		pageloadCheckbyid("username", "Login Page");
		usernameNPass();

		WebElement leadsButton2 = driver.findElement(By.xpath("//*[@id=\"Lead_Tab\"]/a"));
		buttonClick(leadsButton2, "Leads");

		pageloadCheckbyxpath("//*[@id=\"fcf\"]/option[1]", "Leads Page");

		WebElement go = driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[1]/input"));
		buttonClick(go, "Go");

		pageloadCheckbyxpath("//*[@id=\"00Bak00000HJmYA_listButtons\"]/ul/li[1]/input", "Todays Leads Page");

		Logout();
		close("Test22");
	}

	@Test
	public void Test23() throws InterruptedException {
		LoginWpass("safari");

		WebElement leadsButton = driver.findElement(By.xpath("//*[@id=\"Lead_Tab\"]/a"));
		buttonClick(leadsButton, "Leads");

		pageloadCheckbyxpath("//*[@id=\"fcf\"]/option[1]", "Leads Page");

		WebElement todaysLeads = driver.findElement(By.xpath("//*[@id=\"fcf\"]"));
		selectByValue(todaysLeads, "00Bak00000HJmYA", "Todays Leads");

		WebElement go = driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[1]/input"));
		buttonClick(go, "Go");

		pageloadCheckbyxpath("//*[@id=\"00Bak00000HJmYA_listButtons\"]/ul/li[1]/input", "Todays Leads Page");

		Logout();
		close("Test23");
	}

	@Test
	public void Test24() throws InterruptedException {
		LoginWpass("safari");

		WebElement leadsButton = driver.findElement(By.xpath("//*[@id=\"Lead_Tab\"]/a"));
		buttonClick(leadsButton, "Leads");

		pageloadCheckbyxpath("//*[@id=\"fcf\"]/option[1]", "Leads Page");

		WebElement new1 = driver.findElement(By.xpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input"));
		buttonClick(new1, "New");
		pageloadCheckbyxpath("//*[@id=\"name_lastlea2\"]", "New Leads Page");

		WebElement lastName = driver.findElement(By.xpath("//*[@id=\"name_lastlea2\"]"));
		enterText(lastName, "ABCD", "Last Name");

		WebElement companyField = driver.findElement(By.xpath("//*[@id=\"lea3\"]"));
		enterText(companyField, "ABCD", "Company Field");

		WebElement save = driver.findElement(By.xpath("//*[@id=\"topButtonRow\"]/input[1]"));
		buttonClick(save, "Save");

		pageloadCheckbyxpath("//*[@id=\"publishersharebutton\"]", "After Save Page");

		Logout();
		close("Test24");
	}

}
