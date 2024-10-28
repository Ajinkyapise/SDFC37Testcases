
package com.automation.tests;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.automation.pages.base.basePage;
import com.automation.utility.Constants;
import com.automation.utility.PropertiesUtility;

public class Contacts extends basePage {
	String username = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "username");
	String passString = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "password");
	Logger mylog;

	@Test
	public void Test25() throws InterruptedException {
		LoginWpass("safari");

		WebElement contactsButton = driver.findElement(By.xpath("//*[@id=\"Contact_Tab\"]/a"));
		buttonClick(contactsButton, "Contacts");

		pageloadCheckbyxpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input", "Contacts Page");

		WebElement new1 = driver.findElement(By.xpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input"));
		buttonClick(new1, "New");

		pageloadCheckbyxpath("//*[@id=\"topButtonRow\"]/input[1]", "New Contacts Page");

		WebElement lastName = driver.findElement(By.xpath("//*[@id=\"name_lastcon2\"]"));
		enterText(lastName, "Pise", "Last Name");

		WebElement accountNameField = driver.findElement(By.xpath("//*[@id=\"con4\"]"));
		enterText(accountNameField, "Ajinkya Pise", "Account Name");

		WebElement save = driver.findElement(By.xpath("//*[@id=\"topButtonRow\"]/input[1]"));
		buttonClick(save, "Save");

		pageloadCheckbyxpath("//*[@id=\"publishersharebutton\"]", "New2 Contacts Page");

		Logout();

		close("Test25");
	}

	@Test
	public void Test26() throws InterruptedException {
		LoginWpass("safari");

		WebElement contactsButton = driver.findElement(By.xpath("//*[@id=\"Contact_Tab\"]/a"));
		buttonClick(contactsButton, "Contacts");

		pageloadCheckbyxpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input", "Contacts Page");

		WebElement createNew = driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[2]/a[2]"));
		buttonClick(createNew, "Create New View");

		pageloadCheckbyxpath("//*[@id=\"editPage\"]/div[1]/table/tbody/tr/td[2]/input[1]", "Create New View Page");

		WebElement viewName = driver.findElement(By.xpath("//*[@id=\"fname\"]"));
		enterText(viewName, "ajinkya", "View Name");

		WebElement viewUniqueName = driver.findElement(By.xpath("//*[@id=\"devname\"]"));
		enterText(viewUniqueName, "pise2", "View Unique Name");

		WebElement save = driver.findElement(By.xpath("//*[@id=\"editPage\"]/div[1]/table/tbody/tr/td[2]/input[1]"));
		buttonClick(save, "Save");
		Logout();
		close("Test26");
	}

	@Test
	public void Test28() throws InterruptedException {
		LoginWpass("safari");

		WebElement contactsButton = driver.findElement(By.xpath("//*[@id=\"Contact_Tab\"]/a"));
		buttonClick(contactsButton, "Contacts");

		pageloadCheckbyxpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input", "Contacts Page");

		WebElement myContacts = driver.findElement(By.xpath("//*[@id=\"fcf\"]"));
		selectByValue(myContacts, "00Bak00000HJmYr", "My Contacts");

		WebElement Go = driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[1]/input"));
		buttonClick(Go, "GO!");

		pageloadCheckbyxpath("//*[@id=\"create-new-view\"]", "My Contacts Page");

		Logout();
		close("Test28");
	}

	@Test
	public void Test29() throws InterruptedException {
		LoginWpass("safari");

		WebElement contactsButton = driver.findElement(By.xpath("//*[@id=\"Contact_Tab\"]/a"));
		buttonClick(contactsButton, "Contacts");

		pageloadCheckbyxpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input", "Contacts Page");

		WebElement contactNameButton = driver
				.findElement(By.xpath("//*[@id=\"bodyCell\"]/div[3]/div[1]/div/div[2]/table/tbody/tr[2]/th/a"));
		buttonClick(contactNameButton, "Contacts Name");

		pageloadCheckbyxpath("//*[@id=\"publishersharebutton\"]", "First Contacts Page");

		Logout();
		close("Test29");
	}

	@Test
	public void Test30() throws InterruptedException {
		LoginWpass("safari");

		WebElement contactsButton = driver.findElement(By.xpath("//*[@id=\"Contact_Tab\"]/a"));
		buttonClick(contactsButton, "Contacts");

		pageloadCheckbyxpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input", "Contacts Page");

		WebElement createNewView = driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[2]/a[2]"));
		buttonClick(createNewView, "Create New View");

		pageloadCheckbyxpath("//*[@id=\"editPage\"]/div[1]/table/tbody/tr/td[2]/input[1]", "Create New View Page");

		WebElement viewUniqueName = driver.findElement(By.xpath("//*[@id=\"devname\"]"));
		enterText(viewUniqueName, "EFGH", "View Unique Name");

		WebElement save = driver.findElement(By.xpath("//*[@id=\"editPage\"]/div[1]/table/tbody/tr/td[2]/input[1]"));
		buttonClick(save, "Save");
		pageloadCheckbyxpath("//*[@id=\"editPage\"]/div[2]/div[1]/div[2]/table/tbody/tr[1]/td[2]/div/div[2]",
				"Create New View Page with error ");

		WebElement error = driver
				.findElement(By.xpath("//*[@id=\"editPage\"]/div[2]/div[1]/div[2]/table/tbody/tr[1]/td[2]/div/div[2]"));

		checkText(error, "Error: You must enter a value", "Error");

		Logout();
		close("Test30");
	}

	@Test
	public void Test31() throws InterruptedException {
		LoginWpass("safari");

		WebElement contactsButton = driver.findElement(By.xpath("//*[@id=\"Contact_Tab\"]/a"));
		buttonClick(contactsButton, "Contacts");

		pageloadCheckbyxpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input", "Contacts Page");

		WebElement createNewView = driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[2]/a[2]"));
		buttonClick(createNewView, "Create New View");
		pageloadCheckbyxpath("//*[@id=\"editPage\"]/div[1]/table/tbody/tr/td[2]/input[1]", "Create New View Page");

		WebElement viewName = driver.findElement(By.xpath("//*[@id=\"fname\"]"));
		enterText(viewName, "ABCD", "View Name");

		WebElement viewUniqueName = driver.findElement(By.xpath("//*[@id=\"devname\"]"));
		enterText(viewUniqueName, "EFGH", "View Unique Name");

		WebElement cancel = driver.findElement(By.xpath("//*[@id=\"editPage\"]/div[1]/table/tbody/tr/td[2]/input[2]"));
		buttonClick(cancel, "Cancel");

		pageloadCheckbyxpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input", "Returned to Contacts Page");

		Logout();
		close("Test31");
	}

	@Test
	public void Test32() throws InterruptedException {
		LoginWpass("safari");

		WebElement contactsButton = driver.findElement(By.xpath("//*[@id=\"Contact_Tab\"]/a"));
		buttonClick(contactsButton, "Contacts");

		pageloadCheckbyxpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input", "Contacts Page");

		WebElement new1 = driver.findElement(By.xpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input"));
		buttonClick(new1, "New");

		pageloadCheckbyxpath("//*[@id=\"name_lastcon2\"]", "New Contact Page");

		WebElement lastName = driver.findElement(By.xpath("//*[@id=\"name_lastcon2\"]"));
		enterText(lastName, "Indian", "Last Name");

		WebElement accountNameField = driver.findElement(By.xpath("//*[@id=\"con4\"]"));
		enterText(accountNameField, "Global Media", "Account Name");

		WebElement save = driver.findElement(By.xpath("//*[@id=\"topButtonRow\"]/input[2]"));
		buttonClick(save, "Save And New");

		// pageloadCheckbyxpath("", "New Contact Page");
		// This test isnt working

		Thread.sleep(3000);// Just to make it work

		Logout();
		close("Test32");
	}

}
