
package com.automation.tests;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.automation.pages.base.basePage;
import com.automation.utility.Constants;
import com.automation.utility.PropertiesUtility;

public class CreateOpportunity extends basePage {
	String username = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "username");
	String passString = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "password");
	Logger mylog;

	@Test
	public void Test15() throws InterruptedException {
		LoginWpass("safari");

		WebElement OppoButton = driver.findElement(By.xpath("//*[@id=\"Opportunity_Tab\"]/a"));
		buttonClick(OppoButton, "Opportunities");

		pageloadCheckbyxpath("//option[@value='00Bak00000HJmTu']", "Opportunities Page");

		WebElement AllOppo = driver.findElement(By.xpath("//option[@value='00Bak00000HJmTu']"));
		checkText(AllOppo, "All Opportunities", "All Opportunities");

		WebElement closingNextMonth = driver.findElement(By.xpath("//option[@value='00Bak00000HJmXx']"));
		checkText(closingNextMonth, "Closing Next Month", "Closing Next Month");

		WebElement closingThisMonth = driver.findElement(By.xpath("//option[@value='00Bak00000HJmXr']"));
		checkText(closingThisMonth, "Closing This Month", "Closing This Month");

		WebElement myOppo = driver.findElement(By.xpath("//option[@value='00Bak00000HJmYt']"));
		checkText(myOppo, "My Opportunities", "My Opportunities");

		WebElement NTW = driver.findElement(By.xpath("//option[@value='00Bak00000HJmY4']"));
		checkText(NTW, "New This Week", "New This Week");

		WebElement RVO = driver.findElement(By.xpath("//option[@value='00Bak00000HJmYq']"));
		checkText(RVO, "Recently Viewed Opportunities", "Recently Viewed Opportunities");

		WebElement won = driver.findElement(By.xpath("//option[@value='00Bak00000HJmYB']"));
		checkText(won, "Won", "Won");

		close("Test15");
	}

	@Test
	public void Test16() throws InterruptedException {
		LoginWpass("safari");

		// Accounts button is clicked
		WebElement OppoButton = driver.findElement(By.xpath("//*[@id=\"Opportunity_Tab\"]/a"));
		buttonClick(OppoButton, "Opportunities");

		pageloadCheckbyxpath("//option[@value='00Bak00000HJmTu']", "Opportunities Page");

		WebElement newButton = driver.findElement(By.xpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input"));
		buttonClick(newButton, "New");

		pageloadCheckbyxpath("//*[@id=\"opp3\"]", "New Opportunities Page");

		WebElement oppoName = driver.findElement(By.xpath("//*[@id=\"opp3\"]"));
		enterText(oppoName, "Opportunity 1", "Opportunity Name");

		WebElement accName = driver.findElement(By.xpath("//*[@id=\"opp4\"]"));
		enterText(accName, "Ajinkya Pise", "Account Name");

		WebElement dateClose = driver
				.findElement(By.xpath("//*[@id=\"ep\"]/div[2]/div[3]/table/tbody/tr[2]/td[4]/div/span/span/a"));
		buttonClick(dateClose, "Close Date");

		WebElement stage = driver.findElement(By.xpath("//*[@id=\"opp11\"]"));
		String StageValue = "Needs Analysis";
		selectByValue(stage, StageValue, "Customer Priority");

		WebElement PCS = driver.findElement(By.xpath("//*[@id=\"opp17\"]"));
		enterText(PCS, "Ajinkya ", "Primary Campaign Source");

		close("Test16");
	}

	@Test
	public void Test17() throws InterruptedException {
		LoginWpass("safari");

		WebElement OppoButton = driver.findElement(By.xpath("//*[@id=\"Opportunity_Tab\"]/a"));
		buttonClick(OppoButton, "Opportunities");

		pageloadCheckbyxpath("//option[@value='00Bak00000HJmTu']", "Opportunities Page");

		WebElement OppoPipeButton = driver
				.findElement(By.xpath("//*[@id=\"toolsContent\"]/tbody/tr/td[1]/div/div[1]/div[1]/ul/li[1]/a"));
		buttonClick(OppoPipeButton, "Opportunities Pipeline");

		pageloadCheckbyxpath("//*[@id=\"noTableContainer\"]/div/div[1]/div[1]/div[1]/h1",
				"Opportunities Pipeline Page");
		close("Test17");

	}

	@Test
	public void Test18() throws InterruptedException {
		LoginWpass("safari");

		WebElement OppoButton = driver.findElement(By.xpath("//*[@id=\"Opportunity_Tab\"]/a"));
		buttonClick(OppoButton, "Opportunities");

		pageloadCheckbyxpath("//option[@value='00Bak00000HJmTu']", "Opportunities Page");

		WebElement OppoStuckButton = driver
				.findElement(By.xpath("//*[@id=\"toolsContent\"]/tbody/tr/td[1]/div/div[1]/div[1]/ul/li[2]/a"));
		buttonClick(OppoStuckButton, "Opportunities Pipeline");

		pageloadCheckbyxpath("//*[@id=\"noTableContainer\"]/div/div[1]/div[1]/div[1]/h1", "Stuck Opportunities Page");

		close("Test18");
	}

	@Test
	public void Test19() throws InterruptedException {
		LoginWpass("safari");

		WebElement OppoButton = driver.findElement(By.xpath("//*[@id=\"Opportunity_Tab\"]/a"));
		buttonClick(OppoButton, "Opportunities");

		pageloadCheckbyxpath("//option[@value='00Bak00000HJmTu']", "Opportunities Page");

		WebElement intervalElement = driver.findElement(By.xpath("//*[@id=\"quarter_q\"]"));
		selectByValue(intervalElement, "next1", "Next FQ");

		WebElement includeElement = driver.findElement(By.xpath("//*[@id=\"open\"]"));
		selectByValue(includeElement, "open", "Open Opportunities");

		WebElement runReport = driver.findElement(By.xpath("//*[@id=\"lead_summary\"]/table/tbody/tr[3]/td/input"));
		buttonClick(runReport, "Run Report");

		pageloadCheckbyxpath("//*[@id=\"noTableContainer\"]/div/div[1]/div[1]/div[1]/h1", "Opportunities Report");

		close("Test19");
	}

}
