package org.kff.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.kff.pages.CalculatorPage;
import org.kff.pages.HomePage;
import org.kff.pages.StateDataPage;
import org.kff.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Test789 extends TestBase {
	
	HomePage homePage = new HomePage(driver);
	StateDataPage newUpdatedInd = new StateDataPage(driver);
	CalculatorPage calculatorPage; 
	
	@Test
	public void Test7() {
		extentLogger = report.createTest("Verify State Facts");
		homePage.menu.click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2000)");
		homePage.statHealthFacts.click();
		homePage.statHealthFactsSub.click();
		
//		homePage.statHealthFacts.click();
//		homePage.statHealthFactsSub.click();

		StateDataPage stateDataPage = new StateDataPage(driver);
		extentLogger.info("verifying 'Search State Health Facts:' is displayed");
		assertTrue(stateDataPage.SSHF.isDisplayed());
		assertEquals(stateDataPage.newUpdatedInd.getText(), "NEW & UPDATED INDICATORS");
		
		
        js.executeScript("window.scrollBy(0,700)");
       
		stateDataPage.section1115.click();
		
		assertEquals(driver.getTitle(), "Medicaid Waiver Tracker: Which States Have Approved and Pending Section 1115 Medicaid Waivers? | The Henry J. Kaiser Family Foundation");
		
	}
	

	
	@Test
	public void Test9() {
		extentLogger = report.createTest("Checking ? mark explanation visibility");
		homePage.goToCalculatorPage(driver);
		calculatorPage = new CalculatorPage(driver);
		assertEquals(calculatorPage.header.getText(), "Financial Help for Health Insurance Coverage through Marketplaces");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,550)");
		extentLogger.info("verifying household is diplayed");
		assertTrue(calculatorPage.householdText.isDisplayed());
		List<String> expectedLst= new ArrayList<>(); 
					 expectedLst.add("Select your state. If your state has local data available, you will be able to enter your zip code."); 
					 expectedLst.add("Enter your estimated yearly household income. Include the income(s) of yourself, your spouse, and any dependents who contribute to the household. See the FAQ section on income for more information.");
					 expectedLst.add("Select “No” if your employer requires you to spend more than 9.66% of your household income on your own insurance premium, or if the health insurance your employer offers does not meet the health care law’s minimum value standards.");
					 expectedLst.add("This includes you, your spouse, and any children that you consider dependents on your taxes.");
					 expectedLst.add("Children can stay on their parent's plan until they turn 26.");
					 expectedLst.add("See the FAQ question on Medicare if you are age 65+");

		List<String> actualLst=new ArrayList<>(); 
		for (WebElement each : calculatorPage.questionMarkList) {
			actualLst.add(each.getAttribute("data-tooltip"));
		}		
		
		extentLogger.info("verifying question mark explanations are visible");
	    assertEquals(actualLst,expectedLst);
		
	}

}
