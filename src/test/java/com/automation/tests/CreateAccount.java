
package com.automation.tests;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.automation.pages.base.basePage;
import com.automation.utility.Constants;
import com.automation.utility.PropertiesUtility;

public class CreateAccount extends basePage {
	String username = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "username");
	String passString = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "password");
	Logger mylog;

	@Test
	public void Test10() throws InterruptedException {

		LoginWpass("safari");

		WebElement userNamElement = driver.findElement(By.xpath("//*[@id=\"userNavLabel\"]"));
		checkText(userNamElement, "Ajinkya Pise", "UserName");

		WebElement AccountButton = driver.findElement(By.xpath("//*[@id=\"Account_Tab\"]/a"));
		buttonClick(AccountButton, "Accounts Button");

		pageloadCheckbyxpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input", "Accounts Page");

		WebElement NewButton = driver.findElement(By.xpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input"));
		buttonClick(NewButton, "New");

		pageloadCheckbyxpath("//*[@id=\"acc2\"]", "New Accounts Page");

		WebElement users = driver.findElement(By.xpath("//*[@id=\"acc2\"]"));
		enterText(users, "Ajinkya Pise", "username");

		WebElement type = driver.findElement(By.xpath("//*[@id=\"acc6\"]"));
		String selOptionValue = "Technology Partner";
		selectByValue(type, selOptionValue, "Technology Partner");

		WebElement cusPriority = driver.findElement(By.xpath("//*[@id=\"00Nak000005IgVm\"]"));
		String cusPriorityOptionValue = "High";
		selectByValue(cusPriority, cusPriorityOptionValue, "Customer Priority");

		WebElement saveButton = driver.findElement(By.xpath("//*[@id=\"bottomButtonRow\"]/input[1]"));
		buttonClick(saveButton, "Save Button");

		close("Test10");

	}

	@Test
	public void Test11() throws InterruptedException {

		LoginWpass("safari");

		WebElement AccountButton = driver.findElement(By.xpath("//*[@id=\"Account_Tab\"]/a"));
		buttonClick(AccountButton, "Accounts");

		pageloadCheckbyxpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input", "Accounts Page");

		WebElement newViewButton = driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[2]/a[2]"));
		buttonClick(newViewButton, "Create New View");
		pageloadCheckbyxpath("//*[@id=\"fname\"]", "Create New View Page");

		WebElement viewNameElement = driver.findElement(By.xpath("//*[@id=\"fname\"]"));
		enterText(viewNameElement, "New1", "View Name");

		WebElement viewUniqueNameElement = driver.findElement(By.xpath("//*[@id=\"devname\"]"));
		enterText(viewUniqueNameElement, "real", "View Unique Name");

		WebElement saveButton = driver
				.findElement(By.xpath("//*[@id=\"editPage\"]/div[1]/table/tbody/tr/td[2]/input[1]"));
		buttonClick(saveButton, "Save");

		close("Test11");

	}

	@Test
	public void Test12() throws InterruptedException {

		LoginWpass("safari");

		WebElement AccountButton = driver.findElement(By.xpath("//*[@id=\"Account_Tab\"]/a"));
		buttonClick(AccountButton, "Accounts");

		pageloadCheckbyxpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input", "Accounts Page");

		WebElement type = driver.findElement(By.xpath("//*[@id=\"fcf\"]"));
		String selOptionValue = "00Bak00000HyrMD";
		selectByValue(type, selOptionValue, "New1");

		WebElement EditButton = driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[2]/a[1]"));
		buttonClick(EditButton, "Edit");

		pageloadCheckbyxpath("//*[@id=\"editPage\"]/div[3]/table/tbody/tr/td[2]/input[1]", "Edit Page");

		WebElement viewNameElement = driver.findElement(By.xpath("//*[@id=\"fname\"]"));
		enterText(viewNameElement, "Newest", "View Name");

		WebElement filterField = driver.findElement(By.xpath("//*[@id=\"fcol1\"]"));
		selectByValue(filterField, "ACCOUNT.NAME", "New1");

		WebElement operatorField = driver.findElement(By.xpath("//*[@id=\"fop1\"]"));
		selectByValue(operatorField, "c", "New1");

		WebElement valueElement = driver.findElement(By.xpath("//*[@id=\"fval1\"]"));
		enterText(valueElement, "Ajinkya", "Value Element");

		WebElement saveButton = driver
				.findElement(By.xpath("//*[@id=\"editPage\"]/div[3]/table/tbody/tr/td[2]/input[1]"));
		buttonClick(saveButton, "Save");

		close("Test12");

	}

	@Test
	public void Test13() throws InterruptedException {
		LoginWpass("safari");

		// Accounts button is clicked
		WebElement AccountButton = driver.findElement(By.xpath("//*[@id=\"Account_Tab\"]/a"));
		buttonClick(AccountButton, "Accounts");

		pageloadCheckbyxpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input", "Accounts Page");

		WebElement MergeAccountsButton = driver
				.findElement(By.xpath("//*[@id=\"toolsContent\"]/tbody/tr/td[2]/div/div/div/ul/li[4]/span/a"));
		buttonClick(MergeAccountsButton, "Merge Accounts");

		pageloadCheckbyxpath("//*[@id=\"srch\"]", "Merge Accounts Page");

		WebElement accountNameElement = driver.findElement(By.xpath("//*[@id=\"srch\"]"));
		enterText(accountNameElement, "Ajinkya", "Account Name Element");

		WebElement findAccButton = driver.findElement(By.xpath("//*[@id=\"stageForm\"]/div/div[2]/div[4]/input[2]"));
		buttonClick(findAccButton, "Find Account");

		List<WebElement> bodyChildren = driver.findElements(
				By.xpath("//*[@id=\"stageForm\"]/div/div[2]/div[4]/div/div[1]/div/div[2]/table/tbody/tr"));

		childCount(bodyChildren, "Accounts Link", 2);

		List<WebElement> checkboxes = driver.findElements(By.xpath("//table//input[@type='checkbox']"));

		for (int i = 0; i < checkboxes.size(); i++) {
			WebElement checkbox = checkboxes.get(i);

			if (i < 2) {
				// For the first two checkboxes, check if they are not selected, and then select
				// them
				if (!checkbox.isSelected()) {
					checkbox.click(); // Check the checkbox
					System.out.println("Checkbox " + (i + 1) + " is checked");
				}
			} else {
				// For all remaining checkboxes, ensure they are unchecked
				if (checkbox.isSelected()) {
					checkbox.click(); // Uncheck the checkbox
					System.out.println("Checkbox " + (i + 1) + " is unchecked");
				}
			}
		}

		WebElement nextButton = driver.findElement(By.xpath("//*[@id=\"stageForm\"]/div/div[2]/div[5]/div/input[1]"));
		buttonClick(nextButton, "Next");

		pageloadCheckbyxpath("//*[@id=\"stageForm\"]/div/div[2]/div[1]/div/input[2]", "Merge My Accounts Page");

		WebElement mergeButton = driver.findElement(By.xpath("//*[@id=\"stageForm\"]/div/div[2]/div[1]/div/input[2]"));
		buttonClick(mergeButton, "merge");

		Alert alert = driver.switchTo().alert();
		alert.accept();

		close("Test13");
	}

//	@Test
//	public void Test14() throws InterruptedException {
//		LoginWpass("safari");
//
//		// Accounts button is clicked
//		WebElement AccountButton = driver.findElement(By.xpath("//*[@id=\"Account_Tab\"]/a"));
//		buttonClick(AccountButton, "Accounts");
//
//		pageloadCheckbyxpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input", "Accounts Page");
//
//		WebElement AWLAButton = driver
//				.findElement(By.xpath("//*[@id=\"toolsContent\"]/tbody/tr/td[1]/div/div/div[1]/ul/li[2]/a"));
//		buttonClick(AWLAButton, "Account with last activity >30days");
//
//		pageloadCheckbyxpath("//*[@id=\"ext-gen263\"]/div", "AWLAButton Page");
//
//		WebElement checkTextString1 = driver.findElement(By.xpath("//*[@id=\"ext-gen263\"]/div"));
//		checkText(checkTextString1, "No data was returned. Check report filters.", "Unsaved Report page");
//
//		;
//
//		WebElement dateFieldButton = driver.findElement(By.xpath("//*[@id=\"ext-gen148\"]"));
//		buttonClick(dateFieldButton, "Date Field");
//
//		WebElement createdDateButton = driver.findElement(By.xpath("//div[text()='Created Date']"));
//		buttonClick(createdDateButton, "Created Field");
//
//		WebElement fromdateButton = driver.findElement(By.xpath("//*[@id=\"ext-gen152\"]"));
//		buttonClick(fromdateButton, "From Date");
//
//		WebElement fromtodayButton = driver.findElement(By.xpath("//*[@id=\"ext-comp-1112\"]/tbody/tr[2]/td[2]/em"));
//		buttonClick(fromtodayButton, "From Today");
//
//		WebElement todateButton = driver.findElement(By.xpath("//*[@id=\"ext-gen154\"]"));
//		buttonClick(todateButton, "To Date");
//
//		WebElement totodayButton = driver.findElement(By.xpath("//*[@id=\"ext-comp-1114\"]/tbody/tr[2]/td[2]/em"));
//		buttonClick(totodayButton, "To Today");
//		Thread.sleep(2000);
//		// pageloadCheckbyxpath("//*[@id=\"ext-gen253\"]/div[1]/table/tbody/tr/td[1]/div",
//		// "List Page");
//
//		WebElement checkTextString = driver.findElement(By.xpath("//*[@id=\"ext-gen263\"]/div"));
//		checkText(checkTextString, "This preview shows a limited number of records. Run the report to see all results.",
//				"List of accounts qualified is displayed");
//
//		WebElement saveButton = driver.findElement(By.xpath("//*[@id=\"ext-gen49\"]"));
//		buttonClick(saveButton, "Save");
//
//		pageloadCheckbyxpath("//*[@id=\"saveReportDlg_reportNameField\"]", "Save Report Page");
//
//		WebElement reportNameElement = driver.findElement(By.xpath("//*[@id=\"saveReportDlg_reportNameField\"]"));
//		enterText(reportNameElement, "Report5", "Report Name Element");
//
//		WebElement reportNameUniqueElement = driver.findElement(By.xpath("//*[@id=\"saveReportDlg_DeveloperName\"]"));
//		enterText(reportNameUniqueElement, "Unique3", "Report Name Unique Element");
//
//		Thread.sleep(3000);
//		// Please add new names for reports
//		WebElement saveAndRunReportButton = driver.findElement(By.id("ext-gen322"));
//		buttonClick(saveAndRunReportButton, "Save And Run Report Button");
//
//		pageloadCheckbyxpath("//*[@id=\"status\"]", "Complete Page");
//
//		WebElement checkTex = driver.findElement(By.xpath("//*[@id=\"status\"]"));
//		checkText(checkTex, "Complete", "Complete");
//
//		close("Test14");
//	}
	// This Test has some small Error

}
