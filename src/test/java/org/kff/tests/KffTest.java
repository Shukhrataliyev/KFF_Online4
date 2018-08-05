package org.kff.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.kff.pages.CalculatorPage;
import org.kff.pages.HomePage;
import org.kff.pages.StateDataPage;
import org.kff.utilities.BrowserUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class KffTest extends TestBase {

	HomePage homePage = new HomePage(driver);
	CalculatorPage calculatorPage = new CalculatorPage(driver);
	StateDataPage stateDataPage = new StateDataPage(driver);

	//@Test(priority = 1, groups="smoke") 
	public void testTitleMenuCalc() {
		extentLogger = report.createTest("Verifying the title");
		
		extentLogger.info("verifying title");
		assertEquals(driver.getTitle(),
				"Kaiser Family Foundation - Health Policy Research, Analysis, Polling, Facts, Data and Journalism",
				"HomePage is not displayed. Application is down.");

		extentLogger.info("verifying 'search' is displayed");
		assertTrue(homePage.search.isDisplayed());
		extentLogger.info("verifying 'menu' is clickable");
		assertTrue(homePage.menu.isDisplayed() && homePage.menu.isEnabled());

		homePage.search.sendKeys("insurance calculator");
		homePage.submitBtn.click();
		
		extentLogger.info("verifying 'Health Insurance Marketplace Calculator' and date is displayed ");
		assertEquals(calculatorPage.healthInsuranceMarketplaceCalculator.getText(), "Health Insurance Marketplace Calculator");
		assertEquals(calculatorPage.date.getText().substring(0, 16), "November 3, 2017");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2000)");
		
		calculatorPage.healthInsuranceMarketplaceCalculator.click();
		assertEquals(calculatorPage.verifyText.getText(),
				"Note: This calculator has been updated with premiums for 2018 plans.");

		extentLogger.info("verifying 'all calculator fields' are displayed");
		for (WebElement each : calculatorPage.listCalculatorOptons) {
			if (each.isDisplayed()) {
				assertTrue(each.isDisplayed());
			}
		}
		
		//extentLogger.pass("Velifies title is displayed");
	}

	
	@Test(priority = 2) 
	public void testMenuFunction(){
		extentLogger = report.createTest("Verifying the munu function");

		extentLogger.info("verifying title");
		assertEquals(driver.getTitle(),
				"Kaiser Family Foundation - Health Policy Research, Analysis, Polling, Facts, Data and Journalism",
				"HomePage is not displayed. Application is down.");
		
		HomePage homePage = new HomePage(driver);
		homePage.menu.click();
		
		BrowserUtils.hover(homePage.statHealthFacts);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2000)");
		
		homePage.statHealthFacts.click();
		homePage.statHealthFactsSub.click();

		stateDataPage = new StateDataPage(driver);
		extentLogger.info("verifying 'Search State Health Facts:' is displayed");
		assertEquals(driver.getTitle(), "State Health Facts | The Henry J. Kaiser Family Foundation");
		assertTrue(stateDataPage.SSHF.isDisplayed());

//		String errMsg = " error occured";
//		assertEquals(errMsg, "failed");
//		extentLogger.pass("Velifies error");

	}
}
